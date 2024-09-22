package ua.klunniy.springcourse.dao.impl;

import lombok.Getter;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import ua.klunniy.springcourse.dao.PersonDAO;
import ua.klunniy.springcourse.models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Component
public class PersonDAOJDBC implements PersonDAO {

    private static final String URL = "jdbc:postgresql://localhost:5432/first_db";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "870EVO";

    private static final Connection connection;

   static {
       try {
           Class.forName("org.postgresql.Driver");
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }

       try {
           connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
   }

    public List<Person> index() {
        // return jdbcTemplate.query("SELECT * FROM Person ORDER BY id", new PersonMapper());

        List<Person> personList = new ArrayList<>();
        String sql = "SELECT * FROM Person ORDER BY id ASC";
        try {
            // Это тот объект, который содержит в себе запрос к БД
            Statement statement = connection.createStatement();

            // в этом объекте лежат наши строки
            //executeQuery - он не изменяет данные в БД, он получает данные
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                long id = rs.getLong("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String email = rs.getString("email");
                // Gender gender = Gender.valueOf(rs.getString("gender"));

                Person person = new Person(id, name, age, email);
                personList.add(person);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//       Collections.sort(people, new PersonComparatorById());
        return personList;
    }

    public void save(Person person) {
        String sql = "INSERT INTO Person(name, age, email) VALUES(?, ?, ?)";
        try {
            // Создание объекта PreparedStatement для выполнения параметризованного запроса
            PreparedStatement pstmt = connection.prepareStatement(sql);

            // Установка параметров запроса
            pstmt.setString(1, person.getName());
            pstmt.setInt(2, person.getAge());
            pstmt.setString(3, person.getEmail());

            // Выполнение запроса
            int affectedRows = pstmt.executeUpdate();

            // Проверка, была ли обновлена хотя бы одна строка
            if (affectedRows == 0) {
                throw new SQLException("Save person failed, no rows affected.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Person person) {
       String sql = "UPDATE Person SET name = ?, age = ?, email = ? WHERE id = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);

            // Установка параметров запроса
            pstmt.setString(1, person.getName());
            pstmt.setInt(2, person.getAge());
            pstmt.setString(3, person.getEmail());
            pstmt.setLong(4, person.getId());

            // Выполнение запроса
            int affectedRows = pstmt.executeUpdate();

            // Проверка, была ли обновлена хотя бы одна строка
            if (affectedRows == 0) {
                throw new SQLException("Updating person failed, no rows affected.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    public Person getPersonById(long id) {
//        for (Person person : personList) {
//            if (person.getId() == id) {
//                return person;
//            }
//        }
//        throw new IllegalArgumentException("Person with id " + id + " not found");

//        return personList.stream().filter(person -> person.getId() == id).findFirst().orElseThrow(IllegalArgumentException::new);
//        return null;
//    }

    public Person show(Long id) {
        // SQL-запрос для получения данных человека по ID
        String sql = "SELECT * FROM Person WHERE id = ?";

        try {
            // Создание объекта PreparedStatement для выполнения параметризованного запроса
            PreparedStatement pstmt = connection.prepareStatement(sql);

            // Установка параметров запроса
            pstmt.setLong(1, id);

            // Выполнение запроса и получение ResultSet
            ResultSet rs = pstmt.executeQuery();

            // Обработка результатов запроса
            if (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String email = rs.getString("email");

                // Создание объекта Person с данными из базы данных
                Person person = new Person(id, name, age, email);
                return person;
            } else {
                // Если результатов нет, возвращаем null или кидаем исключение
                return null; // или throw new IllegalArgumentException("Person not found with ID: " + id);
            }
        } catch (SQLException e) {
            // В случае исключения выбрасываем RuntimeException с оригинальным исключением в качестве причины
            throw new RuntimeException("Error retrieving person with ID: " + id, e);
        }
    }

    public void delete(Long id) {
        String sql = "DELETE FROM Person WHERE id = ?";
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, id);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add100People(List<Person> people) {
        System.err.println("add100People");
    }
}
