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
		
		System.out.println("上传文件路径为:" + filePath);
		
		part.write(filePath + "/" + newFileName);
		
		this.importDataFromExcel(filePath + "/" + newFileName);
		
		PrintWriter out = response.getWriter();
		out.print("<h3>数据导入成功！</h3>");
		out.close();
		
	}
	
	private void importDataFromExcel(String filePath){
		//判断是否为excel类型文件
        if(!filePath.endsWith(".xls") || !filePath.endsWith(".xlsx"))
        {
            System.out.println("文件不是excel类型");
        }
        
        FileInputStream fis =null;
        Workbook workbook = null;
        
        try
        {
            //获取一个绝对地址的流
              fis = new FileInputStream(filePath);
        }
        catch(Exception e)
        {
        	System.out.println("获取地址错误");
            e.printStackTrace();
        }
       
        
        
        try 
        {
            //2003版本的excel，用.xls结尾
            workbook = new HSSFWorkbook(fis);//得到工作簿
             
        } 
        catch (Exception ex) 
        {
            //ex.printStackTrace();
            try
            {
                //2007版本的excel，用.xlsx结尾
                
                workbook = new XSSFWorkbook(fis);//得到工作簿
            } catch (IOException e)
            {
                // TODO Auto-generated catch block
               System.out.println("没有打开");
            }
        }
        
        
        
        
        //得到一个工作表
        Sheet sheet = workbook.getSheetAt(0);
        
        //获得表头
        Row rowHead = sheet.getRow(0);
        
        //判断表头是否正确
        if(rowHead.getPhysicalNumberOfCells() != 4)
        {
            System.out.println("表头的数量不对!");
        }
        
        //获得数据的总行数
        int totalRowNum = sheet.getLastRowNum();
        
        //要获得属性
        String name = "";
        int id = 0;
        String myclass= "";
        double score = 0;
       // int latitude = 0;
        
       //获得所有数据
        IStudentDao stuDao = new StudentDaoJDBCImpl();
        Student s = new Student();
        for(int i = 1 ; i <= totalRowNum ; i++)
        {
            //获得第i行对象
            Row row = sheet.getRow(i);
            
            //获得获得第i行第0列的 String类型对象
            Cell cell = row.getCell((short)0);
            id = (int) cell.getNumericCellValue();
            
            cell = row.getCell((short)1);
            name = cell.getStringCellValue().toString();
            
            cell = row.getCell((short)2);
            myclass = cell.getStringCellValue().toString();
            
            cell = row.getCell((short)3);
            score = (double)cell.getNumericCellValue();
            
            //获得一个数字类型的数据
            //cell = row.getCell((short)1);
            //latitude = (int) cell.getNumericCellValue();
            s.setId(id);
            s.setName(name);
            s.setMyclass(myclass);
            s.setScore(score);
            stuDao.add(s);
        }
        System.out.println("导入成功");
	}
	
}

