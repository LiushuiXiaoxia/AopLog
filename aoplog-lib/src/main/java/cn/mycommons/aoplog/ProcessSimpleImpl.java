package cn.mycommons.aoplog;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * SimpleProcess <br/>
 * Created by xiaqiulei on 2016-12-19.
 */
class ProcessSimpleImpl implements IProcess {

    @Override
    public Object process(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        StringBuilder paramStr = new StringBuilder();
        String[] parameterNames = methodSignature.getParameterNames();
        Object[] args = joinPoint.getArgs();

        paramStr.append(joinPoint.getThis())
                .append("--->")
                .append(methodSignature.getDeclaringType().getSimpleName())
                .append(".")
                .append(methodSignature.getName())
                .append("()\n");

        for (int i = 0; i < parameterNames.length; i++) {
            paramStr.append(parameterNames[i])
                    .append(" = ")
                    .append(args[i])
                    .append("\n");
        }

        AopLog.getLogCallback().log(LogTraceMethod.class, paramStr.toString());

        return joinPoint.proceed();
    }
}