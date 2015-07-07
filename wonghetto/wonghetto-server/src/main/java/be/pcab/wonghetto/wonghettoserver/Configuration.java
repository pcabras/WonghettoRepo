package be.pcab.wonghetto.wonghettoserver;

import org.apache.log4j.Logger;
import org.glassfish.jersey.server.ResourceConfig;


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
		
		logger.debug("Resources configured");
	}

}
