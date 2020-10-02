package main.models;

import java.util.HashMap;

import main.exceptions.DepartmentCreationException;

public class Department {
	public static HashMap<Integer,Department> departments = new HashMap<>();

	private int id;
	private String name;
	private HashMap<Integer,Employee> departmentEmployees = new HashMap<>();
	
	
	public Department(int id, String name) throws DepartmentCreationException{
		super();
		this.id = id;
		this.name = name;
		
		if(!departments.containsKey(id)) {
				departments.put(id, this);
		}else { 
			throw new DepartmentCreationException(id);
		}
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
