package com.spean90.proxy;

public class Car implements Moveable {

	@Override
	public void move(String speed) {
		System.out.println("Car..行驶...."+speed);
	}

}
