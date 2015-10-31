/*
 * 版权所有 (c) 2015 。 李倍存 （iPso）。
 * 所有者对该文件所包含的代码的正确性、执行效率等任何方面不作任何保证。
 * 所有个人和组织均可不受约束地将该文件所包含的代码用于非商业用途。若需要将其用于商业软件的开发，请首先联系所有者以取得许可。
 */

package org.ipso.lbc.common.command;

import org.apache.log4j.Logger;
import org.ipso.lbc.common.aop.Logging;
import org.ipso.lbc.common.exception.handler.ExceptionInfoPrintingHelper;

/**
 * 信息：李倍存 创建于 2015/7/8 12:01。电邮 1174751315@qq.com。<br>
 * 说明：
 */
public class CommandWithRetries extends BasicCommand {
    public CommandWithRetries(IReceiver receiver, Integer retryCount, String taskStr) {
        super(receiver);
        this.retryCount = retryCount;
        this.taskStr = taskStr;
    }

    private Integer retryCount;
    private String taskStr;

    @Override
    public Object exec(Object params) {
        Integer failTimes = 0;
        Object o = null;

        do {

            Exception failException = null ;

            String s=failTimes==0?"Try to ":failTimes+"th retry to ";
            Logger log = Logging.instance().createLogger(s+taskStr);

            start(log);

            try {
                o = once(receiver,params);
            } catch (Exception e) {
                failException = e;
            }

            if (failException != null) {
                failTimes++;
                failed(log, ExceptionInfoPrintingHelper.getStackTraceInfo(failException));
            }else if(failed()){
                failTimes++;
                failed(log, reason());
            } else {
                success(log);
                break;
            }

        }while (failTimes <= retryCount);

        return o;

    }
    private void start(Logger logger){
        logger.info("Started.");
    }
    private void success(Logger logger){
        logger.info("Completed.");
    }
    private void failed(Logger logger,Object reason){
        String t = "ERROR occurs when executing the task.";
        logger.info(t);
        logger.error(t +"\n"+ reason);
    }




    protected Boolean failed(){
        return false;
    }
    protected Object reason(){
        return "缺少详情。";
    }
    protected Object once(IReceiver receiver,Object params){
        return receiver.action(params);
    }




}
