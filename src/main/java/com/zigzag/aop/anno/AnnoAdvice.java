package com.zigzag.aop.anno;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author qlk
 */
@Component
@Aspect
public class AnnoAdvice {

    // 抽取切面表达式
    @Pointcut("execution(public void com.zigzag.aop.anno.TargetImpl.*(..))")
    public void pointCut() {

    }

    @Around("execution(public void com.zigzag.aop.anno.TargetImpl.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕前");
        Object proceed = joinPoint.proceed();
        System.out.println("环绕后");
        return proceed;
    }

    @Before("pointCut()")
    public void before() {
        System.out.println("前置");
    }

    @AfterReturning(value = "execution(public String com.zigzag.aop.anno.TargetImpl.*(..))", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("连接点方法为：" + methodName + ",参数为：" + args + ",目标方法执行结果为：" + result);
    }

    @AfterThrowing(value = "execution(public void com.zigzag.aop.anno.TargetImpl.*(..))", throwing = "th")
    public void throwing(JoinPoint joinPoint, Throwable th) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println(methodName + " throw ex: " + th.getMessage());
    }
}
