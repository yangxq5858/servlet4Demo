package com.hx.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author yangxinqiang
 * @content
 * @create 2018-09-27 13:56
 * 用于过滤请求的
 */
public class UserFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("UserFilter....init...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("UserFilter....doFilter");

        //放行请求
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("UserFilter....destroy...");
    }
}
