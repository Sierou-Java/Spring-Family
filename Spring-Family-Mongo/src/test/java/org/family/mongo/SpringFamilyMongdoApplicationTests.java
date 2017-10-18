package org.family.mongo;

import org.family.mongo.bean.UserEntity;
import org.family.mongo.dao.UserDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringFamilyMongdoApplicationTests {


    private UserEntity user = new UserEntity();

    @Autowired
    private UserDao userDao;

    @Before
    public void init() {
        user.setId(2l);
        user.setUserName("sierou");
        user.setPassWord("sierou");
    }

    @Test
    public void contextLoads() {

        userDao.saveUser(user);

        UserEntity user = userDao.findUserByUserName("sierou");
        System.out.println("user is " + user);
    }

}
