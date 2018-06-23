package com.amdocs.RestAssuredDemoAmit;

import java.io.File;
import java.io.IOException;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
import jxl.Cell;
import jxl.JXLException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class excelInput {

	public static Map readExcel() throws IOException, BiffException {
	//public static void main(String[] args) throws IOException, BiffException {
		// TODO Auto-generated method stub
		final String testDataFilePath = "./src/test/java/TestData/TestData.xls";
		
		File inputTestDataFile = new File(testDataFilePath);
		
		WritableWorkbook resultFile = Workbook.createWorkbook(new File("./src/test/java/TestData/TestResult.xls"));
		WritableSheet resultSheet = resultFile.createSheet("Automated Result", 0);		
		
		Workbook inputTestData = Workbook.getWorkbook(inputTestDataFile);
		Sheet inputSheet = inputTestData.getSheet(0);
		
		Cell cell = inputSheet.getCell(0, 0);
		Cell header = inputSheet.getCell(0, 0);
		System.out.println("Cell is :"+cell);
		System.out.println("Header is :"+header);
		//Dictionary returnData = new Hashtable();
		Map returnData = new HashMap();

		
		for (int i =0; i < inputSheet.getColumns(); i++ ) {
			
			header = inputSheet.getCell(i, 0);
			cell = inputSheet.getCell(i, 1);
			System.out.println("value of "+header.getContents()+" is :"+cell.getContents());
			returnData.put(header.getContents(),cell.getContents());
								
					
		}
		System.out.println(returnData);
		return returnData;
		
		
			}
	
}
