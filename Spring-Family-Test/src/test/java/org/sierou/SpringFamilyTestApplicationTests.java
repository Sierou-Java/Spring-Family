package org.sierou;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class SpringFamilyTestApplicationTests {

//	@Test
	public void contextLoads() {
	}

	public static void main(String[] args) {
		try {
			new SpringFamilyTestApplicationTests().wait();
			Thread.interrupted();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	class hello{
		public void haha(){
			System.out.println("hello world!");
		}
	}

	public void hi(){
		System.out.println("SpringFamilyTestApplicationTests.hi");
	}
}
