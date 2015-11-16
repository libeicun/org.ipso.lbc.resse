 /*
 * 版权所有 (c) 2015 。 李倍存 （iPso）。
 * 所有者对该文件所包含的代码的正确性、执行效率等任何方面不作任何保证。
 * 所有个人和组织均可不受约束地将该文件所包含的代码用于非商业用途。若需要将其用于商业软件的开发，请首先联系所有者以取得许可。
 */

package org.ipso.lbc.resseorg.action;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.ipso.lbc.common.action.CommonAjaxAction;
import org.ipso.lbc.common.exception.handler.ExceptionInfoPrintingHelper;
import org.ipso.lbc.common.utils.DateUtil;
import org.ipso.lbc.resseorg.dao.DAODayOffRecord;
import org.ipso.lbc.resseorg.dao.DAOFactoryHWATT;
import org.ipso.lbc.resseorg.dao.DAOFactoryLocal;
import org.ipso.lbc.resseorg.dao.DAOIPsoEmployee;
import org.ipso.lbc.resseorg.domain.DayOffRecord;
import org.ipso.lbc.resseorg.domain.IPsoEmployee;

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

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     private String name = "";
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


     public String getStartDate() {
         return startDate;
     }

     public void setStartDate(String startDate) {
         this.startDate = startDate;
     }

     public String getEndDate() {
         return endDate;
     }

     public void setEndDate(String endDate) {
         this.endDate = endDate;
     }

     public String getEndTime() {
         return endTime;
     }

     public void setEndTime(String endTime) {
         this.endTime = endTime;
     }

     public String getStartTime() {
         return startTime;
     }

     public void setStartTime(String startTime) {
         this.startTime = startTime;
     }

     private String startDate="",startTime="",endDate="",endTime="";


     @Override
     public String execute() throws Exception {
         try {
             Subject user = SecurityUtils.getSubject();

             DAODayOffRecord daoDayOffRecord = DAOFactoryHWATT.getInstance().getDaoDayOffRecord();
             DAOIPsoEmployee daoiPsoEmployee = DAOFactoryHWATT.getInstance().getDaoIPsoEmployee();
             IPsoEmployee employee;
             if (user.isAuthenticated()){
                 employee = daoiPsoEmployee.query(user.getPrincipal().toString());
             } else {
                 employee = daoiPsoEmployee.query(this.name);
             }


             if (employee == null){
                 return warn("您提供的工号无效。");
             }

             DayOffRecord record = new DayOffRecord(employee.getEmployeeID(),employee.getEmployeeName(),startDate+" "+startTime,endDate+" "+endTime,reason, DateUtil.getToday());
             daoDayOffRecord.insertOrUpdate(record);


             return SUCCESS;
         } catch (Exception e) {

             return warn("服务器软件发生未知错误，请联系李倍存。\n" + ExceptionInfoPrintingHelper.getStackTraceInfo(e));
         }
     }
 }
