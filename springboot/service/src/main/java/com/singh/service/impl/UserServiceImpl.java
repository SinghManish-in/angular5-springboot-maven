package com.singh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.singh.dao.UserDAO;
import com.singh.model.User;
import com.singh.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	public User getUser(Integer ID) {
		return userDAO.getOne(ID);
	}

	@Override
	public List<User> getAllUsers() {
		return userDAO.findAll();
	}

	@Override
	public User createUser(User user) throws Exception {
		return userDAO.saveAndFlush(user);
	}

	@Override
	public void deleteUser(Integer ID) {
		userDAO.delete(ID);
	}

	@Override
	public void updateUser(User user) {
		userDAO.saveAndFlush(user);
	}

	@Override
	public Boolean isUserExist(String email) {
		return (null == userDAO.getByEmail(email));
	}

	@Override
	public Boolean login(User user) {
		return (null != userDAO.authenticateUser(user.getEmail(), user.getPassword()));
	}
}
