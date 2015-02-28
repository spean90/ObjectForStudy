package com.spean90.schema.templatemethod;

public class OpenAccountBusiness extends BankBusiness {

	@Override
	protected void handingCharge() {
		System.out.println("交10块开户手续费....");
	}

	@Override
	protected void fillInTheForm() {
		System.out.println("填写开户表格....");
	}

}
