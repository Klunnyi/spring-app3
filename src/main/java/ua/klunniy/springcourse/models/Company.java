package ua.klunniy.springcourse.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;

@Data
public class Company {

    @Valid
    private Long companyId;
    private String companyName;
}
