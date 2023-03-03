package bit203Assignment;
import java.util.*;

/*@authors
 * Sebastian Chai B2000080
 * Lee Xin Yao B2100617*/


public class FlexIS {
	/*
	 * Store Object collections
	 * Store functions for menu
	 * Ex. login, register Employee, submit request etc
	 * Used for manipulate data
	 * */
	private static String employeeID, password, name, position, email, FWAStatus;
	private static String date, workLocation, workHours, workReport, supervisorComment;
	private String deptID, deptName;
	private static ArrayList<Employee> employee;	
	private static ArrayList<Department> department;	
	
	static Scanner sc = new Scanner(System.in);
	
	public FlexIS() {}
	
	// Login() method
	public static void login() {
		// while loop
		while(true) {
			System.out.print("Enter employee ID: ");
			employeeID = sc.nextLine();
			
			System.out.print("Enter Password: ");
			String password = sc.nextLine();
			
			if(employeeID.isEmpty() || password.isEmpty())
				System.out.println("Invalid employee ID or password");
			
			if("HR100".equalsIgnoreCase(employeeID) && "IamNicholas".equalsIgnoreCase(password)) {
				System.out.println("You have logged in successfully.");
				break;
			}
			else if("S100".equalsIgnoreCase(employeeID) && "IamAli".equalsIgnoreCase(password)) {
				System.out.println("You have logged in successfully.");
				break;
			}
			}
			
		}
		
	
	
	public static void displayEmployeeInfo() {}
	
	public static void displayDailyScheduleInfo() {}
	
	public static void sortEmployee() {}
	
	public static void sortDepartment() {}

	public static void registerEmployee() {
		while(true) {
			System.out.print("Departments:\n"
							+ "1. A0001-Accounting\n"
							+ "2. HR0001-Human Resource\n"
							+ "3. P0001- Public Relation\n"
							+ "4. IT0001- IT");
			System.out.print("\nSelect a department: ");
			String deptID = sc.nextLine();
			if("A0001".equalsIgnoreCase(deptID) ||"HR0001".equalsIgnoreCase(deptID)|| 
				"P0001".equalsIgnoreCase(deptID)|| "IT0001".equalsIgnoreCase(deptID)) {
				break;
				}
			}
		
		while(true) {
			System.out.print("\nEnter employee ID: ");
			String employeeID = sc.nextLine();
			if("E100".equalsIgnoreCase(employeeID)|| "E200".equalsIgnoreCase(employeeID)|| 
				"E300".equalsIgnoreCase(employeeID)|| "E400".equalsIgnoreCase(employeeID)) {
				break;
			}
		}
		
		while(true) {
			System.out.print("\nEnter name: ");
			String name = sc.nextLine();
			if(name.isEmpty())
				System.out.println("Invalid name.");
			else
				break;
			}
		
			
		while(true) {
			System.out.print("\nEnter position: ");
			String position = sc.nextLine();
			if(position.isEmpty())
				System.out.println("Invalid position");
			else
				break;
		}			
		
		while(true) {
			System.out.print("\nEnter email: ");
			 email = sc.nextLine();
			if(email.isEmpty())
				System.out.println("Email cannot be empty");
			else {
				break;}
		}
		
		System.out.println("Employee "+name+" has been registered.");
		
		System.out.println("Email has been sent to "+ email);
		System.out.println();
		System.out.println(name +" FWA Status: New");
	}
	
	public static void updateDailySchedule() {
		while(true) {
			System.out.print("Select a date (yyyy-MM-dd): ");
			date = sc.nextLine();
			if(date.isEmpty())
				System.out.println("Invalid date.");
			else
				break;
		}
		
		
		while(true) {
			System.out.print("\nEnter work location: ");
			workLocation = sc.nextLine();
			if(workLocation.isEmpty())
				System.out.println("Invalid work location.");
			else
				break;
		}
		
			
		while(true) {
			System.out.print("\n1. 8am - 4pm\n"
							+ "2. 9am - 5pm\n"
							+ "3. 10am - 6pm");
			System.out.print("\nEnter work hours: ");
			workHours = sc.nextLine();
			if("8am-4pm".equalsIgnoreCase(workHours)|| "9am-5pm".equalsIgnoreCase(workHours)|| 
				"10am-6pm".equalsIgnoreCase(workHours)) {
				break;
			}
		}
		while(true) {
			System.out.print("\nEnter work report: ");
			workReport = sc.nextLine();	
			if(workReport.isEmpty())
				System.out.println("Invalid work report.");
			else
				break;
		}
			
		
		System.out.println("\nYour daily schedule has been updated.");
		System.out.println("Date: " + date
						+ "\nWork location: " + workLocation
						+ "\nWork hours: " + workHours
						+ "\nWork report: "+ workReport
						);
	}

	public static void reviewDailySchedule() {
		System.out.print("Select a Date: ");
		date = sc.nextLine();
		
		System.out.print("\nSelect an employee ID: ");
		employeeID = sc.nextLine();
		
		System.out.print("\nEnter your comment: ");
		supervisorComment = sc.nextLine();
	}

	
	//public String toString() {}
	
	

}