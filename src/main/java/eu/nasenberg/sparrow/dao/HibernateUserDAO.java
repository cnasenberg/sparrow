package eu.nasenberg.sparrow.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import eu.nasenberg.sparrow.application.Application;
import eu.nasenberg.sparrow.entity.User;

@Repository
public class HibernateUserDAO implements UserDAO {

    final static Logger logger = LoggerFactory.getLogger(Application.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public User save(User user) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		return get(user);
	}
	
	public User get(User user) {
		Session session = sessionFactory.openSession();
		session = sessionFactory.openSession();
		session.beginTransaction();
		List result = session.createQuery("from User where username = '" + user.getUsername() + "'").list();
		session.getTransaction().commit();
		User retrievedUser = (User) result.get(0);
		session.close();
		return retrievedUser;
	}
	
}
