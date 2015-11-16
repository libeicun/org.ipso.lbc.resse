/*
 * 版权所有 (c) 2015 。 李倍存 （iPso）。
 * 所有者对该文件所包含的代码的正确性、执行效率等任何方面不作任何保证。
 * 所有个人和组织均可不受约束地将该文件所包含的代码用于非商业用途。若需要将其用于商业软件的开发，请首先联系所有者以取得许可。
 */

package org.ipso.lbc.common.utils.datetime;

import org.ipso.lbc.common.exception.AppUnCheckException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 信息：李倍存 创建于 2015/11/13 9:51。电邮 1174751315@qq.com。<br>
 * 说明：
 */
public class SimpleTime {
    public Integer hour =0;
    public Integer minute =0;
    public Integer second =0;

    private Integer totalSecond =0;

    public Integer getTotalSecond() {
        return totalSecond;
    }
    public SimpleTime getBefore(SimpleTime time){
        return new SimpleTime(this.getTotalSecond() - time.getTotalSecond());
    }
    public SimpleTime getAfter(SimpleTime time){
        return new SimpleTime(this.getTotalSecond() + time.getTotalSecond());
    }
    public boolean isBefore(SimpleTime anotherTime){
        return this.getTotalSecond() <= anotherTime.getTotalSecond();
    }
    public boolean isBetween(SimpleTime t1, SimpleTime t2){
        Integer s1 = t1.getTotalSecond();
        Integer s2 = t2.getTotalSecond();
        Integer s = this.getTotalSecond();
        return (s1 <= s && s <=s2)||(s1>=s && s>=s2);
    }







    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
        updateTotalS();
    }

    public Integer getMinute() {
        return minute;
    }

    public void setMinute(Integer minute) {
        this.minute = minute;
        updateTotalS();
    }

    public Integer getSecond() {
        return second;
    }

    public void setSecond(Integer second) {
        this.second = second;
        updateTotalS();
    }

    public SimpleTime(Integer hour, Integer minute, Integer second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        updateTotalS();
    }
    public SimpleTime(Integer totalSecond){
        this.totalSecond = totalSecond;
        this.hour = totalSecond/3600;
        this.minute = (totalSecond%3600)/60;
        this.second = (totalSecond%3600)%60;
    }

    public SimpleTime(String format){
        this(Integer.valueOf(format.substring(11,13)),Integer.valueOf(format.substring(14,16)),Integer.valueOf(format.substring(17,19)));
    }

    private void updateTotalS(){
        totalSecond = this.hour *3600 + this.minute *60 + this.second;
    }


    public String toString(){
        return hour+":"+minute+":"+second;
    }

}
