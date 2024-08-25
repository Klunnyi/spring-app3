package ua.klunniy.springcourse.controllers;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.klunniy.springcourse.model.People;
import ua.klunniy.springcourse.service.PeopleService;

import java.util.List;

@Controller
@RequestMapping("/people")
//@RequiredArgsConstructor(onConstructor_ = {@Autowired})
//@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class PeopleController {

    @Autowired
    private PeopleService peopleService;

    // index
    @GetMapping()
    public String getPeoplesThymeleaf(@NonNull Model model) {
        model.addAttribute("people", peopleService.getPeople());
        return "people/all";
    }

    // show
    @GetMapping("/{id}")
    public String getOnePeopleThymeleaf(@PathVariable("id") Long id, Model model) {
        model.addAttribute("people", peopleService.getPeopleById(id));
        return "people/one";
    }

    @GetMapping(value = "json", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<People> getPeoplesJson() {
        return peopleService.getPeople();
    }

    @GetMapping(value = "json/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public People getOnePeopleJson(@PathVariable("id") Long id) {
        return  peopleService.getPeopleById(id);
    }

    // метод будет возвращать html форму для создания нового человека
    @GetMapping("/new")
    public String newPerson(Model model) {
        model.addAttribute("people", new People());
        return "people/new";
    }

    // будет принимать пост запрос, будет брать данные из этого пост запроса и
    @PostMapping
    public String savePerson(@ModelAttribute("people") People people) {
        peopleService.save(people);
        return "redirect:/people";
    }
}
