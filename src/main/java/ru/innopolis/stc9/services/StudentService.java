package ru.innopolis.stc9.services;

import ru.innopolis.stc9.db.dao.StudentsDAO;
import ru.innopolis.stc9.db.dao.StudentsDAOImpl;
import ru.innopolis.stc9.pojo.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private static StudentsDAO studentsDAO = new StudentsDAOImpl();

    public List<Object> getStudents(String firstName, String secondName, String middleName) {
        List<Object> result = new ArrayList<>();
        List<Student> students = getStudentsByNameFIO(firstName, secondName, middleName);
        for (Student student : students) {
            result.add(student);
        }
        return result;
    }

    public List<Student> getStudentsByNameFIO(String firstName, String secondName, String middleName) {
        firstName = firstName.equals("") ? null : firstName;
        secondName = secondName.equals("") ? null : secondName;
        middleName = middleName.equals("") ? null : middleName;
        return studentsDAO.getAllStudentsByName(firstName, secondName, middleName);
    }

    public void addStudent(String firstName, String secondName, String middleName, Integer courseId) {
        studentsDAO.addStudent(new Student(-1, firstName, secondName, middleName, courseId));
    }

    public void delStudent(Integer studentId) {
        studentsDAO.deleteStudentById(studentId);
    }
}
