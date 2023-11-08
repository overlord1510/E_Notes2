package com.team10.service;

import org.springframework.dao.DataIntegrityViolationException;

import com.team10.entity.User;

public interface IUserService {

	public void registerUser(User user) throws DataIntegrityViolationException;

	public void removeSessionMessage();

	public User findUser(String email);
}
