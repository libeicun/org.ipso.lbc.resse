/*
 * 版权所有 (c) 2015 。 李倍存 （iPso）。
 * 所有者对该文件所包含的代码的正确性、执行效率等任何方面不作任何保证。
 * 所有个人和组织均可不受约束地将该文件所包含的代码用于非商业用途。若需要将其用于商业软件的开发，请首先联系所有者以取得许可。
 */

package org.ipso.lbc.common.adm;

import org.apache.shiro.crypto.hash.Md5Hash;

import java.io.Serializable;

/**
 * 信息：李倍存 创建于 2015/10/19 11:14。电邮 1174751315@qq.com。<br>
 * 说明：
 */
public class UserRole implements Serializable {

    private String username;
    public UserRole(){}
    public UserRole( String username,String rolename) {
        this.username = username;
        this.rolename = rolename;
    }

    public String getRolename() {

        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String rolename;
}
