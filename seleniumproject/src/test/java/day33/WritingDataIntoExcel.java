package day33;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// File --> Workbook --> Sheets --> Rows --> Cells

public class WritingDataIntoExcel {

	public static void main(String[] args) throws IOException {
		
		FileOutputStream file=new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\myfile.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		XSSFSheet sheet = workbook.createSheet();
		
		
		//Creating rows, cells and update data without loop
		/*
		XSSFRow row1 = sheet.createRow(0);
		row1.createCell(1).setCellValue("welcome");
		row1.createCell(2).setCellValue("to");
		row1.createCell(3).setCellValue("apache");
		
		XSSFRow row2= sheet.createRow(1);
		row2.createCell(1).setCellValue("abc");
		row2.createCell(2).setCellValue("456");
		row2.createCell(3).setCellValue("test");
		*/
		
		// creating rows , cells and update data using loops
		
		Scanner sc = new Scanner(System.in);
		
		for(int r=0;r<=3;r++) {
			XSSFRow currentRow = sheet.createRow(r);
			for(int c=0;c<2;c++) {
				//currentRow.createCell(c).setCellValue("welcome");
				System.out.println("Enter a value: ");
				String value=sc.next();
				currentRow.createCell(c).setCellValue(value);
			}
		}
		
		/*
//		XSSFCell cell= sheet.createRow(0).createCell(1);
//		cell.setCellValue("welcome");
		
		sheet.createRow(0).createCell(1).setCellValue("welcome");
		sheet.createRow(0).createCell(2).setCellValue("to");
		sheet.createRow(0).createCell(2).setCellValue("apache");
		
		sheet.createRow(1).createCell(1).setCellValue("hye");
		sheet.createRow(1).createCell(2).setCellValue("hi");
		sheet.createRow(1).createCell(3).setCellValue("hello");
		*/
		
		workbook.write(file);
		workbook.close();
		file.close();
		
		System.out.println("Writing is done!!");
	}
}
