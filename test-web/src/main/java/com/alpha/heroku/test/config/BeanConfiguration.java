package com.alpha.heroku.test.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

/**
 * @author alpha @Date 2017/10/31
 */
@Configuration
public class BeanConfiguration {

    @Value("${jdbc.postgresql.url}")
    private String url;
    @Value("${jdbc.postgresql.username}")
    private String username;
    @Value("${jdbc.postgresql.password}")
    private String password;
    @Value("${jdbc.postgresql.driver}")
    private String driver;

    @Bean
    public DruidDataSource dataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setInitialSize(1);
        druidDataSource.setMinIdle(1);
        druidDataSource.setMaxActive(20);
        druidDataSource.setMaxWait(60000);
        druidDataSource.setTimeBetweenEvictionRunsMillis(60000);
        druidDataSource.setMinEvictableIdleTimeMillis(300000);
        druidDataSource.setValidationQuery("select 'x'");
        druidDataSource.setTestWhileIdle(true);
        druidDataSource.setTestOnBorrow(false);
        druidDataSource.setTestOnReturn(false);
        druidDataSource.setPoolPreparedStatements(true);
        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(20);
        druidDataSource.setDriverClassName(driver);
        druidDataSource.setFilters("stat,wall,log4j");
        druidDataSource.init();

        return druidDataSource;
    }
}