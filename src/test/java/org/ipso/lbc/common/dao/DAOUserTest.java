/*
 * 版权所有 (c) 2015 。 李倍存 （iPso）。
 * 所有者对该文件所包含的代码的正确性、执行效率等任何方面不作任何保证。
 * 所有个人和组织均可不受约束地将该文件所包含的代码用于非商业用途。若需要将其用于商业软件的开发，请首先联系所有者以取得许可。
 */

package org.ipso.lbc.common.dao;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.ipso.lbc.common.adm.User;
import org.ipso.lbc.resseorg.dao.DAOFactory;
import org.ipso.lbc.resseorg.dao.DAOFactoryLocal;

import static org.junit.Assert.*;

public class DAOUserTest {

    DAOUser daoUser = DAOFactoryLocal.getInstance().getDaoUser();

    @org.junit.Test
    public void testInsertOrUpdate() throws Exception {
        daoUser.insertOrUpdate(new User("TEST","TEST"));
    }

    @org.junit.Test
    public void testQuery() throws Exception {
        User user = daoUser.query("TEST");
        assertEquals(new Md5Hash("TEST").toHex(),user.getPassword());
    }
}