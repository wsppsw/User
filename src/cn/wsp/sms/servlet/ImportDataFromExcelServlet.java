package cn.wsp.sms.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import cn.wsp.sms.dao.IStudentDao;
import cn.wsp.sms.dao.impl.StudentDaoJDBCImpl;
import cn.wsp.sms.domain.Student;






@WebServlet("/import")
@MultipartConfig
public class ImportDataFromExcelServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf8");
		response.setContentType("text/html;charset=utf8");
		
		Part part = request.getPart("dataFile");
		
		String fileName = part.getSubmittedFileName();
		
		String newFileName = System.currentTimeMillis() +  fileName.substring(fileName.lastIndexOf("."));
		
		String filePath = this.getServletContext().getRealPath("/upload");
		
		System.out.println("�ϴ��ļ�·��Ϊ:" + filePath);
		
		part.write(filePath + "/" + newFileName);
		
		this.importDataFromExcel(filePath + "/" + newFileName);
		
		PrintWriter out = response.getWriter();
		out.print("<h3>���ݵ���ɹ���</h3>");
		out.close();
		
	}
	
	private void importDataFromExcel(String filePath){
		//�ж��Ƿ�Ϊexcel�����ļ�
        if(!filePath.endsWith(".xls") || !filePath.endsWith(".xlsx"))
        {
            System.out.println("�ļ�����excel����");
        }
        
        FileInputStream fis =null;
        Workbook workbook = null;
        
        try
        {
            //��ȡһ�����Ե�ַ����
              fis = new FileInputStream(filePath);
        }
        catch(Exception e)
        {
        	System.out.println("��ȡ��ַ����");
            e.printStackTrace();
        }
       
        
        
        try 
        {
            //2003�汾��excel����.xls��β
            workbook = new HSSFWorkbook(fis);//�õ�������
             
        } 
        catch (Exception ex) 
        {
            //ex.printStackTrace();
            try
            {
                //2007�汾��excel����.xlsx��β
                
                workbook = new XSSFWorkbook(fis);//�õ�������
            } catch (IOException e)
            {
                // TODO Auto-generated catch block
               System.out.println("û�д�");
            }
        }
        
        
        
        
        //�õ�һ��������
        Sheet sheet = workbook.getSheetAt(0);
        
        //��ñ�ͷ
        Row rowHead = sheet.getRow(0);
        
        //�жϱ�ͷ�Ƿ���ȷ
        if(rowHead.getPhysicalNumberOfCells() != 4)
        {
            System.out.println("��ͷ����������!");
        }
        
        //������ݵ�������
        int totalRowNum = sheet.getLastRowNum();
        
        //Ҫ�������
        String name = "";
        int id = 0;
        String myclass= "";
        double score = 0;
       // int latitude = 0;
        
       //�����������
        IStudentDao stuDao = new StudentDaoJDBCImpl();
        Student s = new Student();
        for(int i = 1 ; i <= totalRowNum ; i++)
        {
            //��õ�i�ж���
            Row row = sheet.getRow(i);
            
            //��û�õ�i�е�0�е� String���Ͷ���
            Cell cell = row.getCell((short)0);
            id = (int) cell.getNumericCellValue();
            
            cell = row.getCell((short)1);
            name = cell.getStringCellValue().toString();
            
            cell = row.getCell((short)2);
            myclass = cell.getStringCellValue().toString();
            
            cell = row.getCell((short)3);
            score = (double)cell.getNumericCellValue();
            
            //���һ���������͵�����
            //cell = row.getCell((short)1);
            //latitude = (int) cell.getNumericCellValue();
            s.setId(id);
            s.setName(name);
            s.setMyclass(myclass);
            s.setScore(score);
            stuDao.add(s);
        }
        System.out.println("����ɹ�");
	}
	
}

