package crm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

public class PoiTest {

	//老版本office 03版
	@Test
	public void testWrite03Excel() throws Exception{
		//1.创建工作簿 ：Workbook
		HSSFWorkbook workbook = new HSSFWorkbook();
		//2创建工作表：Sheet
		HSSFSheet sheet = workbook.createSheet("HElleJBC");
		//3.创建行：Row
		HSSFRow row = sheet.createRow(2);
		//4.创建单元格 ：Cell
		HSSFCell cell = row.createCell(2);
		cell.setCellValue("Hello LIXIUYAO");
		
		FileOutputStream outputStream = new FileOutputStream("F:\\ppbnb\\x1.xls");
		//输出excel到文件
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();
	}
	
	//版本office 07版
	@Test
	public void testWrite07Excel() throws Exception{
		//1.创建工作簿 ：Workbook
		XSSFWorkbook workbook = new XSSFWorkbook();
		//2创建工作表：Sheet
		XSSFSheet sheet = workbook.createSheet("HElleJBC");
		//3.创建行：Row
		XSSFRow row = sheet.createRow(2);
		//4.创建单元格 ：Cell
		XSSFCell cell = row.createCell(2);
		cell.setCellValue("Hello ZJG");
		
		FileOutputStream outputStream = new FileOutputStream("F:\\ppbnb\\x99.xlsx");
		//输出excel到文件
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();
	}
	@Test
	   public void testRead03Excel() throws Exception {
	       FileInputStream inputStream = new FileInputStream("F:\\ppbnb\\x1.xls");
	       //1、读取工作簿：Workbook。
	       HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
	       //2、读取工作表：Sheet。
	       HSSFSheet sheet = workbook.getSheetAt(0);
	       //3、读取行：Row。
	       HSSFRow row = sheet.getRow(2);
	       //4、读取单元格：Cell。
	       HSSFCell cell = row.getCell(2);
	       String value = cell.getStringCellValue();
	       System.out.println(value);
	       
	       workbook.close();
	       inputStream.close();
	   }  
	
}
