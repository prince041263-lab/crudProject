package org.example.crudproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class CrudProjectApplication {

    public static void main(String[] args) {

        SpringApplication.run(CrudProjectApplication.class, args);
        System.out.println("hello world");
    }

}
