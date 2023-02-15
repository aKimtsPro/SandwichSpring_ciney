package be.technobel.sandwich.controller;

import be.technobel.sandwich.exception.DemoException;
import be.technobel.sandwich.exception.NotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler({DemoException.class})
    public String handle(DemoException ex, Model model, HttpServletRequest req){
        model.addAttribute("ex", ex);
        return "errors/demo-throw";
    }

    @ExceptionHandler(NotFoundException.class)
    public String handle(NotFoundException ex){
        return "errors/page-404";
    }

}
