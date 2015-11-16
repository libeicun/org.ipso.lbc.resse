/*
 * 版权所有 (c) 2015 。 李倍存 （iPso）。
 * 所有者对该文件所包含的代码的正确性、执行效率等任何方面不作任何保证。
 * 所有个人和组织均可不受约束地将该文件所包含的代码用于非商业用途。若需要将其用于商业软件的开发，请首先联系所有者以取得许可。
 */

package org.ipso.lbc.common.shiro;


import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * 信息：李倍存 创建于 2015/11/8 9:54。电邮 1174751315@qq.com。<br>
 * 说明：
 */
public class MyJdbcRealmWithEmptyPasswordAndMd5 extends MyJdbcRealm {
//    protected String[] getPasswordForUser(String username) throws SQLException {
//        String[] result = new String[]{"e10adc3949ba59abbe56e057f20f883e"};
//        switch (saltStyle) {
//            case NO_SALT:
//                break;
//            default:
//                throw new RuntimeException("当前Realm实现不支持除NO_SALT外的Salt特性！");
//        }
//
//        return result;
//    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
            UsernamePasswordToken upToken = (UsernamePasswordToken) token;
            String username = upToken.getUsername();

            char[] password = upToken.getPassword();
            if (password == null){
                upToken.setPassword(("default").toCharArray());
            }


            return new SimpleAuthenticationInfo(username, (new Md5Hash(upToken.getPassword())).toHex().toCharArray(), getName());
    }
}
