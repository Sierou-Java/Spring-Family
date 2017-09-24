package org.sierou.design;

import org.sierou.design.builder.HfbResult;
import org.sierou.design.builder.HfbResultBuilder;

/**
 * @Author 王洪悦.{javayue@yeah.net}
 * @Create 2017-08-29 下午11:48
 */
public class DesignTest {

    public static void main(String[] args) {
//        HfbResultBuilder hfbResultBuilder = new HfbResultBuilder();
//        HfbResult hfb = hfbResultBuilder.setMemo("memo").setMerchantId(123).setOrderId(8080).build();
        HfbResult build = HfbResultBuilder.getInstance().setMemo("memo").build();
        System.out.println(build);
    }
}
