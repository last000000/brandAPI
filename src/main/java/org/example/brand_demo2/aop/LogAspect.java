package org.example.brand_demo2.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LogAspect {
    @Around("execution(* org.example.brand_demo2.service.BrandServiceImpl.*(..))")
    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable{
        Object[] args = joinPoint.getArgs();
        log.info("开始执行方法：{}",joinPoint.getSignature().getName()+"参数为: {}",args.toString());
        Object result = joinPoint.proceed();
        log.info("执行方法结束，结果为：{}",result);
        return result;
    }
}
