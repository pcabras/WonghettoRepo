package be.pcab.wonghetto.wonghettoserver.service;

import java.util.List;

import be.pcab.wonghetto.wonghettoserver.persistence.domain.Category;

/**
 * Stands for CategoryTransactions:<br>
 * it is the blueprint to follow for dealing with transactional operations related to {@link Category}.
 * 
 * @author Paolo Cabras
 *
 */
public interface CategoryTX {

	/**
	 * Stores a {@link Category} into the DB.
	 * 
	 * @param category
	 */
	void create(Category category) throws Exception;
	
	/**
	 * Updates an existing {@link Category}
	 * 
	 * @param category
	 */
	void update(Category category) throws Exception;
	
	/**
	 * 
	 * Deletes an existing {@link Category} 
	 * @param category
	 * @throws Exception
	 */
	void delete(Category category) throws Exception;
	
	/**
	 * Gets the {@link Category} corresponding to the given id;
	 * 
	 * @param id
	 * @return the Category
	 * @throws Exception
	 */
	Category getById(long id) throws Exception;
	
	/**
	 * Gets all {@link Category}ies corresponding to the given userName
	 * 
	 * @param userName
	 * @return
	 * @throws Exception
	 */
	List<Category> getByUserName(String userName) throws Exception;
	
	/**
	 * 
	 * Gets all available {@link Category}ies
	 * 
	 * @return
	 * @throws Exception
	 */
	List<Category> getAll() throws Exception;
	
}
