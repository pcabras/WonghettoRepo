package be.pcab.wonghetto.wonghettoserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import be.pcab.wonghetto.wonghettoserver.persistence.dao.ElementDAO;
import be.pcab.wonghetto.wonghettoserver.persistence.domain.Element;

/**
 * A proper implementation of {@link ElementTX}
 * 
 * @author Paolo Cabras
 *
 */

@Service
public class ElementTXManager implements ElementTX{

	@Autowired
	private ElementDAO elementDAO;
	
	@Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
	@Override
	public void create(Element element) throws Exception {
		
		elementDAO.insert(element);
	}

	@Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
	@Override
	public void update(Element element) throws Exception {
		
		elementDAO.update(element);	
	}

	@Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
	@Override
	public void delete(Element element) throws Exception {
		
		elementDAO.delete(element);
	}

	@Transactional(readOnly=true,propagation=Propagation.REQUIRES_NEW)
	@Override
	public Element getById(long id) throws Exception {
		
		return elementDAO.getById(id);
	}

}
