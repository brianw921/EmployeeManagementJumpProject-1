package main.exceptions;

public class DepartmentCreationException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3439705326427400321L;

	public DepartmentCreationException(int id) {
		super("Department with ID " + id + " is already in use.");
	}
}
