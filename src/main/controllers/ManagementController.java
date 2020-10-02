package main.controllers;

import main.exceptions.DepartmentCreationException;
import main.exceptions.EmployeeCreationException;
import main.models.Employee;
import main.services.ManagementService;
import main.ui.ManagementView;

public class ManagementController {

	private ManagementView view;
	private ManagementService service;
	
	public ManagementController(ManagementView view, ManagementService service) {
		this.view = view;
		this.service = service;
	}
	
	public void runEmployeeManagement() throws NumberFormatException, DepartmentCreationException, EmployeeCreationException {
//		service.seedData(); //use this to create new set of departments and users
		service.getFileData();
		displayMainMenu();
	}
	
	public void displayMainMenu() {
		String[] options = {"View All Departments", "View All Employees", "Exit"};
		
		switch(view.mainMenuBanner(options)) {
			case 1:
				displayAllDepartments();
				break;
			case 2:
				displayAllEmployees();
				break;
			case 3:
				System.out.println("Goodbye");
				service.saveData();
				System.exit(0);
		}
	}
	
	public void displayAllDepartments() {
		String[] options = {"View Department By Id", "Return To Main Menu"};
		
		switch(view.displayAllDepartments(service.getAllDepartments(), options)) {
			
			case 1:
				displayDepartment(view.getIdFromUser());
				break;
			case 2:
				displayMainMenu();
				break;
			}
		
	}
	
		
	public void displayDepartment(int departmentId) {
		String[] options = {"Return To Departments", "Return To Main Menu"};
		switch(view.displayDepartment(service.getDepartment(departmentId), options)) {
		
			case 1:
				displayAllDepartments();
			case 2:
				displayMainMenu();
				break;
		}
	}
	
	public void displayAllEmployees(){
		String[] options = {"View Employee By Id", "Add New Employee", "Return To Main Menu"};
		switch(view.displayAllEmployees(service.getAllEmployees(), service.getAverageSalary(), options)) {
		
		case 1:
			displayEmployee(view.getIdFromUser());
			break;
		case 2:
			addNewEmployee();
			break;
		case 3:
			displayMainMenu();
			break;
		}
	}
	

	public void displayEmployee(int employeeId) {
		String[] options = {"Update Employee Name", "Update Employee Department", "Delete Employee", "Return To Main Menu"};
		Employee employee = service.getEmployee(employeeId);
		switch(view.displayEmployee(employee, options)) {
			case 1:
				updateEmployeeName(employee);
				break;
			case 2:
//				updateDepartment(employee);
				break;
			case 3:
				deleteEmployee(employee.getId());
//				displayAllEmployees();
				break;
			case 4:
				displayMainMenu();
				break;
		}
	}
	
	public  void deleteEmployee(int employeeId) {
		
		Employee employee = service.getEmployee(employeeId);
		
		switch(view.getConfirmationFromUser("Are you sure you want to delete " + employee.getId() + " ||" + employee.getName() + "?  Y/N")) {
		
			case "y":
				System.out.println("Employee " + employee.getId() + " ||" + employee.getName() +"has been deleted.");
				service.deleteEmployee(employeeId);
				displayAllEmployees();
				break;
			case "n":
				System.out.println("Employee Deletion Cancelled");
				displayEmployee(employee.getId());
				break;
			}
	}
	
	public  void updateEmployeeName(Employee employee) {
		
		String newName = view.getStringInputFromUser("Enter New Employee Name: ");
		switch(view.getConfirmationFromUser("Are you sure you want to change " + employee.getName() + "to " + newName + "?  Y/N")) {
			
			case "y":
				service.updateEmployeeName(employee.getId(), newName);
				System.out.println("Name updated successfully");
				displayEmployee(employee.getId());
				break;
			case "n":
				System.out.println("Name update canceled");
				displayEmployee(employee.getId());
				break;
		}
	}
	
	public void updateEmployeeDepartment(Employee employee) {
		int newDepartmentId = view.getIdFromUser("Enter new department: ");
		switch(view.getConfirmationFromUser("Are you sure you want to change " +
												employee.getName() + "'s department to " + 
												service.getDepartment(newDepartmentId).getName() + "?  Y/N")) {
			
			case "y":
				service.updateEmployeeDepartment(employee.getId(), newDepartmentId);
				System.out.println("Department updated successfully");
				displayEmployee(employee.getId());
				break;
			case "n":
				System.out.println("Department update canceled");
				displayEmployee(employee.getId());
				break;
		}
	}
	
	public void addNewEmployee() {
		String name = view.getStringInputFromUser("Enter A Name: ");
//		view.displayAllDepartments(departments, options)
		int departmentId = view.getIdFromUser("Enter Department Id: ");
		String title = view.getStringInputFromUser("Enter Employee's Title: " );
		int salary = view.getIdFromUser("Enter Employee's Salary");
		System.out.println("New Employee Info");
		System.out.println("Name: " + name);
		System.out.println("Department : " + service.getDepartment(departmentId).getName());
		System.out.println("Title : " + title);
		System.out.println("Salary :  " + salary);
		 
		switch(view.getConfirmationFromUser("Is This information correct? Y/N")) {
		
		case "y":
			try {
				service.addNewEmployee(new Employee(departmentId, name, service.getDepartment(departmentId), title, salary));
			} catch (EmployeeCreationException e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
			System.out.println("Employee Added Successfully");
			displayAllEmployees();
			break;
			
		case "n":
			System.out.println("Employee Creation Cancelled");
			displayAllEmployees();
			break;
		}
		
	}
	
}
