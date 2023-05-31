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
import org.springdoc.core.properties.SpringDocConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * Logging aspect class
 * This class is used to log all the incoming requests and outgoing responses
 * This class is also used to log all the exceptions
 */
@Aspect
@Component
public class LoggingAspect {

    // Logger instance
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Autowired
    private SpringDocConfigProperties springDocConfigProperties;

    @Value("${spring.datasource.url}")
    private String databaseUrl;

    /**
     * Method to log the application startup details.
     * This method is executed before the SpringApplication.run() method is invoked.
     * It logs the Swagger URL and the database URL.
     */
    @Before("execution(* org.springframework.boot.SpringApplication.run(..))")
    @EventListener(ApplicationReadyEvent.class)
    public void logApplicationStartup() {

        // Log Swagger URL
        String swaggerUrl = getSwaggerUrl();
        logger.info("Swagger URL: {}", swaggerUrl);

        // Log database URL
        logger.info("Database URL: {}", databaseUrl);
    }

    /**
     * Method to log after returning from a method
     * @param {JoinPoint} joinPoint - JoinPoint instance
     * @param {Object} result - Result object
     */
    @AfterReturning(pointcut = "execution(* com.sample.boilerplate.controllers.*.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        HttpServletRequest request = getRequest();
        HttpServletResponse response = getResponse();

        String url = request.getRequestURL().toString();
        String httpMethod = request.getMethod();
        
        String methodName = joinPoint.getSignature().getName();

        int status = response.getStatus();

        logger.info("Response: {}", result);
        logger.info("Exiting method: {}. URL: {}. HTTP Method: {}. Status Code: {}", methodName, url, httpMethod, status);
    }

    /**
     * Method to log after throwing an exception from a method
     * @param {JoinPoint} joinPoint - JoinPoint instance
     * @param {Throwable} exception - Exception object
     */
    @AfterThrowing(pointcut = "execution(*  com.sample.boilerplate.controllers.*.*(..))", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable exception) {
        HttpServletRequest request = getRequest();

        String url = request.getRequestURL().toString();
        String httpMethod = request.getMethod();
        String methodName = joinPoint.getSignature().getName();

        logger.error("Exception in method: {}. URL: {}. HTTP Method: {}. Exception: {}", methodName, url, httpMethod, exception.getMessage());
    }

    /**
     * Method to get the Swagger URL
     * @return {String} - Swagger URL
     */
    private String getSwaggerUrl() {
        String swaggerUrl = springDocConfigProperties.getApiDocs().getPath();
        return swaggerUrl;
    }

    /**
     * Method to get the request object
     * @return {HttpServletRequest} - HttpServletRequest instance
     */
    private HttpServletRequest getRequest() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (requestAttributes != null) {
            return requestAttributes.getRequest();
        }
        return null;
    }

    /**
     * Method to get the response object
     * @return {HttpServletResponse} - HttpServletResponse instance
     */
    private HttpServletResponse getResponse() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (requestAttributes != null) {
            return requestAttributes.getResponse();
        }
        return null;
    }

}