package ru.innopolis.stc9.services;

import ru.innopolis.stc9.db.dao.StudentsDAO;
import ru.innopolis.stc9.db.dao.StudentsDAOImpl;
import ru.innopolis.stc9.pojo.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentService {
    private static StudentsDAO studentsDAO = new StudentsDAOImpl();

    /*public List<Object> getStudents(String firstName, String secondName, String middleName) {
        List<Object> result = new ArrayList<>();
        Map<String,String> incParam = new HashMap<>();
        incParam.put("firstName", firstName);
        incParam.put("secondName", secondName);
        incParam.put("middleName", middleName);
        List<Student> students = getStudentsByNameFIO(incParam);
        for (Student student : students) {
            result.add(student);
        }
        return result;
    }*/

    public List<Object> getStudents(Map<String, String[]> incParam, String stopWord) {
        List<Object> result = new ArrayList<>();
        List<Student> students = getStudentsByNameFIO(incParam,stopWord);
        for (Student student : students) {
            result.add(student);
        }
        return result;
    }

    public List<Student> getStudentsByNameFIO(Map<String, String[]> incParam, String stopWord) {
        return studentsDAO.getAllByParam(incParam,stopWord);
    }

    public void addStudent(String firstName, String secondName, String middleName, Integer courseId) {
        studentsDAO.addStudent(new Student(-1, firstName, secondName, middleName, courseId));
    }

    public void delStudent(Integer studentId) {
        studentsDAO.deleteStudentById(studentId);
    }
}
