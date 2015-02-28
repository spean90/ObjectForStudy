package com.spean90.schema.factory.test;

import org.junit.Test;

import com.spean90.schema.factory.HairFactory;
import com.spean90.schema.factory.HairInterface;
import com.spean90.schema.factory.LeftHair;

public class TestHairFactory {

	@Test
	public void testGetHair() {
		HairInterface hair = HairFactory.getHair(LeftHair.class);
		hair.drow();
	}
}
