/*
 * 版权所有 (c) 2015 。 李倍存 （iPso）。
 * 所有者对该文件所包含的代码的正确性、执行效率等任何方面不作任何保证。
 * 所有个人和组织均可不受约束地将该文件所包含的代码用于非商业用途。若需要将其用于商业软件的开发，请首先联系所有者以取得许可。
 */

package org.ipso.lbc.common.utils.datetime;

/**
 * 信息：李倍存 创建于 2015/11/13 9:55。电邮 1174751315@qq.com。<br>
 * 说明：
 */
public class SimpleTimePeriod {
    public SimpleTimePeriod() {
    }

    private String name = "";
    public SimpleTime start;


    public SimpleTime getOverlap(SimpleTimePeriod anotherTimePeriod){
        if (this.start.isBefore(anotherTimePeriod.start) && this.end.isBefore(anotherTimePeriod.end) && anotherTimePeriod.start.isBefore(this.end)){
            return this.end.getBefore(anotherTimePeriod.start);
        }
        if (anotherTimePeriod.start.isBefore(this.start) && anotherTimePeriod.end.isBefore(this.end) && this.start.isBefore(anotherTimePeriod.end)){
            return anotherTimePeriod.end.getBefore(this.start);
        }
        if (anotherTimePeriod.start.isBefore(this.start) && this.end.isBefore(anotherTimePeriod.end)){
            return this.end.getBefore(this.start);
        }
        if (this.start.isBefore(anotherTimePeriod.start) && anotherTimePeriod.end.isBefore(this.end)){
            return anotherTimePeriod.end.getBefore(anotherTimePeriod.start);
        }
        return new SimpleTime(0);
    }


    public SimpleTime getPeriod(){
        return new SimpleTime(end.getTotalSecond() - start.getTotalSecond());
    }

    public String getName() {
        return name;
    }

    public SimpleTimePeriod(SimpleTime start, SimpleTime end) {
        this.end = end;
        this.start = start;
    }
    public SimpleTimePeriod(SimpleTime start, SimpleTime end,String name) {
        this(start,end);
        this.name = name;
    }
    public SimpleTime end;

    public SimpleTime getEnd() {
        return end;
    }

    public void setEnd(SimpleTime end) {
        this.end = end;
    }

    public SimpleTime getStart() {
        return start;
    }

    public void setStart(SimpleTime start) {
        this.start = start;
    }




    public static SimpleTimePeriod PERIOD_AM_0 = new SimpleTimePeriod(new SimpleTime(7,50,0),new SimpleTime(10,10,0),"上午1大节");
    public static SimpleTimePeriod PERIOD_AM_1 = new SimpleTimePeriod(new SimpleTime(10,30,0),new SimpleTime(12,0,0),"上午2大节");
    public static SimpleTimePeriod PERIOD_PM = new SimpleTimePeriod(new SimpleTime(14,40,0),new SimpleTime(17,0,0),"下午");
    public static SimpleTimePeriod PERIOD_EV = new SimpleTimePeriod(new SimpleTime(19,40,0),new SimpleTime(22,0,0),"晚间");

}
