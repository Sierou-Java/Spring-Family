package org.sierou.design.builder;

import java.math.BigDecimal;

/**
 * @Author 王洪悦.{javayue@yeah.net}
 * @Create 2017-08-29 下午11:42
 */
public class HfbResultBuilder {

    private HfbResult hfbResult = new HfbResult();

    private String name;
    private Integer orderId;
    private Integer merchantId;
    private String age;
    private String memo;
    private BigDecimal total;

    public static HfbResultBuilder getInstance(){
        return new HfbResultBuilder();
    }

    public void setHfbResult(HfbResult hfbResult) {
        this.hfbResult = hfbResult;
    }

    public HfbResultBuilder setName(String name) {
        this.hfbResult.setName(name);
        return this;
    }

    public HfbResultBuilder setOrderId(Integer orderId) {
        this.hfbResult.setOrderId(orderId);
        return this;
    }

    public HfbResultBuilder setMerchantId(Integer merchantId) {
        this.hfbResult.setMerchantId(merchantId);
        return this;
    }

    public HfbResultBuilder setAge(String age) {
        this.hfbResult.setAge(age);
        return this;
    }

    public HfbResultBuilder setMemo(String memo) {
        this.hfbResult.setMemo(memo);
        return this;
    }

    public HfbResultBuilder setTotal(BigDecimal total) {
        this.hfbResult.setTotal(total);
        return this;
    }


    public HfbResult build(){
//        return new HfbResult(name, orderId, merchantId, age, memo, total);
        return hfbResult;
    }
}
