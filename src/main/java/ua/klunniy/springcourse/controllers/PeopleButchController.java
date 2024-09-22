package ua.klunniy.springcourse.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.klunniy.springcourse.service.PeopleService;

@Controller
@RequiredArgsConstructor
@RequestMapping("people-butch-test")
public class PeopleButchController {

    private final PeopleService peopleService;

    @GetMapping
    public String index() {
        return "butch/people-butch-test";
    }

    @GetMapping("add-100-people")
    public String add100People() {
        peopleService.add100People();
        return "redirect:/people";
    }

    @GetMapping("add-100-people-with-butch")
    public String add100PeopleWithButch() {
        peopleService.add100PeopleWithButch();
        return "redirect:/people";
    }
}
