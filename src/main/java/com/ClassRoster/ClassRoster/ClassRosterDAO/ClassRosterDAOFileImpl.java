package com.ClassRoster.ClassRoster.ClassRosterDAO;



import com.ClassRoster.ClassRoster.ClassRosterDTO.Student;

import java.io.*;
import java.util.*;

public class ClassRosterDAOFileImpl implements ClassRosterDAO{

        private Map<String, Student> students = new HashMap<>();
        public static final String ROSTER_FILE = "audit.txt";
        public static final String DELIMITER = "::";


        @Override
        public Student addStudent(String studentId, Student student) throws ClassRosterPersistenceException {
            Student newStudent = students.put(studentId, student);
            writeRoster();
            return newStudent;
        }

        @Override
        public List<Student> getAllStudents() throws ClassRosterPersistenceException {
            loadRoster();
            return new ArrayList<Student>(students.values());
        }

        @Override
        public Student getStudent(String studentId)throws ClassRosterPersistenceException {
            return students.get(studentId);
        }

        @Override
        public Student removeStudent(String studentId) throws ClassRosterPersistenceException {
            Student removedStudent = students.remove(studentId);
            writeRoster();
            return removedStudent;
        }

    private void loadRoster() throws ClassRosterPersistenceException {
        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(ROSTER_FILE)));
        } catch (FileNotFoundException e) {
            throw new ClassRosterPersistenceException(
                    "-_- Could not load roster data into memory.", e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;

        String[] currentTokens;

        while (scanner.hasNextLine()) {

            currentLine = scanner.nextLine();

            currentTokens = currentLine.split(DELIMITER);
            // Create a new Student object and put it into the map of students
            // NOTE FOR APPRENTICES: We are going to use the student id
            // which is currentTokens[0] as the map key for our student object.
            // We also have to pass the student id into the Student constructor
            Student currentStudent = new Student(currentTokens[0]);
            // Set the remaining vlaues on currentStudent manually
            currentStudent.setFirstName(currentTokens[1]);
            currentStudent.setLastName(currentTokens[2]);
            currentStudent.setCohort(currentTokens[3]);

            // Put currentStudent into the map using studentID as the key
            students.put(currentStudent.getStudentId(), currentStudent);
        }

        scanner.close();
    }


    private void writeRoster() throws ClassRosterPersistenceException {

        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ROSTER_FILE));
        } catch (IOException e) {
            throw new ClassRosterPersistenceException(
                    "Could not save student data.", e);

        }

        // Write out the Student objects to the roster file.
        // NOTE TO THE APPRENTICES: We could just grab the student map,
        // get the Collection of Students and iterate over them but we've
        // already created a method that gets a List of Students so
        // we'll reuse it.
        List<Student> studentList = this.getAllStudents();
        for (Student currentStudent : studentList) {
            // write the Student object to the file
            out.println(currentStudent.getStudentId() + DELIMITER
                    + currentStudent.getFirstName() + DELIMITER
                    + currentStudent.getLastName() + DELIMITER
                    + currentStudent.getCohort());
            // force PrintWriter to write line to the file
            out.flush();
        }
        // Clean up
        out.close();
    }
}

