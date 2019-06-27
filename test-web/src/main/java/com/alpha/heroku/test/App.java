package com.alpha.heroku.test;

import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author huiyan.yao
 * @Date 2019/6/26 15:07
 */
@SpringBootApplication
@MapperScan("com.alpha.heroku.test.mapper")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
