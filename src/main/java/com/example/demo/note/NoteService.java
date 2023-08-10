package com.example.demo.note;

import com.example.demo.note.Note;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Service
public class NoteService implements InterfaceNote {

        private static long counter=0l;



        private Map<Long, Note> noteMap = new HashMap<>();

        @Override
        public Note add(Note note) {
           if (note.getId()==0) {
               counter++;
               note.setId(counter);
        }
            noteMap.put(note.getId(), note);
            return note;
        }

        @Override
        public Note getById(long id) {
            Note note = noteMap.get(id);
            if (note == null) {
                throw new IllegalArgumentException("Note with ID " + id + " not found.");
            }
            return note;
        }

        @Override
        public void update(Note note) {
            if (!noteMap.containsKey(note.getId())) {
                throw new IllegalArgumentException("Note with ID: " + note.getId() + " not found.");
            }
              noteMap.put(note.getId(), note);
        }

        @Override
        public void deleteById(long id) {
            if (!noteMap.containsKey(id)) {
                throw new IllegalArgumentException("Note with ID: " + id + " not found.");
            }
            noteMap.remove(id);
        }

        @Override
        public List<Note> listAll() {
            return noteMap.values().stream().toList();
        }


}

