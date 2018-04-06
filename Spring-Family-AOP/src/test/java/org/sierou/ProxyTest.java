package org.sierou;


/**
 * @Author 王洪悦.{javayue@yeah.net}
 * @Create 2017-12-18 下午9:47
 */
public class ProxyTest {

    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory(ProxyService.class);
        ProxyService proxyService = proxyFactory.getProxyObject();
        proxyService.say();
    }
}
