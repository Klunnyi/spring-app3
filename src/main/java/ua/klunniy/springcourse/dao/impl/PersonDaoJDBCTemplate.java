package ua.klunniy.springcourse.dao.impl;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ua.klunniy.springcourse.dao.PersonDAO;
import ua.klunniy.springcourse.models.Person;
import ua.klunniy.springcourse.models.mapper.PersonMapper;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Getter
@Component
@RequiredArgsConstructor
public class PersonDaoJDBCTemplate implements PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    // Мы используем метод query что бы получить данные из таблицы
    public List<Person> index() {
 //       return jdbcTemplate.query("SELECT * FROM Person ORDER BY id", new PersonMapper());
        return jdbcTemplate.query("SELECT * FROM Person ORDER BY id", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person show(Long id) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE id = ?", new Object[]{id}, new PersonMapper()).stream().findFirst().orElseThrow(IllegalArgumentException::new);
        //return jdbcTemplate.queryForObject("SELECT * FROM Person WHERE id = ?", new Object[]{id}, new PersonMapper());
    }

    public Optional<Person> getPersonByEmail(String email) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE email = ?", new Object[]{email}, new PersonMapper()).stream().findFirst();
    }

    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO Person (name, age, email) VALUES (?, ?, ?)", person.getName(), person.getAge(), person.getEmail());
    }

    public void update(Person person) {
        jdbcTemplate.update("UPDATE Person SET name = ?, age = ?, email = ? WHERE id = ?", person.getName(), person.getAge(), person.getEmail(), person.getId());
    }

    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM Person WHERE id = ?", id);
    }

    public void add100People(List<Person> people) {
        for (Person person : people) {
            this.save(person);
        }
    }

    public void add100PeopleWithButch(List<Person> people) {
        jdbcTemplate.batchUpdate("INSERT INTO Person (name, age, email) VALUES (?, ?, ?)", new BatchPreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1, people.get(i).getName());
                ps.setInt(2, people.get(i).getAge());
                ps.setString(3, people.get(i).getEmail());
            }

            @Override
            public int getBatchSize() {
                return people.size();
            }
        } );
    }
}
