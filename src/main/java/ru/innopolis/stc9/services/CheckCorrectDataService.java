package ru.innopolis.stc9.services;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CheckCorrectDataService {
    public static List<String> isCorrectAddData(Map<String, String[]> incParam, HttpServletRequest req) {
        List<String> result = new ArrayList<>();
        String[] type = req.getParameter("methodType").split("_");
        switch (type[type.length - 1]) {
            case "course":
                result = CourseService.isCorrectData(incParam);
                break;
            case "student":
                result = StudentService.isCorrectData(incParam);
                break;
        }
        return result;
    }
}
