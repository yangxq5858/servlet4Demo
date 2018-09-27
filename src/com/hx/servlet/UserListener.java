package com.hx.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author yangxinqiang
 * @create 2018-09-27 14:02
 * 用于监听项目的启动和停止
 *
 */
public class UserListener implements ServletContextListener {

    //监听ServletContext启动和初始化
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        System.out.println("ServletContext启动和初始化...");
    }


    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContext销废...");
    }
}
