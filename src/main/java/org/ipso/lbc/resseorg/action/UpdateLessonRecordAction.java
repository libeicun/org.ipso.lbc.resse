 /*
 * 版权所有 (c) 2015 。 李倍存 （iPso）。
 * 所有者对该文件所包含的代码的正确性、执行效率等任何方面不作任何保证。
 * 所有个人和组织均可不受约束地将该文件所包含的代码用于非商业用途。若需要将其用于商业软件的开发，请首先联系所有者以取得许可。
 */

package org.ipso.lbc.resseorg.action;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.ServletActionContext;
import org.ipso.lbc.common.action.CommonAjaxAction;
import org.ipso.lbc.common.ado.ConvertUtils;
import org.ipso.lbc.common.dao.DAOStudent;
import org.ipso.lbc.common.exception.AppUnCheckException;
import org.ipso.lbc.common.exception.handler.ExceptionInfoPrintingHelper;
import org.ipso.lbc.common.utils.DateUtil;
import org.ipso.lbc.common.utils.datetime.SimpleTime;
import org.ipso.lbc.common.utils.datetime.SimpleTimePeriod;
import org.ipso.lbc.resseorg.dao.*;
import org.ipso.lbc.resseorg.domain.CardTimeRecord;
import org.ipso.lbc.resseorg.domain.LessonRecord;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

 /**
 * 信息：李倍存 创建于 2015/10/24 21:24。电邮 1174751315@qq.com。<br>
 * 说明：
 */
public class UpdateLessonRecordAction extends CommonAjaxAction {


     public UpdateLessonRecordAction() {
    }


     private String warning="OK";
     private Integer minutes;
     private Integer times;
     private String id = "UNSPECIFIED";
     private String name = "UNSPECIFIED";
     private String info = "";

     private Integer code0=0,code1=0,code2=0,code3=0,code4=0,code5=0,code6=0;


     public String getWarning() {
         return warning;
     }

     public void setWarning(String warning) {
         this.warning = warning;
     }
     @Override
     protected void setWarningInfo(String info) {
         warning = info;
     }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
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


     public Integer getCode0() {
         return code0;
     }

     public void setCode0(Integer code0) {
         this.code0 = code0;
     }

     public Integer getCode1() {
         return code1;
     }

     public void setCode1(Integer code1) {
         this.code1 = code1;
     }

     public Integer getCode2() {
         return code2;
     }

     public void setCode2(Integer code2) {
         this.code2 = code2;
     }

     public Integer getCode3() {
         return code3;
     }

     public void setCode3(Integer code3) {
         this.code3 = code3;
     }

     public Integer getCode4() {
         return code4;
     }

     public void setCode4(Integer code4) {
         this.code4 = code4;
     }

     public Integer getCode5() {
         return code5;
     }

     public void setCode5(Integer code5) {
         this.code5 = code5;
     }

     public Integer getCode6() {
         return code6;
     }

     public void setCode6(Integer code6) {
         this.code6 = code6;
     }

     @Override
    public String execute() throws Exception {
        try {
            DAOStudent daoStudent = DAOFactoryLocal.getInstance().getDaoStudent();
            DAOLessonRecord daoLessonRecord = DAOFactoryLocal.getInstance().getDaoLessonRecord();
            Subject user = SecurityUtils.getSubject();
            if (user.isAuthenticated()){
                this.name = daoStudent.query(user.getPrincipal().toString()).getStudentName();
                System.err.println(DateUtil.getNowDateTime()+" "+ServletActionContext.getRequest().getRemoteHost() + " 【登录】之后访问。");
            } else{
                System.err.println(DateUtil.getNowDateTime()+" "+ServletActionContext.getRequest().getRemoteHost() + " 【未登录】的访问。");
            }

            String overlapInfo = getOverlapInfo();
            if (!overlapInfo.equals("")){
                System.err.println(DateUtil.getNowDateTime()+"===================>");
                System.err.println(overlapInfo);
                System.err.println("<======================================");
                return warn("检测到：某些上课时段与刷脸记录时段重叠，如下：\n\n "+overlapInfo + "\n在取消选中这些上课之前，将不会提交您的登记信息。\n\n");
            }


            LessonRecord currentRecord = daoLessonRecord.queryByStudentName(this.name);
            if (currentRecord == null){
                return warn("没有找到您的姓名，请联系纪委同学。");
            }


//            Student currentStudent = daoStudent.query(id);




//        if (currentStudent == null){
//            return warn("没有找到您的信息，请检查学号是否正确。");
//        }
//            if (!currentStudent.getStudentName().equals(name)){
//                return warn("您输入的的学号和姓名不匹配，请重新键入正确的信息。");
//            }

            LessonRecord record = new LessonRecord(currentRecord.getStudentId(),currentRecord.getName(),minutes,times,info,new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
            daoLessonRecord.insertOrUpdate(record);

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


     private static String[] weekdays = {"星期一","星期二","星期三","星期四","星期五","星期六","星期日"};
     private static String[] weekdaysTimePeriods = {"上午1大节","上午2大节","下午","晚间"};
     private String today = DateUtil.getToday();
     public String getOverlapInfo(){

         List<String> daysFormMondayToNow = DateUtil.getAllDateStringsBetweenNowAndLatestISOWeekday(today,1);
         List<List<SimpleTimePeriod>> inDatabase = getAllPeriodsInDatabase(daysFormMondayToNow);
         List<List<SimpleTimePeriod>> inWebPage  = getAllPeriodInWebPage(daysFormMondayToNow);
         String overlapsInfo = getOverlapInfo(daysFormMondayToNow,inDatabase,inWebPage);

        return overlapsInfo;
    }

     private String getOverlapInfo(List<String> days, List<List<SimpleTimePeriod>> period1, List<List<SimpleTimePeriod>> period2){
         String overlapsInfo = "";
         Integer counter = 0;
         for (int i = 0; i < days.size(); i++) {
             List<SimpleTimePeriod> inDatabase1 = period1.get(i);
             List<SimpleTimePeriod> inWebPage1 = period2.get(i);
             for (int j = 0; j < inDatabase1.size(); j++) {
                 for (int k = 0; k < inWebPage1.size(); k++) {
                     SimpleTimePeriod database = inDatabase1.get(j);
                     SimpleTimePeriod webPage = inWebPage1.get(k);
                     SimpleTime overlap = database.getOverlap(webPage);
                     if (overlap.getTotalSecond()>3600){

                         counter ++;

                         String type ="";
                         if (overlap.getTotalSecond().equals(webPage.getPeriod().getTotalSecond())){
                             type = "数据库覆盖网页";
                         } else if (overlap.getTotalSecond().equals(database.getPeriod().getTotalSecond())){
                             type = "网页覆盖数据库";
                         } else {
                             type = "交叉重叠";
                         }
                         overlapsInfo += "冲突 " + counter + " : 请不要选择 "+weekdays[i]+" 已刷脸时段: " + webPage.getName() +" 。\n";
                     }
                 }
             }
         }
         return overlapsInfo;
     }

     private List<List<SimpleTimePeriod>> getAllPeriodsInDatabase(List<String> days){
         DAOCardTimeRecord daoCardTimeRecord = DAOFactoryHWATT.getInstance().createDaoCardTimeRecord();
         List<List<CardTimeRecord>> records = new LinkedList<List<CardTimeRecord>>();
         List<List<SimpleTimePeriod>> recordsTimePeriods = new LinkedList<List<SimpleTimePeriod>>();

         String timeStart = " 00:00:00";
         String timeEnd = " 23:59:59";
         for (int i = 0; i < days.size(); i++) {
             List<CardTimeRecord> record = daoCardTimeRecord.queryByNameBetweenTime(name, days.get(i) + timeStart, days.get(i) + timeEnd);
             if (record.size()%2 != 0){
                 record.remove(record.size()-1);
             }
             records.add(record);
         }
         for (int i = 0; i < records.size(); i++) {
             recordsTimePeriods.add(getPeriods(records.get(i)));
         }
        return recordsTimePeriods;
     }
     private List<List<SimpleTimePeriod>> getAllPeriodInWebPage(List<String> days){
//         List<List<SimpleTimePeriod>> periodsInWebPage=new LinkedList<List<SimpleTimePeriod>>();
//
//         for (int i = 0; i < days.size(); i++) {
//             periodsInWebPage.add(new LinkedList<SimpleTimePeriod>());
//         }
//
//         periodsInWebPage.get(0).add(new SimpleTimePeriod(new SimpleTime(9,12,10),new SimpleTime(13,11,0)));
//         periodsInWebPage.get(1).add(new SimpleTimePeriod(new SimpleTime(7,12,20),new SimpleTime(11,12,20)));
//         periodsInWebPage.get(2).add(new SimpleTimePeriod(new SimpleTime(9,12,20),new SimpleTime(11,12,20)));
//         periodsInWebPage.get(2).add(new SimpleTimePeriod(new SimpleTime(13,58,20),new SimpleTime(19,12,20)));
         List<Integer> codes = new LinkedList<Integer>();
         codes.add(code0);
         codes.add(code1);
         codes.add(code2);
         codes.add(code3);
         codes.add(code4);
         codes.add(code5);
         codes.add(code6);
         return getPeriodsFromCodes(codes);
     }


     private List<SimpleTimePeriod> getPeriods(List<CardTimeRecord> records){
         List<SimpleTimePeriod> timePeriods = new LinkedList<SimpleTimePeriod>();
         List<SimpleTime> timePeriodStarts = new LinkedList<SimpleTime>();
         List<SimpleTime> timePeriodEnds = new LinkedList<SimpleTime>();
         for (int i = 0; i < records.size(); i += 2) {
             timePeriodStarts.add(new SimpleTime(records.get(i).getCardTime()));
         }
         for (int i = 1; i < records.size(); i += 2) {
             timePeriodEnds.add(new SimpleTime(records.get(i).getCardTime()));
         }
         if (timePeriodEnds.size()!=timePeriodStarts.size()){
             throw new AppUnCheckException("异常");
         }
         for (int i = 0; i < timePeriodStarts.size(); i++) {
             timePeriods.add(new SimpleTimePeriod(timePeriodStarts.get(i),timePeriodEnds.get(i)));
         }
         return timePeriods;
     }




     private List<List<SimpleTimePeriod>> getPeriodsFromCodes(List<Integer> codes){
         List<List<SimpleTimePeriod>> periods = new LinkedList<List<SimpleTimePeriod>>();
         for (int i = 0; i < codes.size(); i++) {
             periods.add(getPeriods(codes.get(i)));
         }
         return periods;
     }
     private List<SimpleTimePeriod> getPeriods(Integer code){
         return ConvertUtils.toList(PERIOD_CODE_MAPPING[code]);
     }
     private static SimpleTimePeriod P0 = SimpleTimePeriod.PERIOD_AM_0,
                                     P1 = SimpleTimePeriod.PERIOD_AM_1,
                                     P2 = SimpleTimePeriod.PERIOD_PM,
                                     P3 = SimpleTimePeriod.PERIOD_EV;
     private static SimpleTimePeriod[][] PERIOD_CODE_MAPPING = new SimpleTimePeriod[][]{
             new SimpleTimePeriod[]{},//0
             new SimpleTimePeriod[]{P3},//1
             new SimpleTimePeriod[]{P2},//2
             new SimpleTimePeriod[]{P2,P3},//3
             new SimpleTimePeriod[]{P1},//4
             new SimpleTimePeriod[]{P1,P3},//5
             new SimpleTimePeriod[]{P1,P2},//6
             new SimpleTimePeriod[]{P1,P2,P3},//7
             new SimpleTimePeriod[]{P0},//8
             new SimpleTimePeriod[]{P0,P3},//9
             new SimpleTimePeriod[]{P0,P2},//10
             new SimpleTimePeriod[]{P0,P2,P3},//11
             new SimpleTimePeriod[]{P0,P1},//12
             new SimpleTimePeriod[]{P0,P1,P3},//13
             new SimpleTimePeriod[]{P0,P1,P2},//14
             new SimpleTimePeriod[]{P0,P1,P2,P3}//15
     };


 }
