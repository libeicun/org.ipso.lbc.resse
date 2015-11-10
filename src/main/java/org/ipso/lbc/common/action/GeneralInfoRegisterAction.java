/*
 * 版权所有 (c) 2015 。 李倍存 （iPso）。
 * 所有者对该文件所包含的代码的正确性、执行效率等任何方面不作任何保证。
 * 所有个人和组织均可不受约束地将该文件所包含的代码用于非商业用途。若需要将其用于商业软件的开发，请首先联系所有者以取得许可。
 */

package org.ipso.lbc.common.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.ipso.lbc.common.db.dao.SuperDAO;
import org.ipso.lbc.common.exception.handler.ExceptionInfoPrintingHelper;
import org.ipso.lbc.common.utils.ResourcePathHelper;
import org.ipso.lbc.common.utils.python.PythonProcessHelper;
import org.ipso.lbc.resseorg.dao.DAOFactoryMain;

/**
 * 信息：李倍存 创建于 2015/11/3 15:31。电邮 1174751315@qq.com。<br>
 * 说明：
 */
public class GeneralInfoRegisterAction  extends CommonAjaxAction{
    public GeneralInfoRegisterAction() {
    }

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

    private String warning="OK";


    String buildInfo(){
        return id+","+name+","+p0+","+p1+","+p2+","+p3+","+p4+","+p5+","+p6+","+p7+","+p8+","+p9+","+p10+","+p11+","+p12+","+p13+","+p14;
    }

    @Override
    public String execute() throws Exception {
        try{
            SuperDAO superDAO = DAOFactoryMain.getInstance().getSuperDAO();
            String sqlDel = "DELETE FROM GENERAL_INFO where UID = ?";
            String sqlIns = "INSERT INTO GENERAL_INFO(UID,NAME,P0,P1,P2,P3,P4,P5,P6,P7,P8,P9,P10,P11,P12,P13,P14) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
            superDAO.excuteUpdate(sqlDel,id);
            superDAO.excuteUpdate(sqlIns,id,name, p0, p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14);

            error(name+ ", " + ServletActionContext.getRequest().getRemoteHost() + " : 成功提交了信息: "+buildInfo());

            return SUCCESS;
        }catch (Exception e){

            info(id+", "+name+" : 操作失败。");
            return warn("提交失败。\n"+ExceptionInfoPrintingHelper.getStackTraceInfo(e));
        }

    }







    private String id="";
    private String name="";

    public String getP0() {
        return p0;
    }

    public void setP0(String p0) {
        this.p0 = p0;
    }

    private String p0="",p1="",p2="",p3="",p4="",p5="",p6="",p7="",p8="",p9="",p10="",p11="",p12="",p13="",p14="";

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

    public String getP10() {
        return p10;
    }

    public void setP10(String p10) {
        this.p10 = p10;
    }

    public String getP11() {
        return p11;
    }

    public void setP11(String p11) {
        this.p11 = p11;
    }

    public String getP12() {
        return p12;
    }

    public void setP12(String p12) {
        this.p12 = p12;
    }

    public String getP13() {
        return p13;
    }

    public void setP13(String p13) {
        this.p13 = p13;
    }

    public String getP14() {
        return p14;
    }

    public void setP14(String p14) {
        this.p14 = p14;
    }

    public String getP1() {
        return p1;
    }

    public void setP1(String p1) {
        this.p1 = p1;
    }

    public String getP2() {
        return p2;
    }

    public void setP2(String p2) {
        this.p2 = p2;
    }

    public String getP3() {
        return p3;
    }

    public void setP3(String p3) {
        this.p3 = p3;
    }

    public String getP4() {
        return p4;
    }

    public void setP4(String p4) {
        this.p4 = p4;
    }

    public String getP5() {
        return p5;
    }

    public void setP5(String p5) {
        this.p5 = p5;
    }

    public String getP6() {
        return p6;
    }

    public void setP6(String p6) {
        this.p6 = p6;
    }

    public String getP7() {
        return p7;
    }

    public void setP7(String p7) {
        this.p7 = p7;
    }

    public String getP8() {
        return p8;
    }

    public void setP8(String p8) {
        this.p8 = p8;
    }

    public String getP9() {
        return p9;
    }

    public void setP9(String p9) {
        this.p9 = p9;
    }
}
