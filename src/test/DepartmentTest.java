package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.exceptions.DepartmentCreationException;
import main.exceptions.EmployeeCreationException;
import main.models.Department;
import main.models.Employee;

class DepartmentTest {
	
	@Test
	void testCreateNewDepartment(){
		try {
			Department department1 = new Department(1, "Test Department");
		}catch(Exception e) {
			
		}
		assertThrows(DepartmentCreationException.class, () -> {new Department(1, "Test Department");});
	}

	@Test
	void testAddDepartmentEmployee() throws DepartmentCreationException, EmployeeCreationException {
		
		Department department = new Department(1, "Test Department");
		Employee employee = new Employee(1, 1, "Test Employee", department, "Test Title", 50000);
		
		department.addDepartmentEmployee(employee);
		
		assertEquals(1, department.getDepartmentEmployees().size());
		assertTrue(employee.equals(department.getDepartmentEmployees().get(1)));
	}


}
