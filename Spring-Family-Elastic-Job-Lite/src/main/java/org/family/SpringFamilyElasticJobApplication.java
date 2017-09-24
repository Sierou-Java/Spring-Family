package org.family;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import javax.annotation.PostConstruct;

@SpringBootApplication
@ImportResource(locations = "classpath:elastic-job/elastic-job.xml")
public class SpringFamilyElasticJobApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringFamilyElasticJobApplication.class, args);
	}

	@PostConstruct
	public void init(){
		System.out.println("SpringFamilyElasticJobApplication.init");
	}
}
