package org.example.course_manager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.example.course_manager.mapper")
public class CourseManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseManagerApplication.class, args);
    }
}
