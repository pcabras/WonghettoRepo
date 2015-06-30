package be.pcab.wonghetto.wonghettocore.cloud;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.glassfish.grizzly.servlet.WebappContext;

import be.pcab.wonghetto.wonghettocore.model.CategoryModel;
import be.pcab.wonghetto.wonghettoserver.WebContainer;
import be.pcab.wonghetto.wonghettoserver.WonghettoServer;

public class WonghettoCloud {
	
	
	private static Logger logger = Logger.getLogger(WonghettoCloud.class);
	
	private WonghettoServer server;
	
	public synchronized void getIn(){
		
		WebappContext webappContext = WebContainer.createWebContext();
		
		server = new WonghettoServer(8082, null, webappContext);
		
		try {
			server.start();
		} catch (IOException e) {
			logger.error(e);
		}
	}
	
	public synchronized void getOut(){
		
		server.stop();
	}
	
	
	public synchronized void synchronize(CategoryModel...categoryModels ){
		
//		my custom implementation
	}

}
