/*
 * 版权所有 (c) 2015 。 李倍存 （iPso）。
 * 所有者对该文件所包含的代码的正确性、执行效率等任何方面不作任何保证。
 * 所有个人和组织均可不受约束地将该文件所包含的代码用于非商业用途。若需要将其用于商业软件的开发，请首先联系所有者以取得许可。
 */

package org.ipso.lbc.resseorg.utils;

import org.ipso.lbc.resseorg.dao.DAOFactoryHWATT;
import org.ipso.lbc.resseorg.domain.IPsoEmployee;

import java.nio.charset.Charset;

/**
 * 信息：李倍存 创建于 2015/11/16 13:44。电邮 1174751315@qq.com。<br>
 * 说明：
 */
public class IPsoUserHelper {
    private static DAOFactoryHWATT daoFactoryHWATT = DAOFactoryHWATT.getInstance();
    public static String getEmployeeName(String employeeIdOrName,String srcEncoding,String targetEncoding){
        try {
            Integer id = Integer.valueOf(employeeIdOrName);
            return getEmployeeName(id);
        } catch (NumberFormatException e) {
            return new String(employeeIdOrName.getBytes(Charset.forName(srcEncoding)),Charset.forName(targetEncoding));
        }

    }

    public static String getEmployeeName(Integer employeeId){
        IPsoEmployee employee = daoFactoryHWATT.getDaoIPsoEmployee().query(employeeId);
        if (employee==null){
            return "invalid";
        }
        return employee.getEmployeeName();
    }
}
