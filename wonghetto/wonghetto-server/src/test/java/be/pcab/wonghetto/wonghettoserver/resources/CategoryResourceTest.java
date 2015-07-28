package be.pcab.wonghetto.wonghettoserver.resources;

import static org.junit.Assert.*;

import java.net.URI;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.grizzly.servlet.WebappContext;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import be.pcab.wonghetto.wonghettoserver.WebContainer;
import be.pcab.wonghetto.wonghettoserver.WonghettoServer;
import be.pcab.wonghetto.wonghettoserver.persistence.domain.Category;
import be.pcab.wonghetto.wonghettoserver.persistence.domain.User;

public class CategoryResourceTest {

	private URI basicURI;

	private Client client;

	private WonghettoServer server;

	@Before
	public void setUp() throws Exception {

		client = ClientBuilder.newClient(new ClientConfig()
				.register(JacksonFeature.class));

		WebappContext webappContext = WebContainer.createWebContext(true);

		WebContainer.registerServlet(webappContext);

		server = new WonghettoServer(8082, null, webappContext);
		server.start();

		basicURI = UriBuilder.fromUri("http://localhost").port(8082)
				.path("category").build();
	}

	@After
	public void tearDown() throws Exception {

		server.stop();
	}

	@Test
	public void testPostCategory() {

		User user = new User();
		user.setUserName("pcabras");

		Category category = new Category();
		category.setName("fakeCategory");
		category.setUser(user);

		Response response = client.target(basicURI).request()
				.post(Entity.entity(category, MediaType.APPLICATION_JSON));

		int expectedStatus = 200;

		int actualStatus = response.getStatus();

		assertEquals(expectedStatus, actualStatus);

		response = client.target(basicURI).path("/byUserName")
				.queryParam("userName", "pcabras").request()
				.accept(MediaType.APPLICATION_JSON).get();

		@SuppressWarnings("unchecked")
		List<Category> categories = response.readEntity(List.class);

		int expected = 4;

		int actual = categories.size();

		assertEquals(expected, actual);
	}

	@Test
	public void testPutCategory() {

		Response response = client.target(basicURI).queryParam("id", 1)
				.request().accept(MediaType.APPLICATION_JSON).get();

		Category category = response.readEntity(Category.class);

		String newCategoryName = "MyMusic";

		category.setName(newCategoryName);

		response = client.target(basicURI).request()
				.put(Entity.entity(category, MediaType.APPLICATION_JSON));

		int expectedStatus = 200;

		int actualStatus = response.getStatus();

		assertEquals(expectedStatus, actualStatus);

		response = client.target(basicURI).queryParam("id", 1).request()
				.accept(MediaType.APPLICATION_JSON).get();

		String actualCategoryname = response.readEntity(Category.class)
				.getName();

		assertEquals(newCategoryName, actualCategoryname);

	}

	@Test
	public void testDeleteCategory() {

		Response response = client.target(basicURI).queryParam("id", 3)
				.request().delete();

		int expectedStatus = 200;

		int actualStatus = response.getStatus();

		assertEquals(expectedStatus, actualStatus);
		
		response = client.target(basicURI).queryParam("id", 3).request()
				.accept(MediaType.APPLICATION_JSON).get();
		
		Category category = response.readEntity(Category.class);
		
		assertNull(category);
	}

}
