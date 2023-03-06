package bit203Assignment;
import java.util.*;
/*Department class
 * This class stores department's information, such as deptID and deptName*/

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
	
	public String toString() {
		return ("Department ID "+'\t'+"Department Name "+
				"\n"+getDeptID()+'\t'+'\t'+getDeptName());
	}
	
}
