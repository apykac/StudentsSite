package ru.innopolis.stc9.Servlets.filters;

import ru.innopolis.stc9.Servlets.ConstantContainer;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainPagesFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //some comment
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        req.setCharacterEncoding(ConstantContainer.UTF8);
        resp.setCharacterEncoding(ConstantContainer.UTF8);
        Integer role = (Integer) req.getSession().getAttribute(ConstantContainer.ROLE);
        String servletPath = req.getServletPath();
        switch (servletPath) {
            case "/admin_page":
                if ((role != null) && (role == 1)) {
                    req.getRequestDispatcher("/admin_page.jsp").forward(req, resp);
                    return;
                }
                break;
            case "/user_page":
                if ((role != null) && (role < 3)) {
                    req.getRequestDispatcher("/user_page.jsp").forward(req, resp);
                    return;
                }
                break;
            case "/guest_page":
                if ((role != null) && (role != 3)) {
                    resp.sendRedirect(req.getContextPath() + "/defaultmenu");
                    return;
                }
                else {
                    req.getRequestDispatcher("/guest_page.jsp").forward(req, resp);
                    return;
                }
        }
        resp.sendRedirect(req.getContextPath() + "/error?error_message=permissionError");
    }

    @Override
    public void destroy() {
        //some comment
    }
}
