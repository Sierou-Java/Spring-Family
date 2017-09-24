package org.family.elasticjob.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 王洪悦.{javayue@yeah.net}
 * @Create 2017-09-24 下午9:28
 */
@RestController
public class JobController {

    @RequestMapping(value = "/job")
    public String job(){
        return "job controller";
    }
}
