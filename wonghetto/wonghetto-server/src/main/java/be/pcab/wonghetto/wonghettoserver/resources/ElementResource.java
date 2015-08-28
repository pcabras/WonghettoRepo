//package be.pcab.wonghetto.wonghettoserver.resources;
//
//import java.util.List;
//
//import javax.ws.rs.DELETE;
//import javax.ws.rs.GET;
//import javax.ws.rs.POST;
//import javax.ws.rs.PUT;
//import javax.ws.rs.Path;
//import javax.ws.rs.QueryParam;
//import javax.ws.rs.core.Response;
//
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import be.pcab.wonghetto.wonghettoserver.persistence.domain.Element;
//import be.pcab.wonghetto.wonghettoserver.service.CategoryTX;
//import be.pcab.wonghetto.wonghettoserver.service.ElementTX;
//import be.pcab.wonghetto.wonghettoserver.service.UserTX;
//
///**
// * The class representing REST resources for dealing with {@link Element}s
// * operations.
// * 
// * @author Paolo Cabras
// *
// */
//
//@Component
//@Path("/element")
//public class ElementResource {
//
//	private static Logger logger = Logger.getLogger(ElementResource.class);
//
//	@Autowired
//	private ElementTX elementTXManager;
//	
//	@Autowired
//	private UserTX userTXManager;
//	
//	@Autowired
//	private CategoryTX categoryTXManager; 
//
//	/**
//	 * POST method for storing {@link Element}s into DB.
//	 * 
//	 * @param element
//	 * @return
//	 */
//	@Path("/")
//	@POST
//	public Response postElement(Element element) {
//
//		Response response = null;
//
//		try {
//			
//			elementTXManager.create(element);
//
//			response = Response.ok().build();
//
//		} catch (Exception e) {
//
//			logger.error(e);
//
//			response = Response.notModified().build();
//		}
//
//		return response;
//	}
//
//	/**
//	 * PUT method for updating {@link Element}s into DB.
//	 * 
//	 * @param element
//	 * @return
//	 */
//	@Path("/")
//	@PUT
//	public Response updateElement(Element element) {
//
//		Response response = null;
//
//		try {
//
//			elementTXManager.update(element);
//
//			response = Response.ok().build();
//
//		} catch (Exception e) {
//
//			logger.error(e);
//
//			response = Response.notModified().build();
//		}
//
//		return response;
//	}
//
//	/**
//	 * DELETE method for deleting {@link Element}s from DB.
//	 * 
//	 * @param element
//	 * @return
//	 */
//	@Path("/")
//	@DELETE
//	public Response deleteElement(@QueryParam("id")long id) {
//
//		Response response = null;
//
//		try {
//
//			Element element = elementTXManager.getById(id);
//			
//			elementTXManager.delete(element);
//
//			response = Response.ok().build();
//
//		} catch (Exception e) {
//
//			logger.error(e);
//
//			response = Response.notModified().build();
//		}
//
//		return response;
//	}
//
//	/**
//	 * GET method for retrieving {@link Element}s from DB.
//	 * 
//	 * @param id
//	 * @return
//	 */
//	@Path("/")
//	@GET
//	public Response getElement(@QueryParam("id")long id) {
//
//		Response response = null;
//
//		try {
//
//			Element element = elementTXManager.getById(id);
//
//			response = Response.ok(element).build();
//
//		} catch (Exception e) {
//
//			logger.error(e);
//
//			response = Response.noContent().build();
//		}
//
//		return response;
//	}
//
//	@Path("/byCategoryAndUserName")
//	@GET
//	public Response getElementByCategoryAnUserName(
//			@QueryParam("categoryName") String categoryName,
//			@QueryParam("userName") String userName) {
//
//		Response response = null;
//
//		try {
//			
//			List<Element> elements = elementTXManager.getByCategoryAndUserName(
//					categoryName, userName);
//			
//			response = Response.ok(elements).build();
//			
//		} catch (Exception e) {
//
//			logger.error(e);
//			
//			response = Response.noContent().build();
//		}
//
//		return response;
//
//	}
//
//}
