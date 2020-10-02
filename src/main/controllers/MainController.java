package main.controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;

import main.models.Department;
import main.models.Employee;

public class MainController {

    public static final String DELIMITER = "::";

	static TreeMap<Integer, Department> departments = new TreeMap<>();
	
	static TreeMap<Integer, Employee> employees = new TreeMap<>();
	

	public static void setDepartmentsFromFile() {
		readDataFromTxtFile();
	}
	
	
	static String[] ministryDepartments = {"Minister for Magic and Support Staff", "Department of Magical Law Enforcement",
									"Department of Magical Accidents and Catastrophes", "Department of Regulation and Control of Magical Creatures",
									"Department of International Magic Cooperation", "Department of Magical Transportation",
									"Department of Magical Games and Sports", "Department of Mysteries"};
	

	
	public static void setDepartmentEmployee(Employee employee, int departmentId) {
		departments.get(departmentId).addDepartmentEmployee(employee);		
	}
	
	public List<Department> getAllDepartments(){
		return new ArrayList<Department>(departments.values());
	}
	
	public Department getDepartment(int departmentId){
		return departments.get(departmentId);
	}
	
	
	public List<Employee> getAllEmployees(){
		return new ArrayList<Employee>(employees.values());
	}
	
	public Employee getEmployee(int employeeId) {
		return employees.get(employeeId);
			
	}
	
	public void deleteEmployee(int employeeId) {
		departments.get(employees.get(employeeId).getDepartment().getId()).removeDepartmentEmployee(employees.get(employeeId));
		employees.remove(employeeId);
		
	}
	
	public void updateEmployeeName(Employee employee, String name) {
		employee.setName(name);
	}
	
	public void updateEmployeeDepartment(Employee employee, int departmentId) {
		employee.setDepartment(departments.get(departmentId));
	}
	
	public void addNewEmployee(Employee employee) {
		employees.put(employee.getId(), employee);
		departments.get(employee.getDepartment().getId()).addDepartmentEmployee(employee);

	}
	
	public void saveData() {
		writeDataToTxtFile();
	}
	
	public void readDataFromTxt() {
		readDataFromTxtFile();
	}
	
	private void writeDataToTxtFile() {
		File file = new File("resources/Employees.txt");
		try(PrintWriter out = new PrintWriter(new FileWriter(file)))
		{
			if(!file.exists()) {
				file.createNewFile();
			}
			List<Department> deptList = getAllDepartments();
			for(Department department : deptList) {
				out.println(department.getId() + "::"
						+ department.getName()
//						+ department.getDepartmentEmployees()		
										
						);
			}
			out.println("***");
			List<Employee> empList = getAllEmployees();
			for(Employee employee : empList) {
				out.println(employee.getId() + "::"
						+ employee.getDepartmentId() + "::"
						+ employee.getName()									
						);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void readDataFromTxtFile() {
		File file = new File("resources/Employees.txt");
		
		try(BufferedReader br = new BufferedReader(new FileReader(file))){
			
			String line;
			while((line = br.readLine()).compareTo("***") != 0) {
				String[] deptAttributes = line.split(DELIMITER, 2 );
				departments.put(Integer.parseInt(deptAttributes[0]), new Department(Integer.parseInt(deptAttributes[0]), deptAttributes[1]));
			}
			while((line = br.readLine()) != null) {
				String[] empAttributes = line.split(DELIMITER, 3 );
				int empId = Integer.parseInt(empAttributes[0]);
				int deptId = Integer.parseInt(empAttributes[1]);
				String name = empAttributes[2];
				Department dept = departments.get(Integer.parseInt(empAttributes[1]));
							
				employees.put(empId,new Employee(empId, deptId, name, dept));
			}

		}catch(IOException e){
			
		}
		

	}
	
	public static void seedData() {
		setDepartments();
		setEmployees();
	}
	
	private static void setDepartments() {
		for(int i = 0; i < ministryDepartments.length; i++) {
			departments.put(i + 1, new Department(i + 1 , ministryDepartments[i]));
		}
	}
	
	private static  void setEmployees() {
		Random rand = new Random();
		for(int i = 1; i < 11; i++) {
			employees.put(i, new Employee(rand.nextInt(4),"Employee " + i, departments.get(rand.nextInt(departments.size()) +1 )));
			setDepartmentEmployee(employees.get(i), employees.get(i).getDepartmentId());
		}
	}
	
	
}
