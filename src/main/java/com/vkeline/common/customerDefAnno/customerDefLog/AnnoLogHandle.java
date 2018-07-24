package com.vkeline.common.customerDefAnno.customerDefLog;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.UUID;

@Component
@Aspect
@EnableAsync
public class AnnoLogHandle {
    private static final Logger logger = LoggerFactory.getLogger(AnnoLogHandle.class);


    /**
     * 织入点
     */
    @Pointcut("@annotation(com.vkeline.common.customerDefAnno.customerDefLog.CustomerDefAnnoLog)")
    public void logPointCut(){

    }

    /**
     * 拦截操作
     * @param joinPoint
     */
    @AfterReturning(pointcut = "logPointCut()")
    public void handleOperation(JoinPoint joinPoint){
        logHandle(joinPoint, null);
    }

    /**
     * 拦截异常
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(pointcut = "logPointCut()",throwing = "e")
    public void handleException(JoinPoint joinPoint, Exception e){
        logHandle(joinPoint, e);
    }

    /**
     * 处理类
     */
    @Async
    public void logHandle(JoinPoint joinPoint, Exception e){
        CustomerDefAnnoLog custDefAnnoLog = getCustDefAnnoLog(joinPoint);
        //如果不存在注解就终止
        if(getCustDefAnnoLog(joinPoint) == null){
            return;
        }

        if(e == null){
            OperationLogEntity operationLogEntity = new OperationLogEntity();
            //id
            operationLogEntity.setId(UUID.randomUUID().toString());
            //获取当前用户

            //获取当前时间
            operationLogEntity.setCurrentDate(new Date());
            //获取当前登录ip

            //获取当前注解着的方法
            String className = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();
            operationLogEntity.setMethodName(className+"."+methodName+"()");

            //获得参数列表

            //获取路径

            //获取注解上的内容
            operationLogEntity.setOperationName(custDefAnnoLog.operation());
            operationLogEntity.setMethodName(custDefAnnoLog.module());
            operationLogEntity.setDescription(custDefAnnoLog.description());

        }else{
            ExceptionLogEntity exceptionLogEntity = new ExceptionLogEntity();
            //TODO:将公共字段同样放入此实体中

            StringBuilder sbr = new StringBuilder(e.getMessage());
            sbr.substring(0,2000);
            exceptionLogEntity.setExceptionDetail(sbr.toString());
        }
    }


    /**
     * 获取切点上的注解
     */
    public CustomerDefAnnoLog getCustDefAnnoLog(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();

        if(method != null){
            return method.getAnnotation(CustomerDefAnnoLog.class);
        }
        return null;
    }

}
