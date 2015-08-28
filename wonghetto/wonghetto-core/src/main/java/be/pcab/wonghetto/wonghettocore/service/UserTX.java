package be.pcab.wonghetto.wonghettocore.service;

import java.util.List;

import be.pcab.wonghetto.wonghettocore.persistence.domain.User;


/**
 * Stands for UserTransactions:<br>
 * it is the blueprint to follow for dealing with transactional operations related to {@link User}.
 * 
 * @author Paolo Cabras
 *
 */
public interface UserTX {
	
	/**
	 * Stores a {@link User} into the DB.
	 * 
	 * @param user
	 */
	void create(User user) throws Exception;
	
	/**
	 * Updates an existing {@link User}
	 * 
	 * @param user
	 */
	void update(User user) throws Exception;

	/**
	 * Deletes an existing {@link User} 
	 * 
	 * @param user
	 */
	void delete(User user) throws Exception;
	
	/**
	 * Gets a {@link User} by its userName;
	 * 
	 * @param uname
	 * @return the corresponding user
	 */
	User getByUserName(String uname) throws Exception;
	
	/**
	 * Gets all stored users
	 * 
	 * @return a list of stored users
	 * @throws Exception
	 */
	List<User> getAll() throws Exception;
}
