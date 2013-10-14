package com.cn.thu.web;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: wangjiayu
 * Date: 13-6-17
 * Time: 上午11:14
 * To change this template use File | Settings | File Templates.
 */
public class CharsetEncodingFilter implements Filter {
    private String charEncode = null;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.charEncode = filterConfig.getInitParameter("charEncode");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding(charEncode);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }
}
