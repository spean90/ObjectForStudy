package com.spean90.schema.adapter;


/**
 * 对象适配器，通过实现目标接口+聚会实现类，来实现；
* 
* @author Huangsp
* @date 2015年2月28日 
*
 */
public class TowPlugAdapter implements IThreePlug {
	
	public TowPlug towPlug;
	public TowPlugAdapter(TowPlug towPlug) {
		this.towPlug = towPlug;
	}

	@Override
	public void chargingByThreePlug() {
		System.out.println("使用适配器..");
		towPlug.charging();
	}

}
