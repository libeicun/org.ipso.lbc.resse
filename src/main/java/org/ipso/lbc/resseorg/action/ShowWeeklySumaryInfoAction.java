/*
 * 版权所有 (c) 2015 。 李倍存 （iPso）。
 * 所有者对该文件所包含的代码的正确性、执行效率等任何方面不作任何保证。
 * 所有个人和组织均可不受约束地将该文件所包含的代码用于非商业用途。若需要将其用于商业软件的开发，请首先联系所有者以取得许可。
 */

package org.ipso.lbc.resseorg.action;

import org.ipso.lbc.common.action.CommonAjaxAction;
import org.ipso.lbc.common.shiro.ShiroFacade;
import org.ipso.lbc.common.utils.DateUtil;
import org.ipso.lbc.resseorg.dao.*;
import org.ipso.lbc.resseorg.domain.*;
import org.ipso.lbc.resseorg.utils.ErrorHelper;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 信息：李倍存 创建于 2015/11/20 14:46。电邮 1174751315@qq.com。<br>
 * 说明：
 */
public class ShowWeeklySumaryInfoAction extends CommonAjaxAction {
    private String name;
    private List<WeeklySummary> summariesOfAll = new LinkedList<WeeklySummary>();

    public String getName() {
        return name;
    }

    public ShowWeeklySumaryInfoAction() {
    }
    public String executeStatics() throws Exception {
        try {
            name = ShiroFacade.getCurrentUserName();
            WeeklySummary.MyComparator comparator =new WeeklySummary.MyComparator();

            DAOWeeklySummary daoWeeklySummary = DAOFactoryHWATT_RO.getInstance().getDaoWeeklySummary();
            List<WeeklySummary> summariesOfTutors = daoWeeklySummary.query(DAOWeeklySummary.TUTOR);
            List<WeeklySummary> summariesOfDoctors = daoWeeklySummary.query(DAOWeeklySummary.DOCTOR);
            List<WeeklySummary> summariesOf2013s = daoWeeklySummary.query(DAOWeeklySummary.G2013);
            List<WeeklySummary> summariesOf2014s = daoWeeklySummary.query(DAOWeeklySummary.G2014);
            List<WeeklySummary> summariesOf2015s = daoWeeklySummary.query(DAOWeeklySummary.G2015);
            Collections.sort(summariesOfTutors,comparator);
            Collections.sort(summariesOfDoctors,comparator);
            Collections.sort(summariesOf2013s,comparator);
            Collections.sort(summariesOf2014s,comparator);
            Collections.sort(summariesOf2015s,comparator);
            summariesOfAll.addAll(summariesOfTutors);
            summariesOfAll.addAll(summariesOfDoctors);
            summariesOfAll.addAll(summariesOf2013s);
            summariesOfAll.addAll(summariesOf2014s);
            summariesOfAll.addAll(summariesOf2015s);
            removeSummariesWhoseTotalTimeIs0(summariesOfAll);
        }catch (Exception e){
            return ErrorHelper.actionError(e, this);        }
        return SUCCESS;
    }

    public List<WeeklySummary> getSummariesOfAll() {
        return summariesOfAll;
    }


    public void removeSummariesWhoseTotalTimeIs0(List<WeeklySummary> summaries){
        List<WeeklySummary> zeros = new LinkedList<WeeklySummary>();
        for (int i = 0; i < summaries.size(); i++) {
            if (summaries.get(i).getTotalTime().doubleValue() == 0.0){
                zeros.add(summaries.get(i));
            }
        }
        summaries.removeAll(zeros);
    }

    public String executePersonal() throws Exception {
        try {
            List<String> days = DateUtil.getAllDateStringsInThisWeek();
            String start = days.get(0) + " 00:00:00.000";
            String end = days.get(days.size()-1) + " 23:59:59.999";

            name = ShiroFacade.getCurrentUserName();

            DAOBusinessTripRecord daoBusinessTripRecord = DAOFactoryHWATT_RW.getInstance().getDaoBusinessTripRecord();
            DAODayOffRecord daoDayOffRecord = DAOFactoryHWATT_RW.getInstance().getDaoDayOffRecord();
            DAOCardTimeRecord daoCardTimeRecord = DAOFactoryHWATT_RO.getInstance().createDaoCardTimeRecord();
            DAOLessonRecord daoLessonRecord = DAOFactoryHWATT_RW.getInstance().getDaoLessonRecord();
            DAOWeeklySummary daoWeeklySummary = DAOFactoryHWATT_RO.getInstance().getDaoWeeklySummary();

            businessTripRecords = daoBusinessTripRecord.queryByNameBetweenTime(name,start,end);
            dayOffRecords = daoDayOffRecord.queryByNameBetweenTime(name,start,end);
            cardTimeRecords = daoCardTimeRecord.queryByNameBetweenTime(name,start,end);
            lessonRecords = daoLessonRecord.queryByNameBetweenTime(name,start,end);
            summary = daoWeeklySummary.queryByName(name);
        }catch (Exception e){
            return ErrorHelper.actionError(e, this);        }
        return SUCCESS;
    }

    @Override
    protected void setWarningInfo(String info) {
        warning = info;
    }



    private String warning="OK";
    private List<BusinessTripRecord> businessTripRecords ;
    private List<DayOffRecord> dayOffRecords;
    private List<CardTimeRecord> cardTimeRecords;
    private List<LessonRecord> lessonRecords;
    private WeeklySummary summary;

    public WeeklySummary getSummary() {
        return summary;
    }

    public List<BusinessTripRecord> getBusinessTripRecords() {
        return businessTripRecords;
    }
    public String getWarning() {
        return warning;
    }
    public List<CardTimeRecord> getCardTimeRecords() {
        return cardTimeRecords;
    }

    public List<DayOffRecord> getDayOffRecords() {
        return dayOffRecords;
    }

    public List<LessonRecord> getLessonRecords() {
        return lessonRecords;
    }
}
