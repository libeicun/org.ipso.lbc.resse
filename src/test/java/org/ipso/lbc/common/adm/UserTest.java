/*
 * 版权所有 (c) 2015 。 李倍存 （iPso）。
 * 所有者对该文件所包含的代码的正确性、执行效率等任何方面不作任何保证。
 * 所有个人和组织均可不受约束地将该文件所包含的代码用于非商业用途。若需要将其用于商业软件的开发，请首先联系所有者以取得许可。
 */

package org.ipso.lbc.common.adm;

import org.ipso.lbc.common.dao.DAOUser;
import org.ipso.lbc.common.db.DAOFactory;
import org.ipso.lbc.resseorg.dao.DAOFactoryMain;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void testSetPassword() throws Exception {
//        DAOUser daoUser = DAOFactoryMain.getInstance().getDaoUser();
//        daoUser.insertOrUpdate(new User("admin","admin"));
//        UserUtils.setPassword(daoUser,"admin","admin");
//        daoUser.insertOrUpdate(new User("1512302009","lbc"));
        User user = new User("guest","guest");
        System.err.println(user.getPassword());
    }
}