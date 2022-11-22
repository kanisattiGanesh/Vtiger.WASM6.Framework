package vTiger.Practice;

import java.io.FileInputStream;
//import java.io.IOException;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelSheet {

	public static void main(String[] args) throws Exception {
		
//Step1:Read the file and load file into input stream
FileInputStream fis = new FileInputStream(".\\\\src\\\\test\\\\resources\\\\TestData.xlsx");
//step 2 :create a workbook 
Workbook wb = WorkbookFactory.create(fis);
//step 3 :Navigate to required sheet
Sheet sh = wb.getSheet("Contacts");

//step 4 : Navigate to required row inside the sheet
Row rw = sh.getRow(1);

//step 5 : Navigate to required cell inside the row
Cell ce = rw.getCell(2);

//read the value present in the cell
String value = ce.getStringCellValue();
System.out.println(value);

	}

}
