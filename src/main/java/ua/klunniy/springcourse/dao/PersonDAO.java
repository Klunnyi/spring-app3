package ua.klunniy.springcourse.dao;

import ua.klunniy.springcourse.models.Person;

import java.util.List;

public interface PersonDAO {
    List<Person> index();
    Person show(Long id);
    void save(Person person);
    void update(Person person);
    void delete(Long id);
}