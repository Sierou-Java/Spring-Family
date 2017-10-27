package org.family.config;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * Spring通过任务执行器(TaskExecutor)来实现多线程和并发编程
 *
 * @author 王洪悦.{javayue@yeah.net}
 * @create 2017-10-27 下午11:44
 */
@Configuration
// 利用@EnableAsync注解开启异步任务支持。
@EnableAsync
public class TaskExecutorConfig implements AsyncConfigurer{

    /**
     * 配置类实现AsyncConfigurer接口并重写getAsyncExecutor方法，
     * 并返回ThreadPoolTaskExecutor ，这样就获得了一个基于线程池的TaskExecutor。
     * @return
     */
    @Override
    public Executor getAsyncExecutor() {//②
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(5);
        taskExecutor.setMaxPoolSize(10);
        taskExecutor.setQueueCapacity(25);
        taskExecutor.initialize();
        return taskExecutor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }
}
