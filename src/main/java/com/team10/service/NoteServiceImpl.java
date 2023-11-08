package com.team10.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team10.entity.Note;
import com.team10.entity.User;
import com.team10.repository.NoteRepository;

@Service
public class NoteServiceImpl implements INoteService {

	@Autowired
	private NoteRepository n_repository;
	
	@Override
	public void saveNote(Note note,User user) {
		note.setUser(user);
		n_repository.save(note);
	}

	@Override
	public List<Note> getAllNotes(User user) {
		return n_repository.findByUserOrderByCreatedAtDesc(user);
	}

	@Override
	public void deleteNote(int id) {
		n_repository.deleteById(id);
	}

	@Override
	public Note findNoteById(int id) {
		return n_repository.findById(id).get();
	}

}
