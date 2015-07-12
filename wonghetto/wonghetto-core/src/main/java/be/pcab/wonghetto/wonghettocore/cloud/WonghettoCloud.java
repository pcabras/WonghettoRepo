package be.pcab.wonghetto.wonghettocore.cloud;

import java.io.IOException;

import javafx.collections.ObservableList;

import org.apache.log4j.Logger;
import org.glassfish.grizzly.servlet.WebappContext;

import be.pcab.wonghetto.wonghettocore.model.CategoryModel;
import be.pcab.wonghetto.wonghettoserver.WebContainer;
import be.pcab.wonghetto.wonghettoserver.WonghettoServer;

/**
 * A class representing the cloud.<br>
 * As it is conceived, you can <b>{@link #getIn()}</b> the cloud so being able to access<br>
 * its resources, you can <b>{@link #synchronize()}</b> your view with your sub-set and <br>
 * finally, when you have done, <b>{@link #getOut()}</b>.<br>
 * The private cloud should have users-defined sub-set (or sub-cloud) which can be <= to the whole<br>
 * available cloud.   
 * 
 * @author Paolo Cabras
 *
 */
public class WonghettoCloud {
	
	
	private static Logger logger = Logger.getLogger(WonghettoCloud.class);
	
	private WonghettoServer server;
	
	/**
	 * Gets in the cloud.
	 * 
	 */
	public synchronized void getIn(){
		
		WebappContext webappContext = WebContainer.createWebContext();
		
		server = new WonghettoServer(8082, null, webappContext);
		
		try {
			server.start();
		} catch (IOException e) {
			logger.error(e);
		}
	}
	
	/**
	 * 
	 * Gets out the cloud
	 */
	public synchronized void getOut(){
		
		server.stop();
	}
	
	/**
	 * Lets synchronize the current workspace or view with users sub-set or sub-cloud.
	 * 
	 * @param categoryModels Objects carrying info to be synchronized.
	 */
	public synchronized void synchronize(ObservableList<CategoryModel> categoryModels){
		
//		if(categoryModels.isEmpty())
		
	}

}
