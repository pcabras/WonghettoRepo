package be.pcab.wonghetto.wonghettocore;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import be.pcab.wonghetto.wonghettocore.cloud.AOPService;
import be.pcab.wonghetto.wonghettoserver.persistence.domain.Category;

public class CloudInitializerTest {

	private CloudInitializer init;
	
//	@Autowired
//	private AOPService service;
	
	@Before
	public void setUp() throws Exception {
		
		init = new CloudInitializer();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetBean() {
		
		AOPService service = (AOPService) init.getBean(AOPService.class);
		assertTrue(service.isStarted());
	}

}
