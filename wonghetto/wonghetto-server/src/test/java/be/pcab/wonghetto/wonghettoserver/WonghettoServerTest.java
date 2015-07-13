package be.pcab.wonghetto.wonghettoserver;

import static org.junit.Assert.*;

import org.glassfish.grizzly.servlet.WebappContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WonghettoServerTest {

	private WonghettoServer server;

	
	@Before
	public void setUp() throws Exception {
		
		WebContainer webContainer = new WebContainer();
		
		WebappContext webappContext = webContainer.createWebContext(true);
		
		server = new WonghettoServer(8082, null, webappContext);
		
		server.start();
	}

	@After
	public void tearDown() throws Exception {
		
		server.stop();
	}

	@Test
	public void testStartServer() {
		
		assertTrue(!server.isStopped());
	}
	
	@Test
	public void testStopServer(){
		
		server.stop();
		
		assertTrue(server.isStopped());
	}

}
