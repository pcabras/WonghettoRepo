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

import be.pcab.wonghetto.wonghettoserver.persistence.domain.Category;
import be.pcab.wonghetto.wonghettoserver.service.CategoryTXManager;

/**
 * The class representing REST resources for dealing with {@link Category}ies operations.
 * 
 * @author Paolo Cabras
 *
 */

@Component
@Path("/category")
public class CategoryResource {

	private static Logger logger = Logger.getLogger(CategoryResource.class);
	
	@Autowired
	private CategoryTXManager categoryTXManager;
	
	
	/**
	 * POST method for storing {@link Category}ies into DB
	 * 
	 * @param category
	 * @return a {@link Response} object according to workflow
	 */
	@Path("/")
	@POST
	public Response postCategory(Category category){
		
		Response response = null;
		
		try {
			categoryTXManager.create(category);
			
			response = Response.ok().build();
			
		} catch (Exception e) {
			
			logger.error(e);
			
			response = Response.notModified().build();
		}
		
		return response;
	}
	
	/**
	 * PUT method for updating {@link Category}ies into DB.
	 * 
	 * @param category
	 * @return
	 */
	@Path("/")
	@PUT
	public Response putCategory(Category category){
		
		Response response = null;
		
		try {
			categoryTXManager.update(category);
			
			response = Response.ok().build();
			
		} catch (Exception e) {
			
			logger.error(e);
			
			response = Response.notModified().build();
		}
		
		return response;
	}
	
	/**
	 * DELETE method for deleting {@link Category}ies from DB.
	 * 
	 * @param category
	 * @return
	 */
	@Path("/")
	@DELETE
	public Response deleteCategory(Category category){
		
		Response response = null;
		
		try {
			categoryTXManager.delete(category);
			
			response = Response.ok().build();
			
		} catch (Exception e) {
			
			logger.error(e);
			
			response = Response.notModified().build();
		}
		
		return response;
	}
	
	/**
	 * GET method for retrieving {@link Category}ies from DB.
	 * 
	 * @param id
	 * @return
	 */
	@Path("/")
	@GET
	public Response getCategory(long id){
		
		Response response = null;
		
		try {
			
			Category category = categoryTXManager.getById(id);
			
			response = Response.ok(category).build(); 
			
		} catch (Exception e) {
			
			logger.error(e);
			
			response = Response.noContent().build();
		}
		
		return response;
	}
}
