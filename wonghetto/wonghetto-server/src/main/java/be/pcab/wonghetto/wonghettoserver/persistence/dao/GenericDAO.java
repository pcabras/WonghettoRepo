package be.pcab.wonghetto.wonghettoserver.persistence.dao;

import java.util.List;

/**
 * A generic interface for DAO objects.
 * 
 * @author Paolo Cabras
 *
 * @param <E>
 */
public interface GenericDAO <E>{

	/**
	 * 
	 * Gets all stored Objects of type E  
	 * 
	 * @return
	 */
	List<E> getAll();
	
	/**
	 * Gets the Object of type E corresponding to the given id.
	 * 
	 * @param id
	 * @return
	 */
	E getById(long id);
	
	/**
	 *  Stores the Object of type E. 
	 * 
	 * @param entity
	 */
	void insert(E entity );
	
	/**
	 * Update the object of type E.
	 * 
	 * @param entity
	 */
	void update(E entity);
	
	/**
	 * 
	 * Delete the object of type E.
	 * @param entity
	 */
	void delete(E entity);
}
