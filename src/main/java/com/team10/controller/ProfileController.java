package com.team10.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team10.entity.Note;
import com.team10.entity.User;
import com.team10.service.INoteService;
import com.team10.service.IUserService;

@Controller
@RequestMapping("/auth")
public class ProfileController {

	@Autowired
	private IUserService userService;

	@Autowired
	private INoteService noteService;

	@GetMapping("/profile")
	public String profile(Model model, Principal p) {
		String email = null;
		if (p != null) {
			email = p.getName();
		}
		User user = userService.findUser(email);
		List<Note> notes = noteService.getAllNotes(user);
		model.addAttribute("notes", notes);
		model.addAttribute("username", user.getName());
		return "profile";
	}

	@GetMapping("/addNotes")
	public String addNotes() {
		return "add_notes";
	}
}
