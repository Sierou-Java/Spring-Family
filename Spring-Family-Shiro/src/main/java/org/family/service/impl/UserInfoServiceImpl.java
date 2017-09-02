package org.family.service.impl;

import org.family.pojo.UserInfo;
import org.family.repository.UserInfoRepository;
import org.family.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author 王洪悦.{javayue@yeah.net}
 * @Create 2017-09-02 下午7:16
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired private UserInfoRepository userInfoRepository;

    @Override
    public UserInfo findByUsername(String userName) {
        return userInfoRepository.findByUsername(userName);
    }
}
