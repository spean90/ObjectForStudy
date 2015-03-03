package com.spean90.schema.chainofrespinsibility.handler;


/**
 * 总裁
* 
* @author Huangsp
* @date 2015年3月3日 
*
 */
public class CEO extends RequestHandler {

	@Override
	public void processDiscount(float discount) {

		if (discount<=0.50) {
			System.out.format("%s批准了折扣：%.2f%n", this.getClass().getName(),discount);
		}else {
			System.out.format("%s决绝了折扣：%.2f%n", this.getClass().getName(),discount);
		}
		
	}

}
