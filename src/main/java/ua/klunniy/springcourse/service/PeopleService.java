package ua.klunniy.springcourse.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.klunniy.springcourse.dao.jdbc.PersonDAO;
import ua.klunniy.springcourse.models.Person;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PeopleService {

    private final PersonDAO personDAO;

    public List<Person> getPeople() {
        return personDAO.getPersonList();
    }

    public Person getPersonById(Long id) {
        return personDAO.getPersonById(id);
    }

    public void save(Person person) {
        personDAO.save(person);
    }

    public void update(long id, Person person) {
//        Person personToBeUpdated = personDAO.getPersonById(id);
//
//        personToBeUpdated.setName(person.getName());
//        personToBeUpdated.setAge(person.getAge());
//        personToBeUpdated.setEmail(person.getEmail());

        person.setId(id);
        personDAO.update(person);
    }

    public void delete(long id) {
        personDAO.delete(id);
    }
}
