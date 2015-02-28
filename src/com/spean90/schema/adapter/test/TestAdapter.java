package com.spean90.schema.adapter.test;

import org.junit.Test;

import com.spean90.schema.adapter.Computer;
import com.spean90.schema.adapter.TowPlug;
import com.spean90.schema.adapter.TowPlugAdapter;
import com.spean90.schema.adapter.TowPlugClassAdapter;

public class TestAdapter {
	//@Test
	public void testObjectAdapter() {
		TowPlug towPlug = new TowPlug();
		TowPlugAdapter towPlugAdapter = new TowPlugAdapter(towPlug);
		Computer computer = new Computer(towPlugAdapter);
		computer.work();
	}
	
	@Test
	public void testClassAdapter() {
		TowPlugClassAdapter towPlugClassAdapter = new TowPlugClassAdapter();
		Computer computer = new Computer(towPlugClassAdapter);
		computer.work();
	}

}
