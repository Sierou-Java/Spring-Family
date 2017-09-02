package org.family.controller;

import com.alibaba.fastjson.JSONObject;
import javafx.print.Printer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * @Author 王洪悦.{javayue@yeah.net}
 * @Create 2017-08-10 上午10:44
 */

@Controller
public class RestControllerTest {

    static final String URL = "http://localhost:8080/restful";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/test")
    public String post(HttpServletRequest request) {
        System.out.println("hello world jsp!11111111222");
        request.setAttribute("hello", "hello world!!!");
        return "hellothymeleaf";
    }

    @GetMapping(value = "/rest")
    public String rest() {
        JSONObject postData = new JSONObject();
        postData.put("descp", "request for post");
        JSONObject body = restTemplate.postForEntity(URL, postData, JSONObject.class).getBody();
        System.out.println("test   end   ..........");
        body.put("hello2", "hello world!2");
        return body.toJSONString();
    }

    @PostMapping(value = "/restful")
    public String restful(@RequestBody JSONObject post) {
        System.out.println("requestBody = " + post);
        System.out.println("restful  end ....");
        post.put("hello", "helloworld");
        return post.toJSONString();
    }

}
