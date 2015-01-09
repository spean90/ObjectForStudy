package com.spean90.poi.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.spean90.poi.ExcelUtil;

public class TestExcelUtil {

	
	@Test
	public void testCreateExcel() {
		List list = new ArrayList();
		Map<String, Object> data = null;
		for (int i = 0; i < 10; i++) {
			data = new HashMap<String, Object>();
			data.put("time", new Date());
			data.put("name", "name"+i);
			data.put("account", i);
			list.add(data);
		}
		Map<String, String> headMap = new HashMap<String, String>();
		headMap.put("time", "时  间");
		headMap.put("name", "名 称");
		headMap.put("account", "账  号");
		try {
			ExcelUtil.createExcelByList(list, "test.xls",headMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
