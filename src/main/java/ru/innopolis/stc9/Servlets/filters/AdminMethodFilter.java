package ru.innopolis.stc9.Servlets.filters;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.Servlets.ConstantContainer;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminMethodFilter implements Filter {
    private static Logger logger = Logger.getLogger(AdminMethodFilter.class);

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
            if ((Integer) req.getSession().getAttribute(ConstantContainer.ROLE) != 1) {
                resp.sendRedirect(req.getContextPath() + "/error?error_message=permissionError");
                return;
            }
            switch (param) {
                case "add_student":
                    req.getRequestDispatcher("/method/add_student.jsp").forward(req, resp);
                    return;
                case "del_student":
                    req.getRequestDispatcher("/method/del_student.jsp").forward(req, resp);
                    return;
                case "add_course":
                    req.getRequestDispatcher("/method/add_course.jsp").forward(req, resp);
                    return;
                case "del_course":
                    req.getRequestDispatcher("/method/del_course.jsp").forward(req, resp);
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
