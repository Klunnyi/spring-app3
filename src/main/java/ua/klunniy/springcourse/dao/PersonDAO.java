package ua.klunniy.springcourse.dao;

import lombok.Getter;
import org.springframework.stereotype.Component;
import ua.klunniy.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;

@Getter
@Component
public class PersonDAO {

    private static int PEOPLE_COUNT;

    private final List<Person> personList = new ArrayList<>() {{
        add(new Person(PEOPLE_COUNT++, "Serhii", 10, "serhii@gmail.com"));
        add(new Person(PEOPLE_COUNT++, "Solomiya", 20, "solomiya@gmail.com"));
        add(new Person(PEOPLE_COUNT++, "Tom", 30, "tom@gmail.com"));
        add(new Person(PEOPLE_COUNT++, "Bob", 40, "bob@gmail.com"));
        add(new Person(PEOPLE_COUNT++, "Katy", 50, "katy@gmail.com"));
    }};

    public Person getPersonById(long id) {
//        for (Person person : personList) {
//            if (person.getId() == id) {
//                return person;
//            }
//        }
//        throw new IllegalArgumentException("Person with id " + id + " not found");

        return personList.stream().filter(person -> person.getId() == id).findFirst().orElseThrow(IllegalArgumentException::new);
    }

    public void add(Person person) {
        person.setId(PEOPLE_COUNT++);
        personList.add(person);
    }

    public void delete(Long id) {
        personList.removeIf(person -> person.getId() == id);
    }
}
