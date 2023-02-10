package be.technobel.sandwich.controller;

import be.technobel.sandwich.exception.DemoException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("/throw")
    public String throwDemoException(){
        throw new DemoException("data");
    }

    // Ne reagit que pour les excpetions lancées dans ce controller
//    @ExceptionHandler({DemoException.class})
//    public String handle(DemoException ex, Model model, HttpServletRequest req){
//        model.addAttribute("ex", ex);
//        return "errors/demo-throw";
//    }


}
