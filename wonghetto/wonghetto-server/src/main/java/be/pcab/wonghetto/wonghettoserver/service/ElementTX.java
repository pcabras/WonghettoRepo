package be.pcab.wonghetto.wonghettoserver.service;

import be.pcab.wonghetto.wonghettoserver.persistence.domain.Element;

/**
 * Stands for ElementTransaction:<br>
 * it is the blueprint to follow for dealing with transactional operations related to {@link Element}.
 * 
 * @author Paolo Cabras
 *
 */
public interface ElementTX {
	
	/**
	 * 
	 * Stores a new {@link Element} into the DB
	 * 
	 * @throws Exception
	 */
	void create(Element element) throws Exception;

	/**
	 * Updates an existing {@link Element}
	 * 
	 * @param element
	 * @throws Exception
	 */
	void update(Element element) throws Exception;
	
	/**
	 * Deletes an existing {@link Element}
	 * 
	 * @param element
	 * @throws Exception
	 */
	void delete(Element element) throws Exception;
	
	/**
	 * Gets the {@link Element} corresponding to the given id
	 * 
	 * @return the Element
	 * @throws Exception
	 */
	Element getById(long id) throws Exception;
}
