package org.family.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Author 王洪悦.{javayue@yeah.net}
 * @Create 2017-09-28 下午4:32
 */
@Controller
@RequestMapping(value = "/thymeleaf")
public class ThymeleafController {

    @GetMapping(value = "/test")
    public String test(HttpServletRequest request){
        request.setAttribute("hello", "hello world!");
        return "hello";
    }
}
