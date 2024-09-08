//package ua.klunniy.springcourse.service;
//
//import lombok.NoArgsConstructor;
//import org.springframework.stereotype.Service;
//import ua.klunniy.springcourse.models.People;
//
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
////@RequiredArgsConstructor
//@NoArgsConstructor
//public class PeopleService {
////
//    private static final String URL = "jdbc:postgresql://localhost:5432/security_app_db";
//    private static final String USERNAME = "postgres";
//    private static final String PASSWORD = "870EVO";
//
//    private static Connection connection;
//
//    static {
//        try{
//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
////    @Autowired
////    private PeopleRepository peopleRepository;
//
////    public List<People> getPeople() {
////        return peopleRepository.findAll();
////    }
////
////    public People getPeopleById(Long id) {
////        return peopleRepository.findById(id)
////                .orElseThrow(() -> new IllegalArgumentException("Person not found with id: " + id));
////    }
////
////    public void save(People people) {
////        peopleRepository.save(people);
//
//
//    public List<People> getPeople() {
//
//        List<People> peopleList = new ArrayList<>();
//
//        try {
//            // Это тот обьект который содержит в себе sql запрос к БД
//            Statement statement = connection.createStatement();
//            String query = "SELECT * FROM Person";
//
//            // ResultSet - это обьект который инкапсулирует в себе результат выполнения запроса к БД
//            ResultSet resultSet = statement.executeQuery(query);
//            while (resultSet.next()) {
//                People people = new People();
//                people.setId(resultSet.getInt("id"));
//                people.setName(resultSet.getString("username"));
//                peopleList.add(people);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//        return peopleList;
//    }
//
//    public People getPeopleById(Long id) {
//        return null;
//    }
//
//    public void save(People people) {
////        try {
////            // Это тот объект, который содержит в себе sql запрос к БД
////            Statement statement = connection.createStatement();
////            String query = "INSERT INTO Person VALUES (" + people.getId() + ",'" + people.getName() + "'," + people.getAge() + ",'" + people.getEmail() + "';)";
////
////            // ResultSet - это объект который инкапсулирующем в себе результат выполнения запроса к БД
////            statement.executeUpdate(query);
////
////        } catch (SQLException e) {
////            throw new RuntimeException(e);
////        }
//
//    }
//}
