package ua.klunniy.springcourse.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.klunniy.springcourse.model.People;
import ua.klunniy.springcourse.repository.PeopleRepository;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class PeopleService {

    private final PeopleRepository peopleRepository;

    public List<People> getPeople() {
        return peopleRepository.findAll();
    }

    public People getPeopleById(Long id) {
        return peopleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Person not found with id: " + id));
    }
}
