package org.sierou;

import org.sierou.aop.spring.service.AopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringFamilyTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringFamilyTestApplication.class, args);
	}

	@Autowired
	AopService aopService;

	@GetMapping(value = "/hello")
	public String hello(){
		aopService.helloAop();
		return "hello world!";
	}
}
