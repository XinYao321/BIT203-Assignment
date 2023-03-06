package bit203Assignment;
import bit203Assignment.FlexIS;
import java.util.*;

/*Driver class- FlexConsole
 * This class contains main method
 * It will display a menu program for users
 * User must login before selecting an option*/

/*@authors:
 * Sebastian Chai B2000080
 * Lee Xin Yao B2100617
 * */

public class FlexISConsole {
	public static void main(String[] args) {
		
		FlexIS f = new FlexIS();
		Employee e = new Employee();
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		String employeeID, password, name,position, email, FWAStatus;
		String date, workLocation, workHours, workReport, supervisorComments;
		// HR Admin object
		HRAdmin hr = new HRAdmin("HR100","IamNicholas","Nicholas","HRAdmin","nicholaszz@gmail.com","-");
		// Department collection
		ArrayList<Department> department;
		
		// Welcome message
		System.out.println("Welcome to FlexIS System");
		// Display a list of options that users can perform
		System.out.println("Users can perform the following options:"
							+ "\n1. Register Employee"
							+ "\n2. View FWA Analytics"
							+ "\n3. Review FWA Request"
							+ "\n4. Review Employee Schedules"
							+ "\n5. Submit FWA Request"
							+ "\n6. Update Daily Schedule"
							+ "\n7. Display Employee details"
							+ "\n8. Display Daily Schedule details"
							+ "\n0. Quit");
		
		/* Login method
		 * Users must login before they can choose an option*/
		while(true) {
			System.out.print("Enter employee ID: ");
			employeeID = sc.nextLine();
			
			System.out.print("Enter Password: ");
			password = sc.nextLine();
			
			// If both employeeID and password are empty
			if(employeeID.isEmpty() || password.isEmpty())
				System.out.println("Invalid employee ID or password");
			
			// HR Admin login with valid employee ID and password
			else if("HR100".equalsIgnoreCase(employeeID) && "IamNicholas".equalsIgnoreCase(password)) {
				System.out.println("You have logged in successfully.");
				System.out.println("Select options below to continue: "
								+ "\n1. Register Employee"
								+ "\n2. View FWA Analytics");
				break;
			}
			// Supervisor login with valid employee ID and password
			else if("S100".equalsIgnoreCase(employeeID) && "IamAli".equalsIgnoreCase(password)) {
				System.out.println("You have logged in successfully.");
				System.out.println("Select the options below to continue:"
								+ "\n3. Review FWA Request"
								+ "\n4. Review Employee Schedules");
				break;
				}
			// Existing employees login with valid employee and password
			else if(("E100".equalsIgnoreCase(employeeID) && "IamAdam".equalsIgnoreCase(password))|| 
					("E200".equalsIgnoreCase(employeeID) && "IamLucas".equalsIgnoreCase(password)) || 
					("E300".equalsIgnoreCase(employeeID) && "IamSara".equalsIgnoreCase(password))|| 
					("E400".equalsIgnoreCase(employeeID) && "IamJohn".equalsIgnoreCase(password))) {
				System.out.println("You have logged in successfully.");
				System.out.println("Select the options below to continue:"
									+ "\n5. Submit FWA Request"
									+ "\n6. Update Daily Schedule");
				break;
			}
			}
		
		// do-while loop
		do {
			System.out.print("Enter your choice: ");
			choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			
			// Option 1: Register Employee or Supervisor
			case 1:
				// Department validation
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
				// EmployeeID validation
				while(true) {
					System.out.print("\nEnter employee ID: ");
					employeeID = sc.nextLine();
					if("E100".equalsIgnoreCase(employeeID)|| "E200".equalsIgnoreCase(employeeID)|| 
						"E300".equalsIgnoreCase(employeeID)|| "E400".equalsIgnoreCase(employeeID)) {
						break;
					}
				}
				
				// Name validation
				while(true) {
					System.out.print("\nEnter name: ");
					name = sc.nextLine();
					if(name.isEmpty())
						System.out.println("Invalid name.");
					else
						break;
					}
				
				
				// Position validation
				while(true) {
					System.out.print("\nEnter position: ");
					position = sc.nextLine();
					if(position.isEmpty())
						System.out.println("Invalid position");
					else
						break;
				}			
				
				// Email validation
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
					
			// Option 2 - view FWA Analytics
			case 2:
			
			// Option 3 - Review FWA Request
			case 3:
			
			// Option 4 - Review Employee Schedules			
			case 4:
			
			// Option 5 - Submit FWA request
			case 5:
			
			// Option 6 - Update Daily Schedule
			case 6:
				// Date validation
				while(true) {
					System.out.print("Select a date (yyyy-MM-dd): ");
					date = sc.nextLine();
					if(date.isEmpty())
						System.out.println("Invalid date.");
					else
						break;
				}
				// work location validation
				while(true) {
					System.out.print("\nEnter work location: ");
					workLocation = sc.nextLine();
					if(workLocation.isEmpty())
						System.out.println("Invalid work location.");
					else
						break;
				}
				
				// work hours validation	
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
				// work report validation	
				while(true) {
					System.out.print("\nEnter work report: ");
					workReport = sc.nextLine();	
					if(workReport.isEmpty())
						System.out.println("Invalid work report.");
					else
						break;
					}
				System.out.println("\nYour daily schedule have been updated successfully.");
				System.out.println("Your schedule on "+date);
				System.out.println("\nWork location: "+workLocation
									+ "\nWork hours: "+workHours
									+ "\nWork report: "+workReport);
			
			// Option 7: Display Employee details
			case 7:
			
			// Option 8: Display daily schedule details
			case 8:
				
					}
		} while(choice != 0);
		
		
		// If users want to exit program
		while(choice == 0) {
			System.out.println("--------The End--------");
			break;
		}
		
}
}
