/*
 * 版权所有 (c) 2015 。 李倍存 （iPso）。
 * 所有者对该文件所包含的代码的正确性、执行效率等任何方面不作任何保证。
 * 所有个人和组织均可不受约束地将该文件所包含的代码用于非商业用途。若需要将其用于商业软件的开发，请首先联系所有者以取得许可。
 */

package org.ipso.lbc.common.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 信息：李倍存 创建于 2015-04-12 11:54。电邮 1174751315@qq.com。
 * 说明：该类用于封装Spring框架的Bean工厂或应用上下文。
 */
 public class BeanFactory implements ServletContextListener{
    /**
     * spring配置文件列表。
     */
    public static final String[] configFileNames = {
            "spring-config.xml",
            "spring-predictors.xml",
            "spring-mail-appcontext.xml",
            "spring-aop.xml",
            "spring-jobs.xml",
            "spring-shiro.xml"
    };

    private static ApplicationContext context=SpringApplicationContextUtil.getContext();

    /**从Spring应用上下文获取一个Bean。
     * @param id 唯一标识该Bean的ID。
     * @return id所指Bean
     */
    public Object getBean(String id) {
        if (!hasInited()){
            init();
        }
        return context.getBean(id);
    }

    /**
     * 初始化Spring应用上下文context。
     */
    private void init(){
        context = new ClassPathXmlApplicationContext(configFileNames, true);
        System.out.println("INIT CONTEXT!");
    }
    private Boolean hasInited(){
        return context!=null;
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        init();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
