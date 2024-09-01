package ua.klunniy.springcourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.klunniy.springcourse.service.CompanyManager;
import ua.klunniy.springcourse.dto.CompanyDto;

import java.util.List;

@RestController
@RequestMapping(path = "/company")
public class CompanyController {

    @Autowired
    private CompanyManager companyManager;

//    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<CompanyDto> findCompanies() {
//        return companyManager.findCompanies();
//    };
}
