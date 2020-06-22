package com.ClassRoster.ClassRoster.ClassRosterDAO;

import com.ClassRoster.ClassRoster.ClassRosterDTO.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClassRosterDAOTest  {

    ClassRosterDAO dao = new ClassRosterDAOFileImpl();

    @BeforeEach
    void setUp() throws Exception {
        List <Student> studentList = dao.getAllStudents();
        for(Student student : studentList){
            dao.removeStudent(student.getStudentId());
        }
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testAddGetStudent() throws Exception {
        Student student = new Student("0001");
        student.setFirstName("John");
        student.setLastName("Smith");
        student.setCohort("Java-2020");
        dao.addStudent(student.getStudentId(), student);
        assertEquals(dao.getStudent(student.getStudentId()),student);
    }

    @Test
    void testGetAllStudents()throws Exception {
        Student student1 = new Student("0001");
        student1.setFirstName("Joe");
        student1.setLastName("Smith");
        student1.setCohort("Java-2020");
        dao.addStudent(student1.getStudentId(),student1);

        Student student2 = new Student("0002");
        student2.setFirstName("Sara");
        student2.setLastName("Never");
        student2.setCohort("Java-2019");
        dao.addStudent(student2.getStudentId(),student2);

        assertEquals(2,dao.getAllStudents().size());
    }


    @Test
    void testRemoveStudent() throws Exception{
        Student student1 = new Student("0001");
        student1.setFirstName("Joe");
        student1.setLastName("Smith");
        student1.setCohort("Java-2020");
        dao.addStudent(student1.getStudentId(),student1);

        Student student2 = new Student("0002");
        student2.setFirstName("Sara");
        student2.setLastName("Never");
        student2.setCohort("Java-2019");
        dao.addStudent(student2.getStudentId(),student2);

        dao.removeStudent(student1.getStudentId());
        assertEquals(1,dao.getAllStudents().size());
        assertNull(dao.getStudent(student1.getStudentId()));
    }


}