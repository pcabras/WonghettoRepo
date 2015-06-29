package be.pcab.wonghetto.wonghettoserver;

import javax.servlet.ServletRegistration;

import org.apache.log4j.Logger;
import org.glassfish.grizzly.servlet.WebappContext;
import org.glassfish.jersey.servlet.ServletContainer;

public class WebContainer {

	private static Logger logger = Logger.getLogger(WebContainer.class);
	
	public static WebappContext createWebContext() {

		logger.debug("Creating Web Context...");
		
		WebappContext webappContext = new WebappContext(
				"Wonghetto Server Web Context");

		webappContext
				.addContextInitParameter("contextClass",
						"org.springframework.web.context.support.XmlWebApplicationContext");
		webappContext.addContextInitParameter("contextConfigLocation",
				"classpath*:spring-context.xml");
		webappContext
				.addListener("org.springframework.web.context.ContextLoaderListener");

		logger.debug("Web Context created");
		
		return webappContext;
	}

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
