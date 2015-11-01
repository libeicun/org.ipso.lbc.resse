/*
 * 版权所有 (c) 2015 。 李倍存 （iPso）。
 * 所有者对该文件所包含的代码的正确性、执行效率等任何方面不作任何保证。
 * 所有个人和组织均可不受约束地将该文件所包含的代码用于非商业用途。若需要将其用于商业软件的开发，请首先联系所有者以取得许可。
 */

package org.ipso.lbc.resseorg;

import org.ipso.lbc.common.adm.User;
import org.ipso.lbc.common.adm.UserRole;
import org.ipso.lbc.common.adm.UserUtils;
import org.ipso.lbc.common.dao.DAOStudent;
import org.ipso.lbc.common.dao.DAOUser;
import org.ipso.lbc.common.dao.DAOUserRole;
import org.ipso.lbc.common.domain.Student;
import org.ipso.lbc.resseorg.dao.DAOFactoryMain;

/**
 * 信息：李倍存 创建于 2015/10/24 21:45。电邮 1174751315@qq.com。<br>
 * 说明：
 */
public class PrepareData {
    public PrepareData() {
    }

    @org.junit.Test
    public void doPrepare() throws Exception {
        DAOUser daoUser = DAOFactoryMain.getInstance().getDaoUser();
        DAOStudent daoStudent = DAOFactoryMain.getInstance().getDaoStudent();
        DAOUserRole daoUserRole = DAOFactoryMain.getInstance().getDaoUserRole();

        String id = "1512302009";
        String pass = "lbc";
        String name = "李倍存";
        String role = "user";

        daoUser.insertOrUpdate(new User(id,pass));
        daoStudent.insertOrUpdate(new Student(id,name));
        daoUserRole.insertOrUpdate(new UserRole(id,role));

    }
}
