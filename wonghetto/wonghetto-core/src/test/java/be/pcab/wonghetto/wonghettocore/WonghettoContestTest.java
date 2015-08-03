package be.pcab.wonghetto.wonghettocore;

import static org.junit.Assert.*;

import org.glassfish.grizzly.servlet.WebappContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import be.pcab.wonghetto.wonghettoserver.WebContainer;
import be.pcab.wonghetto.wonghettoserver.WonghettoServer;
import be.pcab.wonghetto.wonghettoserver.service.CategoryTX;
import be.pcab.wonghetto.wonghettoserver.testpackage.AnnotatedTestBean;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath*:application-context-tests.xml")
public class WonghettoContestTest {

	private WonghettoContext context;

	private AnnotationConfigApplicationContext applicationContext;

	private WonghettoServer server;

	@Before
	public void setUp() throws Exception {

		context = WonghettoContext.getInstance();

		context.refresh();

		WebContainer webContainer = new WebContainer();

		WebappContext webappContext = webContainer.createWebContext(true);
		
		server = new WonghettoServer(8082, null, webappContext);
	}

	@After
	public void tearDown() throws Exception {

		server.stop();
	}

	@Test
	public void testRetrievingSpringComponents() {

		AnnotatedTestBean annotatedTestBean = (AnnotatedTestBean) context.getBean("notAnnotatedTestBean");
		
		assertNotNull(annotatedTestBean);
	}

}
