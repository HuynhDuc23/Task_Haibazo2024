package vn.com.Haibazo.com.aop;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class LoggingAspect {
    @Before("execution(* vn.com.Haibazo.com.controller.*.*(..))")
    public void logBeforeExecutionMethod(JoinPoint joinPoint) {
        System.out.println("Calling method start: " + joinPoint.getSignature().getName());
    }
    @After("execution(* vn.com.Haibazo.com.service.services.*.*(..))")
    public void logAfterExecutionMethod(JoinPoint joinPoint) {
        System.out.println("Calling method end: " + joinPoint.getSignature().getName());
    }
}
