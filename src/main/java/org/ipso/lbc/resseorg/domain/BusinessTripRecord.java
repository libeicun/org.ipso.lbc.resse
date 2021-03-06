/*
 * 版权所有 (c) 2015 。 李倍存 （iPso）。
 * 所有者对该文件所包含的代码的正确性、执行效率等任何方面不作任何保证。
 * 所有个人和组织均可不受约束地将该文件所包含的代码用于非商业用途。若需要将其用于商业软件的开发，请首先联系所有者以取得许可。
 */

package org.ipso.lbc.resseorg.domain;

import org.ipso.lbc.common.utils.datetime.SimpleTimePeriod;

import java.io.Serializable;

/**
 * 信息：李倍存 创建于 2015/11/15 9:23。电邮 1174751315@qq.com。<br>
 * 说明：
 */
public class BusinessTripRecord implements Serializable {
    private Integer employeeId;
    private String name;
    private String startTime;
    private String endTime;
    private String updateDate;

    public BusinessTripRecord() {
    }

    public BusinessTripRecord(Integer employeeId, String name, String startTime, String endTime,String updateDate) {
        this.employeeId = employeeId;
        this.endTime = endTime;
        this.name = name;
        this.startTime = startTime;
        this.updateDate = updateDate;
    }


    public BusinessTripRecord(Integer employeeId, String name, String date, SimpleTimePeriod period,String updateDate) {
        this(employeeId,name,date + " " + period.start.toString(),date + " " + period.end.toString(),updateDate);
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
}
