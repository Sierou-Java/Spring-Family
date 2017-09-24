package org.sierou.aop.Aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.family.core.ServiceException;
import org.family.result.Result;
import org.family.result.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * ${DESCRIPTION}
 * @Author 王洪悦.{javayue@yeah.net}
 * @Create 2017-08-29 下午4:48
 **/
@Aspect
@Component
public class ResultAspect {

    private static final Logger logger = LoggerFactory.getLogger(ResultAspect.class);

    // 定义切点
    @Pointcut("@annotation(org.sierou.aop.annotation.ControResult)")
    // "execution(* com.sierou.repository..*(..)) && @annotation(xxx)"
    private void pointCut(){};


    @Around("pointCut()")
    public Result around(ProceedingJoinPoint joinPoint){
        System.out.println("ResultAspect.around");
        long startTime = System.currentTimeMillis();
        Result<?> result;
        try {
            result = (Result<?>) joinPoint.proceed();
//            logger.info(joinPoint.getSignature() + "use time:" + (System.currentTimeMillis() - startTime));
            System.out.println(joinPoint.getSignature() + "use time:" + (System.currentTimeMillis() - startTime));
        } catch (Throwable e) {
            result = handlerException(joinPoint, e);
        }
        return result;
    }


    private Result<?> handlerException(ProceedingJoinPoint pjp, Throwable e) {
        Result<?> result = new Result();
        // 已知异常
        if (e instanceof ServiceException) {
            result.setMessage(e.getLocalizedMessage());
            result.setCode(ResultCode.FAIL);
        } else {
            System.out.println(pjp.getSignature() + " error : " + e);
//            logger.error(pjp.getSignature() + " error ", e);
            result.setMessage(e.toString());
            result.setCode(ResultCode.FAIL);
            // 未知异常是应该重点关注的，这里可以做其他操作，如通知邮件，单独写到某个文件等等。
        }
        return result;
    }
}
