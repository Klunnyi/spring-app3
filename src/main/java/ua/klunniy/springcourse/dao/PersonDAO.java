package ua.klunniy.springcourse.dao;

import org.springframework.stereotype.Component;
import ua.klunniy.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    List<Person> personList = new ArrayList<>(){{
        add(new Person(1, "Serhii"));
        add(new Person(2, "Solomiya"));
    }};

    public List<Person> getPersonList() {
        return personList;
    }

    public Person getPersonById(long id) {
        for (Person person : personList) {
            if (person.getId() == id) {
                return person;
            }
        }
        throw new IllegalArgumentException("Person with id " + id + " not found");
    }
}
