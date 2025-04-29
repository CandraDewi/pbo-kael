package com.kidaro.kael.repository;
import com.kidaro.kael.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {}
