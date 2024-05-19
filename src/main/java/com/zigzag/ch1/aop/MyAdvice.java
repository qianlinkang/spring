package com.zigzag.ch1.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Arrays;

/**
 * 通知/增强类 advice
 * @author qlk
 */
public class MyAdvice {

    public void beforeAdvice() {
        System.out.println("beforeAdvice...");
    }

    public void afterAdvice() {
        System.out.println("afterAdvice...");
    }

    /**
     * 环绕
     */
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕前通知");

        System.out.println(Arrays.toString(joinPoint.getArgs()));//获得目标方法的参数
        System.out.println(joinPoint.getTarget());//获得目标对象
        System.out.println(joinPoint.getStaticPart());//获得精确的切点表达式信息

        joinPoint.proceed();
        System.out.println("环绕后通知");
    }

    /**
     * 异常通知
     */
    public void afterThrowing(JoinPoint joinPoint, Throwable th) {
        System.out.println("目标方法异常");
    }

    /**
     * 最终执行
     */
    public void after() {
        System.out.println("都会执行");
    }
}
