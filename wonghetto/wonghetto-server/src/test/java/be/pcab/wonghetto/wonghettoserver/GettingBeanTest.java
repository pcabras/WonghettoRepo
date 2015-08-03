package be.pcab.wonghetto.wonghettoserver;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import be.pcab.wonghetto.wonghettoserver.testpackage.AnnotatedTestBean;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath*:application-context-tests.xml")
public class GettingBeanTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {

		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"classpath*:application-context-tests.xml");
		
		AnnotatedTestBean annotatedTestBean = (AnnotatedTestBean) applicationContext.getBean("annotatedTestBean");

		assertNotNull(annotatedTestBean);
		
		assertEquals("It works", annotatedTestBean.getMessage());
		
	}

}
