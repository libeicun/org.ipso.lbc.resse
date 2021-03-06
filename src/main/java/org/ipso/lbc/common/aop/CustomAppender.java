/*
 * 版权所有 (c) 2015 。 李倍存 （iPso）。
 * 所有者对该文件所包含的代码的正确性、执行效率等任何方面不作任何保证。
 * 所有个人和组织均可不受约束地将该文件所包含的代码用于非商业用途。若需要将其用于商业软件的开发，请首先联系所有者以取得许可。
 */

package org.ipso.lbc.common.aop;

import org.apache.log4j.Priority;
import org.apache.log4j.RollingFileAppender;

/**
 * 李倍存 创建于 2015-03-25 13:37。电邮 1174751315@qq.com。
 */
public class CustomAppender extends RollingFileAppender {

    @Override
    public boolean isAsSevereAsThreshold(Priority priority) {

//        return super.isAsSevereAsThreshold(priority);
//
//        return this.getThreshold().equals(priority);
        return priority.equals(this.getThreshold());
    }

}
