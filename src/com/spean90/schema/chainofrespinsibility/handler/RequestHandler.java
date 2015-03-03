package com.spean90.schema.chainofrespinsibility.handler;

/**
 * 责任链中处理请求的接口
* 
* @author Huangsp
* @date 2015年3月3日 
*
 */
public abstract class RequestHandler {
	
	protected RequestHandler nextHandler;

	public void setNextHandler(RequestHandler nextHandler) {
		this.nextHandler = nextHandler;
	}
	
	public abstract void processDiscount(float discount);
	

}
