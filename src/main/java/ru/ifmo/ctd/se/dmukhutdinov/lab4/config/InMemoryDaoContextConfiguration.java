package ru.ifmo.ctd.se.dmukhutdinov.lab4.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.ifmo.ctd.se.dmukhutdinov.lab4.dao.TodoDao;
import ru.ifmo.ctd.se.dmukhutdinov.lab4.dao.TodoInMemoryDao;

/**
 * @author akirakozov
 */
@Configuration
public class InMemoryDaoContextConfiguration {
    @Bean
    public TodoDao productDao() {
        return new TodoInMemoryDao();
    }
}
