package com.spean90.webservice.rest.service;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="user")
public class User {
	private int id;
	private String name;
	
	public User() {
	}
	public User(int id,String name){
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "id: "+id+", name: "+name;
	}
	
	@XmlElement(name="id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@XmlElement(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
