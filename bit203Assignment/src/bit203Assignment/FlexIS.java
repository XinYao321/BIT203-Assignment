package bit203Assignment;
import java.util.*;


/*@authors
 * Sebastian Chai B2000080
 * Lee Xin Yao B2100617*/


public class FlexIS {
	/*Employee and Department collections*/
	private static ArrayList<Employee> employee = new ArrayList<>();	
	private static ArrayList<Department> department = new ArrayList<>();	
	
	static Scanner sc = new Scanner(System.in);
	
	public FlexIS() {}
	
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
		
		employee.forEach(e->
		{System.out.println(e);
		});
	}
	
	public int EmployeeSize() {
		return employee.size();
	}
	
	public static void displayDailyScheduleInfo() {}
	
	public static void sortEmployee() {}
	
	public static void sortDepartment() {}

	
	//public String toString() {}
	
}