package bit203Assignment;

/*HR Admin class
 * Subclass of Employee superclass
 * This class inherits all attributes and methods from Employee*/

/*@author:
 * Sebastian Chai B2000080
 * Lee Xin Yao B2100617
 * */
public class HRAdmin extends Employee{
	
	private String employeeID, password, name, position, email;
	
	public HRAdmin() {
		setEmployeeID(employeeID);
		setPassword(password);
		setName(name);
		setPosition(position);
		setEmail(email); 
		}
	
	
	// Constructor
	public HRAdmin(String employeeID, String password, String name, String position, String email,String FWAStatus) {
		super(employeeID, password, name, position, email, FWAStatus);
		setEmployeeID(employeeID);
		setPassword(password);
		setName(name);
		setPosition(position);
		setEmail(email);
	}
	
	// Getters and Setters method
	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	//toString() method
	public String toString() {
		return (super.toString());
	}
}
