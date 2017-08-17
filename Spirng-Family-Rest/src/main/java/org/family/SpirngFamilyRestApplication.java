package org.family;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpirngFamilyRestApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(SpirngFamilyRestApplication.class, args);
	}

//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		return application.sources(SpirngFamilyRestApplication.class);
//	}
	@PostConstruct
	public void init(){
		System.out.println("SpirngFamilyRestApplication.init ...");
	}
}
