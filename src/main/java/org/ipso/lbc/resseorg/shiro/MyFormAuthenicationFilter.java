/*
 * 版权所有 (c) 2015 。 李倍存 （iPso）。
 * 所有者对该文件所包含的代码的正确性、执行效率等任何方面不作任何保证。
 * 所有个人和组织均可不受约束地将该文件所包含的代码用于非商业用途。若需要将其用于商业软件的开发，请首先联系所有者以取得许可。
 */

package org.ipso.lbc.resseorg.shiro;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.ipso.lbc.resseorg.utils.IPsoUserHelper;

import javax.servlet.ServletRequest;

/**
 * 信息：李倍存 创建于 2015/11/16 13:06。电邮 1174751315@qq.com。<br>
 * 说明：
 */
public class MyFormAuthenicationFilter extends FormAuthenticationFilter {
    public MyFormAuthenicationFilter() {
    }

//    @Override
//    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
//
//        IPsoEmployee employee = DAOFactoryHWATT.getInstance().getDaoIPsoEmployee().query(Integer.valueOf(subject.getPrincipal().toString()));
//        if (employee == null){
//            throw new AppUnCheckException("数据库中不存在对应当前工号的记录。");
//        }
//        String ps = subject.getPrincipal().toString();
//        String ps2 = subject.getPrincipals().toString();
//        return super.onLoginSuccess(token, subject, request, response);
//    }

    @Override
    protected String getUsername(ServletRequest request) {

        String userName = IPsoUserHelper.getEmployeeName(WebUtils.getCleanParam(request, getUsernameParam()),"ISO-8859-1","UTF-8");
        return userName;

    }
}
