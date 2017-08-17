package org.sierou.aop.service;

import org.sierou.aop.annotation.ControLog;
import org.springframework.stereotype.Service;

/**
 * @Author 王洪悦.{javayue@yeah.net}
 * @Create 2017-08-12 下午6:16
 */
@Service
public class AopService {

    @ControLog
    public String testControLog(String name){
        System.out.println("AopService.testControLog name " + name);
        return name;
    }
}
