package org.sierou.aop.cglib;

import net.sf.cglib.proxy.Enhancer;
import org.sierou.aop.common.*;

/**
 * @Author 王洪悦.{javayue@yeah.net}
 * @Create 2017-08-09 上午10:44
 */
public class CglibTest {

    public static void main(String[] args) {
//        CglibMethodInterceptor cglibMethodInterceptor = new CglibMethodInterceptor();
//        CglibTarget cglibTarget = (CglibTarget)cglibMethodInterceptor.getInstance(CglibTarget.class);
//        cglibTarget.execute();
        CglibMethodInterceptor cglibMethodInterceptor = new CglibMethodInterceptor();
        Target cglibTarget = (Target)cglibMethodInterceptor.getInstance(TargetImpl.class);
        cglibTarget.execute();
    }
}
