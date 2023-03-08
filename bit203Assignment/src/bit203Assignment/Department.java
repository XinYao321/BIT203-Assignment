package bit203Assignment;
import java.util.*;
/*Department class
 * This class stores department ID and department name
 * It contains Constructor, getters and setters method, and toString() method*/

/*@author:
 * Lee Xin Yao B2100617
*/
public class Department {
	private String deptID, deptName; // Department attributes
	private ArrayList<Employee> employee; // Employee object
	
	
	// Constructor
	public Department(String deptID, String deptName) {
		setDeptID(deptID);
		setDeptName(deptName);
	}
	
	// Getters and Setters method
	public String getDeptID() {
		return deptID;
	}
	
	public void setDeptID(String deptID) {
		this.deptID = deptID;
	}
	
	public String getDeptName() {
		return deptName;
	}
	
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	// toString() method
	public String toString() {
		return (getDeptID()+": "+getDeptName());
	}
	
}
