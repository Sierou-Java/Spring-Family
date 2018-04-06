package org.sierou;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sierou.redis.RedisLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringFamilyRedisApplicationTests {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public static int test = 10;
    @Test
    public void contextLoads() {
        RedisLock redisLock = new RedisLock(redisTemplate, 1000);

            for(int j = 0; j < 20; j++){
                new Thread(() -> {
                    try {
                        if (-1 != redisLock.lock("sierou", Thread.currentThread().getName())){
                            test += 100;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                   redisLock.unlock("sierou", Long.valueOf(redisTemplate.boundValueOps("sierou").get().toString()), Thread.currentThread().getName());
                }
                ).start();
            }

        try {
            Thread.sleep(10000);
            System.out.println("test = " + test);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
