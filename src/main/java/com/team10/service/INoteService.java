package com.team10.service;

import java.util.List;

import com.team10.entity.Note;
import com.team10.entity.User;

public interface INoteService {
	public void saveNote(Note note,User user); 
	
	public List<Note> getAllNotes(User user);
	
	public void deleteNote(int id);
	
	public Note findNoteById(int id);

}
