package be.pcab.wonghetto.wonghettoserver;

import org.apache.log4j.Logger;
import org.glassfish.jersey.server.ResourceConfig;

//import be.pcab.wonghetto.wonghettoserver.resources.CategoryResource;
//import be.pcab.wonghetto.wonghettoserver.resources.ElementResource;
import be.pcab.wonghetto.wonghettoserver.resources.InfoResource;
//import be.pcab.wonghetto.wonghettoserver.resources.UserResource;


/**
 * An extension of the {@link ResourceConfig} class.<br>
 * This class together with the {@link WebContainer} represent a servlet container
 * and its configuration (deployment descriptor) 
 * 
 * @author Paolo Cabras
 *
 */
public class Configuration extends ResourceConfig {
	
	private static Logger logger = Logger.getLogger(Configuration.class);
	
	public Configuration() {
		
		logger.debug("Configuring Resources...");
		
		this.register(InfoResource.class);
//		this.register(UserResource.class);
//		this.register(CategoryResource.class);
//		this.register(ElementResource.class);
		
		logger.debug("Resources configured");
	}

}
