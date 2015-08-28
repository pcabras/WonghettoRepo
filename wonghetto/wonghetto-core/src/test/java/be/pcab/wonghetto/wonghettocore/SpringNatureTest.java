package be.pcab.wonghetto.wonghettocore;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.glassfish.grizzly.servlet.WebappContext;

import be.pcab.wonghetto.wonghettocore.persistence.dao.CategoryDAO;
import be.pcab.wonghetto.wonghettocore.service.CategoryTX;
import be.pcab.wonghetto.wonghettocore.service.CategoryTXManager;
import be.pcab.wonghetto.wonghettoserver.WebContainer;
import be.pcab.wonghetto.wonghettoserver.WonghettoServer;

public class SpringNatureTest {

	private static Logger logger = Logger.getLogger(SpringNatureTest.class);

	public static void main(String[] args) {

		WebappContext webappContext = WebContainer.createWebContext(true);

		WebContainer.registerServlet(webappContext);

		WonghettoServer server = new WonghettoServer(8082, null, webappContext);
		try {
			server.start();

			WonghettoContext.getInstance();
			
			
			
		} catch (IOException e) {

			logger.error(e);
		}
	}

}
