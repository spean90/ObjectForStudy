package com.spean90.webservice.rest.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


public interface IUserService {
	
	@GET
	@Path("/getUserList")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<User> getUserList();
	
	@GET
	@Path("/getUserById/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public User getUserById(@PathParam("id")int id);
	
	
	
	/**  
	 * JSON提交  
	 * url:http://localhost/ws/user/addUser 
	 * Json format:{"user":{"id":"12345","name":"hello2"}}  
	 */  
	@POST
	@Path("/addUser")
	@Produces(MediaType.APPLICATION_JSON)
    @Consumes({MediaType.APPLICATION_JSON})
	public Object addUser(User user);
	
	
}
