package be.pcab.wonghetto.wonghettoserver;

import java.io.IOException;
import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import org.apache.log4j.Logger;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.NetworkListener;
import org.glassfish.grizzly.servlet.WebappContext;

/**
 * The class representing Wonghetto Server
 * 
 * @author Paolo Cabras
 *
 */
public class WonghettoServer {

	private static Logger logger = Logger.getLogger(WonghettoServer.class);
	
	private int port;

	private WebappContext webappContext;

	private final String defaultUrl = "http://localhost";

	private String SERVER_ADDRESS;

	private HttpServer server;

	private NetworkListener listener;
	
	private boolean stopped;

	/**
	 * It constructs Wonghetto Server reachable at the given url, listening to the given port
	 * and according to the given {@link WebappContext}.
	 * 
	 * @param port
	 * @param url
	 * @param webappContext
	 */
	public WonghettoServer(int port, String url, WebappContext webappContext) {

		this.port = port;

		this.webappContext = webappContext;

		String connectionUrl = (url == null) ? defaultUrl : url;

		URI BASE_URI = UriBuilder.fromUri(connectionUrl).port(port).build();

		SERVER_ADDRESS = BASE_URI.getHost();

	}

	/**
	 * Starts the server
	 * 
	 * @throws IOException
	 */
	public void start() throws IOException {

		initializeServer();

		server.start();
		
		logger.debug("Server started");
	}

	/**
	 * Initializes the server
	 * 
	 */
	private void initializeServer() {

		server = new HttpServer();

		listener = new NetworkListener("grizzly2", SERVER_ADDRESS, port);

		server.addListener(listener);

		webappContext.deploy(server);
		
		setStopped(false);
	}

	/**
	 * 
	 * Stops the server
	 */
	public void stop() {

		server.shutdown();
		
		setStopped(true);
		
		logger.debug("Server Stopped");
	}

	public boolean isStopped() {
		return stopped;
	}

	public void setStopped(boolean stopped) {
		this.stopped = stopped;
	}
}
