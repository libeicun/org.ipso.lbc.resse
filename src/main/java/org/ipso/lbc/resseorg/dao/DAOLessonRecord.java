/*
 * 版权所有 (c) 2015 。 李倍存 （iPso）。
 * 所有者对该文件所包含的代码的正确性、执行效率等任何方面不作任何保证。
 * 所有个人和组织均可不受约束地将该文件所包含的代码用于非商业用途。若需要将其用于商业软件的开发，请首先联系所有者以取得许可。
 */

package org.ipso.lbc.resseorg.dao;

import org.ipso.lbc.common.adm.UserRole;
import org.ipso.lbc.common.db.dao.AbstractDAO;
import org.ipso.lbc.common.db.dao.SuperDAO;
import org.ipso.lbc.resseorg.domain.LessonRecord;

import java.util.List;

/**
 * 信息：李倍存 创建于 2015/10/19 11:24。电邮 1174751315@qq.com。<br>
 * 说明：
 */
public class DAOLessonRecord extends AbstractDAO {
    public DAOLessonRecord(SuperDAO superDAO) {
        this.superDAO = superDAO;
    }

    public void insertOrUpdate(LessonRecord record){
        superDAO.insertOrUpdate(record);
    }
    public LessonRecord queryByStudentName(String s){
        List records = superDAO.query("from LessonRecord where name = ?",s);
        if (records.size() == 0){
            return null;
        }
        return (LessonRecord)records.get(0);

    }
}
