package ClassRosterController;

import ClassRosterDAO.ClassRosterDAO;
import ClassRosterDTO.Student;
import ClassRosterUI.ClassRosterView;


import java.util.List;

public class ClassRosterController {


    ClassRosterView view;
    ClassRosterDAO dao;

    public ClassRosterController(ClassRosterDAO dao, ClassRosterView view) {
        this.dao = dao;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;

        try {

            while (keepGoing) {
                menuSelection = getMenuSelection();


                switch (menuSelection) {
                    case 1:
                        listStudents();
                        break;
                    case 2:
                        createStudent();
                        break;
                    case 3:
                        viewStudent();
                        break;
                    case 4:
                        removeStudent();
                        break;
                    case 5:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }

            }
            exitMessage();

        } catch (ClassRosterDAOException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }


    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }


    private void createStudent() throws ClassRosterDAOException {
        view.displayCreateStudentBanner();
        Student newStudent = view.getNewStudentInfo();
        dao.addStudent(newStudent.getStudentId(), newStudent);
        view.displayCreateSuccessBanner();
    }

    private void listStudents() throws ClassRosterDAOException {
        view.displayDisplayAllBanner();
        List<Student> studentList = dao.getAllStudents();
        view.displayStudentList(studentList);
    }

    private void viewStudent() {
        view.displayDisplayStudentBanner();
        String studentId = view.getStudentIdChoice();
        Student student = dao.getStudent(studentId);
        view.displayStudent(student);
    }

    private void removeStudent() throws ClassRosterDAOException {
        view.displayRemoveStudentBanner();
        String studentId = view.getStudentIdChoice();
        dao.removeStudent(studentId);
        view.displayRemoveSuccessBanner();
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }



