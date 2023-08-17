package com.example.demo.mvc;

import com.example.demo.dto.NoteDTO;
import com.example.demo.note.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping ("/note")
@Controller
@RequiredArgsConstructor
public class NoteController {


     private final NoteService noteService;



    @GetMapping ("/list")
    public ModelAndView getListAllNotes() {
        ModelAndView result = new ModelAndView("index");
        result.addObject("notes", noteService.listAll());
        return result;
    }

    @PostMapping ("/delete/{id}")
    public ModelAndView deleteNote (@PathVariable("id") long id) {
        ModelAndView result = new ModelAndView("index");
        noteService.deleteById(id);
        result.addObject("notes", noteService.listAll());
        return result;
    }


    @GetMapping("/edit")
    public ModelAndView getEditNote(@RequestParam("id") long id) {
        ModelAndView result = new ModelAndView("edit");
        result.addObject("note", noteService.getById(id));
        return result;
    }


    @PostMapping ("/edit")
    public ModelAndView getEditNote(@ModelAttribute("noteDTO") NoteDTO noteDTO) {
        ModelAndView result = new ModelAndView("index");
        Note note =  NoteDTO.fromDTO(noteDTO);
        noteService.update(note);
        result.addObject("notes", noteService.listAll());
        return result;
    }


    @GetMapping("/create")
    public ModelAndView openFormForSave() {
        ModelAndView result = new ModelAndView("begin");
    //    result.addObject("note", noteService.getById(id));
        return result;
    }


    @PostMapping ("/create")
    public ModelAndView saveInBase(@ModelAttribute("note") Note note) {
        ModelAndView result = new ModelAndView("index");
        noteService.add(note);
        result.addObject("notes", noteService.listAll());
        return result;
    }





}




