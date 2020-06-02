package com.callibrity.k8s.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(HelloProperties.class)
public class HelloKubernetesApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloKubernetesApplication.class, args);
	}

}
