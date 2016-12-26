package cn.mycommons.aoplog;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * ProcessAdvancedImpl <br/>
 * Created by xiaqiulei on 2016-12-19.
 */
class ProcessAdvancedImpl implements IProcess {

    @Override
    public Object process(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        StringBuilder paramStr = new StringBuilder();
        String[] parameterNames = methodSignature.getParameterNames();
        Class[] parameterTypes = methodSignature.getParameterTypes();
        Object[] args = joinPoint.getArgs();

        paramStr.append(joinPoint.getSourceLocation())
                .append("\n")
                .append(methodSignature.getReturnType().getSimpleName())
                .append(" ")
                .append(methodSignature.getDeclaringTypeName())
                .append(".")
                .append(methodSignature.getName())
                .append("(\n");
        for (int i = 0; i < parameterNames.length; i++) {
            paramStr.append(parameterTypes[i].getSimpleName())
                    .append(" ")
                    .append(parameterNames[i])
                    .append(" = ")
                    .append(args[i]);
            if (i != parameterNames.length - 1) {
                paramStr.append(",");
            }
            paramStr.append("\n");
        }
        paramStr.append(")\n");


        final Watch watch = new Watch();
        watch.start();
        try {
            Object obj = joinPoint.proceed();
            watch.stop();
            paramStr.append("return = ").append(obj);
            return obj;
        } catch (Exception e) {
            watch.stop();
            paramStr.append("throw ")
                    .append(e.getClass().getSimpleName())
                    .append("(")
                    .append(e.getMessage())
                    .append(")");
            throw e;
        } finally {
            paramStr.append("\ntime = ")
                    .append(watch.getTotalTime());

            AopLog.getLogCallback().log(LogTraceMethod.class, paramStr.toString());
        }
    }
}
