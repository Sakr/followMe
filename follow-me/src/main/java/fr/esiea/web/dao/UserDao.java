package fr.esiea.web.dao;


import java.util.List;

import fr.esiea.web.model.User;

public interface UserDao {
	public User getUserById(int id);
	public List<User> getAllUsers();
	
	public void createUser(User user);
	public void updateUser(User user);
	public void deleteUser(int id);
	public User getUserByActivationCode(String code);
}
