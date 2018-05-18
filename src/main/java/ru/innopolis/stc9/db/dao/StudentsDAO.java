package ru.innopolis.stc9.db.dao;


import ru.innopolis.stc9.pojo.Student;

import java.util.List;
import java.util.Map;

public interface StudentsDAO{
    boolean addStudent(Student student);

    Student getStudentById(int id);

    boolean updateStudent(Student student);

    boolean deleteStudentById(int id);

    List<Student> getAllByParam(Map<String, String[]> incParam, String stopWord);

    //Map<String, TypeOfGetSet> getTypesOfGS();
}
