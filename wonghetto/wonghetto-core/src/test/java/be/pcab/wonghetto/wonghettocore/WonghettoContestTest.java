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

	@Before
	public void setUp() throws Exception {

		context = WonghettoContext.getInstance();

		context.refresh();


	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testRetrievingSpringComponents() {

		CategoryTX categoryTX = (CategoryTX) context.getBean("categoryTXManager");
		
		assertNotNull(categoryTX);
	}

}
