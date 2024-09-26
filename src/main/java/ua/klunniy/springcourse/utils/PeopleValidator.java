package ua.klunniy.springcourse.utils;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ua.klunniy.springcourse.models.Person;
import ua.klunniy.springcourse.service.PeopleService;

@Component
@RequiredArgsConstructor
public class PeopleValidator implements Validator {

    private final PeopleService peopleService;

    @Override
    public boolean supports(@NonNull Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(@NonNull Object target, @NonNull Errors errors) {
        Person person = (Person) target;
        if (peopleService.getPersonByEmail(person.getEmail()).isPresent()) {
            errors.rejectValue("email", "409 Conflict", "Person with email '" + person.getEmail() + "' already exists");
        }
    }
}
