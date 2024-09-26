package ua.klunniy.springcourse.dao;

import ua.klunniy.springcourse.models.Person;

import java.util.List;
import java.util.Optional;

public interface PersonDAO {
    List<Person> index();
    Person show(Long id);
    void save(Person person);
    void update(Person person);
    void delete(Long id);
    void add100People(List<Person> people);
    void add100PeopleWithButch(List<Person> people);
    Optional<Person> getPersonByEmail(String email);
}