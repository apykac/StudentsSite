package ru.innopolis.stc9.services;

import javax.servlet.http.HttpServletRequest;

public final class CreateObjectService {
    public static ObjectService create(HttpServletRequest req) {
        String[] reqDisp = req.getParameter("methodType").split("_");
        switch (reqDisp[reqDisp.length - 1]) {
            case "course":
                return new CourseService();
            case "student":
                return new StudentService();
            case "subject":
                return new SubjectService();
            case "lesson":
                return new LessonService();
            case "mark":
                return new MarkService();
        }
        return null;
    }
}
