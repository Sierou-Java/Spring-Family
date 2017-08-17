package org.sierou.aop.dynamicproxy;

import org.sierou.aop.common.CglibTarget;
import org.sierou.aop.common.CglibTargetImpl;
import org.sierou.aop.common.TargetImpl;

/**
 * @Author 王洪悦.{javayue@yeah.net}
 * @Create 2017-08-13 下午9:00
 */
public class CglibTest {

    public static void main(String[] args) {
//        CglibTarget target = new CglibTarget();
//        CglibTarget target = new CglibTargetImpl();
        CglibTargetImpl target = new CglibTargetImpl();
        CblibProxy cblibProxy = new CblibProxy();
//        CglibTarget object = (CglibTarget)cblibProxy.getObject(target.getClass());
        CglibTargetImpl object = (CglibTargetImpl)cblibProxy.getObject(target.getClass());
        object.hello();
    }
}
