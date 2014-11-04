package fr.esiea.web.service;

import java.util.List;

import fr.esiea.web.model.User;

public interface UserService {
	public User getUserById(int userId);
	public User getUserByEmail(String email);
	public List<User> listUser();
	public void createUser(User user);
	public void updateUser(User user);
	public void deleteUser(int id);
}