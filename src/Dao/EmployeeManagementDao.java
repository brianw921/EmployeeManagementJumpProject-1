package Dao;

import java.util.List;
import java.util.TreeMap;

import main.exceptions.DepartmentCreationException;
import main.exceptions.EmployeeCreationException;
import main.models.Department;
import main.models.Employee;

public interface EmployeeManagementDao  {
    public static final String DELIMITER = "::";

	static TreeMap<Integer, Department> departments = new TreeMap<>();
	
	static TreeMap<Integer, Employee> employees = new TreeMap<>();
	
	List<Department>getAllDepartments();
	Department getDepartment(int departmentId);
	void setEmployeeDepartment(int employeeId, int departmentId);
	void setDepartments() throws DepartmentCreationException;
	
	List<Employee> getAllEmployees();
	Employee getEmployee(int employeeId);
	void deleteEmployee(int employeeId);
	Employee updateEmployeeName(int employeeId, String name);
	Employee updateEmployeeDepartment(int employeeId, int departmentId);
	Employee addNewEmployee(Employee employee);
	void setDepartmentEmployee(Employee employee, int departmentId);
	void setEmployees() throws EmployeeCreationException;
	void readDataFromTxtFile() throws NumberFormatException, DepartmentCreationException, EmployeeCreationException;
	void writeDataToTxtFile();
	void seedData() throws EmployeeCreationException, DepartmentCreationException;

}
