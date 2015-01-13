package com.spean90.poi;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelUtil {

	/**
	 * 根据list创建xls
	* @author Huangsp
	* @date 2015年1月12日 
	*
	* @param dataList
	* @param fileName
	* @param headMap
	* @param path
	* @throws Exception
	 */
	public static void createExcelByList(List<Object> dataList,String fileName,Map<String, String> headMap,String path) throws Exception {
		List<String> values = new ArrayList<String>();
		List<String> keys = new ArrayList<String>();
		if(headMap!=null){
			Set<String> keySet = headMap.keySet();
			Iterator<String> iter = keySet.iterator();
			
			while (iter.hasNext()) {
				String key = iter.next();
				values.add(headMap.get(key));
				keys.add(key);
			}
		}
		//创建workbook 一个workbook对应一个excel
		Workbook workbook = new HSSFWorkbook();
		//创建creationHelper 用于设置cell的格式
		CreationHelper createHelper = workbook.getCreationHelper();
		//设置样式
		CellStyle style = workbook.createCellStyle();
		style.setDataFormat(createHelper.createDataFormat().getFormat("yyyy-MM-dd HH:mm:ss"));
		style.setAlignment(CellStyle.ALIGN_CENTER);
		//下面2行为设置颜色
//		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
//	    style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		//创建sheet 一个excel有多个sheet
		Sheet sheet = workbook.createSheet("sheet1");
		
		//根据列名来设置列的宽度
		for (int i = 0; i < keys.size(); i++) {
			sheet.setColumnWidth(i, (values.get(i).length()+2)*2*256*2);
			sheet.setDefaultColumnStyle(i, style);
		}
		
		//创建行 从0开始
		Row row = sheet.createRow(0);
		//创建列 从0开始
		Cell cell = null;
		//设置列名；
		for (int i = 0; i < keys.size(); i++) {
			cell = row.createCell(i);
			cell.setCellStyle(style);
			cell.setCellValue(values.get(i));
		}
		//填充数据
		if (null!=dataList) {
			for (int i = 0; i < dataList.size(); i++) {
				row = sheet.createRow((int) i + 1);
				Object obj = dataList.get(i);
				for (int j = 0; j < keys.size(); j++) {
					cell = row.createCell(j);
					cell.setCellValue(String.valueOf(PropertyUtils.getProperty(obj, keys.get(j))));
				}
			}
		}
		File file = new File(path);
		if (!file.exists()) {
			file.createNewFile();
		}
		file = new File(path+"/"+fileName);
		FileOutputStream fout = new FileOutputStream(file);
		workbook.write(fout);
		fout.close();
	}
}
