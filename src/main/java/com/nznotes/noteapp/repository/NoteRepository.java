package com.nznotes.noteapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nznotes.noteapp.entity.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note,Long> {
    
}
