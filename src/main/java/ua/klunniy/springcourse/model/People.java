package ua.klunniy.springcourse.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class People {

    private Integer id;
    private String name;
    private Integer age;
    private String email;

}
