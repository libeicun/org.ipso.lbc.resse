 /*
 * 版权所有 (c) 2015 。 李倍存 （iPso）。
 * 所有者对该文件所包含的代码的正确性、执行效率等任何方面不作任何保证。
 * 所有个人和组织均可不受约束地将该文件所包含的代码用于非商业用途。若需要将其用于商业软件的开发，请首先联系所有者以取得许可。
 */

package org.ipso.lbc.resseorg.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ThreadContext;
import org.apache.shiro.web.mgt.WebSecurityManager;
import org.ipso.lbc.common.dao.DAOStudent;
import org.ipso.lbc.common.domain.Student;
import org.ipso.lbc.resseorg.dao.DAOFactoryMain;
import org.ipso.lbc.resseorg.dao.DAOLessonRecord;
import org.ipso.lbc.resseorg.domain.LessonRecord;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 信息：李倍存 创建于 2015/10/24 21:24。电邮 1174751315@qq.com。<br>
 * 说明：
 */
public class UpdateLessonRecordAction extends ActionSupport {


    public UpdateLessonRecordAction() {
    }

    private Integer minutes;
    private Integer times;
    private String id = "未指定";
    private String name;
    private String info = "";

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWarning() {
        return warning;
    }

    public void setWarning(String warning) {
        this.warning = warning;
    }

    private String warning="OK";

    public Integer getMinutes() {
        return minutes;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }


    private String warn(String info){
        warning = info;
        return SUCCESS;
    }

    @Override
    public String execute() throws Exception {

        try {
//            DAOStudent daoStudent = DAOFactoryMain.getInstance().getDaoStudent();
            DAOLessonRecord daoLessonRecord = DAOFactoryMain.getInstance().getDaoLessonRecord();

            LessonRecord currentRecord = daoLessonRecord.queryByStudentName(name);
            if (currentRecord == null){
                return warn("没有找到您的姓名，请联系纪委同学。");
            }
//            Subject user = SecurityUtils.getSubject();
//            Boolean isAdm = user.hasRole("adm");
//            Boolean isUser = user.hasRole("user");
//            Student currentStudent = daoStudent.query(id);



//        if (currentStudent == null){
//            return warn("没有找到您的信息，请检查学号是否正确。");
//        }
//            if (!currentStudent.getStudentName().equals(name)){
//                return warn("您输入的的学号和姓名不匹配，请重新键入正确的信息。");
//            }

            LessonRecord record = new LessonRecord(currentRecord.getStudentId(),currentRecord.getName(),minutes,times,info,new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
            daoLessonRecord.insertOrUpdate(record);

//        String username = subject.getPrincipal().toString();
//        DAOLessonRecord daoLessonRecord = DAOFactoryMain.getInstance().getDaoLessonRecord();
//
//        LessonRecord record = new LessonRecord(new Student(subject.getPrincipal().toString(),"UNNAMED"),minutes,times);
//
//        daoLessonRecord.insertOrUpdate(record);
//
            return SUCCESS;
        } catch (Exception e) {
            return warn("服务器软件发生未知错误，请联系李倍存。");
        }
    }
}
