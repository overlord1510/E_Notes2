package com.team10.controller;

import java.security.Principal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.team10.entity.Note;
import com.team10.entity.User;
import com.team10.service.INoteService;
import com.team10.service.IUserService;

@Controller
public class NotesController {

	@Autowired
	private IUserService userService;

	@Autowired
	private INoteService noteService;

	@PostMapping("/process-note")
	public String processNote(@ModelAttribute Note theNote, Principal p) {
		theNote.setCreatedAt(new Date());
		String email = null;
		if (p != null) {
			email = p.getName();
		}
		User user = userService.findUser(email);
		noteService.saveNote(theNote, user);
		return "redirect:/auth/profile";
	}

	@GetMapping("/deleteNote")
	public String deleteNote(@RequestParam int id) {
		noteService.deleteNote(id);
		return "redirect:/auth/profile";
	}

	@GetMapping("/updateNote")
	public String updateNote(@RequestParam int id, Model model) {
		Note note = noteService.findNoteById(id);
		model.addAttribute("snote", note);
		return "update_notes";
	}

	@PostMapping("/update-note")
	public String processAndUpdateNote(@ModelAttribute Note theNote, Principal p) {
		theNote.setUpdatedAt(new Date());

		String email = null;
		if (p != null) {
			email = p.getName();
		}
		User user = userService.findUser(email);
		theNote.setUser(user);
		noteService.saveNote(theNote, user);
		return "redirect:/auth/profile";
	}

}
