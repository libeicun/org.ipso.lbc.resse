/*
 * 版权所有 (c) 2015 。 李倍存 （iPso）。
 * 所有者对该文件所包含的代码的正确性、执行效率等任何方面不作任何保证。
 * 所有个人和组织均可不受约束地将该文件所包含的代码用于非商业用途。若需要将其用于商业软件的开发，请首先联系所有者以取得许可。
 */

package org.ipso.lbc.resseorg.dao;

import org.ipso.lbc.resseorg.domain.WeeklySummary;

import java.util.List;

public class DAOWeeklySummaryTest {

    @org.junit.Test
    public void testQueryByName() throws Exception {

    }

    @org.junit.Test
    public void testQueryByGrade() throws Exception {
        List<WeeklySummary> tutors = DAOFactoryHWATT_RW.getInstance().getDaoWeeklySummary().queryByGrade(DAOWeeklySummary.TUTOR);
        List<WeeklySummary> doctors = DAOFactoryHWATT_RW.getInstance().getDaoWeeklySummary().queryByGrade(DAOWeeklySummary.DOCTOR);
        List<WeeklySummary> g2013s = DAOFactoryHWATT_RW.getInstance().getDaoWeeklySummary().queryByGrade(DAOWeeklySummary.G2013);
        List<WeeklySummary> g2014s = DAOFactoryHWATT_RW.getInstance().getDaoWeeklySummary().queryByGrade(DAOWeeklySummary.G2014);
        List<WeeklySummary> g2015s = DAOFactoryHWATT_RW.getInstance().getDaoWeeklySummary().queryByGrade(DAOWeeklySummary.G2015);
    }

    @org.junit.Test
    public void testQuery() throws Exception {
        List<WeeklySummary> all = DAOFactoryHWATT_RW.getInstance().getDaoWeeklySummary().query();
    }
}