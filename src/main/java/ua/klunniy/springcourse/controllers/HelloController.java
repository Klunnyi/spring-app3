package ua.klunniy.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("new")
public class HelloController {

    @GetMapping("hello")
    public String helloPage(){
        return "hello_world";
    }

    @GetMapping("goodbye")
    public String goodByePage() {
        return "good_by_page";
    }
}
