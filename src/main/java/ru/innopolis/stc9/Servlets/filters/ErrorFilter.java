package ru.innopolis.stc9.Servlets.filters;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.Servlets.ConstantContainer;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ErrorFilter implements Filter {
    private static Logger logger = Logger.getLogger(ErrorFilter.class);

    @Override
    public void init(FilterConfig filterConfig) {
        //some comment
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain){
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        try {
            req.setCharacterEncoding(ConstantContainer.UTF8);
            resp.setCharacterEncoding(ConstantContainer.UTF8);
            req.getRequestDispatcher(
                    "/error_page.jsp?error_message=" + req.getParameter("error_message")).forward(req, resp);
        } catch (IOException | ServletException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public void destroy() {
        //some comment
    }
}
