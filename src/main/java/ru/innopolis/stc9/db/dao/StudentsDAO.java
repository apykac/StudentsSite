package ru.innopolis.stc9.db.dao;


import ru.innopolis.stc9.pojo.Student;

import java.util.List;

public interface StudentsDAO{
    boolean addStudent(Student student);

    Student getStudentById(int id);

    boolean updateStudent(Student student);

    boolean deleteStudentById(int id);

    List<Student> getAllStudentsByName(String firstName, String secondName, String middleName);
}
