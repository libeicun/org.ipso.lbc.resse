/*
 * 版权所有 (c) 2015 。 李倍存 （iPso）。
 * 所有者对该文件所包含的代码的正确性、执行效率等任何方面不作任何保证。
 * 所有个人和组织均可不受约束地将该文件所包含的代码用于非商业用途。若需要将其用于商业软件的开发，请首先联系所有者以取得许可。
 */

package org.ipso.lbc.resseorg.dao;

import org.ipso.lbc.common.db.dao.AbstractDAO;
import org.ipso.lbc.common.db.dao.SuperDAO;
import org.ipso.lbc.resseorg.domain.BusinessTripRecord;
import org.ipso.lbc.resseorg.domain.CardTimeRecord;

import java.util.LinkedList;
import java.util.List;

/**
 * 信息：李倍存 创建于 2015/10/19 11:24。电邮 1174751315@qq.com。<br>
 * 说明：
 */
public class DAOBusinessTripRecord extends AbstractDAO {
    public DAOBusinessTripRecord(SuperDAO superDAO) {
        this.superDAO = superDAO;
    }

    public void insertOrUpdate(BusinessTripRecord record){
        superDAO.insertOrUpdate(record);
    }

    public List<BusinessTripRecord> queryByNameBetweenTime(String name, String startDate, String endDate){
        List list =  superDAO.query("from BusinessTripRecord where name=? and startTime>? and endTime<? order by startTime asc",name,startDate,endDate);
        List<BusinessTripRecord> businessTripRecords = new LinkedList<BusinessTripRecord>();
        for (int i = 0; i < list.size(); i++) {
            businessTripRecords.add((BusinessTripRecord)list.get(i));
        }
        return businessTripRecords;
    }
}
