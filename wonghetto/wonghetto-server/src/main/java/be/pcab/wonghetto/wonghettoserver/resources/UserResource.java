package be.pcab.wonghetto.wonghettoserver.resources;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import be.pcab.wonghetto.wonghettoserver.persistence.domain.User;
import be.pcab.wonghetto.wonghettoserver.service.UserTX;

/**
 * 
 * The class representing REST resources for for dealing with {@link User}s operations.
 * 
 * @author Paolo Cabras
 *
 */

@Component
@Path("/user")
public class UserResource {

	private static Logger logger = Logger.getLogger(UserResource.class);
	
	@Autowired
	private UserTX userTxManager;
	
	/**
	 * POST method for storing users into DB.
	 * 
	 * @param user
	 * @return a {@link Response} object according to workflow.
	 */	
	@Path("/")
	@POST
	public Response postUser(User user){
		
		Response response = null;
		
		try {
			userTxManager.create(user);
			
			response = Response.ok().build();
			
		} catch (Exception e) {
			
			logger.error(e);
			
			response = Response.notModified().build();
		}
		
		return response;
	}
	
	/**
	 * PUT method for updating Users into DB.
	 * 
	 * @param user
	 * @return a {@link Response} object according to workflow. 
	 */
	@Path("/")
	@PUT
	public Response putUser(User user){
		
		Response response = null;
		
		try {
			
			userTxManager.update(user);
			
			response = Response.ok().build();
			
		} catch (Exception e) {
			
			logger.error(e);
			
			response = Response.notModified().build();
		}
		
		return response;
	}
	
	/**
	 * DELETE method for deleting users from DB.
	 * 
	 * @param user
	 * @return a {@link Response} object according to workflow.
	 */
	@Path("/")
	@DELETE
	public Response deleteUser(User user){
		
		Response response = null;
		
		try {
			userTxManager.delete(user);
			
			response = Response.ok().build();
			
		} catch (Exception e) {
			
			logger.error(e);
			
			response = Response.notModified().build();
		}
		
		return response;
	}
	
	/**
	 * GET method for retrieving users by their username
	 * 
	 * @param userName
	 * @return a {@link Response} object according to workflow.
	 */
	@Path("/")
	@GET
	public Response getUser(String userName){
		
		Response response = null;
		
		try {
			
			
			User user = userTxManager.getByUserName(userName);
			
			response = Response.ok(user).build();
			
		} catch (Exception e) {
			
			logger.error(e);
			
			response = Response.noContent().build();
		}
		
		return response;
	}
	
	
}
