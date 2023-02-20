package bit203Assignment;

// Employee superclass

/*@author:
 * Sebastian Chai B2000080
 * Lee Xin Yao B2100617
 * */

public class Employee {
	private String employeeID, password, name, position, email, FWAStatus;

	// Constructor
	public Employee(String employeeID, String password,String name,
			String position,String email,String FWAStatus) {
		setEmployeeID(employeeID);
		setPassword(password);
		setName(name);
		setPosition(position);
		setEmail(email);
		setFWAStatus(FWAStatus);

	}
	
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

	public String getFWAStatus() {
		return FWAStatus;
	}

	public void setFWAStatus(String fWAStatus) {
		FWAStatus = fWAStatus;
	}
	
	// To Do: toString(),submitFWARequest(), updateDailySchedule()
}
