package bit203Assignment;
import java.util.Scanner;

/*
 * This is the Employee superclass
 * Supervisor and HRAdmin class are its subclasses
 * This class stores employee's information*/

/*@author:
 * Sebastian Chai B2000080
 * Lee Xin Yao B2100617
 * */

public class Employee {
	
	Scanner sc = new Scanner(System.in);
	// Attributes
	private String employeeID, password, name, position, email, FWAStatus;
	private Department deptID, deptName;
	private DailySchedule date, workLocation, workHours, workReport;
	
	public Employee() {
		setEmployeeID(employeeID);
		setPassword(password);
		setName(name);
		setPosition(position);
		setEmail(email);
		setFWAStatus(FWAStatus);

	}
	
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

	public void setFWAStatus(String fWAStatus) {
		FWAStatus = fWAStatus;
	}

	public Department getDeptID() {
		return deptID;
	}

	public void setDeptID(Department deptID) {
		this.deptID = deptID;
	}

	public Department getDeptName() {
		return deptName;
	}

	public void setDeptName(Department deptName) {
		this.deptName = deptName;
	}
	
	public DailySchedule getDate() {
		return date;
	}

	public void setDate(DailySchedule date) {
		this.date = date;
	}
	
	
	public DailySchedule getWorkLocation() {
		return workLocation;
	}

	public void setWorkLocation(DailySchedule workLocation) {
		this.workLocation = workLocation;
	}

	public DailySchedule getWorkHours() {
		return workHours;
	}

	public void setWorkHours(DailySchedule workHours) {
		this.workHours = workHours;
	}

	public DailySchedule getWorkReport() {
		return workReport;
	}

	public void setWorkReport(DailySchedule workReport) {
		this.workReport = workReport;
	}
	
	/*toString() method*/
	public String toString() {
		return 
		(
			"Employee ID "+'\t'+"Password"+'\t'+"Name"+'\t'+"Position"+'\t'+"Email"+'\t'+'\t'+"FWAStatus"+
	  "\n"+ getEmployeeID()+'\t'+'\t'+getPassword()+'\t'+getName()+'\t'+getPosition()+'\t'+
	  getEmail()+'\t'+getFWAStatus()
	  );
		}
	
	/*equals() method to check if two employee IDs are the same*/
	public boolean equals(Object obj) {
		Employee e = (Employee) obj;
		if(obj instanceof Employee) {
			if(this.employeeID.equals(e.employeeID))
				return true;
		}
		return false;
	}
	
	}
