package org.family.service;

import org.family.pojo.UserInfo;

/**
 * @Author 王洪悦.{javayue@yeah.net}
 * @Create 2017-09-02 下午7:15
 */
public interface UserInfoService {

    UserInfo findByUsername(final String userName);
}
