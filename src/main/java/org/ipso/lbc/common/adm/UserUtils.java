/*
 * 版权所有 (c) 2015 。 李倍存 （iPso）。
 * 所有者对该文件所包含的代码的正确性、执行效率等任何方面不作任何保证。
 * 所有个人和组织均可不受约束地将该文件所包含的代码用于非商业用途。若需要将其用于商业软件的开发，请首先联系所有者以取得许可。
 */

package org.ipso.lbc.common.adm;

import org.ipso.lbc.common.dao.DAOUser;
import org.ipso.lbc.common.dao.DAOUserRole;

/**
 * 信息：李倍存 创建于 2015/10/19 11:29。电邮 1174751315@qq.com。<br>
 * 说明：
 */
public class UserUtils {
    public UserUtils() {
    }

    public static void setPassword(DAOUser daoUser,String username,String newPassword){
        User user = new User(username,newPassword);
        daoUser.insertOrUpdate(user);
    }

    public static void setRole(DAOUserRole daoUserRole,String username, String newRole){
        UserRole userRole= new UserRole(username,newRole);
        daoUserRole.insertOrUpdate(userRole);
    }
}
