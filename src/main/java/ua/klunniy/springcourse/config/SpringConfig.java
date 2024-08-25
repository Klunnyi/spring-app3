package ua.klunniy.springcourse.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static javax.servlet.SessionTrackingMode.URL;
import static org.postgresql.shaded.com.ongres.scram.common.ScramAttributes.USERNAME;

@PropertySource({"classpath:database.properties",
        "classpath:hibernate.properties",
        "classpath:property.properties"})
@Configuration
@ComponentScan("ua.klunniy.springcourse")
@EnableWebMvc
//@EnableJpaRepositories("ua.klunniy.springcourse.repository")
//@EnableTransactionManagement
public class SpringConfig implements WebMvcConfigurer {

    private final ApplicationContext applicationContext;

    @Value("{$url}")
    private String url;

    @Value("{$username}")
    private String username;

    @Value("{$password}")
    private String password;

    @Value("{$driver}")
    private String driver;


    @Autowired
    public SpringConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix("/WEB-INF/views/");
        templateResolver.setSuffix(".html");
        return templateResolver;
    }

//    @Bean
//    public Connection dataSource() {
//        try{
//            Class.forName(driver);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        Connection connection = null;
//        try {
//            connection = DriverManager.getConnection(url, username, password);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return connection;
//    }


    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.setEnableSpringELCompiler(true);
        return templateEngine;
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        registry.viewResolver(resolver);
    }
}
