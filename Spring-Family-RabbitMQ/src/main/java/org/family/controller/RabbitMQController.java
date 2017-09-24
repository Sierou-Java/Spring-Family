package org.family.controller;

import org.family.rabbitmq.HelloSender1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 王洪悦.{javayue@yeah.net}
 * @Create 2017-09-08 下午5:02
 */
@RestController
@RequestMapping("/rabbit")
public class RabbitMQController {

    @Autowired
    private HelloSender1 helloSender1;
    @Autowired
    private HelloSender1 helloSender2;

    @PostMapping("/hello")
    public void hello() {
        helloSender1.send();
    }
}
