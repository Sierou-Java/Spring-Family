package org.sierou.aop.JdkProxy;

import org.sierou.aop.common.Target;
import org.sierou.aop.common.TargetImpl;

import java.lang.reflect.Proxy;

/**
 * @Author 王洪悦.{javayue@yeah.net}
 * @Create 2017-08-09 上午9:54
 */
public class JDKProxyTest {

    public static void main(String[] args) {
        Target target = new TargetImpl();
        JdkProxy jdkProxy = new JdkProxy(target);
        // 因为Target本身就是一个接口，它的字节码符合第二个参数要求
        Target o = (Target)Proxy.newProxyInstance(Target.class.getClassLoader(), new Class[]{Target.class}, jdkProxy);
//        Target o = (Target)Proxy.newProxyInstance(Target.class.getClassLoader(), Target.class.getInterfaces(), jdkProxy);
        /**
         * Exception in thread "main" java.lang.IllegalArgumentException:
         * org.sierou.aop.common.TargetImpl is not an service
         */
//        Target o = (Target)Proxy.newProxyInstance(Target.class.getClassLoader(), new Class[]{TargetImpl.class}, jdkProxy);
        o.execute();
    }


    public static void main1(String[] args) {
        Class<?>[] interfaces = TargetImpl.class.getInterfaces();
        for (Class<?> aClass : interfaces) {
            System.out.println(aClass.getName());
        }
    }
}
