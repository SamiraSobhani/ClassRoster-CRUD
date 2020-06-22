package com.ClassRoster.ClassRoster.ClassRosterDAO;

import com.ClassRoster.ClassRoster.ClassRosterDTO.Student;

import java.util.ArrayList;
import java.util.List;

public class ClassRosterDAOStubImpl implements ClassRosterDAO {

    private Student onlyStudent;
    private List<Student> studentList = new ArrayList<>();

    public ClassRosterDAOStubImpl() {
        onlyStudent = new Student("0001");
        onlyStudent.setFirstName("John");
        onlyStudent.setLastName("Doe");
        onlyStudent.setCohort("Java-Jan-2015");

        studentList.add(onlyStudent);
    }

    @Override
    public Student addStudent(String studentId, Student student) throws ClassRosterPersistenceException {
        if (studentId.equals(onlyStudent.getStudentId())) {
            return onlyStudent;
        } else {
            return null;
        }
    }

    @Override
    public List<Student> getAllStudents() throws ClassRosterPersistenceException {
        return studentList;
    }

    @Override
    public Student getStudent(String studentId) throws ClassRosterPersistenceException {
        if (studentId.equals(onlyStudent.getStudentId())) {
            return onlyStudent;
        } else {
            return null;
        }
    }

    @Override
    public Student removeStudent(String studentId) throws ClassRosterPersistenceException {
        if (studentId.equals(onlyStudent.getStudentId())) {
            return onlyStudent;
        } else {
            return null;
        }
    }
}
