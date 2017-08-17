package org.sierou.aop.annotation;

import sun.awt.SunHints;

import java.lang.annotation.*;

/**
 * 自定义AOP注解
 *
 * @Author 王洪悦.{javayue@yeah.net}
 * @Create 2017-08-12 下午5:52
 */
// 说明该注解将被包含在javadoc中
@Documented
// 注解会在class字节码文件中存在，在运行时可以通过反射获取到 （RetentionPolicy：保留政策）
@Retention(RetentionPolicy.RUNTIME)
// 方法
@Target(ElementType.METHOD)
// @Inherited：说明子类可以继承父类中的该注解
@Inherited
public @interface ControLog {
    String value() default "log annotation";
}
