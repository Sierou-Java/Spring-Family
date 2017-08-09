package org.family.test;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Author 王洪悦.{javayue@yeah.net}
 * @Create 2017-07-26 下午3:24
 */

//    @Entity 声明这是一个跟数据库有映射关系的实体类
//    @Id 声明主键ID
//    @GeneratedValue 声明自增长

@Data
@Entity
public class TestPO {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer age;

    public TestPO() {
    }

    public TestPO(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
