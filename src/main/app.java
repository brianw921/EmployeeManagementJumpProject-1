package main;


import main.controllers.ManagementController;
import main.dao.EmployeeManagementDaoImpl;
import main.exceptions.DepartmentCreationException;
import main.exceptions.EmployeeCreationException;
import main.services.ManagementService;
import main.ui.ManagementView;
import main.ui.UserIO;
import main.ui.UserIOConsoleImpl;

public class app {
	

	public static void main(String[] args) throws NumberFormatException, DepartmentCreationException, EmployeeCreationException {
		UserIO io = new UserIOConsoleImpl();
		ManagementView view = new ManagementView(io);
		EmployeeManagementDaoImpl dao = new EmployeeManagementDaoImpl();
		ManagementService service = new ManagementService(dao);
		ManagementController controller = new ManagementController(view, service);
		
		controller.runEmployeeManagement();
	}
	
}
