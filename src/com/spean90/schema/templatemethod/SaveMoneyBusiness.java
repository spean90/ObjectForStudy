package com.spean90.schema.templatemethod;

public class SaveMoneyBusiness extends BankBusiness {

	@Override
	protected void handingCharge() {
		System.out.println("不需要手续费....");
	}

	//通过钩子函数、使得业务逻辑跳过handingCharge步骤；
	@Override
	protected boolean isNeedHandingCharge() {
		return false;
	};
	
	@Override
	protected void fillInTheForm() {
		System.out.println("填写存款单....");
	}
	

}
