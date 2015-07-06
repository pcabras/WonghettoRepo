package be.pcab.wonghetto.wonghettoserver.persistence.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import be.pcab.wonghetto.wonghettoserver.persistence.domain.Element;

@Repository
public class ElementDAO implements GenericDAO<Element> {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Element> getAll() {
		
		Session session = sessionFactory.getCurrentSession();
		return (List<Element>) session.createCriteria(Element.class).list();
	}

	@Override
	public Element getById(long id) {
		
		Session session = sessionFactory.getCurrentSession();
		return (Element) session.get(Element.class, id);
	}

	@Override
	public void insert(Element entity) {
		
		Session session = sessionFactory.getCurrentSession();
		session.save(entity);
	}

	@Override
	public void update(Element entity) {
		
		Session session = sessionFactory.getCurrentSession();
		session.update(entity);
	}

	@Override
	public void delete(Element entity) {
		
		Session session = sessionFactory.getCurrentSession();
		session.delete(entity);
	}

}