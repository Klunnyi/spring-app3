package ua.klunniy.springcourse.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private long id;

    @NotBlank(message = "Name should not be blank")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    private String name;

    @Min(value = 0, message = "Age should be greater then 0")
    @Max(value = 110, message = "Age should be less then 110" )
    private int age;

    @NotBlank(message = "Email should not be blank")
    @Email
    private String email;

}
