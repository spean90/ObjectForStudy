package com.spean90.schema.adapter;


/**
 * 类适配器，通过继承已有的类和实现目标接口来实现功能、（因为单继承，所以不是很好）
* 
* @author Huangsp
* @date 2015年2月28日 
*
 */
public class TowPlugClassAdapter extends TowPlug implements IThreePlug {

	@Override
	public void chargingByThreePlug() {
		System.out.println("使用类适配器。。。");
		this.charging();
	}

}
