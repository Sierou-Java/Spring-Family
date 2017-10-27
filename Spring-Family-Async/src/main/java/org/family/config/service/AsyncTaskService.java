package org.family.config.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 通过@Async注解表明该方法是个异步方法，如果注解在类级别，
 * 则表明该类所有的方法都是异步方法，而这里的方法自动被注入使用ThreadPoolTaskExecutor作为TaskExecutor。
 *
 * @Author 王洪悦.{javayue@yeah.net}
 * @Create 2017-10-27 下午11:47
 */
@Service
public class AsyncTaskService {

    @Async
    public void executeAsyncTask() {
        System.out.println("AsyncTaskService.executeAsyncTask");
    }

    @Async
    public void executeAsyncTask(int temp) {
        System.out.println("temp = " + (temp + 1));
    }
}
