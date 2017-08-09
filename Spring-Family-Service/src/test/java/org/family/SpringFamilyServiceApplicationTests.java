package org.family;

import org.family.test.TestPO;
import org.family.test.TestPORepository;
import org.family.user.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringFamilyServiceApplicationTests {

//	@Autowired
//	private UserRepository userService;

	@Autowired
	private TestPORepository testPORepository;

	@Test
	public void contextLoads() {
		testPORepository.save(new TestPO("AAA", 10));
		testPORepository.save(new TestPO("BBB", 10));
		testPORepository.save(new TestPO("CCC", 10));
		testPORepository.save(new TestPO("DDD", 40));

		List<TestPO> all = testPORepository.findAll();
		for (TestPO testPO : all) {
			System.out.println(testPO);
		}

	}

	@Test
	public void test(){
//		userService.save(new User("AAA", 10));
//		userService.save(new User("BBB", 20));
//		userService.save(new User("CCC", 30));
//		userService.save(new User("DDD", 40));
//		userService.save(new User("EEE", 50));
//		userService.save(new User("FFF", 60));
//		userService.save(new User("GGG", 70));
//		userService.save(new User("HHH", 80));
//		userService.save(new User("III", 90));
//		userService.save(new User("JJJ", 100));
//
//		// 测试findAll, 查询所有记录
//		Assert.assertEquals(10, userService.findAll().size());
//
//		// 测试findByName, 查询姓名为FFF的User
//		Assert.assertEquals(60, userService.findByName("FFF").getAge().longValue());
//
//		// 测试findUser, 查询姓名为FFF的User
//		Assert.assertEquals(60, userService.findUser("FFF").getAge().longValue());
//
//		// 测试findByNameAndAge, 查询姓名为FFF并且年龄为60的User
//		Assert.assertEquals("FFF", userService.findByNameAndAge("FFF", 60).getName());
//
//		// 测试删除姓名为AAA的User
//		userService.delete(userService.findByName("AAA"));
//
//		// 测试findAll, 查询所有记录, 验证上面的删除是否成功
//		Assert.assertEquals(9, userService.findAll().size());

		
	}
}
