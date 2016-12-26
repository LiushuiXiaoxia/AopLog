package cn.mycommons.aoplog;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * LogAspect <br/>
 * Created by xiaqiulei on 2016-12-19.
 */
@Aspect
public class LogAspect {

    private static final String TAG = "LOG";

    private static final String POINTCUT_CONSTRUCTOR = "execution(@cn.mycommons.aoplog.LogTraceMethod *.new(..))";
    private static final String POINTCUT_METHOD = "execution(@cn.mycommons.aoplog.LogTraceMethod * *(..))";

    @Pointcut(POINTCUT_METHOD)
    public void methodAnnotatedWithDebugTrace() {
    }

    @Pointcut(POINTCUT_CONSTRUCTOR)
    public void constructorAnnotatedDebugTrace() {
    }

    @Around("methodAnnotatedWithDebugTrace() || constructorAnnotatedDebugTrace()")
    public Object weaveJoinPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        LogTraceMethod logTraceMethod = methodSignature.getMethod().getAnnotation(LogTraceMethod.class);
        if (logTraceMethod != null && logTraceMethod.simple()) {
            return new ProcessSimpleImpl().process(joinPoint);
        }
        return new ProcessAdvancedImpl().process(joinPoint);
    }
}