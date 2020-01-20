package com.automationpractice.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author TechCenture
 *
 */
public final class ExcelUtils {

	private ExcelUtils() {}
	
	/**
	 * @throws IOException 
	 * 
	 */
	public static Map<Integer, List<String>> getExcelDataAsMaps ( String filePath ) throws IOException {
		Map<Integer, List<String>> map = new TreeMap<>();
		
		FileInputStream fileInputStream = new FileInputStream(filePath);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheetAt(0);
		
		int rows = sheet.getLastRowNum();
		
		for ( int rowNum = 0; rowNum <= rows; rowNum++ ) {
			
			Row row = sheet.getRow(rowNum);
			int columns = row.getLastCellNum();
			
			List<String> cells = new ArrayList<>();
			for ( int columnNum = 0; columnNum < columns; columnNum++ ) {
				Cell cell = row.getCell(columnNum);
				String cellValue = cell.toString();
				
				cells.add(cellValue);
			}
			map.put(rowNum, cells);
		}
		workbook.close();
		fileInputStream.close();
		return map;
	}
	
	public static void writeToExcel ( String fileName ) throws IOException {
		File file = new File(Common.USER_DIR + "/src/test/resources/files/" + fileName + ".xlsx");
		boolean isFile = file.exists();
		
		if ( !isFile ) file.createNewFile();
		
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet();
		
		 Map<Integer, List<String>> excelData = DataStoreUtils.getObjectAsMaps("excel data");
		 
		 int rownum = 0;
		 for ( Entry<Integer, List<String>> data : excelData.entrySet() ) {
			 Row row = sheet.createRow(rownum);
			 
			 List<String> cellData = data.getValue();
			 
			 for ( int index = 0; index < cellData.size(); index++ ) {
				 Cell cell = row.createCell(index);
				 String cellValue = cellData.get(index);
				 
				 cell.setCellValue(cellValue);
			 }
			 rownum++;
		 }
		 
		 workbook.write(fileOutputStream);
		 workbook.close();
		 fileOutputStream.close();
	}
	
	
}
