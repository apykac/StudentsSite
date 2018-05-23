package ru.innopolis.stc9.Servlets.filters;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.Servlets.ConstantContainer;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Фильтр проверки прав доступа поситителей на главные страницы сайта, определяет права доступа и перенаправляет на нужную страницу
 */
public class LoginValidFilter implements Filter {
    private static Logger logger = Logger.getLogger(LoginValidFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //some comment
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
        try {
            if ((request == null) || (response == null) || (chain) == null) throw new IOException();
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse resp = (HttpServletResponse) response;
            HttpSession httpSession = (req).getSession();
            req.setCharacterEncoding(ConstantContainer.UTF8);
            resp.setCharacterEncoding(ConstantContainer.UTF8);
            Integer role = (Integer) httpSession.getAttribute(ConstantContainer.ROLE);
            switch (role) {
                case 1:
                    resp.sendRedirect(req.getContextPath() + "/admin_page");
                    break;
                case 2:
                    resp.sendRedirect(req.getContextPath() + "/user_page");
                    break;
                default:
                    resp.sendRedirect(req.getContextPath() + "/guest_page");
                    break;
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public void destroy() {
        //some comment
    }
}
