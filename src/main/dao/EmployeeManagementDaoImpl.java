package main.dao;

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

import main.exceptions.DepartmentCreationException;
import main.exceptions.EmployeeCreationException;
import main.models.Department;
import main.models.Employee;

public class EmployeeManagementDaoImpl implements EmployeeManagementDao{

    public static final String DELIMITER = "::";

	private TreeMap<Integer, Department> departments = new TreeMap<>();
	
	private TreeMap<Integer, Employee> employees = new TreeMap<>();
	
	private String[] ministryDepartments = {"Minister for Magic and Support Staff", "Magical Law Enforcement",
			"Magical Accidents and Catastrophes", "Regulation and Control of Magical Creatures",
			"International Magic Cooperation", "Magical Transportation",
			"Magical Games and Sports", "Mysteries"};
	
	
	private String[] ministryNames = {"Alastor Gumboil", "Albert Boot", "Amos Diggory",
										"Archer Evermonde", "Royden Poke", "Newt Scamander","Ignatius Tuft",
										"Dolores Umbridge", "Barty Crouch Sr.", "Eldritch Diggory"};
	
	private String[] titles = {"Auror", "Accountant","Calamity Investigator", "Hit Wizard", "Research Assistant"};
	
	
	@Override
	public List<Department> getAllDepartments() {
		return new ArrayList<Department>(departments.values());
	}

	@Override
	public Department getDepartment(int departmentId) {
		return departments.get(departmentId);
	}

	@Override
	public void setEmployeeDepartment(int employeeId, int departmentId) {
		departments.get(departmentId).addDepartmentEmployee(employees.get(employeeId));		
	}

	@Override
	public List<Employee> getAllEmployees() {
		return new ArrayList<Employee>(employees.values());
	}

	@Override
	public Employee getEmployee(int employeeId) {
		return employees.get(employeeId);
	}

	@Override
	public void deleteEmployee(int employeeId) {
		departments.get(employees.get(employeeId).getDepartment().getId()).removeDepartmentEmployee(employees.get(employeeId));
		employees.remove(employeeId);		
	}

	@Override
	public Employee updateEmployeeName(int employeeId, String name) {
		employees.get(employeeId).setName(name);
		return employees.get(employeeId);

	}

	@Override
	public Employee updateEmployeeDepartment(int employeeId, int departmentId) {
		employees.get(employeeId).setDepartment(departments.get(departmentId));
		return employees.get(employeeId);
	}

	@Override
	public Employee addNewEmployee(Employee employee) {
		employees.put(employee.getId(), employee);
		departments.get(employee.getDepartment().getId()).addDepartmentEmployee(employee);
		return employees.get(employee.getId());
	}
	
	public void writeDataToTxtFile() {
		File file = new File("resources/Employees.txt");
		try(PrintWriter out = new PrintWriter(new FileWriter(file)))
		{
			if(!file.exists()) {
				file.createNewFile();
			}
			List<Department> deptList = getAllDepartments();
			for(Department department : deptList) {
				out.println(department.getId() + DELIMITER
						+ department.getName()
						);
			}
			out.println("***");
			List<Employee> empList = getAllEmployees();
			for(Employee employee : empList) {
				out.println(employee.getId() + DELIMITER
						+ employee.getDepartmentId() + DELIMITER
						+ employee.getName() + DELIMITER
						+ employee.getTitle() + DELIMITER
						+ employee.getSalary()
						);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void readDataFromTxtFile() throws NumberFormatException, DepartmentCreationException, EmployeeCreationException {
		File file = new File("resources/Employees.txt");
		
		try(BufferedReader br = new BufferedReader(new FileReader(file))){
			
			String line;
			while((line = br.readLine()).compareTo("***") != 0) {
				String[] deptAttributes = line.split(DELIMITER, 2 );
				departments.put(Integer.parseInt(deptAttributes[0]), new Department(Integer.parseInt(deptAttributes[0]), deptAttributes[1]));
			}
			while((line = br.readLine()) != null) {
				String[] empAttributes = line.split(DELIMITER, 5 );
				int empId = Integer.parseInt(empAttributes[0]);
				int deptId = Integer.parseInt(empAttributes[1]);
				String name = empAttributes[2];
				String title = empAttributes[3];
				int salary = Integer.parseInt(empAttributes[4]);
				Department dept = departments.get(Integer.parseInt(empAttributes[1]));
							
				employees.put(empId,new Employee(empId, deptId, name, dept, title, salary));
				
				Employee.setCounter(employees.lastKey() + 1);
			}

		}catch(IOException e){
			
		}
		

	}

	@Override
	public void seedData() throws EmployeeCreationException, DepartmentCreationException {
		setDepartments();
		setEmployees();		
	}

	@Override
	public void setDepartments() throws DepartmentCreationException {
		for(int i = 0; i < ministryDepartments.length; i++) {
			departments.put(i + 1, new Department(i + 1 , ministryDepartments[i]));
		}
	}

	@Override
	public void setEmployees() throws EmployeeCreationException {
		Random rand = new Random();
		for(int i = 0; i < ministryNames.length; i++) {
			employees.put(i + 1, new Employee(rand.nextInt(4),ministryNames[i], departments.get(rand.nextInt(departments.size()) + 1),
					titles[rand.nextInt(titles.length)], rand.nextInt(20000) + 50000));
			setDepartmentEmployee(employees.get(i+1), employees.get(i+1).getDepartmentId());
		}		
	}

	@Override
	public void setDepartmentEmployee(Employee employee, int departmentId) {
		departments.get(departmentId).addDepartmentEmployee(employee);		
	}

}
