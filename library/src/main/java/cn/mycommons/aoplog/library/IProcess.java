package cn.mycommons.aoplog.library;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * IProcess <br/>
 * Created by xiaqiulei on 2016-12-19.
 */
interface IProcess {

    Object process(ProceedingJoinPoint joinPoint) throws Throwable;
}