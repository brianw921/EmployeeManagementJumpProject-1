package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.exceptions.DepartmentCreationException;
import main.exceptions.EmployeeCreationException;
import main.models.Department;
import main.models.Employee;

class EmployeeTest {

	@Test
	void testCreateNewEmployee() throws DepartmentCreationException {
		Department department = new Department(1, "Test Department");
		
		try {
			Employee employee = new Employee(1, 1, "Test Employee", department, "Test Title", 50000);
		}catch(Exception e) {
			
		}
		
		assertThrows(EmployeeCreationException.class, () -> {new Employee(1, 1, "Test Employee", department, "Test Title", 50000);});

	}

}
