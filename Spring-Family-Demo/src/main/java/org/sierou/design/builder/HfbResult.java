package org.sierou.design.builder;

import java.math.BigDecimal;

/**
 * @Author 王洪悦.{javayue@yeah.net}
 * @Create 2017-08-29 下午11:41
 */
public class HfbResult {

    private String name;
    private Integer orderId;
    private Integer merchantId;
    private String age;
    private String memo;
    private BigDecimal total;


    public HfbResult(String name, Integer orderId, Integer merchantId, String age, String memo, BigDecimal total) {
        this.name = name;
        this.orderId = orderId;
        this.merchantId = merchantId;
        this.age = age;
        this.memo = memo;
        this.total = total;
    }

    public HfbResult() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "HfbResult{" +
                "name='" + name + '\'' +
                ", orderId=" + orderId +
                ", merchantId=" + merchantId +
                ", age='" + age + '\'' +
                ", memo='" + memo + '\'' +
                ", total=" + total +
                '}';
    }
}
