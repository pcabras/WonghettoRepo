package be.pcab.wonghetto.wonghettoserver.persistence.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import be.pcab.wonghetto.wonghettoserver.persistence.domain.Category;

/**
 * 
 * DAO for Accessing the Category table.
 * 
 * @author Paolo Cabras
 *
 */

@Repository
public class CategoryDAO implements GenericDAO<Category> {

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getAll() {

		Session session = sessionFactory.getCurrentSession();
		return (List<Category>) session.createCriteria(Category.class).list();
	}

	@Override
	public Category getById(long id) {

		Session session = sessionFactory.getCurrentSession();
		return (Category) session.get(Category.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Category> getByUserName(String userName) {

		Session session = sessionFactory.getCurrentSession();
		return (List<Category>) session
				.createQuery(
						"select c from Category c join c.user u where u.userName = :userName")
				.setParameter("userName", userName).list();
	}

	@Override
	public void insert(Category entity) {

		Session session = sessionFactory.getCurrentSession();
		session.save(entity);
	}

	@Override
	public void update(Category entity) {

		Session session = sessionFactory.getCurrentSession();
		session.update(entity);
	}

	@Override
	public void delete(Category entity) {

		Session session = sessionFactory.getCurrentSession();
		session.delete(entity);
	}
	

}
