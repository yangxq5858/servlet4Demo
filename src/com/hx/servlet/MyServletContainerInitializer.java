package com.hx.servlet;

import com.hx.service.IHelloService;

import javax.servlet.*;
import javax.servlet.annotation.HandlesTypes;
import java.util.EnumSet;
import java.util.Set;

/**
 * @author yangxinqiang
 * @create 2018-09-27 10:17
 *
 * Servlet容器一启动的时候，就会运行onStartup方法
 *
 *ServletContext： 一个web对应一个ServletContext。
 *Set<Class<?>> 是用来接收@HandleTypes中传入的类型对象（实现类，子接口等）
 *
 */


//容器启动时会将这些类型下面的子类（实现类、子接口等）传递进去，注意：接口本身或类本身不会传递
@HandlesTypes(value = {IHelloService.class})
public class MyServletContainerInitializer implements javax.servlet.ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        for (Class<?> aClass : set) {
            System.out.println("加载的的类"+aClass);
        }

        //添加第三方的Servlet
        ServletRegistration.Dynamic userServlet = servletContext.addServlet("UserServlet", UserServlet.class);
        //配置映射信息
        userServlet.addMapping("/user");


        FilterRegistration.Dynamic userFilter = servletContext.addFilter("UserFilter", UserFilter.class);

        //配置Filter的映射信息
        userFilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST),true,"/*");

        //监听器注册
        servletContext.addListener(UserListener.class);
    }
}
