package org.sierou;

import org.sierou.aop.annotation.ControLog;
import org.sierou.aop.service.AopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@RestController
public class SpringFamilyDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringFamilyDemoApplication.class, args);
    }

    private static Logger log = LoggerFactory.getLogger(SpringFamilyDemoApplication.class);

    @Autowired
    private AopService aopService;

    @GetMapping(value = "/hello/{name}")
    @ResponseBody
    public String hello(@PathVariable(value = "name") String name) {
        aopService.testControLog("name : " + name);
        log.info("=========================wwwwwww================");
        return "hello world!" + name;
    }

    @PostConstruct
    void init() {
        System.out.println("**** init spring boot ****");
    }

    @ControLog
    public void annoTest() {
        System.out.println("SpringFamilyDemoApplication.annoTest");
    }
}
