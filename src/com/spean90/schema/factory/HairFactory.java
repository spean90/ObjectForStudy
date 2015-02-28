package com.spean90.schema.factory;

public class HairFactory {

	//根据类名来创建实例
	public static HairInterface getHair(Class clazz) {
		System.out.println(clazz+" : "+clazz.getName());
		HairInterface hair = null;
		try {
			hair = (HairInterface) Class.forName(clazz.getName()).newInstance();
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}
		return hair;
	}
}
