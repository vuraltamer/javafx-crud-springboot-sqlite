package com.example.jfxtest;

import com.example.jfxtest.config.JavaFxConfiguration;
import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class JfxTestApplication {
    public static void main(String[] args) {
        Application.launch(JavaFxConfiguration.class, args);
    }
}
