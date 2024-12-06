package me.maaky1.basic.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/say")
public class GreetingController {

    /**
     * Say Hello without parameter
     */
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World!";
    }

    /**
     * Say Hello with parameter
     */
    @GetMapping("/hello-to")
    public String sayHelloTo(@RequestParam String name) {
        return "Hello " + name;
    }
}
