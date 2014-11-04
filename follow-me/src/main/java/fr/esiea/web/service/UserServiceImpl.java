package fr.esiea.web.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.esiea.web.dao.UserDao;
import fr.esiea.web.model.User;


@Service
public class UserServiceImpl implements UserService {
	
	private UserDao userDao;

	public void setUserDAO(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	@Transactional
	public List<User> listUser() {
		return this.userDao.getAllUsers();
	}

	@Override
	@Transactional
	public User getUserById(int id) {
		return this.userDao.getUserById(id);
	}

	@Override
	@Transactional
	public void createUser(User user) {
		this.userDao.createUser(user);
		
	}

	@Override
	@Transactional
	public void updateUser(User user) {
		this.userDao.updateUser(user);
		
	}

	@Override
	@Transactional
	public void deleteUser(int id) {
		this.userDao.deleteUser(id);
	}

	@Override
	@Transactional
	public User getUserByActivationCode(String code) {
		return this.userDao.getUserByActivationCode(code);
	}

}
