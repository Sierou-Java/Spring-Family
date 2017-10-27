package org.family;

import org.family.config.service.AsyncTaskService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringFamilyAsyncApplicationTests {

    @Autowired
    private AsyncTaskService asyncTaskService;

    @Test
    public void contextLoads() {

        for (int i = 0; i < 10; i++) {
            asyncTaskService.executeAsyncTask();
            asyncTaskService.executeAsyncTask(1);
        }

    }

}
