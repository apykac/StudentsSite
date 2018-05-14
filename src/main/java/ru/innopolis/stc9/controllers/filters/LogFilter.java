package ru.innopolis.stc9.controllers.filters;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class LogFilter implements Filter {
    private static Logger logger = Logger.getLogger(LogFilter.class);
    @Override
    public void init(FilterConfig filterConfig) {
        //some comment
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain){
        HttpServletRequest req = (HttpServletRequest) request;
        logger.info("Servlet Path: " + req.getServletPath() +" @ URL: "+ req.getRequestURL());
        try {
            chain.doFilter(request,response);
        } catch (IOException|ServletException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public void destroy() {
        //some comment
    }
}
