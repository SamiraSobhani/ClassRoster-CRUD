package ClassRosterDAO;

import ClassRosterDTO.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassRosterDAOFileImpl implements ClassRosterDAO {

        private Map<String, Student> students = new HashMap<>();

        @Override
        public Student addStudent(String studentId, Student student) {
            Student newStudent = students.put(studentId, student);
            return newStudent;
        }

        @Override
        public List<Student> getAllStudents() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public Student getStudent(String studentId) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public Student removeStudent(String studentId) {
            throw new UnsupportedOperationException("Not supported yet.");
        }



    }

