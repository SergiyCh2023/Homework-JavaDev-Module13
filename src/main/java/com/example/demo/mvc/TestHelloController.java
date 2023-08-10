package com.example.demo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/test")
@Controller
public class TestHelloController {
    @GetMapping()  // RequestMapping - загальна анатація
    public ModelAndView getCurrentTime () {
        ModelAndView result = new ModelAndView("test"); // html шаблон який ми прикрутимо до цього запиту
        return result;
    }


}