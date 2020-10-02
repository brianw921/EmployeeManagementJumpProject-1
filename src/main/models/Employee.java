package main.models;

public class Employee {
	
	static int counter = 1;
	
	private int id;
	private int departmentId;
	private Department department;
	private String name;
	
	
	public Employee(int departmentId, String name, Department department) {
		this.id = counter++;
		this.departmentId = departmentId;
		this.name = name;
		this.department = department;
		this.departmentId = department.getId();
		
	}
	
	public Employee(int id, int departmentId, String name, Department department) {
		this.id = id;
		this.departmentId = departmentId;
		this.name = name;
		this.department = department;
		this.departmentId = department.getId();
		
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
	
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", departmentId=" + departmentId + ", name=" + name + "]";
	}
	
}
