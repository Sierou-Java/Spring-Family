package org.family.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 王洪悦.{javayue@yeah.net}
 * @Create 2017-08-31 下午5:01
 */
@RestController
public class DockerController {

    @RequestMapping(value = "/docker")
    public String docker(){
        return "hello docker!";
    }
}
