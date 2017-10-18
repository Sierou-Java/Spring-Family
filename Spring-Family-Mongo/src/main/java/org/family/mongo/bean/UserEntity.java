package org.family.mongo.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * User实体
 *
 * @Author 王洪悦.{javayue@yeah.net}
 * @Create 2017-10-18 下午11:31
 */
@Data
public class UserEntity implements Serializable{

    private static final long serialVersionUID = -3258839839160856613L;
    private Long id;
    private String userName;
    private String passWord;

}
