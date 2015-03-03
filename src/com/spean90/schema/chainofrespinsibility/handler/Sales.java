package com.spean90.schema.chainofrespinsibility.handler;


public class Sales extends RequestHandler {

	@Override
	public void processDiscount(float discount) {

		if (discount<=0.05) {
			System.out.format("%s批准了折扣：%.2f%n", this.getClass().getName(),discount);
		}else {
			nextHandler.processDiscount(discount);
		}
		
	}

}
