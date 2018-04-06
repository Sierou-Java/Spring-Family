package org.family;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ResourceBanner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ResourceBundle;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringFamilyMybatisAutomaticApplicationTests {


	@Test
	public void contextLoads() {
		ResourceBundle resourceBundle = ResourceBundle.getBundle("application");
		String string = resourceBundle.getString("server.port");
		System.out.println(string);
	}

}
