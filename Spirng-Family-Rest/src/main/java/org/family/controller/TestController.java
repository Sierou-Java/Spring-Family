package org.family.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 王洪悦.{javayue@yeah.net}
 * @Create 2017-07-26 下午4:06
 */
@RestController
public class TestController {

    @GetMapping(value = "/test")
    public String test(){
        return "Hello World!";
    }
}
