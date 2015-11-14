 /*
 * 版权所有 (c) 2015 。 李倍存 （iPso）。
 * 所有者对该文件所包含的代码的正确性、执行效率等任何方面不作任何保证。
 * 所有个人和组织均可不受约束地将该文件所包含的代码用于非商业用途。若需要将其用于商业软件的开发，请首先联系所有者以取得许可。
 */

package org.ipso.lbc.resseorg.action;

import org.ipso.lbc.common.action.CommonAjaxAction;
import org.ipso.lbc.common.exception.handler.ExceptionInfoPrintingHelper;

import java.util.LinkedList;
import java.util.List;

 /**
  * 信息：李倍存 创建于 2015/10/24 21:24。电邮 1174751315@qq.com。<br>
  * 说明：
  */
 public class RegisterBusinessTripAction extends CommonAjaxAction {


     public RegisterBusinessTripAction() {
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


     private Integer minutes;
     private Integer times;
     private String id = "UNSPECIFIED";
     private String info = "";
     private List<String> timesSegments = new LinkedList<String>();

     public String getTimesSegmentsStr() {
         return timesSegmentsStr;
     }

     public void setTimesSegmentsStr(String timesSegmentsStr) {
         this.timesSegmentsStr = timesSegmentsStr;
     }

     public List<String> getTimesSegments() {
         return timesSegments;
     }

     public void setTimesSegments(List<String> timesSegments) {
         this.timesSegments = timesSegments;
     }

     private String timesSegmentsStr = "";





     public String getInfo() {
         return info;
     }

     public void setInfo(String info) {
         this.info = info;
     }


     public String getId() {
         return id;
     }

     public void setId(String id) {
         this.id = id;
     }



     public Integer getMinutes() {
         return minutes;
     }

     public void setMinutes(Integer minutes) {
         this.minutes = minutes;
     }

     public Integer getTimes() {
         return times;
     }

     public void setTimes(Integer times) {
         this.times = times;
     }




     @Override
     public String execute() throws Exception {


         try {

//             DAOStudent daoStudent = DAOFactoryMain.getInstance().getDaoStudent();
//             DAOLessonRecord daoLessonRecord = DAOFactoryMain.getInstance().getDaoLessonRecord();
//
//             Subject user = SecurityUtils.getSubject();
//             String name;
//             if (user.isAuthenticated()){
//                 name = daoStudent.query(user.getPrincipal().toString()).getStudentName();
//             } else {
//                 name = this.name;
//             }
//             LessonRecord currentRecord = daoLessonRecord.queryByStudentName(name);
//             if (currentRecord == null){
//                 return warn("没有找到您的姓名，请联系纪委同学。");
//             }
//
//
//             Student currentStudent = daoStudent.query(id);
//
//
//
//
//         if (currentStudent == null){
//             return warn("没有找到您的信息，请检查学号是否正确。");
//         }
//             if (!currentStudent.getStudentName().equals(name)){
//                 return warn("您输入的的学号和姓名不匹配，请重新键入正确的信息。");
//             }

//             LessonRecord record = new LessonRecord(currentRecord.getStudentId(),currentRecord.getName(),minutes,times,info,new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
//             daoLessonRecord.insertOrUpdate(record);

 //        String username = subject.getPrincipal().toString();
 //        DAOLessonRecord daoLessonRecord = DAOFactoryMain.getInstance().getDaoLessonRecord();
 //
 //        LessonRecord record = new LessonRecord(new Student(subject.getPrincipal().toString(),"UNNAMED"),minutes,times);
 //
 //        daoLessonRecord.insertOrUpdate(record);
 //
             return SUCCESS;
         } catch (Exception e) {
             return warn("服务器软件发生未知错误，请联系李倍存。\n" + ExceptionInfoPrintingHelper.getStackTraceInfo(e));
         }
     }
 }
