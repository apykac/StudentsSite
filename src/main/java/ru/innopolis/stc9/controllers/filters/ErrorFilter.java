package ru.innopolis.stc9.controllers.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ErrorFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
        //some comment
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain){
        HttpSession httpSession = ((HttpServletRequest) request).getSession();
    }

    @Override
    public void destroy() {
        //some comment
    }
}
