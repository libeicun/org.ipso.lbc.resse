/*
 * 版权所有 (c) 2015 。 李倍存 （iPso）。
 * 所有者对该文件所包含的代码的正确性、执行效率等任何方面不作任何保证。
 * 所有个人和组织均可不受约束地将该文件所包含的代码用于非商业用途。若需要将其用于商业软件的开发，请首先联系所有者以取得许可。
 */

package org.ipso.lbc.resseorg.dao;

import org.ipso.lbc.common.db.dao.AbstractDAO;
import org.ipso.lbc.common.db.dao.SuperDAO;
import org.ipso.lbc.resseorg.domain.CardTimeRecord;
import org.ipso.lbc.resseorg.domain.IPsoEmployee;

import java.util.LinkedList;
import java.util.List;

/**
 * 信息：李倍存 创建于 2015/10/19 11:24。电邮 1174751315@qq.com。<br>
 * 说明：
 */
public class DAOIPsoEmployee extends AbstractDAO {
    public DAOIPsoEmployee(SuperDAO superDAO) {
        this.superDAO = superDAO;
    }

    public IPsoEmployee query(String name){
        List list = superDAO.query("from IPsoEmployee where EmployeeName = ?",name);
        if (list.size()==0)
        {
            return null;
        }
        return (IPsoEmployee) list.get(0);
    }

    public IPsoEmployee query(Integer id){
        return (IPsoEmployee) superDAO.query(IPsoEmployee.class,id);
    }

}
