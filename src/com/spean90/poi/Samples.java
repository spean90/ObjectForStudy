package com.spean90.poi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

public class Samples {

	public void MergingCell() throws Exception {
		Workbook wb = new HSSFWorkbook();
	    Sheet sheet = wb.createSheet("new sheet");
	    Row row = sheet.createRow((short) 1);
	    Cell cell = row.createCell((short) 1);
	    cell.setCellValue("This is a test of merging");

	    sheet.addMergedRegion(new CellRangeAddress(
	            1, //first row (0-based)
	            2, //last row  (0-based)
	            1, //first column (0-based)
	            2  //last column  (0-based)
	    ));

	    // Write the output to a file
	    FileOutputStream fileOut = new FileOutputStream("cfg/poi/workbook.xls");
	    wb.write(fileOut);
	    fileOut.close();
	}
	public void ReadAndWrite() throws Exception {
		InputStream inp = new FileInputStream("cfg/poi/workbook.xls");
	    //InputStream inp = new FileInputStream("workbook.xlsx");

	    Workbook wb = new HSSFWorkbook(inp);
	    Sheet sheet = wb.getSheetAt(0);
	    Row row = sheet.getRow(0);
	    Cell cell = row.getCell(0);
	    if (cell == null)
	        cell = row.createCell(3);
	    cell.setCellType(Cell.CELL_TYPE_STRING);
	    cell.setCellValue("a test");

	    // Write the output to a file
	    FileOutputStream fileOut = new FileOutputStream("cfg/poi/workbook.xls");
	    wb.write(fileOut);
	    fileOut.close();
	}
}
