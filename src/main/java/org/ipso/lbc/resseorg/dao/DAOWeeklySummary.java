/*
 * 版权所有 (c) 2015 。 李倍存 （iPso）。
 * 所有者对该文件所包含的代码的正确性、执行效率等任何方面不作任何保证。
 * 所有个人和组织均可不受约束地将该文件所包含的代码用于非商业用途。若需要将其用于商业软件的开发，请首先联系所有者以取得许可。
 */

package org.ipso.lbc.resseorg.dao;

import org.ipso.lbc.common.db.dao.AbstractDAO;
import org.ipso.lbc.common.db.dao.SuperDAO;
import org.ipso.lbc.resseorg.domain.CardTimeRecord;
import org.ipso.lbc.resseorg.domain.WeeklySummary;
import org.jfree.data.time.Week;

import java.util.LinkedList;
import java.util.List;

/**
 * 信息：李倍存 创建于 2015/10/19 11:24。电邮 1174751315@qq.com。<br>
 * 说明：
 */
public class DAOWeeklySummary extends AbstractDAO {
    public DAOWeeklySummary(SuperDAO superDAO) {
        this.superDAO = superDAO;
    }

    public WeeklySummary queryByName(String s){
        List list = superDAO.query("from WeeklySummary where name = ? order by totalTime desc",s);
        if (list.size()==0)
            return null;
        return (WeeklySummary)list.get(0);
    }
    public List<WeeklySummary> queryByGrade(String s){
        List list = superDAO.query("from WeeklySummary where grade like '?%' order by percentage desc",s);
        List<WeeklySummary> summaries = new LinkedList<WeeklySummary>();
        for (int i = 0; i < list.size(); i++) {
            summaries.add((WeeklySummary) list.get(i));
        }
        return summaries;
    }

    public List<WeeklySummary> query(){
        List list = superDAO.query("from WeeklySummary order by totalTime asc");
        LinkedList<WeeklySummary> summaries = new LinkedList<WeeklySummary>();
        for (int i = 0; i < list.size(); i++) {
            summaries.addFirst((WeeklySummary) list.get(i));
        }

        return summaries;
    }


    public List<WeeklySummary> query(String s){
        List list = superDAO.query(hql(s));
        LinkedList<WeeklySummary> summaries = new LinkedList<WeeklySummary>();
        for (int i = 0; i < list.size(); i++) {
            summaries.addFirst((WeeklySummary) list.get(i));
        }
        return summaries;
    }

    public static String DOCTOR = "博士", TUTOR = "老师", G2013 = "2013", G2014 = "2014", G2015 = "2015";
    private static String hql(String t){
        return "from WeeklySummary where grade like '"+t+"%' order by percentage asc";
    }
}
