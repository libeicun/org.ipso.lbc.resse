/*
 * 版权所有 (c) 2015 。 李倍存 （iPso）。
 * 所有者对该文件所包含的代码的正确性、执行效率等任何方面不作任何保证。
 * 所有个人和组织均可不受约束地将该文件所包含的代码用于非商业用途。若需要将其用于商业软件的开发，请首先联系所有者以取得许可。
 */

package org.ipso.lbc.resseorg.domain;

import java.io.Serializable;

/**
 * 信息：李倍存 创建于 2015/11/15 9:33。电邮 1174751315@qq.com。<br>
 * 说明：
 */
public class IPsoEmployee implements Serializable {
    public String getAPOSITION() {
        return APOSITION;
    }

    public void setAPOSITION(String APOSITION) {
        this.APOSITION = APOSITION;
    }

    public String getBEGINATTDATE() {
        return BEGINATTDATE;
    }

    public void setBEGINATTDATE(String BEGINATTDATE) {
        this.BEGINATTDATE = BEGINATTDATE;
    }

    public String getBirthday() {
        return Birthday;
    }

    public void setBirthday(String birthday) {
        Birthday = birthday;
    }

    public Long getBrchID() {
        return BrchID;
    }

    public void setBrchID(Long brchID) {
        BrchID = brchID;
    }

    public String getBrchName() {
        return BrchName;
    }

    public void setBrchName(String brchName) {
        BrchName = brchName;
    }

    public Integer getCanOvertime() {
        return CanOvertime;
    }

    public void setCanOvertime(Integer canOvertime) {
        CanOvertime = canOvertime;
    }

    public String getCardCode() {
        return CardCode;
    }

    public void setCardCode(String cardCode) {
        CardCode = cardCode;
    }

    public String getCheckType() {
        return CheckType;
    }

    public void setCheckType(String checkType) {
        CheckType = checkType;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public Integer getDevType() {
        return DevType;
    }

    public void setDevType(Integer devType) {
        DevType = devType;
    }

    public String getDEVTYPESTR() {
        return DEVTYPESTR;
    }

    public void setDEVTYPESTR(String DEVTYPESTR) {
        this.DEVTYPESTR = DEVTYPESTR;
    }

    public String getEDUCATION() {
        return EDUCATION;
    }

    public void setEDUCATION(String EDUCATION) {
        this.EDUCATION = EDUCATION;
    }

    public String getEmployeeCode() {
        return EmployeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        EmployeeCode = employeeCode;
    }

    public Integer getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        EmployeeID = employeeID;
    }

    public String getEmployeeLogPwd() {
        return EmployeeLogPwd;
    }

    public void setEmployeeLogPwd(String employeeLogPwd) {
        EmployeeLogPwd = employeeLogPwd;
    }

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String employeeName) {
        EmployeeName = employeeName;
    }

    public String getENDATTDATE() {
        return ENDATTDATE;
    }

    public void setENDATTDATE(String ENDATTDATE) {
        this.ENDATTDATE = ENDATTDATE;
    }

    public String getEnrollDate() {
        return EnrollDate;
    }

    public void setEnrollDate(String enrollDate) {
        EnrollDate = enrollDate;
    }

    public Integer getGender() {
        return Gender;
    }

    public void setGender(Integer gender) {
        Gender = gender;
    }

    public String getGraduation() {
        return Graduation;
    }

    public void setGraduation(String graduation) {
        Graduation = graduation;
    }

    public Integer getHaveFesta() {
        return HaveFesta;
    }

    public void setHaveFesta(Integer haveFesta) {
        HaveFesta = haveFesta;
    }

    public Integer getHavePwd() {
        return HavePwd;
    }

    public void setHavePwd(Integer havePwd) {
        HavePwd = havePwd;
    }

    public String getHDCPInfo() {
        return HDCPInfo;
    }

    public void setHDCPInfo(String HDCPInfo) {
        this.HDCPInfo = HDCPInfo;
    }

    public String getHealth() {
        return Health;
    }

    public void setHealth(String health) {
        Health = health;
    }

    public String getIDCard() {
        return IDCard;
    }

    public void setIDCard(String IDCard) {
        this.IDCard = IDCard;
    }

    public Integer getIsCheck() {
        return IsCheck;
    }

    public void setIsCheck(Integer isCheck) {
        IsCheck = isCheck;
    }

    public Integer getLastCardID() {
        return LastCardID;
    }

    public void setLastCardID(Integer lastCardID) {
        LastCardID = lastCardID;
    }

    public String getMARITALSTATUS() {
        return MARITALSTATUS;
    }

    public void setMARITALSTATUS(String MARITALSTATUS) {
        this.MARITALSTATUS = MARITALSTATUS;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public Integer getModelNum() {
        return ModelNum;
    }

    public void setModelNum(Integer modelNum) {
        ModelNum = modelNum;
    }

    public String getNation() {
        return Nation;
    }

    public void setNation(String nation) {
        Nation = nation;
    }

    public String getNATIVEPLACE() {
        return NATIVEPLACE;
    }

    public void setNATIVEPLACE(String NATIVEPLACE) {
        this.NATIVEPLACE = NATIVEPLACE;
    }

    public Integer getOffRule() {
        return OffRule;
    }

    public void setOffRule(Integer offRule) {
        OffRule = offRule;
    }

    public Integer getOnRule() {
        return OnRule;
    }

    public void setOnRule(Integer onRule) {
        OnRule = onRule;
    }

    public String getOpendoorType() {
        return OpendoorType;
    }

    public void setOpendoorType(String opendoorType) {
        OpendoorType = opendoorType;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String photo) {
        Photo = photo;
    }

    public String getPrivilege() {
        return Privilege;
    }

    public void setPrivilege(String privilege) {
        Privilege = privilege;
    }

    public String getRealEmployeeCode() {
        return RealEmployeeCode;
    }

    public void setRealEmployeeCode(String realEmployeeCode) {
        RealEmployeeCode = realEmployeeCode;
    }

    public Integer getRegisterType() {
        return RegisterType;
    }

    public void setRegisterType(Integer registerType) {
        RegisterType = registerType;
    }

    public String getReserved1() {
        return Reserved1;
    }

    public void setReserved1(String reserved1) {
        Reserved1 = reserved1;
    }

    public String getReserved2() {
        return Reserved2;
    }

    public void setReserved2(String reserved2) {
        Reserved2 = reserved2;
    }

    public String getReserved3() {
        return Reserved3;
    }

    public void setReserved3(String reserved3) {
        Reserved3 = reserved3;
    }

    public String getReserved4() {
        return Reserved4;
    }

    public void setReserved4(String reserved4) {
        Reserved4 = reserved4;
    }

    public String getSchool() {
        return School;
    }

    public void setSchool(String school) {
        School = school;
    }

    public Integer getStaffStatus() {
        return StaffStatus;
    }

    public void setStaffStatus(Integer staffStatus) {
        StaffStatus = staffStatus;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getWorkPhone() {
        return WorkPhone;
    }

    public void setWorkPhone(String workPhone) {
        WorkPhone = workPhone;
    }

    public String getZhengZhi() {
        return ZhengZhi;
    }

    public void setZhengZhi(String zhengZhi) {
        ZhengZhi = zhengZhi;
    }

    String ZhengZhi;
    String WorkPhone;
    String Title;
    Integer StaffStatus;
    String School;
    String Reserved4;
    String Reserved3;
    String Reserved2;
    String Reserved1;
    Integer RegisterType;
    String RealEmployeeCode;
    String Privilege;
    String Photo;
    String OpendoorType;
    Integer OnRule;
    Integer OffRule;
    String NATIVEPLACE;
    String Nation;
    Integer ModelNum;
    String Mobile;
    String MARITALSTATUS;
    Integer LastCardID;
    Integer IsCheck;
    String IDCard;
    String Health;
    String HDCPInfo;
    Integer HavePwd;
    Integer HaveFesta;
    String Graduation;
    Integer Gender;
    String EnrollDate;
    String ENDATTDATE;
    String EmployeeName;
    String EmployeeLogPwd;
    Integer EmployeeID;
    String EmployeeCode;
    String EDUCATION;
    String DEVTYPESTR;
    Integer DevType;
    String Comment;
    String CheckType;
    String CardCode;
    Integer CanOvertime;
    String BrchName;
    Long BrchID;
    String Birthday;
    String BEGINATTDATE;
    String APOSITION;

}

