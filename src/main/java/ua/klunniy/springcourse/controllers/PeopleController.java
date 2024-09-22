package ua.klunniy.springcourse.controllers;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import ua.klunniy.springcourse.models.Person;
import ua.klunniy.springcourse.service.PeopleService;

import javax.validation.Valid;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

//@RequiredArgsConstructor(onConstructor_ = {@Autowired})
//@RequiredArgsConstructor

@Controller
@RequiredArgsConstructor
@RequestMapping("people")
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
     *   GET     /posts/new          HTML форма создания записи
     *   POST    /posts              Создаем новую запись(CREATE)
     *
     *   GET     /posts/:id/edit     HTML форма редактирования записи
     *   PATCH   /posts/:id          Обновляем запись(UPDATE)
     *
     * */

    private final PeopleService peopleService;

    // index
    @GetMapping()
    public String getPeoplesThymeleaf(@NonNull Model model) {
        model.addAttribute("people", peopleService.getPeople());
        return "people/all";
    }

    // show
    @GetMapping("{id}")
    public String getOnePeopleThymeleaf(@PathVariable("id") Long id, Model model) {
        model.addAttribute("person", peopleService.getPersonById(id));
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
    // метод будет возвращать html форму для создания нового человека
    @GetMapping("new")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "people/new";
    }

    // будет принимать пост запрос, будет брать данные из этого пост запроса и
    // @ModelAttribute создает обьект пустого человека, помещает в него данные из формы и кладет его в модель
    // MethodArgumentNotValidException
    @PostMapping
    public String create(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "people/new";
        }

        peopleService.save(person);
        return "redirect:/people";
    }

//    @PostMapping
//    public String create(@ModelAttribute("person") @Valid Person person) {
//        peopleService.save(person);
//        return "redirect:/people";
//    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("person", peopleService.getPersonById(id));
        return "people/edit";
    }

    @PatchMapping("{id}")
    public String update(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult,
                         @PathVariable("id") Long id) {

        if (bindingResult.hasErrors()) {
            return "people/edit";
        }

        peopleService.update(id, person);
        //return "people/all";
        return "redirect:/people";
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") Long id) {
        peopleService.delete(id);
        return "redirect:/people";
    }

//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ResponseBody
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public String handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
//        return  "people/new";
//    }
}
