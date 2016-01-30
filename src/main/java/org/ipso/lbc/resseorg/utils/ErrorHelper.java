/*
 * 版权所有 (c) 2015 。 李倍存 （iPso）。
 * 所有者对该文件所包含的代码的正确性、执行效率等任何方面不作任何保证。
 * 所有个人和组织均可不受约束地将该文件所包含的代码用于非商业用途。若需要将其用于商业软件的开发，请首先联系所有者以取得许可。
 */

package org.ipso.lbc.resseorg.utils;

import org.ipso.lbc.common.action.CommonAjaxAction;
import org.ipso.lbc.common.aop.Logging;
import org.ipso.lbc.common.exception.handler.ExceptionInfoPrintingHelper;

/**
 * 信息：李倍存 创建于 2015/11/23 11:29。电邮 1174751315@qq.com。<br>
 * 说明：
 */
public class ErrorHelper {
    public ErrorHelper() {
    }

    public static String actionError(Exception e, CommonAjaxAction action){
            String err = ExceptionInfoPrintingHelper.getStackTraceInfo(e);
            Logging.instance().createLogger(action.getClass().getSimpleName()).error(err);
            return action.warn("服务器软件发生未知错误，请联系李倍存。\n" + err);
    }
}
