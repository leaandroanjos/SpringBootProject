package br.com.leandro.SpringBootFirstProject.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "🚀 Olá, Spring Boot está rodando!";
    }
}
