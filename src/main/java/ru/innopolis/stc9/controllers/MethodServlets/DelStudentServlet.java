package ru.innopolis.stc9.controllers.MethodServlets;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.controllers.ConstantContainer;
import ru.innopolis.stc9.controllers.MethodServlets.AddStudentServlet;
import ru.innopolis.stc9.services.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DelStudentServlet extends HttpServlet {
    private static Logger logger = Logger.getLogger(AddStudentServlet.class);
    private StudentService studentService = new StudentService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding(ConstantContainer.UTF8);
        resp.setCharacterEncoding(ConstantContainer.UTF8);
        Integer studentId = null;
        try {
            studentId = Integer.parseInt(req.getParameter("id"));
        } catch (Exception e) {
            resp.sendRedirect(req.getContextPath() + "/error_page.jsp?error_message=delStudentError");
            return;
        }
        studentService.delStudent(studentId);
        resp.sendRedirect(req.getContextPath() + "/method?method=del_student");
    }
}
