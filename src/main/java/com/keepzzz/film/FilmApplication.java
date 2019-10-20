package com.keepzzz.film;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.keepzzz.film.mapper")
public class FilmApplication {

    public static void main(String[] args) {
        SpringApplication.run(FilmApplication.class, args);
    }

}
