/*
 * 版权所有 (c) 2015 。 李倍存 （iPso）。
 * 所有者对该文件所包含的代码的正确性、执行效率等任何方面不作任何保证。
 * 所有个人和组织均可不受约束地将该文件所包含的代码用于非商业用途。若需要将其用于商业软件的开发，请首先联系所有者以取得许可。
 */

package org.ipso.lbc.resseorg.domain;

import org.ipso.lbc.common.domain.Student;

import java.io.Serializable;

/**
 * 信息：李倍存 创建于 2015/10/19 10:33。电邮 1174751315@qq.com。<br>
 * 说明：
 */
public class LessonRecord implements Serializable{
    /**
     * 应减去的迟到次数。
     */
    private Integer lateTimesToSubtract;
    /**
     * 应加上的上课分钟数。
     */
    private Integer minutesToAdd;

    private String studentId;
    private String name;
    private String info;
    private String updateTime;

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public LessonRecord() {
    }

    public Boolean validate(){
        return true;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public LessonRecord(String studentId,  String name, Integer minutesToAdd, Integer lateTimesToSubtract,String info,String updateTime) {
        this.studentId = studentId;
        this.lateTimesToSubtract = lateTimesToSubtract;
        this.minutesToAdd = minutesToAdd;
        this.name = name;
        this.info = info;
        this.updateTime = updateTime;

    }

    public Integer getLateTimesToSubtract() {
        return lateTimesToSubtract;
    }

    public void setLateTimesToSubtract(Integer lateTimesToSubtract) {
        this.lateTimesToSubtract = lateTimesToSubtract;
    }

    public Integer getMinutesToAdd() {
        return minutesToAdd;
    }

    public void setMinutesToAdd(Integer minutesToAdd) {
        this.minutesToAdd = minutesToAdd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}
