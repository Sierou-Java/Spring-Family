package org.family;

import org.family.serialized.Serializeds;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class SpringFamilyKyroApplicationTests {

//	@Test
//	public void contextLoads() {
//		String name = "123123";
//
//		try {
//			Serializeds serializeds = new Serializeds();
//			String s = serializeds.toString(name);
//			System.out.println(s);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

	public static void main(String[] args) {
		String name = "123123";

		try {
			Serializeds serializeds = new Serializeds();
			String s = serializeds.toSerialized(name);
			System.out.println(s);

			String s1 = serializeds.toSerialized(s);
			System.out.println("s1 = " + s1);
			Object o = serializeds.toObject(s1);
			System.out.println("o = " + o.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
