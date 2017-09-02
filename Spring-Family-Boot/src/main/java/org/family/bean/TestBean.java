package org.family.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author 王洪悦.{javayue@yeah.net}
 * @Create 2017-09-01 下午4:09
 */
@Configuration
public class TestBean {

    @Bean
    public SierouBean sierouBean(){
        return new SierouBean();
    }
}
