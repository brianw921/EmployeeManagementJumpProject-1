package main.models;

import java.util.HashMap;

import main.exceptions.DepartmentCreationException;
import main.exceptions.EmployeeCreationException;

public class Employee {
	
	static int counter = 1;
	
	private int id;
	private int departmentId;
	private Department department;
	private String name;
	private String title;
	private int salary;
	public static HashMap<Integer,Employee> employees = new HashMap<>();

	
	public Employee(int departmentId, String name, Department department, String title, int salary) throws EmployeeCreationException{
		this.id = counter++;
		this.departmentId = departmentId;
		this.name = name;
		this.department = department;
		this.departmentId = department.getId();
		this.title = title;
		this.salary = salary;
		if(!employees.containsKey(id)) {
			employees.put(id, this);
		}else { 
			throw new EmployeeCreationException(id);
		}	
	}
	
	public Employee(int id, int departmentId, String name, Department department, String title, int salary)  throws EmployeeCreationException {
		this.id = id;
		this.departmentId = departmentId;
		this.name = name;
		this.department = department;
		this.departmentId = department.getId();
		this.title = title;
		this.salary = salary;
		if(!employees.containsKey(id)) {
			employees.put(id, this);
		}else { 
			throw new EmployeeCreationException(id);
		}	
	}
	
	public static void setCounter(int lastId) {
		counter = lastId;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", departmentId=" + departmentId + ", name=" + name + ", title=" + title
				+ ", salary=" + salary + "]";
	}

	
}
