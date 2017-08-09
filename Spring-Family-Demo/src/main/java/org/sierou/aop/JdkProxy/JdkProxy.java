package org.sierou.aop.JdkProxy;

import org.sierou.aop.common.Target;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理主要是通过反射机制，在运行时动态生成所需代理的class.
 * @Author 王洪悦.{javayue@yeah.net}
 * @Create 2017-08-09 上午9:52
 */
public class JdkProxy implements InvocationHandler{

    private Target target;

    public JdkProxy(Target target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("jdkproxy before ...");
        Object invoke = method.invoke(target, args);
        System.out.println("jdkproxy end ...");
        return invoke;
    }
}
