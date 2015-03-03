package com.spean90.schema.chainofrespinsibility.handler;


/**
 * 副总裁
* 
* @author Huangsp
* @date 2015年3月3日 
*
 */
public class VicePresident extends RequestHandler {

	@Override
	public void processDiscount(float discount) {

		if (discount<=0.40) {
			System.out.format("%s批准了折扣：%.2f%n", this.getClass().getName(),discount);
		}else {
			nextHandler.processDiscount(discount);
		}
		
	}

}
