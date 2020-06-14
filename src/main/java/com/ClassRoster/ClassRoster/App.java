package com.ClassRoster.ClassRoster;

import ClassRosterController.ClassRosterController;
import ClassRosterDAO.ClassRosterDAO;
import ClassRosterUI.ClassRosterView;
import ClassRosterUI.UserIO;
import ClassRosterUI.UserIOConsoleImpl;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

//	public static void main(String[] args) {
//
//
//			ClassRosterController controller = new ClassRosterController();
//			controller.run();
//
//
//	}

	public static void main(String[] args) {
		UserIO myIo = new UserIOConsoleImpl();
		ClassRosterView myView = new ClassRosterView(myIo);
		ClassRosterDAO myDao = new ClassRosterDAOException()
		ClassRosterController controller = new ClassRosterController(myDao, myView);
		controller.run();
	}
}
