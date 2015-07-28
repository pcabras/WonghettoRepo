package be.pcab.wonghetto.wonghettoserver.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import be.pcab.wonghetto.wonghettoserver.persistence.domain.Category;
import be.pcab.wonghetto.wonghettoserver.persistence.domain.Element;

/**
 * 
 * Test class for {@link ElementTXManager}.<br>
 * As the service layer is meant here for dealing with transactional behavior,<br>
 * which is needed for performing CRUD, *TXManagers are the right classes to be
 * tested<br>
 * instead of just DAOs.<br>
 * So, in the meantime, this class tests both queries syntax and transactional
 * behavior.
 * 
 * 
 * @author Paolo Cabras
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:application-context-tests.xml")
public class ElementTXManagerTest {

	@Autowired
	private ElementTX elementTXManager;
	
	@Autowired
	private CategoryTX categoryTXManager;

	@Test
	public void testGetByCategoryName() throws Exception {

		List<Element> elements = elementTXManager
				.getByCategoryName("Documents");

		int expected = 3;

		int actual = elements.size();

		assertEquals(expected, actual);
	}

	@Test
	public void testGetByCategoryAndUserName() throws Exception {

		List<Element> elements = elementTXManager.getByCategoryAndUserName(
				"categoryToDelete", "userToDelete");
		
		int expected = 1;
		
		int actual = elements.size();
		
		assertEquals(expected, actual);
	}
	


}
