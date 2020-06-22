package com.ClassRoster.ClassRoster.classRosterService;

import com.ClassRoster.ClassRoster.ClassRosterDAO.ClassRosterAuditDAOStubImpl;
import com.ClassRoster.ClassRoster.ClassRosterDAO.ClassRosterAuditDao;
import com.ClassRoster.ClassRoster.ClassRosterDAO.ClassRosterDAO;
import com.ClassRoster.ClassRoster.ClassRosterDAO.ClassRosterDAOStubImpl;
import com.ClassRoster.ClassRoster.ClassRosterDTO.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClassRosterServiceLayerTest {
    private ClassRosterServiceLayer service;

    public ClassRosterServiceLayerTest() {
        ClassRosterDAO dao = new ClassRosterDAOStubImpl();
        ClassRosterAuditDao auditDao = new ClassRosterAuditDAOStubImpl();

        service = new ClassRosterServiceLayerImpl(dao, auditDao);
    }
    @BeforeEach
     void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createStudent()throws Exception {
        Student student =new Student("0002");
         student.setFirstName("Sally");
        student.setLastName("Smith");
        student.setCohort("Java-Jan-2015");
        service.createStudent(student);
    }

    @Test
    void creatStudentDuplicateId()throws Exception{
        Student student =new Student("0001");
        student.setFirstName("Sally");
        student.setLastName("Smith");
        student.setCohort("Java-Jan-2015");
        try{
            service.createStudent(student);
            fail("Expected ClassRosterDuplicateIdException was not thrown.");
        }catch(ClassRosterDuplicateIdException e){
            return;
        }
    }

    @Test
    void creatStudentInvalidData() throws Exception{
        Student student =new Student("0002");
        student.setFirstName("");
        student.setLastName("Smith");
        student.setCohort("Java-Jan-2015");

        try {
           service.createStudent(student);
           fail("Expected ClassRosterDataValidation was not thrown. ");
        }catch (ClassRosterDataValidationException e){
            return;
        }
    }

    @Test
    void testGetAllStudents()throws Exception {
        assertEquals(1,service.getAllStudents().size());
    }

    @Test
    void testGetStudent() throws Exception{
       assertNotNull(service.getStudent("0001"));
       assertNull(service.getStudent("9999"));
    }

    @Test
    void testRemoveStudent() {
    }
}