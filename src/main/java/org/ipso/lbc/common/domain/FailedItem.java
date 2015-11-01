/*
 * 版权所有 (c) 2015 。 李倍存 （iPso）。
 * 所有者对该文件所包含的代码的正确性、执行效率等任何方面不作任何保证。
 * 所有个人和组织均可不受约束地将该文件所包含的代码用于非商业用途。若需要将其用于商业软件的开发，请首先联系所有者以取得许可。
 */

package org.ipso.lbc.common.domain;

/**
 * 信息：李倍存 创建于 2015-10-07 05:34 PM。电邮 1174751315@qq.com。<br>
 * 说明：
 */
public class FailedItem {
    public FailedItem() {
    }


    private FailedType type;
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public FailedType getType() {
        return type;
    }

    public void setType(FailedType type) {
        this.type = type;
    }

    private String params;
    private String time;

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
