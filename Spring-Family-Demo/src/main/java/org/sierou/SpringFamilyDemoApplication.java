package org.sierou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@SpringBootApplication
@RestController
public class SpringFamilyDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringFamilyDemoApplication.class, args);
	}

	@GetMapping(value = "/hello")
	public String hello(){
		System.out.println("hissssssaa");
		return "hello!ssssssadasd!!s";
	}

	@PostConstruct
	void init(){
		System.out.println("**** init spring boot ****");
	}
}
