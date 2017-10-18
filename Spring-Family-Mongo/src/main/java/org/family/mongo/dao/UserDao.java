package org.family.mongo.dao;

import org.family.mongo.bean.UserEntity;

/**
 * @Author 王洪悦.{javayue@yeah.net}
 * @Create 2017-10-18 下午11:38
 */
public interface UserDao {

    /**
     * 新增
     * @param user
     */
    void saveUser(UserEntity user);

    /**
     * 查找
     * @param userName
     * @return
     */
    UserEntity findUserByUserName(String userName);

    /**
     * 修改
     * @param user
     * @return
     */
    int updateUser(UserEntity user);

    /**
     * 删除
     * @param id
     */
    void deleteUserById(Long id);
}
