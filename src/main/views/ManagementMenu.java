package main.views;

import java.util.List;

import main.models.Department;
import main.models.Employee;

public class ManagementMenu {

	public static void mainMenuBanner() {
		System.out.println("-----------------------------------------------------");
		System.out.println("-----------------------------------------------------");
		System.out.println("---------------Employee Management-------------------");
		System.out.println("---------------------Main Menu-----------------------");
		System.out.println("-----------------------------------------------------");
		System.out.println("-----------------------------------------------------");
		mainMenuOptions();

	}
	
	public static void mainMenuOptions() {
		System.out.println("1. List All Departments");
		System.out.println("2. List All Empoyees");
		System.out.println("3. Exit");
		System.out.println("-----------------------------------------------------");
	}
	
	public static void displayAllDepartments(List<Department> departments) {
		System.out.println("-----------------------------------------------------");
		System.out.println("------------------All Departments--------------------");
		System.out.println("-----------------------------------------------------");
		for(Department department : departments) {
			System.out.println("Department Id: " +  department.getId()  + " Department Name " + department.getName());
		}
		departmentMenuOptions();
	}
	
	
	public static void departmentMenuOptions() {
		System.out.println("1. Select Department By Id");
		System.out.println("2. Return to main menu");

	}
	
	public static void employeeListMenuOptions() {
		System.out.println("1. Select Employee By Id");
		System.out.println("2. Add new employee");
		System.out.println("3. Return to main menu");
	}
	
	public static void employeeMenuOptions() { ///stretch goal make update to all fields
		System.out.println("1. Update name");
		System.out.println("2. Update department");
		System.out.println("3. Delete employee");
		System.out.println("4. Return to main menu");
	}
	
	public static void displayDepartment(Department department) {
		System.out.println(department);
//		for(Employee employee : department.getDepartmentEmployees()) {
//			System.out.println("Employee name");
//		}
	}
	
	public static void displayAllEmployees(List<Employee> employees) {
		System.out.println("-----------------------------------------------------");
		System.out.println("-------------------All Employees---------------------");
		System.out.println("-----------------------------------------------------");
		for(Employee employee : employees) {
			System.out.println("Employee Id: " +  employee.getId()  + " Employee Name " + employee.getName() + " Department id: " + employee.getDepartment().getName());
		}
		
		employeeListMenuOptions();
	}
	
	public static void displayEmployee(Employee employee) {
		System.out.println("Employee Id: " +  employee.getId()  + " Employee Name " + employee.getName() + " Department" + employee.getDepartment().getName());
		employeeMenuOptions();
	}
	
	
	
}
