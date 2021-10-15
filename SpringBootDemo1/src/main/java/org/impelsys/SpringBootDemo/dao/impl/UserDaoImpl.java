package org.impelsys.SpringBootDemo.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.impelsys.SpringBootDemo.dao.UserDao;
import org.impelsys.SpringBootDemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("userDao")
public class UserDaoImpl implements UserDao{
	
	@Autowired
	SessionFactory sessionFactory; 

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		int row;
		Session session = sessionFactory.openSession();
		row = (Integer) session.save(user);
		System.out.println("Created user with id:" +row);
		
		session.close();
		return row;
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.delete(user);;
		session.close();
	}

	@Override
	public User viewUser(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		User user = session.get(User.class, new Integer(id));
		System.out.println("User="+user);
		System.out.println("Id:"+id);
		session.close();
		
		return user;
	}

	@Override
	public List<User> listUsers() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		List<User> userList = session.createQuery("from User").list();
		session.close();
		return userList;
	}

	
	
}
