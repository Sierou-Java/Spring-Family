package org.family;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class SpringFamilyJpaApplicationTests {

	@Test
	public void contextLoads() {
	}


	public static void main(String[] args) {
		TreeMap<String, String> treeMap = new TreeMap<>();

		treeMap.put("s", "svalye");
		treeMap.put("a", "asda");
		treeMap.put("z", "sad");
		treeMap.put("b", "s");

		Set<Map.Entry<String, String>> entries = treeMap.entrySet();
		for (Map.Entry<String, String> entry : entries) {
			System.out.println(entry.getKey());
		}
	}

}
