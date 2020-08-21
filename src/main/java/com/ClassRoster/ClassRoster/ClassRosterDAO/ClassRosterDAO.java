package com.ClassRoster.ClassRoster.ClassRosterDAO;

import com.ClassRoster.ClassRoster.ClassRosterDTO.Student;

import java.util.List;

public interface ClassRosterDAO {



        Student addStudent(String studentId, Student student) throws ClassRosterPersistenceException;


        List<Student> getAllStudents() throws ClassRosterPersistenceException;


        Student getStudent(String studentId)throws ClassRosterPersistenceException;


        Student removeStudent(String studentId) throws ClassRosterPersistenceException;
    }
