package org.sierou.aop.dynamicproxy;

import org.sierou.aop.common.Target;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author 王洪悦.{javayue@yeah.net}
 * @Create 2017-08-13 下午8:20
 */
public class JdkProxy implements InvocationHandler{

    private Target target;

    public JdkProxy(Target target) {
        this.target = target;
    }

    /**
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // say method
//        Class<?> aClass = Class.forName("");
//        aClass.getMethod("method name", String.class);
        System.out.println("before ...");
        // target impl say hello world!
        Object invoke = method.invoke(target, args);
        System.out.println("end ....");
        return invoke;
    }


}
