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
import be.pcab.wonghetto.wonghettoserver.persistence.domain.Element;
import be.pcab.wonghetto.wonghettoserver.persistence.domain.User;

public class ElementResourceTest {

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
				.path("element").build();
	}

	@After
	public void tearDown() throws Exception {

		server.stop();
	}

	@Test
	public void testPostElement() {

		URI categoryURI = UriBuilder.fromUri("http://localhost").port(8082)
				.path("category").build();

		Response response = client.target(categoryURI).queryParam("id", 3)
				.request().accept(MediaType.APPLICATION_JSON).get();

		Category category = response.readEntity(Category.class);

		Element element = new Element();
		element.setName("fake document");
		element.setPath("/fake/path");
		element.setSize("1 Kib");
		element.setCategory(category);

		response = client.target(basicURI).request()
				.post(Entity.entity(element, MediaType.APPLICATION_JSON));

		int expectedStatus = 200;

		int actualStatus = response.getStatus();

		assertEquals(expectedStatus, actualStatus);

		response = client.target(basicURI).path("byCategoryAndUserName")
				.queryParam("categoryName", "categoryToDelete")
				.queryParam("userName", "userToDelete").request()
				.accept(MediaType.APPLICATION_JSON).get();

		@SuppressWarnings("unchecked")
		List<Element> elements = response.readEntity(List.class);

		int expected = 3;

		int actual = elements.size();

		assertEquals(expected, actual);
	}

	@Test
	public void testUpdateElement() {

		String expectedName = "modifiedFakeName";

		Response response = client.target(basicURI).queryParam("id", 6)
				.request().accept(MediaType.APPLICATION_JSON).get();

		Element element = response.readEntity(Element.class);

		element.setName(expectedName);

		response = client.target(basicURI).request()
				.put(Entity.entity(element, MediaType.APPLICATION_JSON));

		int expectedStatus = 200;

		int actualStatus = response.getStatus();

		assertEquals(expectedStatus, actualStatus);

		response = client.target(basicURI).queryParam("id", 6).request()
				.accept(MediaType.APPLICATION_JSON).get();

		element = response.readEntity(Element.class);

		String actualName = element.getName();

		assertEquals(expectedName, actualName);
	}

	@Test
	public void testDeleteElement() {

		Response response = client.target(basicURI).queryParam("id", 7)
				.request().accept(MediaType.APPLICATION_JSON).delete();

		int expectedStatus = 200;

		int actualStatus = response.getStatus();

		assertEquals(expectedStatus, actualStatus);

		response = client.target(basicURI).queryParam("id", 7).request()
				.accept(MediaType.APPLICATION_JSON).get();

		Element element = response.readEntity(Element.class);
		
		assertNull(element);
	}
}
