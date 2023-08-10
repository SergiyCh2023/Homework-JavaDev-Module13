package com.example.demo.mvc;

import com.example.demo.note.InterfaceNote;
import com.example.demo.note.Note;
import com.example.demo.note.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@RequestMapping ("/note")
@Controller
public class NoteController {

    @Autowired
    InterfaceNote interfaceNote;

    @GetMapping ("/list")
    public ModelAndView getListAllNotes() {
        ModelAndView result = new ModelAndView("index");
        result.addObject("notes", interfaceNote.listAll());
        return result;
    }

    @PostMapping ("/delete/{id}")
    public ModelAndView deleteNote (@PathVariable("id") long id) {
        ModelAndView result = new ModelAndView("index");
        interfaceNote.deleteById(id);
        result.addObject("notes", interfaceNote.listAll());
        return result;
    }


    @GetMapping("/edit")
    public ModelAndView getEditNote(@RequestParam("id") long id) {
        ModelAndView result = new ModelAndView("edit");
        result.addObject("note", interfaceNote.getById(id));
        return result;
    }


    @PostMapping ("/edit")
    public ModelAndView getEditNote(@ModelAttribute("note") Note note) {
        ModelAndView result = new ModelAndView("index");
        interfaceNote.update(note);
        result.addObject("notes", interfaceNote.listAll());
        return result;
    }

}




