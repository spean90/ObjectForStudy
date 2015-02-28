package com.spean90.schema.adapter;


/**
 * 电脑，需要使用三孔插座；
* 
* @author Huangsp
* @date 2015年2月28日 
*
 */
public class Computer {
	
	IThreePlug threePlug;

	public Computer(IThreePlug threePlug) {
		this.threePlug = threePlug;
	}
	public void work() {
		threePlug.chargingByThreePlug();
	}
}
