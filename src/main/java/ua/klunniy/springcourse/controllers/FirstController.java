package ua.klunniy.springcourse.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
@RequestMapping("first")
public class FirstController {

    @GetMapping("hello")
    public String helloPage(HttpServletRequest request, Model model) {
        log.info("*** " + Thread.currentThread().getName());

        final String name = request.getParameter("name");
        final String surname = request.getParameter("surname");
        final String message = "name: " + name + ", surname: " + surname;

        model.addAttribute("message", message);
        System.out.println(message);

        return "first/hello_world";
    }

    @GetMapping("goodbye")
    public String goodByePage(@RequestParam(value = "name", defaultValue = "test-1") String name,
                              @RequestParam(value = "surname", required = false) String surname,
                              Model model) {
        final String message = "name: " + name + ", surname: " + surname;
        model.addAttribute("message", message);
        System.out.println(message);

        return "first/good_by_page";
    }
}
