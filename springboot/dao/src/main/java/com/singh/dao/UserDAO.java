package com.singh.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.singh.model.User;


@Repository
public interface UserDAO extends JpaRepository<User, Integer>{
	
	@Query("SELECT E FROM User E WHERE E.email= :email AND E.password = :password")
	public User authenticateUser(@Param("email") String email, @Param("password") String password);
	
	@Query("SELECT E FROM User E WHERE E.email= :email")
	public User getByEmail(@Param("email") String email);
	
	
}
