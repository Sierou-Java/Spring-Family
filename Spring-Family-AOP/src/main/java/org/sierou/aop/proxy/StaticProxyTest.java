package org.sierou.aop.proxy;

import org.sierou.aop.common.Target;
import org.sierou.aop.common.TargetImpl;

/**
 * @Author 王洪悦.{javayue@yeah.net}
 * @Create 2017-08-09 上午9:46
 */
public class StaticProxyTest {

    public static void main(String[] args) {
        // 定义接口实现类 --- 多态 ---
        Target target = new TargetImpl();
        // 定义代理对象
        Proxy proxy = new Proxy(target);
        // 执行代理方法
        proxy.execute();
    }
}
