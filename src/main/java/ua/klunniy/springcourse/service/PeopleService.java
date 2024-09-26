package ua.klunniy.springcourse.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ua.klunniy.springcourse.dao.PersonDAO;
import ua.klunniy.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PeopleService {

    private PersonDAO personDAO;

    public PeopleService(@Qualifier("personDaoJDBCTemplate") PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    public List<Person> getPeople() {
        return personDAO.index();
    }

    public Person getPersonById(Long id) {
        return personDAO.show(id);
    }

    public Optional<Person> getPersonByEmail(String email) {
        return personDAO.getPersonByEmail(email);
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

    public void add100People() {
        long start = System.currentTimeMillis();
        List<Person> people = this.get100People();
        personDAO.add100People(people);
        long end = System.currentTimeMillis();
        System.out.println("add 100 People: time=" + (end - start));
    }

    public void add100PeopleWithButch() {
        long start = System.currentTimeMillis();
        List<Person> people = this.get100People();
        personDAO.add100PeopleWithButch(people);
        long end = System.currentTimeMillis();
        System.out.println("add 100 People with butch: time=" + (end - start));

    }

    private List<Person> get100People() {
        List<Person> people = new ArrayList<>();

        int unick = (int) (Math.random() * 100);
        for (int i = 0; i < 100; i++) {
            Person person = new Person();
            person.setName("test" + unick);
            person.setAge(unick);
            person.setEmail("test" + unick + "@gmail.com");
            people.add(person);
        }
        return people;
    }
}
