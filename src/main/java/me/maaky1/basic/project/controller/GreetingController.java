package me.maaky1.basic.project.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/say")
@Tag(name = "Greeting Controller", description = "Controller untuk menyapa")
public class GreetingController {

    /**
     * Say Hello without parameter
     */
    @GetMapping("/hello")
    @Operation(summary = "Say Hello", description = "Endpoint untuk mengembalikan pesan hello")
    public String sayHello() {
        return "Hello World!";
    }

    /**
     * Say Hello with parameter
     */
    @GetMapping("/hello-to")
    @Operation(summary = "Say Hello To", description = "Endpoint untuk mengembalikan pesan hello dengan nama sebagai inputan")
    public String sayHelloTo(@RequestParam String name) {
        return "Hello " + name;
    }
}
