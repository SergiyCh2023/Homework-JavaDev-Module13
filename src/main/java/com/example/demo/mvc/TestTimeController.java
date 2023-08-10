package com.example.demo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class TestTimeController {
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH},
            value = {"/time", "/another"})
    public ModelAndView getCurrentTime () {
        ModelAndView result = new ModelAndView("time");
        result.addObject("time", LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        return result;
    }

}