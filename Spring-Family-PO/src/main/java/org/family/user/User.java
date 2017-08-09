package org.family.user;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Author 王洪悦.{javayue@yeah.net}
 * @Create 2017-07-26 下午5:08
 */
@Data
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
        private String name;

    @Column(nullable = false)
    private Integer age;

    // 省略构造函数

    // 省略getter和setter

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public User() {
    }
}
