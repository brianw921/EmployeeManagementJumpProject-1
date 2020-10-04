package main.services;

import java.util.List;

import Dao.EmployeeManagementDao;
import Dao.EmployeeManagementDaoImpl;
import main.exceptions.DepartmentCreationException;
import main.exceptions.EmployeeCreationException;
import main.models.Department;
import main.models.Employee;

public class ManagementService {
	
	private EmployeeManagementDao dao = new EmployeeManagementDaoImpl();
	
	public ManagementService(EmployeeManagementDaoImpl dao) {
		this.dao = dao;
	}

	
	public List<Department> getAllDepartments(){
		return dao.getAllDepartments();
	}
	
	public Department getDepartment(int departmentId) {
		return dao.getDepartment(departmentId);
	}
	
	public List<Employee> getAllEmployees(){
		return dao.getAllEmployees();
	}
	
	public Employee getEmployee(int employeeId) {
		return dao.getEmployee(employeeId);
	}
	
	public void deleteEmployee(int employeeId) {
		dao.deleteEmployee(employeeId);
	}
	
	public Employee updateEmployeeName(int employeeId, String name) {
		return dao.updateEmployeeName(employeeId, name);
	}
	
	public Employee updateEmployeeDepartment(int employeeId, int departmentId) {
		return dao.updateEmployeeDepartment(employeeId, departmentId);
	}
	
	public Employee addNewEmployee(Employee employee) {
		return dao.addNewEmployee(employee);
	}
	
	public  int getAverageSalary() {
		
		List<Employee> emps = dao.getAllEmployees();
		
		int totalSalary= emps.stream()
							.map(Employee::getSalary)
							.reduce(0, (x, y) -> x + y);
		
		return (totalSalary/emps.size());
		
	}
							
	
	
	public void seedData() throws DepartmentCreationException, EmployeeCreationException {
		dao.seedData();
	}	
	
	public void getFileData() throws NumberFormatException, DepartmentCreationException, EmployeeCreationException {
		dao.readDataFromTxtFile();
	}
	
	public void saveData() {
		dao.writeDataToTxtFile();
	}
	
	public void readDataFromTxt() throws NumberFormatException, DepartmentCreationException, EmployeeCreationException {
		dao.readDataFromTxtFile();
	}
	
	
}
