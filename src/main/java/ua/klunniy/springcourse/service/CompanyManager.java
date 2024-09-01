package ua.klunniy.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.klunniy.springcourse.dto.CompanyDto;
import ua.klunniy.springcourse.repository.CompanyRepository;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class CompanyManager {

    @Autowired
    private CompanyRepository companyDao;

    public List<CompanyDto> findCompanies() {
        return companyDao.findAll().stream
                .map(c -> newCompanyDto(c.getCompanyId, c.getCompanyName))
                .collect(Collectors.toList());
    }
}
