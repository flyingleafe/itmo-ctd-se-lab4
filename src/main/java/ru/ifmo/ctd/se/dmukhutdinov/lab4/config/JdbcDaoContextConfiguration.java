package ru.ifmo.ctd.se.dmukhutdinov.lab4.config;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.ifmo.ctd.se.dmukhutdinov.lab4.dao.TodoJdbcDao;

import javax.sql.DataSource;

/**
 * @author akirakozov
 */
public class JdbcDaoContextConfiguration {
    @Bean
    public TodoJdbcDao productJdbcDao(DataSource dataSource) {
        return new TodoJdbcDao(dataSource);
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.sqlite.JDBC");
        dataSource.setUrl("jdbc:sqlite:product.db");
        dataSource.setUsername("");
        dataSource.setPassword("");
        return dataSource;
    }
}
