/*
 * 版权所有 (c) 2015 。 李倍存 （iPso）。
 * 所有者对该文件所包含的代码的正确性、执行效率等任何方面不作任何保证。
 * 所有个人和组织均可不受约束地将该文件所包含的代码用于非商业用途。若需要将其用于商业软件的开发，请首先联系所有者以取得许可。
 */

package org.ipso.lbc.resseorg.dao;

import org.hibernate.cfg.Configuration;
import org.ipso.lbc.common.db.dao.SuperDAO;

/**
 * 信息：李倍存 创建于 2015/10/19 11:32。电邮 1174751315@qq.com。<br>
 * 说明：
 */
public class DAOFactoryHWATT_RO extends DAOFactory{
    private static DAOFactoryHWATT_RO instance = new DAOFactoryHWATT_RO();

    public static DAOFactoryHWATT_RO getInstance() {
        return instance;
    }
    private DAOFactoryHWATT_RO() {
        SuperDAO superDAO = new SuperDAO(new Configuration().configure("hibernate.cfg.hwatt-ro.xml").buildSessionFactory());
        this.superDAO = superDAO;
        daos.put("card-time",new DAOCardTimeRecord(superDAO));
        daos.put("iPso-employee",new DAOIPsoEmployee(superDAO));
        daos.put("weekly-summary",new DAOWeeklySummary(superDAO));
    }

    public DAOCardTimeRecord createDaoCardTimeRecord(){
        return (DAOCardTimeRecord)daos.get("card-time");
    }

}
