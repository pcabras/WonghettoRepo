package be.pcab.wonghetto.wonghettoserver.service;

import static org.junit.Assert.*;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import be.pcab.wonghetto.wonghettoserver.persistence.domain.User;


/**
 * Test class for {@link UserTXManager}.<br>
 * As the service layer is meant here for dealing with transactional behavior,<br>
 * which is needed for performing CRUD, *TXManagers are the right classes to be tested<br>
 * instead of just DAOs.<br>
 * So, in the meantime, this class tests both queries syntax and transactional behavior. 
 * 
 * 
 * @author Paolo Cabras
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath*:application-context-tests.xml")
public class UserTXManagerTest {
	
	@Autowired
	private UserTX userTX;

	/**
	 * 
	 * The only method that need to be tested is {@link UserTXManager#getByUserName(String)}.
	 * The reason is that all others methods are façades for hibernate API while 
	 * {@link UserTXManager#getByUserName(String)} is a custom query.<br>
	 * 
	 */
	@Test
	public void testGetByUserName() throws Exception {
		
		User user = userTX.getByUserName("pcabras");
		
		assertNotNull(user);
	}


}
