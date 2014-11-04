package fr.esiea.web.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import fr.esiea.web.model.User;


@Repository
public class UserDaoImpl implements UserDao{

	private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> userList = session.createQuery("from User").list();
		for(User p : userList){
			logger.info("User List::"+p);
		}
		return userList;
	}

	@Override
	public User getUserById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		User user = (User) session.load(User.class, new Integer(id));
		logger.info("User loaded successfully, User details="+user);
		return user;
	}

	@Override
	public void createUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(user);
		logger.info("User saved successfully, User Details="+user);
	}

	@Override
	public void updateUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(user);
		logger.info("User updated successfully, User Details="+user);
	}

	@Override
	public void deleteUser(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		User user = (User) session.load(User.class, new Integer(id));
		if(null != user){
			session.delete(user);
		}
		logger.info("User deleted successfully, user details="+user);
	}

	@Override
	public User getUserByEmail(String email) {
		List<User> userList = new ArrayList<User>();
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User u where u.mail = :mail");
		query.setParameter("mail", email);
		userList = query.list();
		if (userList.size() > 0)
			return userList.get(0);
		else
			return null;	
	}
	
}
