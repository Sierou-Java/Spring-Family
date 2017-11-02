package org.family;

import org.family.mapper.MotorMapper;
import org.family.mapper.UserMapper;
import org.family.pojo.MotorKey;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringFamilyMybatisApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private MotorMapper motorMapper;

	@Test
	public void contextLoads() {
		System.out.println(userMapper.selectByPrimaryKey(21));
		MotorKey motorKey = new MotorKey();
		motorKey.setId(1);
		System.out.println(motorMapper.selectByPrimaryKey(motorKey));
	}

}
