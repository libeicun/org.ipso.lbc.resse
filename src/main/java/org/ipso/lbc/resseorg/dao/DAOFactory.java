/*
 * 版权所有 (c) 2015 。 李倍存 （iPso）。
 * 所有者对该文件所包含的代码的正确性、执行效率等任何方面不作任何保证。
 * 所有个人和组织均可不受约束地将该文件所包含的代码用于非商业用途。若需要将其用于商业软件的开发，请首先联系所有者以取得许可。
 */

package org.ipso.lbc.resseorg.dao;

import org.ipso.lbc.common.dao.DAOStudent;
import org.ipso.lbc.common.dao.DAOUser;
import org.ipso.lbc.common.dao.DAOUserRole;
import org.ipso.lbc.common.db.dao.SuperDAO;
import org.ipso.lbc.common.db.eDbType;

import java.util.HashMap;
import java.util.Map;

/**
 * 信息：李倍存 创建于 2015/10/19 11:32。电邮 1174751315@qq.com。<br>
 * 说明：
 */
public abstract class DAOFactory {
    protected SuperDAO superDAO;
    public SuperDAO getSuperDAO() {
        return superDAO;
    }

    protected Map<String,Object> daos = new HashMap<String, Object>();

    public DAOUser getDaoUser(){
        return (DAOUser) daos.get("user");
    }

    public DAOUserRole getDaoUserRole(){
        return (DAOUserRole) daos.get("user-role");
    }
    public DAOStudent getDaoStudent(){
        return (DAOStudent) daos.get("student");
    }
    public DAOLessonRecord getDaoLessonRecord(){
        return (DAOLessonRecord) daos.get("lesson-record");
    }
    public DAOBusinessTripRecord getDaoBusinessTripRecord(){ return (DAOBusinessTripRecord) daos.get("business-trip-record"); }
    public DAODayOffRecord getDaoDayOffRecord(){ return (DAODayOffRecord) daos.get("day-off-record");}
    public DAOIPsoEmployee getDaoIPsoEmployee(){ return (DAOIPsoEmployee) daos.get("iPso-employee");}
    public DAOWeeklySummary getDaoWeeklySummary(){ return (DAOWeeklySummary) daos.get("weekly-summary");}
}
