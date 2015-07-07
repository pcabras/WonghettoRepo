package be.pcab.wonghetto.wonghettoserver;

import javax.servlet.ServletRegistration;

import org.apache.log4j.Logger;
import org.glassfish.grizzly.servlet.WebappContext;
import org.glassfish.jersey.servlet.ServletContainer;

/**
 * 
 * A class representing the web container.<br>
 * This class together with the {@link Configuration} class represents a servlet container
 * and its configuration (deployment descriptor) 
 * 
 * @author Paolo Cabras
 *
 */
public class WebContainer {

	private static Logger logger = Logger.getLogger(WebContainer.class);
	
	/**
	 * Creates and returns the {@link WebappContext}.
	 * 
	 * @return the {@link WebappContext}
	 */
	public static WebappContext createWebContext() {

		logger.debug("Creating Web Context...");
		
		WebappContext webappContext = new WebappContext(
				"Wonghetto Server Web Context");

		webappContext
				.addContextInitParameter("contextClass",
						"org.springframework.web.context.support.XmlWebApplicationContext");
		webappContext.addContextInitParameter("contextConfigLocation",
				"classpath*:application-context.xml");
		webappContext
				.addListener("org.springframework.web.context.ContextLoaderListener");

		logger.debug("Web Context created");
		
		return webappContext;
	}

	/**
	 * Registers the servlet according to the given {@link WebappContext}
	 * 
	 * @param webappContext
	 */
	public static void registerServlet(WebappContext webappContext) {

		logger.debug("Registering Servlet parameters...");
		
		ServletRegistration servletRegistration = webappContext.addServlet(
				"wonghetto servlet", ServletContainer.class);

		servletRegistration.setInitParameter("javax.ws.rs.Application",
				"be.pcab.wonghetto.wonghettoserver.Configuration");

		servletRegistration.setInitParameter(
				"com.sun.jersey.config.property.packages",
				"be.pcab.wonghetto.wonghettoserver");
		
		logger.debug("Servlet Parameters registered");
	}

}
