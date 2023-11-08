package com.team10.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.team10.entity.User;
import com.team10.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository repository;

	@Autowired
	private PasswordEncoder encoder;

	@Override
	public void registerUser(User user) throws DataIntegrityViolationException {
		user.setCreatedAt(new Date());
		user.setRole("ROLE_USER");
		// System.out.println(user);
		user.setPasswordHash(encoder.encode(user.getPasswordHash()));
		// System.out.println(user);
		repository.save(user);
	}

	@Override
	public void removeSessionMessage() {
		HttpSession session = ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest()
				.getSession();
		session.removeAttribute("success");
		session.removeAttribute("fail");
		session.removeAttribute("duplicate");
	}

	@Override
	public User findUser(String email) {
		return repository.findByEmail(email);
	}

}
