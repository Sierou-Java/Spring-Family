package org.sierou.aop.spring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * @Author 王洪悦.{javayue@yeah.net}
 * @Create 2017-08-13 下午9:20
 */
@Component
@Aspect
public class AspectAnno {

    @Pointcut("@annotation(org.sierou.aop.spring.ControLog)")
    public void pointCut(){};

    @Before(value = "pointCut()")
    public void Before(){
        System.out.println("AspectAnno.Before");
        System.out.println("before aop ........");
    }

    // ProceedingJoinPoint is only supported for around advice
//    @Around(value = "pointCut()")
//    public void Around(ProceedingJoinPoint proceedingJoinPoint){
//
//    }
    @After(value = "pointCut()")
    public void after(){
        System.out.println("AspectAnno.after");
        System.out.println("after aop .........");

    }
//    @AfterReturning(value = "pointCut()")
//    public void afterReturning(ProceedingJoinPoint proceedingJoinPoint){
//
//    }
}
