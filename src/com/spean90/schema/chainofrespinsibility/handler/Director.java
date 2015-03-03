package com.spean90.schema.chainofrespinsibility.handler;


/**
 * 销售总监
* 
* @author Huangsp
* @date 2015年3月3日 
*
 */
public class Director extends RequestHandler {

	@Override
	public void processDiscount(float discount) {

		if (discount<=0.20) {
			System.out.format("%s批准了折扣：%.2f%n", this.getClass().getName(),discount);
		}else {
			nextHandler.processDiscount(discount);
		}
		
	}

}
