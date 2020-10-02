package main.exceptions;

public class EmployeeCreationException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 368728657755298002L;

	public EmployeeCreationException(int id){
		super("Employee with ID " + id + " already exists");
	}
}
