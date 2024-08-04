package ua.klunniy.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("first")
public class FirstController {

    @GetMapping("hello")
    public String helloPage(HttpServletRequest request) {
        final String name = request.getParameter("name");
        final String surname = request.getParameter("surname");
        System.out.println("name: " + name + ", surname: " + surname);

        return "first/hello_world";
    }

    @GetMapping("goodbye")
    public String goodByePage(@RequestParam(value = "name", defaultValue = "test-1") String name,
                              @RequestParam(value = "surname", required = false) String surname) {
        System.out.println("name: " + name + ", surname: " + surname);

        return "first/good_by_page";
    }
}
