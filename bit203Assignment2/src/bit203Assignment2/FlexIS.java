package bit203Assignment2;
import java.io.*;
import java.util.*;

// Date: 7th April 2023

/*FlexIS class*/

/*@authors
 * Sebastian Chai B2000080
 * Lee Xin Yao B2100617*/


public class FlexIS {
	 private static int FWAIncrement = 1;
	 private ArrayList<Department> departments;
	 private ArrayList<Employee> employees;
	 /**
	 * Constructor for instantiating FlexIS object.
	 */
	 public FlexIS() {
	 setDepartments(new ArrayList<Department>());
	 setEmployees(new ArrayList<Employee>());
	 }
	 /**
	 * Returns a collection of FWARequest for s department
	 * @param dept Department for which the collection of requests is
	 * to be obtained.
	 * @return Collection of FWARequest of the parametric department
	 */
	 public ArrayList<FWARequest> getAllFWARequestsForDept(Department dept) {
	 return dept.getAllFWARequests();
	 }
	 
	 /**
	 * Return the count of number of employees for each work type for
	 * a specific department.
	 * @param dept Department for which the count is needed
	 * @return The count of number of employees for each work type for
	 * the parametric department.
	 */
	 public Map<String, Long> getWorkType(Department dept) {
	 return dept.getWorkType();
	 }
	 
	 /**
	 * Return the count of employees for each work type for all
	 * the departments.
	 * @return Return a string consists of the count of employees 
	 * for each work type for all the departments 
	 */
	 public String getWorkTypes() {
	 String result = "";
	 for (Department dept: getDepartments()) {
	 result += dept.getDeptID() + " " + dept.getDeptName() + "\n";
	 Map<String, Long> workType = getWorkType(dept);
	 for (Map.Entry<String, Long> pair: workType.entrySet()) {
	 result += " " + pair.getKey() + " : " + pair.getValue() + "\n";
	 }
	 }
	 return result;
	 }
	 
	 /**
	 * To add a new department into the FlexIS object.
	23
	 * @param dept Department that will be added into the FlexIS object.
	 */
	 public void addDepartment(Department dept) {
	 departments.add(dept);
	 }
	 
	 /**
	 * Returns the department's ID as a string, one per line
	 * @return A string consists of the departments's ID, one
	 * per line.
	 */
	 public String allDepartmentIDs() {
	 return getDepartments().stream()
	 .map(d -> d.getDeptID())
	 .collect(Collectors.joining("\n"));
	 }
	 
	 /**
	 * Returns a string consists of the details of each
	 * department, one per line
	 * @return A string consists of the details of each
	 * department, one per line
	 */
	 public String allDepartments() {
	 return getDepartments().stream()
	.map(Department::toString)
	.collect(Collectors.joining("\n"));
	 }
	 
	 /**
	 * Finds a Department with the matching department ID.
	 * @param deptID The given department ID to be searched.
	 * @return The Department with the matching deptID.
	 */
	 public Department findDepartment(String deptID) {
	 return getDepartments().stream()
	.filter(d -> d.getDeptID().equalsIgnoreCase(deptID))
	.findFirst()
	.orElse(null);
	 }
	 
	 /**
	 * Generates a random password of length 8 for an Employee.
	 * @return a random password.
	 */
	 public String generatePassword() {
	 Random random = new Random();
	 int randNum = random.nextInt(1000); // 0 to 999
	 return String.format("Hello%3d", randNum);
	 }
	 
	 /**
	 * Add an employee (could be HRAdmin, Supervisor, or Employee
	 * to the FlexIS
	 * @param employee Employee to be added to the FlexIS instance
	 */
	 public void addEmployee(Employee employee) {
	24
	 getEmployees().add(employee);
	 }
	 
	/**
	* Find Employee by employee ID
	* @param employeeID The given employee ID to be searched.
	* @return Employee with the parametric employeeID, or null if no matches
	*/
	public Employee findEmployee(String employeeID) {
	return getEmployees().stream()
	.filter(emp -> emp.getEmployeeID().equalsIgnoreCase(employeeID))
	.findAny()
	.orElse(null);
	}
	 
	/**
	* Return a string containing details of all employees, in original order
	* or sorted according to name
	* @return a string containing details of all employees, in original order
	* or sorted according to name
	*/
	public String sortedEmployees(String criteria) {
	if(criteria.equalsIgnoreCase("ORIGINAL"))
	return getEmployees().stream()
	.map(Employee::toString)
	.collect(Collectors.joining("\n"));
	else // sorted according to "NAME"
	return getEmployees().stream()
	.sorted(Comparator.comparing(Employee::getName))
	.map(Employee::toString)
	.collect(Collectors.joining("\n"));
	}
	 
	 /**
	 * Adds an Employee into FlexIS and under their Department.
	 * For Employees without a Supervisor.
	 * @param emp The given Employee.
	 * @param dept The given Department.
	 */
	 public void addEmployee(Employee emp, Department dept) {
	 getEmployees().add(emp);
	 dept.getEmployees().add(emp);
	 }
	 
	 /**
	 * Edits the FWARequest after being reviewed, and then replaces
	 * the unreviewed FWARequest.
	 * @param emp The FWARequest to be updated and stored.
	 * @return true or false.
	 */
	 public FWARequest findPendingRequest(Employee emp) {
	 for(FWARequest fwar : emp.getFWARequests())
	 if(fwar.getStatus().equalsIgnoreCase("pending"))
	 return fwar; 
	 return null;
	 }
	 
	25
	 /**
	 * Find and return the collection of DailySchedules, sorted according
	 * to Department, followed by employee's name
	 * @return A collection of DailySchedule sorted according to employee's
	 * name for each department.
	 */
	 public TreeMap<Department, TreeMap<String, ArrayList<DailySchedule>>> 
	 getAllDailySchedules() {
	 TreeMap<Department, TreeMap<String, ArrayList<DailySchedule>>> allDS = 
	 new TreeMap<>();
	 for (Department dept: getDepartments())
	 allDS.put(dept, dept.getDailySchedulesByEmployee());
	 return allDS;
	 }
	 
	 /**
	 * Creates a new request ID for a FWARequest.
	 * @return a new FWA request ID.
	 */
	 public String assignFWARequestID() {
	 return "FWA" + FWAIncrement++;
	 }
	 /**
	 * Gets the list of departments of this FlexIS.
	 * @return the departments list.
	 */
	 public ArrayList<Department> getDepartments() {
	 return departments;
	 }
	 
	 /**
	 * Gets the list of employees (all users) of this FlexIS.
	 * @return the employees list.
	 */
	 public ArrayList<Employee> getEmployees() {
	 return employees;
	 }
	 
	 /**
	 * Gets the current number of the FWAIncrement.
	 * @return the FWAIncrement.
	 */
	 public static int getFWAIncrement() {
	 return FlexIS.FWAIncrement;
	 }
	 
	 /**
	 * Change the list of departments of this FlexIS.
	 * @param departments This FlexIS's new departments array list.
	 */
	 public void setDepartments(ArrayList<Department> departments) {
	 this.departments = departments;
	 }
	 
	 /**
	 * Change the list of employees (all users) of this FlexIS.
	26
	 * @param employees This FlexIS's new employees array list.
	 */
	 public void setEmployees(ArrayList<Employee> employees) {
	 this.employees = employees;
	 }
	 
	 /**
	 * Changes the FWA increment of this FlexIS.
	 * @param FWAIncrement This FlexIS's new FWAIncrement.
	 */
	 public static void setFWAIncrement(int FWAIncrement) {
	 FlexIS.FWAIncrement = FWAIncrement;
	 }
	}