package bit203Assignment;
import java.util.*;
/*Supervisor class
 * Subclass of Employee class
 * It inherits all attributes and methods from Employee class
 * It contains constructor, getters and setters method, and toString() method*/

/*@author:
 * Sebastian Chai B2000080
 * Lee Xin Yao B2100617
 * */
public class Supervisor extends Employee{
	private String employeeID, password, name, position, email, FWAStatus;
	private ArrayList<Employee> employee;
	
	// Employee objects
	Employee em1 = new Employee("E100","IamAdam","Adam","Accountant","adam246@gmail.com","Work-from-home");
    Employee em2 = new Employee("E200","IamLucas","Lucas","Assistant Manager","lucaslee@gmail.com","Hybrid");
    Employee em3 = new Employee("E300","IamSara","Sara","Assistant Manager","sara578@gmail.com","Flexi-hours");
    Employee em4 = new Employee("E400","IamJohn","John","Software developer","johnwong88@gmail.com","Work-from-home");
	
	public Supervisor() {
		setEmployeeID(employeeID);
		setPassword(password);
		setName(name);
		setPosition(position);
		setEmail(email);
	}
	
	// Constructor
	public Supervisor(String employeeID, String password, String name, String position, String email, String FWAStatus) {
		super(employeeID, password, name, position, email, FWAStatus);
		setEmployeeID(employeeID);
		setPassword(password);
		setName(name);
		setPosition(position);
		setEmail(email);
	}
	
	/*Getters and Setters*/
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
	
	public void setFWAStatus(String FWAStatus) {
		this.FWAStatus = FWAStatus;
	}
	
	// toString() method
	public String toString() {
		return ("Supervisor's details \n"+super.toString());
	}
}
