package org.sierou.aop.spring;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @Author 王洪悦.{javayue@yeah.net}
 * @Create 2017-08-13 下午9:14
 */
// javadoc
@Documented
// retention:保留，Policy：政策
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
// @Inherited：说明子类可以继承父类中的该注解
@Inherited
public @interface ControLog {
    String value() default "this log";
}
