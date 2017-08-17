package org.sierou.aop.Aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Aspect
 *
 * @Author 王洪悦.{javayue@yeah.net}
 * @Create 2017-08-12 下午6:01
 */
@Component
@Aspect
public class LogAspect {

    private Logger logger = LoggerFactory.getLogger(LogAspect.class);

    // 定义切点
    @Pointcut("@annotation(org.sierou.aop.annotation.ControLog)")
    // "execution(* com.sierou.service..*(..)) && @annotation(xxx)"
    private void pointCut(){};

    // 环绕通知
    @Around("pointCut()")
    public void Around(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println("before .......");
        logger.info("logger before .......");
        try{
            proceedingJoinPoint.proceed();
        }catch (Throwable e){
            e.printStackTrace();
        }

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容  ----  before
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + proceedingJoinPoint.getSignature().getDeclaringTypeName() + "." + proceedingJoinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(proceedingJoinPoint.getArgs()));


        System.out.println("end .......");
        logger.info("logger  end ....");
        logger.error("error logger .......................................");
    }

}
