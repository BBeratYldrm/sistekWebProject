package com.berat.sistek.service;

import java.util.List;

import com.berat.sistek.model.User;

public interface UserService {

	public User findById(long id);

	public User findUserByEmail(String email);

	public void saveUser(User user);

	List<User> findAllUsers();
}
