package com.sample.boilerplate.configs;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.sample.boilerplate.controllers.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        HttpServletRequest request = getRequest();
        String url = request.getRequestURL().toString();
        String httpMethod = request.getMethod();

        String methodName = joinPoint.getSignature().getName();
        logger.info("Request: {}", request);
        logger.info("Entering method: {}. URL: {}. HTTP Method: {}", methodName, url, httpMethod);
    }

    @AfterReturning(pointcut = "execution(* com.sample.boilerplate.controllers.*.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        HttpServletRequest request = getRequest();
        String url = request.getRequestURL().toString();
        String httpMethod = request.getMethod();
        int statusCode = getStatusCode();
        String methodName = joinPoint.getSignature().getName();
        logger.info("Exiting method: {}. URL: {}. HTTP Method: {}. Status Code: {}", methodName, url, httpMethod, statusCode);
    }

    @AfterThrowing(pointcut = "execution(*  com.sample.boilerplate.controllers.*.*(..))", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable exception) {
        HttpServletRequest request = getRequest();
        String url = request.getRequestURL().toString();
        String httpMethod = request.getMethod();
        String methodName = joinPoint.getSignature().getName();
        logger.error("Exception in method: {}. URL: {}. HTTP Method: {}. Exception: {} ", methodName, url, httpMethod, exception.getMessage());
    }

    private HttpServletRequest getRequest() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (requestAttributes != null) {
            return requestAttributes.getRequest();
        }
        return null;
    }

    private int getStatusCode() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (requestAttributes != null) {
            HttpServletResponse response = requestAttributes.getResponse();
            if (response != null) {
                return response.getStatus();
            }
        }
        return -1;
    }

}