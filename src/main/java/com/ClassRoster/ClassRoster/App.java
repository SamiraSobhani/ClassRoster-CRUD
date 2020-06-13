package com.ClassRoster.ClassRoster;

import ClassRosterController.ClassRosterController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

	public static void main(String[] args) {


			ClassRosterController controller = new ClassRosterController();
			controller.run();


	}

}
