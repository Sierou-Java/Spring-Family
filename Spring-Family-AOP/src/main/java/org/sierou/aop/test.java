package org.sierou.aop;

import org.sierou.aop.annotation.ControLog;
import org.springframework.stereotype.Component;

/**
 * @Author 王洪悦.{javayue@yeah.net}
 * @Create 2017-08-12 下午6:06
 */
@Component
public class test {

    @ControLog
    public static void main(String[] args) {
        System.out.println("123");
    }
}
