package be.pcab.wonghetto.wonghettocore.persistence.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import be.pcab.wonghetto.wonghettocore.persistence.domain.User;

/**
 * A DAO object for accessing User table
 * 
 * @author Paolo Cabras
 *
 */

@Repository
public class UserDAO implements GenericDAO<User> {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAll() {

		Session session = sessionFactory.getCurrentSession();
		return (List<User>) session.createCriteria(User.class).list();
	}

	@Override
	public User getById(long id) {

		Session session = sessionFactory.getCurrentSession();
		return (User) session.get(User.class, id);
	}

	public User getByUserName(String uName) {

		Session session = sessionFactory.getCurrentSession();

		return (User) session
				.createQuery(
						"select u from User u where u.userName = :userName")
				.setParameter("userName", uName).uniqueResult();
	}

	@Override
	public void insert(User entity) {

		Session session = sessionFactory.getCurrentSession();
		session.save(entity);
	}

	@Override
	public void update(User entity) {

		Session session = sessionFactory.getCurrentSession();
		session.update(entity);
	}

	@Override
	public void delete(User entity) {

		Session session = sessionFactory.getCurrentSession();
		session.delete(entity);
	}

}
