package com.spean90.schema.templatemethod.test;

import org.junit.Test;

import com.spean90.schema.templatemethod.BankBusiness;
import com.spean90.schema.templatemethod.OpenAccountBusiness;
import com.spean90.schema.templatemethod.SaveMoneyBusiness;

public class TestBusiness {

	
	@Test
	public void testOpenAccount() {
		BankBusiness openAccount = new OpenAccountBusiness();
		openAccount.doBusiness();
	}
	
	@Test
	public void testSaveMoney() {
		System.out.println("*******************");
		BankBusiness saveMoney = new SaveMoneyBusiness();
		saveMoney.doBusiness();
	}
}
