package com.callibrity.k8s.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/{name}")
    public String sayHello(@PathVariable("name") String name) {
        return String.format("Hello, %s!", name);
    }
}
