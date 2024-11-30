package org.example.brand_demo2.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import org.springframework.stereotype.Component;
//@Slf4j
//@Component

public class TimeAspect {
//    @Around("execution(* org.example.brand_demo2.service.BrandServiceImpl.*(..))")
//    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {
//        long begin = System.currentTimeMillis();
//
//        Object result = joinPoint.proceed();
//
//        long end = System.currentTimeMillis();
//
//        System.out.println("耗时："+(end-begin)+"ms");
//
//        return result;
//    }
}
