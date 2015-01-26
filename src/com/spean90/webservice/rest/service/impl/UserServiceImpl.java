package com.spean90.webservice.rest.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import com.spean90.webservice.rest.service.IUserService;
import com.spean90.webservice.rest.service.User;

public class UserServiceImpl implements IUserService {
	
	
	public UserServiceImpl() {
		System.out.println("UserServiceImpl()....");
	}

	@Override
	public List<User> getUserList() {
		List<User> list = new ArrayList<User>();
		list.add(new User(1, "test1"));
		list.add(new User(2, "test2"));
		list.add(new User(3, "test3"));
		list.add(new User(4, "test4"));
		return list;
	}

	@Override
	public User getUserById(int id) {
		return new User(id, "name");
	}

	@Override
	public Object addUser(User user) {
		System.out.println("...addUser...");
		return Response.ok().entity(user.toString()).build();
	}

}
