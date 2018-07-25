package net.canway.activiti1;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class Activiti1Application {

    public static void main(String[] args) {
        SpringApplication.run(Activiti1Application.class, args);
    }
}
