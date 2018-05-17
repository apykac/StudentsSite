package ru.innopolis.stc9.Servlets.filters;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.Servlets.ConstantContainer;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserMethodFilter implements Filter {
    private static Logger logger = Logger.getLogger(UserMethodFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //some comment
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        try {
            req.setCharacterEncoding(ConstantContainer.UTF8);
            resp.setCharacterEncoding(ConstantContainer.UTF8);
            String param = req.getParameter("method");
            if ((Integer) req.getSession().getAttribute(ConstantContainer.ROLE) > 2) {
                resp.sendRedirect(req.getContextPath() + "/error?error_message=permissionError");
                return;
            }
            switch (param) {
                case "get_students":
                    req.getRequestDispatcher("/method/get_students.jsp").forward(req, resp);
                    return;
                case "get_courses":
                    req.getRequestDispatcher("/method/get_courses.jsp").forward(req, resp);
                    return;
            }
        } catch (IOException | ServletException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public void destroy() {
        //some comment
    }
}
