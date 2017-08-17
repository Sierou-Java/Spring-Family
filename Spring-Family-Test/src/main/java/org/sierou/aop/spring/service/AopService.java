package org.sierou.aop.spring.service;

import org.sierou.aop.spring.ControLog;
import org.springframework.stereotype.Service;

/**
 * @Author 王洪悦.{javayue@yeah.net}
 * @Create 2017-08-13 下午9:29
 */
@Service
public class AopService {

    @ControLog
    public void helloAop(){
        System.out.println("hello aop!!!");
    }
}
