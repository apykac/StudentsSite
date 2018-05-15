package ru.innopolis.stc9.controllers.MethodServlets;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.controllers.ConstantContainer;
import ru.innopolis.stc9.pojo.Student;
import ru.innopolis.stc9.services.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PrintStudentsToPageServlet extends HttpServlet {
    private static Logger logger = Logger.getLogger(PrintStudentsToPageServlet.class);
    private static StudentService studentService = new StudentService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ((Integer)req.getSession().getAttribute(ConstantContainer.ROLE) > 2){
            resp.sendRedirect(req.getContextPath() + "/error_page.jsp?error_message=permissionError");
            return;
        }
        req.setCharacterEncoding(ConstantContainer.UTF8);
        resp.setCharacterEncoding(ConstantContainer.UTF8);
        List<Student> students = studentService.getStudentByNameFIO(
                req.getParameter("firstName").equals("") ? null : req.getParameter("firstName"),
                req.getParameter("secondName").equals("") ? null : req.getParameter("secondName"),
                req.getParameter("middleName").equals("") ? null : req.getParameter("middleName"));
        req.setAttribute("students", students);
        req.getRequestDispatcher("/method/get_students_to_page.jsp").forward(req, resp);
    }
}
