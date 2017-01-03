package cn.mycommons.aoplog.library;

import java.lang.annotation.Annotation;

/**
 * LogTraceEntry <br/>
 * Created by xiaqiulei on 2016-12-28.
 */
public class LogTraceEntry {

    private Class<? extends Annotation> annotationClass;

    // obj
    Object object;
    String methodName;
    String[] parameterNames;
    Object[] args;
    Class declaringType;

    // source
    String fileName;
    int lineNum;

    // runtime
    long beginTime;
    long endTime;
    long totalTime;
    Object result;
    Throwable throwable;

    LogTraceEntry(Class<? extends Annotation> annotationClass) {
        this.annotationClass = annotationClass;
    }

    public Class<? extends Annotation> getAnnotationClass() {
        return annotationClass;
    }

    public Object getObject() {
        return object;
    }

    public String getMethodName() {
        return methodName;
    }

    public String[] getParameterNames() {
        return parameterNames;
    }

    public Object[] getArgs() {
        return args;
    }

    public Class getDeclaringType() {
        return declaringType;
    }

    public String getFileName() {
        return fileName;
    }

    public int getLineNum() {
        return lineNum;
    }

    public long getBeginTime() {
        return beginTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public long getTotalTime() {
        return totalTime;
    }

    public Object getResult() {
        return result;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public String getLogTraceMessage() {
        StringBuilder str = new StringBuilder();
        str.append(object == null ? (declaringType != null ? declaringType.getName() : null) : object)
                .append("--->")
                .append(declaringType != null ? declaringType.getSimpleName() + "." : "")
                .append(methodName)
                .append("()\n");

        for (int i = 0; i < parameterNames.length; i++) {
            str.append(parameterNames[i]).append(" = ").append(args[i]).append("\n");
        }

        if (throwable != null) {
            str.append("throw ")
                    .append(throwable.getClass().getSimpleName())
                    .append("(")
                    .append(throwable.getMessage())
                    .append(")");

        } else {
            str.append("return = ").append(result);
        }
        str.append("\n").append("totalTime = ").append(totalTime);

        return str.toString();
    }
}