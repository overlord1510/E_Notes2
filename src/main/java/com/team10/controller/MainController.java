package com.team10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.team10.entity.User;
import com.team10.service.IUserService;

import jakarta.persistence.OptimisticLockException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

	private SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();

	@Autowired
	private IUserService userService;

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/login")
	public String login() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
			return "login";
		}
		return "redirect:/auth/profile";
	}

	@GetMapping("/register")
	public String register() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
			return "register";
		}
		return "redirect:/auth/profile";
	}

	@PostMapping("/process-user")
	public String processUser(@ModelAttribute User theUser, HttpSession session) {
		System.out.println(theUser);

		try {
			userService.registerUser(theUser);
			session.setAttribute("success", "Registered Successfully! Please Login");
		} catch (IllegalArgumentException | OptimisticLockException e) {
			e.printStackTrace();
			session.setAttribute("fail", "Registration Failed");
		} catch (DataIntegrityViolationException e) {
			session.setAttribute("duplicate", "Username/Email already registered");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/register";
	}

	@PostMapping("/logout")
	public String logoutPage(Authentication authentication, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		this.logoutHandler.logout(httpServletRequest, httpServletResponse, authentication);
		return "redirect:/login";
	}

}
