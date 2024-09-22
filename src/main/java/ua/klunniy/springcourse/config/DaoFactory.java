//package ua.klunniy.springcourse.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//import ua.klunniy.springcourse.dao.PersonDAO;
//import ua.klunniy.springcourse.dao.jdbc.JdbcPersonDAO;
//import ua.klunniy.springcourse.dao.jdbcTemplate.JdbcTemplatePersonDAO;
//
//@Configuration
//public class DaoFactory {
//
//    @Autowired
//    private JdbcPersonDAO jdbcPersonDAO;
//
//    @Autowired
//    private JdbcTemplatePersonDAO jdbcTemplatePersonDAO;
//
//    @Bean
//    public PersonDAO personDAO(Environment env) {
//        String daoType = env.getProperty("dao.type");
//
//        if ("JDBC".equalsIgnoreCase(daoType)) {
//            return jdbcPersonDAO;
//        } else {
//            return jdbcTemplatePersonDAO;
//        }
//    }
//}