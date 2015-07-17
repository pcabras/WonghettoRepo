package be.pcab.wonghetto.wonghettoserver.resources;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.grizzly.servlet.WebappContext;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.json.simple.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import be.pcab.wonghetto.wonghettoserver.WebContainer;
import be.pcab.wonghetto.wonghettoserver.WonghettoServer;

public class InfoResourceTest {

	private URI basicURI;

	private String targetAddress;

	private Client client;

	private WonghettoServer server;
	
	private Process process;

	@Before
	public void setUp() throws Exception {

		client = ClientBuilder.newClient(new ClientConfig()
		.register(JacksonFeature.class));
		
		targetAddress = getExternalIP();
		
		targetAddress = targetAddress.replace("\n", "");
		
		forwardServer(targetAddress);
		
		WebappContext webappContext = WebContainer.createWebContext(true);

		server = new WonghettoServer(8082, null, webappContext);
		server.start();

		basicURI = UriBuilder.fromUri(targetAddress)
				.port(80) .path("/info").build();

	}

	@After
	public void tearDown() throws Exception {

		server.stop();
		
		stopForwarding();
	}

	@Test
	public void testTunnelingInfoResource() {

		Response response = client.target("http://" + targetAddress + ":80").path("/info")
				.request().get();

//		 JSONObject jsonObject = response.readEntity(JSONObject.class);

		String retrieved = response.readEntity(String.class);

		assertNotNull( /*jsonObject*/ retrieved);

		 System.out.println(retrieved);
	}

	private String getExternalIP() {

		String ip = null;

		Response response = client.target("http://checkip.amazonaws.com/")
				.request().get();

		ip = response.readEntity(String.class);

		return ip;
	}

	private void forwardServer(String target) throws IOException {

		process = Runtime.getRuntime().exec(
				"java -jar jTCPfwd-lite.jar 8082 " + target + ":80");

	}
	
	private void stopForwarding(){
		
		process.destroy();
	}
}
