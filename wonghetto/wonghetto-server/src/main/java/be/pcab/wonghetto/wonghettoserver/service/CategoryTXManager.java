package be.pcab.wonghetto.wonghettoserver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import be.pcab.wonghetto.wonghettoserver.persistence.dao.CategoryDAO;
import be.pcab.wonghetto.wonghettoserver.persistence.domain.Category;

/**
 * A proper implementation of {@link CategoryTX}
 * 
 * @author Paolo Cabras
 *
 */

@Service
public class CategoryTXManager implements CategoryTX {

	@Autowired
	private CategoryDAO categoryDAO;

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public void create(Category category) throws Exception {

		categoryDAO.insert(category);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public void update(Category category) throws Exception {

		categoryDAO.update(category);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public void delete(Category category) throws Exception {

		categoryDAO.delete(category);
	}

	@Transactional(readOnly=true,propagation=Propagation.REQUIRES_NEW)
	@Override
	public Category getById(long id) throws Exception {

		return categoryDAO.getById(id);
	}

	@Transactional(readOnly=true,propagation=Propagation.REQUIRES_NEW)
	@Override
	public List<Category> getByUserName(String userName) throws Exception {
		
		return categoryDAO.getByUserName(userName);
	}

}
