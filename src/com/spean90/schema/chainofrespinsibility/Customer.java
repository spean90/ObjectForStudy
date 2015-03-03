package com.spean90.schema.chainofrespinsibility;

import java.util.Random;

import com.spean90.schema.chainofrespinsibility.handler.HandlerFactory;
import com.spean90.schema.chainofrespinsibility.handler.RequestHandler;

public class Customer {
	
	private RequestHandler requestHandler;

	public void setRequestHandler(RequestHandler requestHandler) {
		this.requestHandler = requestHandler;
	}
	
	public void requestDiscount(float discount) {
		requestHandler.processDiscount(discount);
	}

	public static void main(String[] args) {
		Customer customer = new Customer();
		customer.setRequestHandler(HandlerFactory.createHandler());
		Random random = new Random();
		for (int i = 0; i < 100; i++) {
			customer.requestDiscount(random.nextFloat());
		}
	}
	
}
