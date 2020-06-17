package com.ClassRoster.ClassRoster.classRosterService;

import com.ClassRoster.ClassRoster.ClassRosterDAO.ClassRosterPersistenceException;
import com.ClassRoster.ClassRoster.ClassRosterDTO.Student;

import java.util.List;

public interface ClassRosterServiceLayer {

    void createStudent(Student student) throws
            ClassRosterDuplicateIdException,
            ClassRosterDataValidationException,
            ClassRosterPersistenceException;

    List<Student> getAllStudents() throws
            ClassRosterPersistenceException;

    Student getStudent(String studentId) throws
            ClassRosterPersistenceException;

    Student removeStudent(String studentId) throws
            ClassRosterPersistenceException;

}
