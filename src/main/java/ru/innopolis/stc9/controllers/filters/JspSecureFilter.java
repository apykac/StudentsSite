package ru.innopolis.stc9.controllers.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JspSecureFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //some comment
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (((HttpServletRequest)request).getServletPath().equals("/index.jsp")) {
            chain.doFilter(request,response);
        } else {
            ((HttpServletResponse)response).sendRedirect(((HttpServletRequest)request).getContextPath() + "/defaultmenu");
        }
    }

    @Override
    public void destroy() {
        //some comment
    }
}
