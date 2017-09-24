package org.sierou.aop.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CGLib采用了非常底层的字节码技术，其原理是通过字节码技术为一个类创建子类，
 * 并在子类中采用方法拦截的技术拦截所有父类方法的调用，顺势织入横切逻辑。
 * JDK动态代理与CGLib动态代理均是实现Spring AOP的基础。
 *
 * @Author 王洪悦.{javayue@yeah.net}
 * @Create 2017-08-09 上午10:26
 */
public class CglibMethodInterceptor implements MethodInterceptor{

    private Class targetClass;

    // 传入被代理对象
    public Object getInstance(Class targetClass){
        this.targetClass = targetClass;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.targetClass);
        enhancer.setCallback(this);
        return enhancer.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib execute before ..");
        Object o1 = methodProxy.invokeSuper(o, objects);
        System.out.println("cglib execute end ...");
        return o1;
    }
}
