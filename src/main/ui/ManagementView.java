package main.ui;

import java.io.IOException;
import java.util.List;

import main.models.Department;
import main.models.Employee;

public class ManagementView {

	private UserIO io;
	
	public ManagementView(UserIO io) {
		this.io = io;
	}
	
	public int mainMenuBanner(String[] options) {
		io.print("------------------------------------------------------------------------------");
		io.print("------------------------------------------------------------------------------");
		io.print("------------------------------Employee Management-----------------------------");
		io.print("------------------------------------Main Menu---------------------------------");
		io.print("------------------------------------------------------------------------------");
		io.print("______________________________________________________________________________");
		return displayOptions(options);
	}
	
	
	public int displayOptions(String[] options) {
		for(int i = 0; i < options.length; i++) {
			io.print((i+1) + ". " + options[i]);
		}
		io.print("------------------------------------------------------------------------------");
		return io.readInt("Please Select An Option: ", 1, options.length);
	}
	
	public int displayAllDepartments(List<Department> departments, String[] options) {
		io.print("------------------------------------------------------------------------------");
		io.print("-------------------------------All Departments--------------------------------");
		io.print("______________________________________________________________________________");
		for(Department department : departments) {
			io.print("Id | " +  department.getId() + " | "  + department.getName() );
			io.print("______________________________________________________________________________");
		}
		return displayOptions(options);
	}
	
	
	public int displayDepartment(Department department, String[] options) {
		io.print("Department " + department.getId() + " || " + department.getName());
		return displayOptions(options);
	}
	
	public int displayAllEmployees(List<Employee> employees, int averageSalary, String[] options) {
		io.print("--------------------------------------------------------------------");
		io.print("---------------------------All Employees----------------------------");
		io.print("______________________________________________________________________________");
		for(Employee employee : employees) {
			io.print("Id | " +  employee.getId() + " | " + employee.getName() + " Department | " + employee.getDepartment().getName());
			io.print("______________________________________________________________________________");
		}
		io.print("Average Salary: $" + averageSalary);
		return displayOptions(options);
	}
	
	public int displayEmployee(Employee employee, String[] options) {
		io.print("--------------------------------------------------------------------");
		io.print("Id | " +  employee.getId() + " | " + employee.getName() + " Department | " + employee.getDepartment().getName());
		io.print("______________________________________________________________________________");

		return displayOptions(options);
	}
	
	public int getIdFromUser() {
		return io.readInt("Please Enter An Id: ");
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
	
	public void goodbye(String prompt) {
		io.print("------------------------------------------------------------------------------");
		io.print("                                 " + prompt);
		io.print("------------------------------------------------------------------------------");
		io.print("______________________________________________________________________________");
	
	}
}
