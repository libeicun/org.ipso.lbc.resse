/*
 * 版权所有 (c) 2015 。 李倍存 （iPso）。
 * 所有者对该文件所包含的代码的正确性、执行效率等任何方面不作任何保证。
 * 所有个人和组织均可不受约束地将该文件所包含的代码用于非商业用途。若需要将其用于商业软件的开发，请首先联系所有者以取得许可。
 */

package org.ipso.lbc.resseorg.dao;

import org.ipso.lbc.common.utils.DateUtil;
import org.ipso.lbc.common.utils.datetime.SimpleTime;
import org.ipso.lbc.common.utils.datetime.SimpleTimePeriod;
import org.ipso.lbc.resseorg.domain.BusinessTripRecord;

import static org.junit.Assert.*;

public class DAOBusinessTripRecordTest {

    @org.junit.Test
    public void testInsertOrUpdate() throws Exception {

        DAOFactoryLocal.getInstance().getDaoBusinessTripRecord().insertOrUpdate(new BusinessTripRecord(204,"李倍存","2015-11-15",new SimpleTimePeriod(new SimpleTime(8,0,0),new SimpleTime(12,0,0)), DateUtil.getNowDateTime()));
    }
}