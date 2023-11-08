package com.team10.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.team10.cfg.CustomUser;
import com.team10.entity.User;
import com.team10.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomAuthServiceImpl implements ICustomAuthService {

	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repository.findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException("User Not found");
		}
		return new CustomUser(user);
	}

}
