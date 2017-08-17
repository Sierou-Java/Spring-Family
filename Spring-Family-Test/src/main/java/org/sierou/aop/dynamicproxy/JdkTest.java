package org.sierou.aop.dynamicproxy;

import org.sierou.aop.common.Target;
import org.sierou.aop.common.TargetImpl;

import java.lang.reflect.Proxy;

/**
 * @Author 王洪悦.{javayue@yeah.net}
 * @Create 2017-08-13 下午8:24
 */
public class JdkTest {

    public static void main(String[] args) {

        Target targetImpl = new TargetImpl();
        JdkProxy jdkProxy = new JdkProxy(targetImpl);
        // jdk java开发环境  jre 运行环境 jvm java虚拟机
        // .java --> .class --> jvm 机器码 cpu去读
        // com.sun.proxy.$Proxy0 cannot be cast to org.sierou.aop.common.TargetImpl
        Target o = (Target)Proxy.newProxyInstance(JdkTest.class.getClassLoader(),
                    targetImpl.getClass().getInterfaces(),
                    jdkProxy);
        o.say();

    }
}
