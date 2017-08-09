package org.family.test;

import org.family.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @Author 王洪悦.{javayue@yeah.net}
 * @Create 2017-07-27 下午2:29
 */
public interface TestPORepository extends JpaRepository<TestPO, Long>{

    TestPO findByName(String name);

    TestPO findByNameAndAge(String name, Integer age);

//    @Query("from testpo u where u.name=:name")
//    TestPO findTestPO(@Param("name") String name);
}
