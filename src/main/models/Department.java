package main.models;

import java.util.HashMap;

public class Department {

	private int id;
	private String name;
	private HashMap<Integer,Employee> departmentEmployees = new HashMap<>();
	
	public Department() {
	
	}
	
	public Department(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HashMap<Integer, Employee> getDepartmentEmployees() {
		return departmentEmployees;
	}

	public void setDepartmentEmployees(HashMap<Integer, Employee> departmentEmployees) {
		this.departmentEmployees = departmentEmployees;
	}
	
	public void addDepartmentEmployee(Employee employee) {
		this.departmentEmployees.put(employee.getId(), employee);
	}
	
	public void removeDepartmentEmployee(Employee employee) {
		this.departmentEmployees.remove(employee.getId(), employee);
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", departmentEmployees=" + departmentEmployees + "]";
	}
	
	
	
}
