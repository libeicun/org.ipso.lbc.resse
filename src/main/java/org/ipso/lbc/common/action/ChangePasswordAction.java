 /*
 * 版权所有 (c) 2015 。 李倍存 （iPso）。
 * 所有者对该文件所包含的代码的正确性、执行效率等任何方面不作任何保证。
 * 所有个人和组织均可不受约束地将该文件所包含的代码用于非商业用途。若需要将其用于商业软件的开发，请首先联系所有者以取得许可。
 */

package org.ipso.lbc.common.action;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.ipso.lbc.common.adm.UserUtils;
import org.ipso.lbc.common.dao.DAOUser;
import org.ipso.lbc.common.exception.handler.ExceptionInfoPrintingHelper;
import org.ipso.lbc.resseorg.dao.DAOFactory;
import org.ipso.lbc.resseorg.dao.DAOFactoryLocal;

 /**
  * 信息：李倍存 创建于 2015/10/24 21:24。电邮 1174751315@qq.com。<br>
  * 说明：
  */
 public class ChangePasswordAction extends CommonAjaxAction {

     private String warning="OK";

     @Override
     protected void setWarningInfo(String info) {
         warning = info;
     }

     public String getWarning() {
         return warning;
     }

     public void setWarning(String warning) {
         this.warning = warning;
     }

     public ChangePasswordAction() {
     }

     private String newPassword;

     public String getNewPassword() {
         return newPassword;
     }

     public void setNewPassword(String newPassword) {
         this.newPassword = newPassword;
     }

     @Override
     public String execute() throws Exception {
         try {
             DAOUser daoUser = DAOFactoryLocal.getInstance().getDaoUser();

             Subject user = SecurityUtils.getSubject();

             UserUtils.setPassword(daoUser,user.getPrincipal().toString(),newPassword);

             user.logout();

            daoUser.getSuperDAO().getSession().flush();

             return SUCCESS;
         } catch (Exception e) {
             return warn("修改密码失败。\n" + ExceptionInfoPrintingHelper.getStackTraceInfo(e));
         }
     }
 }
