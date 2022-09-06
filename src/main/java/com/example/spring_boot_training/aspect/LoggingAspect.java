package com.example.spring_boot_training.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect
@Component
@Slf4j
public class LoggingAspect {



    /** Ausführungsprüfung auf die Methoden innerhalb vom ToDoController **/
//    @Around("execution(* com.example.spring_boot_training.controller.ToDoController.*(..))")

    @Around("bean(*Controller) || within(com.example.spring_boot_training.service..*) ||  bean(*Repository)")
    public Object profileAllMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
    {
        long start = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();

        long differenz = end - start;

        //Get intercepted method details
        String className =  proceedingJoinPoint.getSignature().getDeclaringType().getSimpleName();
        String methodName = proceedingJoinPoint.getSignature().getName();

        log.info(String.format("The Controller %s with the method %s took %d miliseconds",className, methodName, differenz));

        return result;
    }
}

