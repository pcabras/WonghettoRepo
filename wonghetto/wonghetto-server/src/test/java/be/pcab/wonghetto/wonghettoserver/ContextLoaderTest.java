package be.pcab.wonghetto.wonghettoserver;

import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

public class ContextLoaderTest {

	private ContextLoader loader;

	@Before
	public void setUp() throws Exception {

		loader = new ContextLoader();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetBean() {

		loader = new ContextLoader();
		
		LocalSessionFactoryBean bean = (LocalSessionFactoryBean) loader
				.getBean(LocalSessionFactoryBean.class);
		
		SessionFactory factory = bean.getObject(); 
		
		assertNotNull(factory);
	}

}
