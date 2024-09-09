//package ua.klunniy.springcourse.dao.collection;
//
//import lombok.Getter;
//import org.springframework.stereotype.Component;
//import ua.klunniy.springcourse.models.Person;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Getter
//@Component
//public class PersonDAO {
//
//    private static int PEOPLE_COUNT;
//
//    private final List<Person> personList = new ArrayList<>() {{
//        add(new Person(PEOPLE_COUNT++, "Serhii"));
//        add(new Person(PEOPLE_COUNT++, "Solomiya"));
//        add(new Person(PEOPLE_COUNT++, "Tom"));
//        add(new Person(PEOPLE_COUNT++, "Bob"));
//        add(new Person(PEOPLE_COUNT++, "Katy"));
//    }};
//
//    public Person getPersonById(long id) {
////        for (Person person : personList) {
////            if (person.getId() == id) {
////                return person;
////            }
////        }
////        throw new IllegalArgumentException("Person with id " + id + " not found");
//
//        return personList.stream().filter(person -> person.getId() == id).findFirst().orElseThrow(IllegalArgumentException::new);
//    }
//
//    public void add(Person person) {
//        person.setId(PEOPLE_COUNT++);
//        personList.add(person);
//    }
//
//    public void delete(Long id) {
//        personList.removeIf(person -> person.getId() == id);
//    }
//}
