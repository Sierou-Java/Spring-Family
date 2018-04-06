package org.sierou;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author 王洪悦.{javayue@yeah.net}
 * @Create 2017-12-18 下午9:44
 */
public class ProxyFactory implements InvocationHandler {

    private Class interfaceClass;

    public ProxyFactory(Class interfaceClass) {
        this.interfaceClass = interfaceClass;
    }

    public <T> T getProxyObject(){
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(),//类加载器
                new Class[]{interfaceClass},//为哪些接口做代理(拦截哪些方法)
                this);//(把这些方法拦截到哪处理)
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before ...........");
        System.out.println("method = " + method);
        method.invoke(interfaceClass, args);
        System.out.println("after ............");
        return null;
    }
}
