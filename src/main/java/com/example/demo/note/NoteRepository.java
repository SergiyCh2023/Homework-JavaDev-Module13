package com.example.demo.note;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {



    @Modifying
    @Query(nativeQuery = true, value = "UPDATE note SET title =:title, content= :content WHERE id =:id")
    void updateNotesByIds (@Param("id") Long id, @Param("title") String title, @Param("content") String content);

}
