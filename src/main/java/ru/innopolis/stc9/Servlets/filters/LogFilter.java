package ru.innopolis.stc9.Servlets.filters;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.Servlets.ConstantContainer;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * ФИльтр логирования, при любых обращениях все записывает в консоль
 */
public class LogFilter implements Filter {
    private static Logger logger = Logger.getLogger(LogFilter.class);
    @Override
    public void init(FilterConfig filterConfig) {
        //some comment
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain){
        try {
            if ((request == null) || (response == null) || (chain) == null) throw new IOException();
            HttpServletRequest req = (HttpServletRequest) request;
            logger.info("Servlet Path: " + req.getServletPath() +" @ URL: "+ req.getRequestURL());
            request.setCharacterEncoding(ConstantContainer.UTF8);
            response.setCharacterEncoding(ConstantContainer.UTF8);
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
