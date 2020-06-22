import com.ClassRoster.ClassRoster.ClassRosterController.ClassRosterController;
import com.ClassRoster.ClassRoster.ClassRosterDAO.ClassRosterAuditDao;
import com.ClassRoster.ClassRoster.ClassRosterDAO.ClassRosterAuditDaoFileImpl;
import com.ClassRoster.ClassRoster.ClassRosterDAO.ClassRosterDAO;
import com.ClassRoster.ClassRoster.ClassRosterDAO.ClassRosterDAOFileImpl;
import com.ClassRoster.ClassRoster.ClassRosterUI.ClassRosterView;
import com.ClassRoster.ClassRoster.ClassRosterUI.UserIO;
import com.ClassRoster.ClassRoster.ClassRosterUI.UserIOConsoleImpl;
import com.ClassRoster.ClassRoster.classRosterService.ClassRosterServiceLayer;
import com.ClassRoster.ClassRoster.classRosterService.ClassRosterServiceLayerImpl;
import org.springframework.boot.autoconfigure.SpringBootApplication;

  @SpringBootApplication
  public class App {

	public static void main(String[] args) {
		// Instantiate the UserIO implementation
		UserIO myIo = new UserIOConsoleImpl();
		// Instantiate the View and wire the UserIO implementation into it
		ClassRosterView myView = new ClassRosterView(myIo);
		// Instantiate the DAO
		ClassRosterDAO myDao = new ClassRosterDAOFileImpl();
		// Instantiate the Audit DAO
		ClassRosterAuditDao myAuditDao = new ClassRosterAuditDaoFileImpl();
		// Instantiate the Service Layer and wire the DAO and Audit DAO into it
		ClassRosterServiceLayer myService = new ClassRosterServiceLayerImpl(myDao, myAuditDao);
		// Instantiate the Controller and wire the Service Layer into it
		ClassRosterController controller = new ClassRosterController(myService, myView);
		// Kick off the Controller
		controller.run();
	}
}
