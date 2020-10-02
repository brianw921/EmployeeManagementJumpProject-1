package main;


import java.util.Scanner;

import main.controllers.MainController;
import main.models.Employee;
import main.views.ManagementMenu;

public class app {
	
	static MainController mc = new MainController();
	static Scanner sc = new Scanner(System.in);
	static int userOption;
	
	
	public static void main(String[] args) {
//		MainController.seedData(); //use this to create new set of departments and users
		
		MainController.setDepartmentsFromFile();
		getMainMenu();
		sc.close();
		
	}
	
	public static void getMainMenu() {
		ManagementMenu.mainMenuBanner();
		userOption = sc.nextInt();
		
		switch(userOption) {
		
		case 1:
			getAllDepartments();
			break;
		case 2:
			getAllEmployees();
			break;
		case 3:
			System.out.println("Goodbye");
			mc.saveData();
			System.exit(0);
		}
	}
	
	public static void getAllDepartments() {
		ManagementMenu.displayAllDepartments(mc.getAllDepartments());
		userOption = sc.nextInt();
		switch(userOption) {
		
		case 1:
			getDepartment();
			break;
		case 2:
			getMainMenu();
			break;
		}
		
	}
	
	public static void getDepartment() {
		System.out.println("Enter Department Id:");
		userOption = sc.nextInt();
		ManagementMenu.displayDepartment(mc.getDepartment(userOption));
	}
	
	public static void getAllEmployees(){
		ManagementMenu.displayAllEmployees(mc.getAllEmployees());
		userOption = sc.nextInt();
		switch(userOption) {
		
		case 1:
			getEmployee();
			break;
		case 2:
			addNewEmployee();
			System.out.println("Add New Employee");
			break;
		case 3:
			getMainMenu();
			break;
		}
	}
	
	public static void getEmployee() {
		System.out.println("Enter Employee Id:");
		userOption = sc.nextInt();
		Employee employee = mc.getEmployee(userOption);
		ManagementMenu.displayEmployee(employee);
		userOption = sc.nextInt();
		switch(userOption) {
			case 1:
				updateEmployeeName(employee);
				break;
			case 2:
				updateDepartment(employee);
				break;
			case 3:
				deleteEmployee(employee.getId());
				getAllEmployees();
				break;
			}
	}
	
	public static void deleteEmployee(int employeeId) {
		System.out.println("Employee of id: " + employeeId + " has been deleted.");
		mc.deleteEmployee(employeeId);
	}
	
	public static void updateEmployeeName(Employee employee) {
		System.out.println("Enter new employee name: ");
		String newName = sc.next();
		System.out.println("Are you sure you want to change " + employee.getName() + "to " + newName + "?  Y/N");
		
		switch(sc.next()) {
			
			case "Y":
				mc.updateEmployeeName(employee, newName);
				System.out.println("Name updated successfully");
				ManagementMenu.displayEmployee(employee);
				break;
			case "N":
				System.out.println("Name update canceled");
				ManagementMenu.displayEmployee(employee);
				break;
		}
	}
	
	public static void updateDepartment(Employee employee) {
		System.out.println("Enter new department: ");
		int newDepartmentId = sc.nextInt();
		System.out.println("Are you sure you want to change " + employee.getName() + "'s department to " + mc.getDepartment(newDepartmentId).getName() + "?  Y/N");
		
		switch(sc.next()) {
			
			case "Y":
				mc.updateEmployeeDepartment(employee, newDepartmentId);
				System.out.println("Department updated successfully");
				ManagementMenu.displayEmployee(employee);
				break;
			case "N":
				System.out.println("Department update canceled");
				ManagementMenu.displayEmployee(employee);
				break;
		}
	}
	
	public static void addNewEmployee() {
		System.out.println("Enter a name: ");
		String name = sc.next();
		System.out.println("Enter a department");
		System.out.println(mc.getAllDepartments());
		int departmentId = sc.nextInt();
		System.out.println("New Employee Info");
		System.out.println("Name: " + name);
		System.out.println("Department : " + mc.getDepartment(departmentId).getName());
		System.out.println("Is this information correct?");
		
		switch(sc.next()) {
		
		case "Y":
			mc.addNewEmployee(new Employee(departmentId, name, mc.getDepartment(departmentId)));
			System.out.println("Employee added successfully");
			getAllEmployees();
			break;
			
		case "N":
			System.out.println("Employee creation cancelled");
			getAllEmployees();
			break;
		}
		
	}


}
