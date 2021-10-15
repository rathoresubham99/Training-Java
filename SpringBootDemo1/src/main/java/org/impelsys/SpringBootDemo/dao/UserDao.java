package org.impelsys.SpringBootDemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.impelsys.SpringBootDemo.model.User;

public interface UserDao {
	int addUser(User user);
	void delete(User user);
	User viewUser(int id);
	List<User> listUsers();

	

}
