package com.singh.service;

import java.util.List;

import com.singh.model.User;


public interface UserService {
    public User getUser(Integer username);
    public List<User> getAllUsers();
    public User createUser(User user) throws Exception;
    public void deleteUser(Integer ID);
    public void updateUser(User user);
    public Boolean isUserExist(String username);
    public Boolean login(User user);

}
