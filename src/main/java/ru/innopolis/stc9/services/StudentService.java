package ru.innopolis.stc9.services;

import ru.innopolis.stc9.db.dao.StudentsDAO;
import ru.innopolis.stc9.db.dao.StudentsDAOImpl;
import ru.innopolis.stc9.pojo.Student;

import java.util.List;

public class StudentService {
    private static StudentsDAO studentsDAO = new StudentsDAOImpl();

    public List<Student> getStudentByNameFIO(String firstName, String secondName, String middleName) {
        return studentsDAO.getAllStudentsByName(firstName, secondName, middleName);
    }

    public void addStudent(String firstName, String secondName, String middleName, Integer courseId) {
        studentsDAO.addStudent(new Student(-1, firstName, secondName, middleName, courseId));
    }

    public void delStudent(Integer studentId) {
        studentsDAO.deleteStudentById(studentId);
    }
}
