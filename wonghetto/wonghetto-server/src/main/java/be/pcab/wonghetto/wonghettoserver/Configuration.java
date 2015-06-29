package be.pcab.wonghetto.wonghettoserver;

import org.apache.log4j.Logger;
import org.glassfish.jersey.server.ResourceConfig;



public class Configuration extends ResourceConfig {
	
	private static Logger logger = Logger.getLogger(Configuration.class);
	
	public Configuration() {
		
		logger.debug("Configuring Resources...");
		
		logger.debug("Resources configured");
	}

}
