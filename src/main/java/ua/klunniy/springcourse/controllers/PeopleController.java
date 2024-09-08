package ua.klunniy.springcourse.controllers;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.klunniy.springcourse.service.PeopleService;

import java.util.List;

//@RequiredArgsConstructor(onConstructor_ = {@Autowired})
//@RequiredArgsConstructor


@Controller
@NoArgsConstructor
@AllArgsConstructor
@RequestMapping("/people")
public class PeopleController {

    /* REST описывает то какие URLы и HTTP методы у нас должны быть для взаимодействия с данными
     *
     *
     *   С GET запросом вот по этому URL мы получим все записи:
     *   GET     /posts               Получаем все записи(READ)
     *
     *   GET     /posts/:id          Получаем одну запись(READ)
     *   DELETE  /posts/:id          Удаляем запись(DELETE)
     *
     *   GET     /posts/new           HTML форма создания записи
     *   POST    /posts               Создаем новую запись(CREATE)
     *
     *   GET     /posts/:id/edit     HTML форма редактирования записи
     *   PATCH   /posts/:id          Обновляем запись(UPDATE)
     *
     * */
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
        model.addAttribute("people", peopleService.getPersonById(id));
        return "people/one";
    }

//    @GetMapping(value = "json", produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<People> getPeoplesJson() {
//        return peopleService.getPeople();
//    }
//
//    @GetMapping(value = "json/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public People getOnePeopleJson(@PathVariable("id") Long id) {
//        return  peopleService.getPeopleById(id);
//    }
//
//    // метод будет возвращать html форму для создания нового человека
//    @GetMapping("/new")
//    public String newPerson(Model model) {
//        model.addAttribute("people", new People());
//        return "people/new";
//    }
//
//    // будет принимать пост запрос, будет брать данные из этого пост запроса и
//    @PostMapping
//    public String savePerson(@ModelAttribute("people") People people) {
//        peopleService.save(people);
//        return "redirect:/people";
//    }
}
