package bit203Assignment2;

import java.util.ArrayList;


/*@author:
 * Lee Xin Yao B2100617
*/
public class Department {
	private String deptID, deptName; // Department attributes
	private ArrayList<Employee> employee= new ArrayList<Employee>(); // Employee object
	
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
		return (getDeptID() +": "+getDeptName());
	}
	
}