package cn.wsp.sms.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import cn.wsp.sms.dao.IStudentDao;
import cn.wsp.sms.dao.impl.StudentDaoJDBCImpl;
import cn.wsp.sms.domain.Student;

@	WebServlet("/exportData")
public class ExportData2ExcelServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		//生成Dao对象
		IStudentDao stuDao = new StudentDaoJDBCImpl();
		
		List<Student> stuList = stuDao.findAll();
		
		//创建一个工作簿对象
		HSSFWorkbook wb = new HSSFWorkbook();
		
		// 建立新的sheet对象（excel的表单）
		HSSFSheet sheet = wb.createSheet("学生表");
		
		// 在sheet里创建第二行
		HSSFRow row1 = sheet.createRow(0);
		// 创建单元格并设置单元格内容
		row1.createCell(0).setCellValue("学号");
		row1.createCell(1).setCellValue("姓名");
		row1.createCell(2).setCellValue("班级");
		row1.createCell(3).setCellValue("分数");
		
		HSSFRow rows;
		int rownum = 1;
		
		for(Student s:stuList){
			rows = sheet.createRow(rownum);
			rows.createCell(0).setCellValue(s.getId());
			rows.createCell(1).setCellValue(s.getName());
			rows.createCell(2).setCellValue(s.getMyclass());
			rows.createCell(3).setCellValue(s.getScore());
			rownum++;
		}
		
		// 输出Excel文件
		OutputStream output = response.getOutputStream();
		response.reset();
		response.setHeader("Content-disposition", "attachment; filename=studentData.xls");
		response.setContentType("application/msexcel");
		wb.write(output);
		output.close();
		wb.close();
		
	}
}
