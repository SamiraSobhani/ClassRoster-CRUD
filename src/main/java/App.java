import com.ClassRoster.ClassRoster.ClassRosterController.ClassRosterController;
import com.ClassRoster.ClassRoster.ClassRosterDAO.ClassRosterDAO;
import com.ClassRoster.ClassRoster.ClassRosterDAO.ClassRosterDAOFileImpl;
import com.ClassRoster.ClassRoster.ClassRosterUI.ClassRosterView;
import com.ClassRoster.ClassRoster.ClassRosterUI.UserIO;
import com.ClassRoster.ClassRoster.ClassRosterUI.UserIOConsoleImpl;
import org.springframework.boot.autoconfigure.SpringBootApplication;

  @SpringBootApplication
  public class App {

	public static void main(String[] args) {
		UserIO myIo = new UserIOConsoleImpl();
		ClassRosterView myView = new ClassRosterView(myIo);
		ClassRosterDAO myDao = new ClassRosterDAOFileImpl();
		ClassRosterController controller = new ClassRosterController(myDao, myView);
		controller.run();
	}
}
