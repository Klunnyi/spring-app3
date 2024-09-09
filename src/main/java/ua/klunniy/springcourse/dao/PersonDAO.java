package ua.klunniy.springcourse.dao;

import lombok.Getter;
import org.springframework.stereotype.Component;
import ua.klunniy.springcourse.models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Component
public class PersonDAO {

//    private static int PEOPLE_COUNT;
//
//    private final List<Person> personList = new ArrayList<>() {{
//        add(new Person(PEOPLE_COUNT++, "Serhii", 10, "serhii@gmail.com"));
//        add(new Person(PEOPLE_COUNT++, "Solomiya", 20, "solomiya@gmail.com"));
//        add(new Person(PEOPLE_COUNT++, "Tom", 30, "tom@gmail.com"));
//        add(new Person(PEOPLE_COUNT++, "Bob", 40, "bob@gmail.com"));
//        add(new Person(PEOPLE_COUNT++, "Katy", 50, "katy@gmail.com"));
//    }};

    private static final String URL = "jdbc:postgresql://localhost:5432/first_db";
    private static final String LOGIN = "postgres";
    private static final String PASSWORD = "870EVO";


    private static final Connection connection;

   static {
       try {
           Class.forName("org.postgresql.Driver");
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }

       try {
           connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
   }

    public List<Person> getPersonList() {
        // return jdbcTemplate.query("SELECT * FROM Person ORDER BY id", new PersonMapper());

        List<Person> personList = new ArrayList<>();
        String sql = "SELECT * FROM Person order by id";
        try {
            Statement statement = connection.createStatement();

            //executeQuery - он не изменяет данные в БД, он получает данные
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                long id = rs.getLong("id");
                int age = rs.getInt("age");
                String name = rs.getString("name");
                String email = rs.getString("email");
                //              Gender gender = Gender.valueOf(rs.getString("gender"));

                Person person = new Person(id, name, age, email);
                personList.add(person);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//       Collections.sort(people, new PersonComparatorById());
        return personList;
    }






    public Person getPersonById(long id) {
//        for (Person person : personList) {
//            if (person.getId() == id) {
//                return person;
//            }
//        }
//        throw new IllegalArgumentException("Person with id " + id + " not found");

//        return personList.stream().filter(person -> person.getId() == id).findFirst().orElseThrow(IllegalArgumentException::new);
        return null;
    }

    public void add(Person person) {

    }

    public void delete(Long id) {
        //personList.removeIf(person -> person.getId() == id);
    }
}
