package ru.innopolis.stc9.controllers.MethodServlets;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.controllers.ConstantContainer;
import ru.innopolis.stc9.services.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddStudentServlet extends HttpServlet {
    private static Logger logger = Logger.getLogger(AddStudentServlet.class);
    private StudentService studentService = new StudentService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ((Integer)req.getSession().getAttribute(ConstantContainer.ROLE) != 1){
            resp.sendRedirect(req.getContextPath() + "/error_page.jsp?error_message=permissionError");
            return;
        }
        req.setCharacterEncoding(ConstantContainer.UTF8);
        resp.setCharacterEncoding(ConstantContainer.UTF8);
        String firstName = req.getParameter("firstName");
        String secondName = req.getParameter("secondName");
        if (firstName.equals("") || secondName.equals("")) {
            resp.sendRedirect(req.getContextPath() + "/error_page.jsp?error_message=addStudentError");
            return;
        }
        String middleName = req.getParameter("middleName");
        Integer courseId = null;
        try {
            courseId = Integer.parseInt(req.getParameter("courseId"));
        } catch (Exception e) {
            resp.sendRedirect(req.getContextPath() + "/error_page.jsp?error_message=addStudentError");
            return;
        }
        studentService.addStudent(firstName, secondName, middleName, courseId);
        resp.sendRedirect(req.getContextPath() + "/method?method=add_student");
    }
}
