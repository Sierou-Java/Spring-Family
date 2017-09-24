package org.sierou.aop.proxy;

import org.sierou.aop.common.Target;

/**
 * @Author 王洪悦.{javayue@yeah.net}
 * @Create 2017-08-09 上午9:46
 */
public class Proxy {

    private Target target;

    public Target getTarget() {
        return target;
    }

    public void setTarget(Target target) {
        this.target = target;
    }

    public Proxy(Target target) {
        this.target = target;
    }

    public String execute(){
        System.out.println("proxy before ...");
        this.target.execute();
        System.out.println("proxy end ...");
        return "proxy execute";
    }
}
