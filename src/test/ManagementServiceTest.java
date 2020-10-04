package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import main.controllers.ManagementController;
import main.dao.EmployeeManagementDaoImpl;
import main.exceptions.DepartmentCreationException;
import main.exceptions.EmployeeCreationException;
import main.models.Department;
import main.models.Employee;
import main.services.ManagementService;
import main.ui.ManagementView;
import main.ui.UserIO;
import main.ui.UserIOConsoleImpl;

class ManagementServiceTest {

	EmployeeManagementDaoImpl dao = new EmployeeManagementDaoImpl();
	ManagementService service = new ManagementService(dao);

	
	@Before
	public void setUp(){
	}
	
	
	@Test
	void testAddEmployee() throws DepartmentCreationException, EmployeeCreationException {
		
		service.seedData(); // adds 10 employees
		assertEquals(service.getAllEmployees().size(), 10);
//		Employee employee1 = new Employee(11, 1, "name", service.getDepartment(1), "title", 50000);
//		service.addNewEmployee(employee1);
//		assertEquals(service.getAllEmployees().size(), 11);
	}
	
	@Test
	void testDeleteEmployee() throws DepartmentCreationException, EmployeeCreationException {

		service.seedData(); //adds 10 employees
		assertEquals(service.getAllEmployees().size(), 10);

//		service.deleteEmployee(1);
//		assertEquals(service.getAllEmployees().size(), 9);
	}
	
	@Test
	void testEmployeeAverageSalary() throws DepartmentCreationException, EmployeeCreationException {
		service.seedData(); //adds 10 employees
		assertEquals(service.getAverageSalary(), 50000);
	}


}
