/*
 * 版权所有 (c) 2015 。 李倍存 （iPso）。
 * 所有者对该文件所包含的代码的正确性、执行效率等任何方面不作任何保证。
 * 所有个人和组织均可不受约束地将该文件所包含的代码用于非商业用途。若需要将其用于商业软件的开发，请首先联系所有者以取得许可。
 */

package org.ipso.lbc.common.exception.handler;

import org.apache.log4j.Logger;

/**
 * Created by LBC on 2015-04-05.
 */
public class ExceptionLogger extends ExceptionHandlerDecorator {
    private Logger logger;
    private String msgPrefix;

    public ExceptionLogger(ExceptionHandler handler, Logger logger, String msgPrefix) {
        super(handler);
        this.logger = logger;
        this.msgPrefix = msgPrefix;
    }

    public ExceptionLogger(ExceptionHandler handler, String msgPrefix) {
        this(handler, org.ipso.lbc.common.aop.Logging.instance().createLogger(), msgPrefix);
    }

    public ExceptionLogger(ExceptionHandler handler) {
        this(handler, org.ipso.lbc.common.aop.Logging.instance().createLogger(), "【未指定异常提示】]");
    }

    @Override
    public void handle(Throwable e) {
        String info = "";
        info += msgPrefix + "\n" + e.getMessage() + "\n";
        info+=ExceptionInfoPrintingHelper.getStackTraceInfo(e);
        logger.error(info);
        logger.info(msgPrefix + "\n");
        super.handle(e);
    }
}
