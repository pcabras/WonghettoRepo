package be.pcab.wonghetto.wonghettoserver.resources;

import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;

@Component
@Path("/info")
public class InfoResource {

	private static Logger logger = Logger.getLogger(InfoResource.class);
	
	@SuppressWarnings("unchecked")
	@Path("/")
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response info(){
		
		Response response = null;
		
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("Server Name", "Woghetto Server");
		jsonObject.put("Date", new Date());
		
		response = Response.ok("Target Reached").build();
		
		logger.debug(jsonObject.toJSONString());
		
//		response = Response.ok(jsonObject).build();
		
		return response;
	}
}
