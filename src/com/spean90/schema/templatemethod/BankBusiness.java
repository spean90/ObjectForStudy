package com.spean90.schema.templatemethod;

public abstract class BankBusiness {

	public final void doBusiness() {
		takeNo();
		fillInTheForm();
		handle();
		if(isNeedHandingCharge()){
			handingCharge();
		}
		
	}

	//提供一个钩子函数，让子类灵活控制业务逻辑
	protected boolean isNeedHandingCharge() {
		return true;
	}

	protected abstract void handingCharge();

	private void handle() {
		System.out.println("叫号..到窗口办理业务...");
	}

	protected abstract void fillInTheForm();

	private void takeNo() {
		System.out.println("取号...");
	}
}
