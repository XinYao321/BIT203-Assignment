package bit203Assignment2;
import java.util.*;


/*@authors
 * Sebastian Chai B2000080
 * Lee Xin Yao B2100617*/


public class FlexIS {
	
	private String employeeID, deptID;
	/*Employee and Department collections*/
	private static ArrayList<Employee> employee = new ArrayList<>();	
	private static ArrayList<Department> department = new ArrayList<>();	
	
	// Department objects
	Department d1 = new Department("A0001","Accounting");
	Department d2 = new Department("HR0001","Human Resource");
	Department d3 = new Department("PR0001","Public Relation");
	Department d4 = new Department("IT0001","IT");
	
	// Constructor
	public FlexIS() {
		setEmployeeID(employeeID);
		setDeptID(deptID);
		
	}
	
	// Display every employee's details sorted by name
	public void displayEmployeeInfo() {
		Employee e1 = new Employee("E100","IamAdam","Adam","Accountant","adam246@gmail.com","pending");
		Employee e2 = new Employee("E200","IamLucas","Lucas","Assistant Manager","lucaslee@gmail.com","pending");
		Employee e3 = new Employee("E300","IamSara","Sara","Assistant Manager","sara578@gmail.com","pending");
		Employee e4 = new Employee("E400","IamJohn","John","Software Developer","johnwong88@gmail.com","pending");
		Supervisor e5 = new Supervisor("S100","IamAli","Ali","Supervisor","alimuhamad@gmail.com","-");
		
		employee.add(e1);
		employee.add(e2);
		employee.add(e3);
		employee.add(e4);
		employee.add(e5);
		
		// Lambda expression to display all employees
		employee.forEach(e->
		{System.out.println(e);
		});
	}
	
	// return size of Employee
	public int EmployeeSize() {
		return employee.size();
	}
	
	// return size of Department
	public int DepartmentSize() {
		return department.size();
	}
	
	// Getters and Setters
	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public String getDeptID() {
		return deptID;
	}

	public void setDeptID(String deptID) {
		this.deptID = deptID;
	}
	
	
	//public String toString() {}
	
}