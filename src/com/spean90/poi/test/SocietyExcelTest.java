package com.spean90.poi.test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

public class SocietyExcelTest {

	
	public static void main(String[] args) throws Exception {
		OutputStream os = new FileOutputStream("cfg/poi/test.xls");
		Workbook wb = new HSSFWorkbook();
		SocietyExcelTest test = new SocietyExcelTest();
		test.createFile(os, wb);
	}
	private void createFile(OutputStream os,Workbook wb) throws IOException{
		Font font = wb.createFont();
		font.setFontName("宋体");
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setFontHeightInPoints((short)18);
		Sheet sheet = wb.createSheet("社保缴费明细");
		CellStyle style = wb.createCellStyle();
		style.setFont(font);
		style.setDataFormat(wb.createDataFormat().getFormat("yyyy-MM-dd HH:mm:ss"));
		style.setAlignment(CellStyle.ALIGN_CENTER);
		//
		Font font2 = wb.createFont();
		font2.setFontName("宋体");
		font2.setFontHeightInPoints((short)14);
		CellStyle style2 = wb.createCellStyle();
		style2.setFont(font2);
		
		//
		Font font3 = wb.createFont();
		font3.setFontName("宋体");
		font3.setFontHeightInPoints((short)10);
		CellStyle style3 = wb.createCellStyle();
		style3.setAlignment(CellStyle.ALIGN_CENTER);
		style3.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		style3.setFont(font3);
		//第1行
		Row row = sheet.createRow(0);
		Cell cell = row.createCell((short) 0);
		cell.setCellStyle(style);
		cell.setCellValue("福州XXXXX有限公司社会保险缴交明细表");
	    sheet.addMergedRegion(new CellRangeAddress(
	            0, //first row (0-based)
	            0, //last row  (0-based)
	            0, //first column (0-based)
	            17  //last column  (0-based)
	    ));
	  //第2行
	    row = sheet.createRow(1);
	    cell = row.createCell(0);
	    cell.setCellStyle(style2);
	    cell.setCellValue("缴交月份：2014年10月");
	    sheet.addMergedRegion(new CellRangeAddress(1,1,0,17));
	  //第3行
	    row = sheet.createRow(2);
	    cell = row.createCell(0);
	    cell.setCellStyle(style3);
	    cell.setCellValue("部门");
	    sheet.addMergedRegion(new CellRangeAddress(2,5,0,0));
	    
	    cell = row.createCell(1);
	    cell.setCellStyle(style3);
	    cell.setCellValue("姓名");
	    sheet.addMergedRegion(new CellRangeAddress(2,5,1,1));
	    
	    cell = row.createCell(2);
	    cell.setCellStyle(style3);
	    cell.setCellValue("工资基数");
	    sheet.addMergedRegion(new CellRangeAddress(2,3,2,5));
	    
	    cell = row.createCell(6);
	    cell.setCellStyle(style3);
	    cell.setCellValue("社会保险");
	    sheet.addMergedRegion(new CellRangeAddress(2,2,6,13));
	    
	    cell = row.createCell(14);
	    cell.setCellStyle(style3);
	    cell.setCellValue("医疗保险");
	    sheet.addMergedRegion(new CellRangeAddress(2,3,14,15));
	    
	    cell = row.createCell(16);
	    cell.setCellStyle(style3);
	    cell.setCellValue("缴交总额");
	    sheet.addMergedRegion(new CellRangeAddress(2,3,16,17));
	    
	    //第4行
	    row = sheet.createRow(3);
	    cell = row.createCell(6);
	    cell.setCellStyle(style3);
	    cell.setCellValue("养老保险");
	    sheet.addMergedRegion(new CellRangeAddress(3,3,6,7));
	    
	    cell = row.createCell(8);
	    cell.setCellStyle(style3);
	    cell.setCellValue("工商保险");
	    sheet.addMergedRegion(new CellRangeAddress(3,3,8,9));
	    
	    cell = row.createCell(10);
	    cell.setCellStyle(style3);
	    cell.setCellValue("失业保险");
	    sheet.addMergedRegion(new CellRangeAddress(3,3,10,11));
	    
	    cell = row.createCell(12);
	    cell.setCellStyle(style3);
	    cell.setCellValue("生育保险");
	    sheet.addMergedRegion(new CellRangeAddress(3,3,12,13));
	  //第5行
	    row = sheet.createRow(4);
	    cell = row.createCell(2);
	    cell.setCellStyle(style3);
	    cell.setCellValue("养老");
	    sheet.addMergedRegion(new CellRangeAddress(4,5,2,2));
	    
	    cell = row.createCell(3);
	    cell.setCellStyle(style3);
	    cell.setCellValue("工伤/生育");
	    sheet.addMergedRegion(new CellRangeAddress(4,5,3,3));
	    
	    cell = row.createCell(4);
	    cell.setCellStyle(style3);
	    cell.setCellValue("失业");
	    sheet.addMergedRegion(new CellRangeAddress(4,5,4,4));
	    
	    cell = row.createCell(5);
	    cell.setCellStyle(style3);
	    cell.setCellValue("医保");
	    sheet.addMergedRegion(new CellRangeAddress(4,5,5,5));
	    for (int i = 6; i < 16; i++) {
	    	cell = row.createCell(i);
		    cell.setCellStyle(style3);
		    if (i%2==0) {
		    	cell.setCellValue("公司");
			}else {
				cell.setCellValue("个人");
			}
		    
		}
	    cell = row.createCell(16);
	    cell.setCellStyle(style3);
	    cell.setCellValue("公司");
	    sheet.addMergedRegion(new CellRangeAddress(4,5,16,16));
	    
	    cell = row.createCell(17);
	    cell.setCellStyle(style3);
	    cell.setCellValue("个人");
	    sheet.addMergedRegion(new CellRangeAddress(4,5,17,17));
	  //第6行
	    row = sheet.createRow(5);
	    cell = row.createCell(6);
	    cell.setCellStyle(style3);
	    cell.setCellValue("18%");
	    
	    cell = row.createCell(7);
	    cell.setCellStyle(style3);
	    cell.setCellValue("8%");
	    
	    cell = row.createCell(8);
	    cell.setCellStyle(style3);
	    cell.setCellValue("0.5%");
	    
	    cell = row.createCell(10);
	    cell.setCellStyle(style3);
	    cell.setCellValue("1%");
	    
	    cell = row.createCell(11);
	    cell.setCellStyle(style3);
	    cell.setCellValue("1%");
	    
	    cell = row.createCell(12);
	    cell.setCellStyle(style3);
	    cell.setCellValue("0.7%");
	    
	    cell = row.createCell(14);
	    cell.setCellStyle(style3);
	    cell.setCellValue("8%");
	    
	    cell = row.createCell(15);
	    cell.setCellStyle(style3);
	    cell.setCellValue("2%");
	    wb.write(os);
	}
}
