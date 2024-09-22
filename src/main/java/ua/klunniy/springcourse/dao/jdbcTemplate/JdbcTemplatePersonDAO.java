package ua.klunniy.springcourse.dao.jdbcTemplate;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ua.klunniy.springcourse.dao.PersonDAO;
import ua.klunniy.springcourse.models.Person;
import ua.klunniy.springcourse.models.mapper.PersonMapper;

import java.util.List;

@Getter
@Component
@RequiredArgsConstructor
public class JdbcTemplatePersonDAO implements PersonDAO {

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

    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO Person (name, age, email) VALUES (?, ?, ?)", person.getName(), person.getAge(), person.getEmail());
    }

    public void update(Person person) {
        jdbcTemplate.update("UPDATE Person SET name = ?, age = ?, email = ? WHERE id = ?", person.getName(), person.getAge(), person.getEmail(), person.getId());
    }

    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM Person WHERE id = ?", id);
    }
}
