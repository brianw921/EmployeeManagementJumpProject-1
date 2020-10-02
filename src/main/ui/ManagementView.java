package main.ui;

import java.util.List;

import main.models.Department;
import main.models.Employee;

public class ManagementView {

	private UserIO io;
	
	public ManagementView(UserIO io) {
		this.io = io;
	}
	
	public int mainMenuBanner(String[] options) {
		io.print("-----------------------------------------------------");
		io.print("-----------------------------------------------------");
		io.print("---------------Employee Management-------------------");
		io.print("---------------------Main Menu-----------------------");
		io.print("-----------------------------------------------------");
		io.print("-----------------------------------------------------");
		return displayOptions(options);
	}
	
	
	public int displayOptions(String[] options) {
		for(int i = 0; i < options.length; i++) {
			System.out.println((i+1) + ". " + options[i]);
		}
		return io.readInt("Please Select An Option", 1, options.length +1);
	}
	
	public int displayAllDepartments(List<Department> departments, String[] options) {
		System.out.println("-----------------------------------------------------");
		System.out.println("------------------All Departments--------------------");
		System.out.println("-----------------------------------------------------");
		for(Department department : departments) {
			System.out.println("Department Id: " +  department.getId()  + " Department Name " + department.getName());
		}
		return displayOptions(options);
	}
	
	
	public int displayDepartment(Department department, String[] options) {
		System.out.println(department);
		return displayOptions(options);
	}
	
	public int displayAllEmployees(List<Employee> employees, int averageSalary, String[] options) {
		System.out.println("-----------------------------------------------------");
		System.out.println("-------------------All Employees---------------------");
		System.out.println("-----------------------------------------------------");
		for(Employee employee : employees) {
			System.out.println("Employee Id: " +  employee.getId()  + " Employee Name " + employee.getName() + " Department id: " + employee.getDepartment().getName());
		}
		System.out.println("Average Salary: $" + averageSalary);
		return displayOptions(options);
	}
	
	public int displayEmployee(Employee employee, String[] options) {
		System.out.println("Employee Id: " +  employee.getId()  + " Employee Name " + employee.getName() + " Department" + employee.getDepartment().getName() );
		System.out.println(employee);
		return displayOptions(options);
	}
	
	public int getIdFromUser() {
		return io.readInt("Please Enter An Id");
	}
	
	public int getIdFromUser(String prompt) {
		return io.readInt(prompt);
	}
	
	
	public String getConfirmationFromUser(String prompt) {
		return io.readString(prompt).toLowerCase();
	}
	
	public String getStringInputFromUser(String prompt) {
		return io.readString(prompt);
	}
	
	
	
}
