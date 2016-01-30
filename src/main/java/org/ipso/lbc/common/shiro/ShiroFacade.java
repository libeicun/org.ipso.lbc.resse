/*
 * 版权所有 (c) 2015 。 李倍存 （iPso）。
 * 所有者对该文件所包含的代码的正确性、执行效率等任何方面不作任何保证。
 * 所有个人和组织均可不受约束地将该文件所包含的代码用于非商业用途。若需要将其用于商业软件的开发，请首先联系所有者以取得许可。
 */

package org.ipso.lbc.common.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 * 信息：李倍存 创建于 2015/11/20 14:51。电邮 1174751315@qq.com。<br>
 * 说明：
 */
public class ShiroFacade {

    public static String getCurrentUserName(){
        if (!isCurrentUserAuthenticated()){
            return "";
        }
        return SecurityUtils.getSubject().getPrincipal().toString();
    }

    public static Boolean isCurrentUserAuthenticated(){
        if (SecurityUtils.getSubject() == null){
            return false;
        }
        return SecurityUtils.getSubject().isAuthenticated();
    }

    public static Subject getCurrentUser(){
        return SecurityUtils.getSubject();
    }
}
