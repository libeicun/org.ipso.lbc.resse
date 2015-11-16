/*
 * 版权所有 (c) 2015 。 李倍存 （iPso）。
 * 所有者对该文件所包含的代码的正确性、执行效率等任何方面不作任何保证。
 * 所有个人和组织均可不受约束地将该文件所包含的代码用于非商业用途。若需要将其用于商业软件的开发，请首先联系所有者以取得许可。
 */

package org.ipso.lbc.resseorg.dao;

import org.hibernate.cfg.Configuration;
import org.ipso.lbc.common.dao.DAOStudent;
import org.ipso.lbc.common.dao.DAOUser;
import org.ipso.lbc.common.dao.DAOUserRole;
import org.ipso.lbc.common.db.dao.SuperDAO;
import org.ipso.lbc.common.db.eDbType;
import org.ipso.lbc.common.utils.ResourcePathHelper;

import java.util.HashMap;
import java.util.Map;

/**
 * 信息：李倍存 创建于 2015/10/19 11:32。电邮 1174751315@qq.com。<br>
 * 说明：
 */
public class DAOFactoryHWATT extends DAOFactory{
    private static DAOFactoryHWATT instance = new DAOFactoryHWATT();

    public static DAOFactoryHWATT getInstance() {
        return instance;
    }
    private DAOFactoryHWATT() {
        SuperDAO superDAO = new SuperDAO(new Configuration().configure("hibernate.cfg.hwatt.xml").buildSessionFactory());
        this.superDAO = superDAO;

        daos.put("card-time",new DAOCardTimeRecord(superDAO));
        daos.put("iPso-employee",new DAOIPsoEmployee(superDAO));
        daos.put("lesson-record",new DAOLessonRecord(superDAO));
        daos.put("business-trip-record",new DAOBusinessTripRecord(superDAO));
        daos.put("day-off-record",new DAODayOffRecord(superDAO));
    }

    public DAOCardTimeRecord createDaoCardTimeRecord(){
        return (DAOCardTimeRecord)daos.get("card-time");
    }

}
