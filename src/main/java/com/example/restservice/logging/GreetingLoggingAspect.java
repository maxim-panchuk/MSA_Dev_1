package com.example.restservice.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class GreetingLoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(GreetingLoggingAspect.class);

    @Before("execution(* com.example.restservice.controller.GreetingController.greeting(..))")
    public void logBeforeGreeting(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        logger.info("Call greeting() with args: {}", Arrays.toString(args));
    }

    @AfterReturning(value = "execution(* com.example.restservice.controller.GreetingController.greeting(..))", returning = "result")
    public void logAfterGreeting(JoinPoint joinPoint, Object result) {
        logger.info("greeting() returned: {}", result);
    }

}
