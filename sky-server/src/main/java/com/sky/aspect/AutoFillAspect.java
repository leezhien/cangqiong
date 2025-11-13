package com.sky.aspect;

import com.sky.annotation.AutoFill;
import com.sky.context.BaseContext;
import com.sky.entity.User;
import com.sky.enumeration.OperationType;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;

/**
 * @program: sky-take-out
 * @description:
 * @author: hechunrong
 * @create: 2025-11-13 11:51
 **/
@Aspect
@Component
@Slf4j
public class AutoFillAspect {
    /**
     * 切入点
     */
    @Pointcut("execution(* com.sky.mapper.*.*(..)) && @annotation(com.sky.annotation.AutoFill)")
    public void  autoFillPointCut(){
    }

    @Before("autoFillPointCut()")
    public void before(JoinPoint joinPoint) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        log.info("开始公共字段填充");
        //1、获取注解上被拦截操作数据库类型
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();//方法签名对象
        AutoFill annotation = signature.getMethod().getAnnotation(AutoFill.class);
        OperationType type = annotation.value();
        //2、获取被拦截的方法的参数、实体对象
        Object[] args = joinPoint.getArgs();
        if (args == null || args.length == 0){
            return;
        }
        Object arg = args[0];
        //3、准备赋值数据
        LocalDateTime now = LocalDateTime.now();
        Long currentId = BaseContext.getCurrentId();
        //4、根据不同的操作类型为对应的属性通过反射赋值
        if (type == OperationType.INSERT){
            //四个字段
            Method setCreatTime = arg.getClass().getDeclaredMethod("setCreateTime", LocalDateTime.class);
            Method setCreateUser = arg.getClass().getDeclaredMethod("setCreateUser", Long.class);
            Method setUpdateTime = arg.getClass().getDeclaredMethod("setUpdateTime", LocalDateTime.class);
            Method setUpdateUser = arg.getClass().getDeclaredMethod("setUpdateUser", Long.class);
            setCreatTime.invoke(arg, now);
            setCreateUser.invoke(arg, currentId);
            setUpdateTime.invoke(arg, now);
            setUpdateUser.invoke(arg, currentId);
        } else if (type == OperationType.UPDATE) {
            Method setUpdateTime = arg.getClass().getDeclaredMethod("setUpdateTime", LocalDateTime.class);
            Method setUpdateUser = arg.getClass().getDeclaredMethod("setUpdateUser", Long.class);
            setUpdateTime.invoke(arg, now);
            setUpdateUser.invoke(arg, currentId);
        }
    }

}
