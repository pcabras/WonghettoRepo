//package be.pcab.wonghetto.wonghettoserver.resources;
//
//import static org.junit.Assert.*;
//
//import java.net.URI;
//import java.util.List;
//
//import javax.ws.rs.client.Client;
//import javax.ws.rs.client.ClientBuilder;
//import javax.ws.rs.client.Entity;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//import javax.ws.rs.core.UriBuilder;
//
//import org.glassfish.grizzly.servlet.WebappContext;
//import org.glassfish.jersey.client.ClientConfig;
//import org.glassfish.jersey.jackson.JacksonFeature;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import be.pcab.wonghetto.wonghettoserver.WebContainer;
//import be.pcab.wonghetto.wonghettoserver.WonghettoServer;
//
//
//public class UserResourceTest {
//
//	private URI basicURI;
//
//	private Client client;
//
//	private WonghettoServer server;
//
//	@Before
//	public void setUp() throws Exception {
//
//		client = ClientBuilder.newClient(new ClientConfig()
//				.register(JacksonFeature.class));
//
//		WebappContext webappContext = WebContainer.createWebContext(true);
//
//		WebContainer.registerServlet(webappContext);
//
//		server = new WonghettoServer(8082, null, webappContext);
//		server.start();
//
//		basicURI = UriBuilder.fromUri("http://localhost").port(8082)
//				.path("user").build();
//	}
//
//	@After
//	public void tearDown() throws Exception {
//
//		server.stop();
//	}
//
//	@Test
//	public void testPostUser() {
//
//		User user = new User();
//		user.setUserName("fakeUserName");
//		user.setPassword("fakeUserPsw");
//
//		Response response = client.target(basicURI).request()
//				.accept(MediaType.APPLICATION_JSON)
//				.post(Entity.entity(user, MediaType.APPLICATION_JSON));
//
//		int expected = 200;
//
//		int actual = response.getStatus();
//
//		assertEquals(expected, actual);
//
//		response = client.target(basicURI).path("/all").request()
//				.accept(MediaType.APPLICATION_JSON).get();
//
//		@SuppressWarnings("unchecked")
//		List<User> users = (List<User>) response.readEntity(List.class);
//
//		expected = 3;
//
//		actual = users.size();
//
//		assertEquals(expected, actual);
//	}
//
//	@Test
//	public void testPutUser() {
//
//		Response response = client.target(basicURI)
//				.queryParam("userName", "pcabras").request()
//				.accept(MediaType.APPLICATION_JSON).get();
//
//		User user = response.readEntity(User.class);
//
//		user.setUserName("pcabras1");
//
//		long expectedId = user.getUserId();
//
//		response = client.target(basicURI).request()
//				.put(Entity.entity(user, MediaType.APPLICATION_JSON));
//
//		int expectedStatus = 200;
//
//		int actualStatus = response.getStatus();
//
//		assertEquals(expectedStatus, actualStatus);
//
//		response = client.target(basicURI).queryParam("userName", "pcabras1")
//				.request().accept(MediaType.APPLICATION_JSON).get();
//
//		long actualId = response.readEntity(User.class).getUserId();
//
//		assertEquals(expectedId, actualId);
//
//	}
//
//	@Test
//	public void testDeleteUser() {
//
//		Response response = client.target(basicURI)
//				.queryParam("userName", "userToDelete").request()
//				.accept(MediaType.APPLICATION_JSON).delete();
//
//		int expectedStatus = 200;
//
//		int actualStatus = response.getStatus();
//
//		assertEquals(expectedStatus, actualStatus);
//
//		response = client.target(basicURI)
//				.queryParam("userName", "userToDelete").request()
//				.accept(MediaType.APPLICATION_JSON).get();
//		
//		User userToCheck = response.readEntity(User.class);
//		
//		assertNull(userToCheck);
//	}
//
//}
