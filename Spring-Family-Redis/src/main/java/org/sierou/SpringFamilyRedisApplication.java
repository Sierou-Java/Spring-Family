package org.sierou;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableCaching
public class SpringFamilyRedisApplication {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	public static void main(String[] args) {
		SpringApplication.run(SpringFamilyRedisApplication.class, args);
	}

	@PostConstruct
	public void initRedis(){
		ValueOperations<String, String> vop = stringRedisTemplate.opsForValue();
		vop.set("lock", "lockvalue");
		System.out.println(vop.get("lock"));
	}
}
