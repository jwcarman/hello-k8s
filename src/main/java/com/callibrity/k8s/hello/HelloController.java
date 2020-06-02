package com.callibrity.k8s.hello;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
@EnableConfigurationProperties
public class HelloController {

    private final String pattern;

    public HelloController(HelloProperties props) {
        this.pattern = props.getPattern();
    }

    @GetMapping("/{name}")
    public String sayHello(@PathVariable("name") String name) {
        return String.format(pattern, name);
    }
}
