/*
 * 版权所有 (c) 2015 。 李倍存 （iPso）。
 * 所有者对该文件所包含的代码的正确性、执行效率等任何方面不作任何保证。
 * 所有个人和组织均可不受约束地将该文件所包含的代码用于非商业用途。若需要将其用于商业软件的开发，请首先联系所有者以取得许可。
 */

package org.ipso.lbc.resseorg.dao;

import org.ipso.lbc.common.db.dao.AbstractDAO;
import org.ipso.lbc.common.db.dao.SuperDAO;
import org.ipso.lbc.resseorg.domain.CardTimeRecord;
import org.ipso.lbc.resseorg.domain.LessonRecord;

import java.util.LinkedList;
import java.util.List;

/**
 * 信息：李倍存 创建于 2015/10/19 11:24。电邮 1174751315@qq.com。<br>
 * 说明：
 */
public class DAOCardTimeRecord extends AbstractDAO {
    public DAOCardTimeRecord(SuperDAO superDAO) {
        this.superDAO = superDAO;
    }

    public List queryByName(String s){
        return superDAO.query("from CardTimeRecord where name = ?",s);
    }

    public List<CardTimeRecord> queryByNameBetweenTime(String name, String timeStart, String timeEnd){
        List list =  superDAO.query("from CardTimeRecord where name=? and cardTime>? and cardTime<? order by cardTime asc",name,timeStart,timeEnd);
        List<CardTimeRecord> cardTimeRecords = new LinkedList<CardTimeRecord>();
        for (int i = 0; i < list.size(); i++) {
            cardTimeRecords.add((CardTimeRecord)list.get(i));
        }
        return cardTimeRecords;
    }

}
