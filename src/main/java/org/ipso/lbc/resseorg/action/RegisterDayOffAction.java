 /*
 * 版权所有 (c) 2015 。 李倍存 （iPso）。
 * 所有者对该文件所包含的代码的正确性、执行效率等任何方面不作任何保证。
 * 所有个人和组织均可不受约束地将该文件所包含的代码用于非商业用途。若需要将其用于商业软件的开发，请首先联系所有者以取得许可。
 */

package org.ipso.lbc.resseorg.action;

import org.ipso.lbc.common.action.CommonAjaxAction;
import org.ipso.lbc.common.exception.handler.ExceptionInfoPrintingHelper;

 /**
  * 信息：李倍存 创建于 2015/10/24 21:24。电邮 1174751315@qq.com。<br>
  * 说明：
  */
 public class RegisterDayOffAction extends CommonAjaxAction {


     public RegisterDayOffAction() {
     }

     public String getWarning() {
         return warning;
     }

     public void setWarning(String warning) {
         this.warning = warning;
     }

     private String warning="OK";
     @Override
     protected void setWarningInfo(String info) {
         warning = info;
     }

     private String id = "UNSPECIFIED";
     private String start = "";
     private String end = "";
     private String reason = "无。";

     public String getEnd() {
         return end;
     }

     public void setEnd(String end) {
         this.end = end;
     }

     public String getReason() {
         return reason;
     }

     public void setReason(String reason) {
         this.reason = reason;
     }

     public String getStart() {
         return start;
     }

     public void setStart(String start) {
         this.start = start;
     }

     public String getId() {
         return id;
     }

     public void setId(String id) {
         this.id = id;
     }






     @Override
     public String execute() throws Exception {
         try {

             return SUCCESS;
         } catch (Exception e) {
             return warn("服务器软件发生未知错误，请联系李倍存。\n" + ExceptionInfoPrintingHelper.getStackTraceInfo(e));
         }
     }
 }
