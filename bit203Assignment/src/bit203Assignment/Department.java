package bit203Assignment;

// Department class

/*@author:
 * Lee Xin Yao B2100617
*/
public class Department {
	private String deptID;
	private String deptName;
	
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
	
	// TODO: toString()
}
