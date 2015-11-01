/*
 * 版权所有 (c) 2015 。 李倍存 （iPso）。
 * 所有者对该文件所包含的代码的正确性、执行效率等任何方面不作任何保证。
 * 所有个人和组织均可不受约束地将该文件所包含的代码用于非商业用途。若需要将其用于商业软件的开发，请首先联系所有者以取得许可。
 */

package org.ipso.lbc.common.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;
import org.ipso.lbc.common.exception.handler.ExceptionHandler;
import org.ipso.lbc.common.exception.handler.ExceptionMailer;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 李倍存 创建于 2015-04-12 14:19。电邮 1174751315@qq.com。
 */

@Aspect
public class AopTraceMethodsAndThrows implements MethodBeforeAdvice, AfterReturningAdvice, ThrowsAdvice {

    private static Logger methodTracingLogger = Logging.instance().createLogger("【调用跟踪】【返回】");
    private static Logger methodenterTracingLogger = Logging.instance().createLogger("【调用跟踪】【进入】");

    private static Logger busExceptionLogger = Logging.instance().createLogger("【业务异常】");
    private static Logger extExceptionLogger = Logging.instance().createLogger("【系统异常】");
    private static Logger daeExceptionLogger = Logging.instance().createLogger("【数据访问异常】");

    private static ExceptionMailer exceptionMailer = new ExceptionMailer(new ExceptionHandler());

    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        String paras = "";
        for (int i = 0; i < objects.length; i++) {
            paras += objects[i].hashCode() + "\n";
        }
        String text = o1.getClass().getName() + "." + method.getName() + "参数" + paras + "\n返回  " + o + "\n";
        text+=new SimpleDateFormat("HH:mm:ss.SSS").format(new Date());
        methodTracingLogger.debug(text);
    }

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        methodenterTracingLogger.debug("进入  " + o.getClass().getName() + "." + method.getName()+"\n"+new SimpleDateFormat("HH:mm:ss.SSS").format(new Date()));

    }

    public void afterThrowing(Method m, Object[] os, Object target, Throwable throwable) {
        String text = "";
        StackTraceElement[] elements = throwable.getStackTrace();
        text += target.hashCode() + "  调用  " + m.getName() + "  时发生异常  " + throwable.getClass().getSimpleName() + "\n";

        Logger logger = null;
        String exType = throwable.getClass().getSimpleName();

        if (exType.equals("LPE")) {
            logger = busExceptionLogger;
            exceptionMailer.handle(throwable);
        } else if (exType.equals("DAE")) {
            logger = daeExceptionLogger;
        } else {
            text += "类型：" + exType + "\n";
            logger = extExceptionLogger;
        }

        text += throwable.getMessage() + "\n";
        text += "起因：" + throwable.getCause() + "\n";
        text += "栈追踪\n";
        for (int e = 0; e < elements.length; e++) {
            text += elements[e].toString() + "\n";
        }

        logger.error(text);
    }


}
