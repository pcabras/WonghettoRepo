package be.pcab.wonghetto.wonghettocore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import be.pcab.wonghetto.wonghettocore.persistence.dao.UserDAO;
import be.pcab.wonghetto.wonghettocore.persistence.domain.User;

/**
 * 
 * A proper implementation of {@link UserTX}
 * 
 * @author Paolo Cabras
 *
 */

@Service
public class UserTXManager implements UserTX {

	@Autowired
	private UserDAO userDAO;
	
	@Transactional(readOnly=false,propagation= Propagation.REQUIRES_NEW)
	@Override
	public void create(User user) throws Exception {
		
		userDAO.insert(user);
	}

	@Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
	@Override
	public void update(User user) throws Exception {
		
		userDAO.update(user);
	}

	@Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
	@Override
	public void delete(User user) throws Exception {
		
		userDAO.delete(user);
	}

	@Transactional(readOnly=true,propagation=Propagation.REQUIRES_NEW)
	@Override
	public User getByUserName(String uName) throws Exception {
		
		return userDAO.getByUserName(uName);
	}

	@Transactional(readOnly=true,propagation=Propagation.REQUIRES_NEW)
	@Override
	public List<User> getAll() throws Exception {
		
		return userDAO.getAll();
	}

}
