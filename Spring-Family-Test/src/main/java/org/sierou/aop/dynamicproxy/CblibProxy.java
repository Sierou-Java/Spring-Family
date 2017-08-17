package org.sierou.aop.dynamicproxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author 王洪悦.{javayue@yeah.net}
 * @Create 2017-08-13 下午8:50
 */

// 通过 一个子类对父类进行代理 字节码技术放射出父类对象 class 字节码 反射
public class CblibProxy implements MethodInterceptor{

    // 被增强的对象
//    private Class targectClass;

    public Object getObject(Class<?> clz){
//        this.targectClass = clz;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib before ...");
        // 通过子类 反射出 父类方法
        Object o1 = methodProxy.invokeSuper(o, objects);
        System.out.println("cglib end ....");
        return o1;
    }
}
