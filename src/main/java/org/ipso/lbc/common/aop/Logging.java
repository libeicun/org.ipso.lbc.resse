/*
 * 版权所有 (c) 2015 。 李倍存 （iPso）。
 * 所有者对该文件所包含的代码的正确性、执行效率等任何方面不作任何保证。
 * 所有个人和组织均可不受约束地将该文件所包含的代码用于非商业用途。若需要将其用于商业软件的开发，请首先联系所有者以取得许可。
 */

package org.ipso.lbc.common.aop;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.ipso.lbc.common.utils.ResourcePathHelper;

import java.net.URL;

/**
 * 信息：李倍存 创建于 2015-03-25 11:41。电邮 1174751315@qq.com。
 * 说明：该类为工厂类/单例，依赖于log4j框架，用于统一封装创建Logger的过程。
 */
public class Logging {
    /**
     * log4j配置文件路径。
     */
    private String res = ResourcePathHelper.getAbsolutePath("") + "log.properties";
    /**
     * log4j配置文件URL，来自res。
     */

    private static Logging instance = new Logging();

    private Logging() {
        /*配置log4j。*/

        PropertyConfigurator.configure(res);
    }

    public static Logging instance() {
        return instance;
    }

    /** 创建一个以name命名的Logger对象。
     * @param name Logger对象的名字，将会显示在日志的首行内。
     * @return Logger对象
     */
    public Logger createLogger(String name) {
        return Logger.getLogger(name);
    }
    public Logger createLogger() {
        return createLogger("默认记录仪");
    }


}
