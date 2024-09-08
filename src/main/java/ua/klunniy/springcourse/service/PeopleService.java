package ua.klunniy.springcourse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.klunniy.springcourse.dao.PersonDAO;
import ua.klunniy.springcourse.models.Person;

import java.util.List;

@Service
public class PeopleService {

    @Autowired
    private PersonDAO personDAO;

    public List<Person> getPeople() {
        return personDAO.getPersonList();
    }

    public Person getPersonById(Long id) {
        return personDAO.getPersonById(id);
    }
}
