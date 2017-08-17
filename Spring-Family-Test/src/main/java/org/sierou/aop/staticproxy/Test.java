package org.sierou.aop.staticproxy;

import org.sierou.aop.common.Target;
import org.sierou.aop.common.TargetImpl;

/**
 * @Author 王洪悦.{javayue@yeah.net}
 * @Create 2017-08-13 下午8:14
 */
public class Test {


    // 手动创建代理对象  必须有接口，必须有接口实现类
    public static void main(String[] args) {
        Target target = new TargetImpl();
        Proxy proxy = new Proxy(target);
        proxy.say();
        // before --> hello world! --> end..
    }
}
