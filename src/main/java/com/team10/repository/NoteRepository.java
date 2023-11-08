package com.team10.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team10.entity.Note;
import com.team10.entity.User;

public interface NoteRepository extends JpaRepository<Note, Integer> {
	
	public List<Note> findByUserOrderByCreatedAtDesc(User user);
	
}
