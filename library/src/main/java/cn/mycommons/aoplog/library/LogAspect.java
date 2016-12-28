package cn.mycommons.aoplog.library;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * LogAspect <br/>
 * Created by xiaqiulei on 2016-12-19.
 */
@Aspect
public class LogAspect {

    private static final String POINTCUT_CONSTRUCTOR = "execution(@cn.mycommons.aoplog.library.LogTraceMethod *.new(..))";
    private static final String POINTCUT_METHOD = "execution(@cn.mycommons.aoplog.library.LogTraceMethod * *(..))";

    @Pointcut(POINTCUT_CONSTRUCTOR)
    public void pointcutConstructor() {
    }

    @Pointcut(POINTCUT_METHOD)
    public void pointcutMethod() {
    }

    @Around("pointcutConstructor() || pointcutMethod()")
    public Object normal(ProceedingJoinPoint joinPoint) throws Throwable {
        if (joinPoint != null) {
            if (AopLog.isEnable()) {
                return new ProcessImpl(LogTraceMethod.class).process(joinPoint);
            }
            return joinPoint.proceed();
        }
        return null;
    }
}