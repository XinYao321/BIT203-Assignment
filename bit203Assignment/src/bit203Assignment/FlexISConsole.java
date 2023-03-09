package bit203Assignment;
//import bit203Assignment.FlexIS;
import java.util.*;
import java.text.SimpleDateFormat;


/*Driver class- FlexConsole
 * This class contains main method
 * It will display a menu program for users
 * User must login before selecting an option*
 * Prior to the display of menu:
 * A FlexIS object, Department collection, and HRAdmin object is created/

/*@authors:
 * Sebastian Chai B2000080
 * Lee Xin Yao B2100617
 * */

public class FlexISConsole {
	public static void main(String[] args) {
		
		Employee e = new Employee();
		FlexIS f = new FlexIS();
		ArrayList<Department> department;
		
		// FWARequest objects for review
		FWARequest fr1_1 = new FWARequest("R001","2023-03-01", "Work-from-home", "Can set for 3 days?", "Not well", "Accepted", "Understood, take care");
		FWARequest fr1_2 = new FWARequest("R002","2023-03-07", "Flexi-Hours", "I can work for 1 week at office", "Home Wi-Fi not working", "Pending", "");
		FWARequest fr2_1 = new FWARequest("R003","2023-03-01", "Hybrid", "May I for 1 month?", "-", "Rejected", "Reason must be given");
		FWARequest fr2_2 = new FWARequest("R004","2023-03-08", "Flexi-Hours", "I can do for 3 weeks", "None", "Pending", "");
		FWARequest fr3_1 = new FWARequest("R005","2023-02-27", "Work-from-home", "-", "-", "Rejected", "");
		FWARequest fr3_2 = new FWARequest("R006","2023-03-08", "Hybrid", "Can set until changes are needed?", "Preferred", "Pending", "");
		FWARequest fr4_1 = new FWARequest("R007","2023-03-01", "Work-from-home", "Need 3 days", "Need to take care of son", "Accepted", "");
		FWARequest fr4_2 = new FWARequest("R008","2023-03-08", "Work-from-home", "Can set for 3 days?", "Not feeling well", "Pending", "");
		
		// DailySchedule objects for update and review purposes
		DailySchedule ds1 = new DailySchedule("2023-02-05", "Starbucks", "8am-4pm", "I will have meeting with other staffs","");
		DailySchedule ds2 = new DailySchedule("2023-02-07", "At my house", "9am-5pm", "I will be working at my house","");
		DailySchedule ds3 = new DailySchedule("2023-02-09", "Library", "10am-6pm", "I will be scheduling the appointments for next week","");
		DailySchedule ds4 = new DailySchedule("2023-02-11", "At home", "8am-4pm", "I will be preparing the presentation slides","");
		
		// Deoartment objects
		Department d1 = new Department("A0001","Accounting");
		Department d2 = new Department("HR0001","Human Resource");
		Department d3 = new Department("PR0001","Public Relation");
		Department d4 = new Department("IT0001","IT");
		
		
		try (Scanner sc = new Scanner(System.in)) {
			int choice = 0;
			int i = 0;
			String employeeID, password, name,position, email, FWAStatus;
			String date, workLocation, workHours, workReport, supervisorComments;
			String requestID, requestDate, workType, description, reason, status, comment;
			String deptID;
			// HR Admin object
			HRAdmin hr = new HRAdmin("HR100","IamNicholas","Nicholas","HRAdmin","nicholaszz@gmail.com","-");
			
			// Supervisor object
			Supervisor sp = new Supervisor("S100","Ali","IamAli","Supervisor","AlinFAVOR@gmail.com","-");
			
			// Employee object
			Employee em1 = new Employee("E100","IamAdam","Adam","Employee","AtomnEve@gmail.com","Work-from-home");
			Employee em2 = new Employee("E200","IamLucas","Lucas","Employee","Lucintuit@gmail.com","Hybrid");
			Employee em3 = new Employee("E300","IamSara","Sara","Employee","SaraW32@gmail.com","Flexi-hours");
			Employee em4 = new Employee("E400","IamJohn","John","Employee","JJJ3@gmail.com","Work-from-home");
			
			// Welcome message
			System.out.println("Welcome to FlexIS System");
			System.out.println();
			// Display a list of options that users can perform
			System.out.println("Users can perform the following options:"
					+ "\n1. Register Employee or Supervisor"
					+ "\n2. Submit FWA Request"
					+ "\n3. Review FWA Request"
					+ "\n4. Update Daily Schedule"
					+ "\n5. Review Employee Schedule"
					+ "\n6. View FWA Analytics"
					+ "\n7. Display employee details"
					+ "\n8. Display daily schedules details"
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
					// Display available options for HR Admin
					System.out.println("Select options below to continue: "
									+ "\n1. Register Employee"
									+ "\n6. View FWA Analytics"
									+ "\n7. Display employee details"
									+ "\n8. Display daily schedules details");
					break;
				}
				// Supervisor login with valid employee ID and password
				else if("S100".equalsIgnoreCase(employeeID) && "IamAli".equalsIgnoreCase(password)) {
					System.out.println("You have logged in successfully.");
					// Display available options for Supervisor
					System.out.println("Select the options below to continue:"
									+ "\n3. Review FWA Request"
									+ "\n5. Review Employee Schedules"
									+ "\n6. View FWA Analytics"
									+ "\n7. Display employee details"
									+ "\n8. Display daily schedules details");
					break;
					}
				// Existing employees login with valid employee and password
				else if(("E100".equalsIgnoreCase(employeeID) && "IamAdam".equalsIgnoreCase(password))|| 
						("E200".equalsIgnoreCase(employeeID) && "IamLucas".equalsIgnoreCase(password)) || 
						("E300".equalsIgnoreCase(employeeID) && "IamSara".equalsIgnoreCase(password))|| 
						("E400".equalsIgnoreCase(employeeID) && "IamJohn".equalsIgnoreCase(password))) {
					System.out.println("You have logged in successfully.");
					// Display available options for Employee
					System.out.println("Select the options below to continue:"
										+ "\n2. Submit FWA Request"
										+ "\n4. Update Daily Schedule");
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
						System.out.print("\nSelect a department: ");
						deptID = sc.nextLine();
						if("A0001".equalsIgnoreCase(deptID)) {
							System.out.println("Department: "+d1.getDeptName());
							break;
							}
						else if("HR0001".equalsIgnoreCase(deptID)) {
							System.out.println("Department: "+d2.getDeptName());
							break;
						}
						else if("PR0001".equalsIgnoreCase(deptID)) {
							System.out.println("Department: "+d3.getDeptName());
							break;
						}
						else if("IT0001".equalsIgnoreCase(deptID)) {
							System.out.println("Department: "+d4.getDeptName());
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
					System.out.println("Employee's FWA Status: New");
					break;
						
				// Option 2 - Submit FWA Request
				case 2:
					// auto generate request ID
					while(true) {
						if (i == i)
							i++;
							requestID = "R00"+Integer.toString(i);

							break;
					}
					// Set request date to system date
					while(true) {
						System.out.print("\nToday's date (yyyy-MM-dd): ");
						requestDate = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
						break;
					}

					// work type validation
					while(true) {
						System.out.print("\n1. Flexi-hour\n"
										+ "2. Work-from-home\n"
										+ "3. Hybrid");
						System.out.print("\nEnter work type: ");
						workType = sc.nextLine();
						if("Flexi-hour".equalsIgnoreCase(workType)|| "Work-from-home".equalsIgnoreCase(workType)|| 
							"Hybrid".equalsIgnoreCase(workType)) 
							break;
					}

					// description validation	
					while(true) {
						System.out.print("\nEnter description: ");
						description = sc.nextLine();	
						if(description.isEmpty())
							System.out.println("Invalid description.");
						else
							break;
						}

					// reason validation	
					while(true) {
						System.out.print("\nEnter reason: ");
						reason = sc.nextLine();	
						if(reason.isEmpty())
							System.out.println("Invalid reason.");
						else
							break;
						}

					// set status to "Pending" 	
					while(true) {
						status = "Pending";	
						break;
						}
					
					System.out.println("\nYour FWA request has been submitted successfully.");
					System.out.println("Request ID: "+requestID);
					System.out.println(requestDate);
					System.out.println("An email has been sent to your supervisor.");

					break;
				
				// Option 3 - Review FWA Request
				case 3:
					while(true) {
						System.out.println("\nYou have pending FWA requests.");
						
						// Ensure Supervisor selects a valid employeeID
						while(true) 
						{
							System.out.println("E100 - Adam"
												+ "\nE200 - Lucas"
												+ "\nE300 - Sara"
												+ "\nE400 - John");
							System.out.print("\nSelect an employee ID: ");
							employeeID = sc.nextLine();
							if(employeeID.isEmpty())
							{
								System.out.println("Invalid employee ID");
							}

							else if("E100".equalsIgnoreCase(employeeID)) 
							{
								// Display available FWA Requests  
								System.out.println("\nRequest ID: "+fr1_1.getRequestID()+
										"\nRequest Date: "+fr1_1.getRequestDate()+
										"\nWork Type: "+fr1_1.getWorkType()+
										"\nDescription: "+fr1_1.getDescription()+
										"  Reason: "+fr1_1.getReason()+
										"\nStatus: "+fr1_1.getStatus()+
										"\nComment: "+fr1_1.getComment());
								
								System.out.println("\nRequest ID: "+fr1_2.getRequestID()+
										"\nRequest Date: "+fr1_2.getRequestDate()+
										"\nWork Type: "+fr1_2.getWorkType()+
										"\nDescription: "+fr1_2.getDescription()+
										"  Reason: "+fr1_2.getReason()+
										"\nStatus: "+fr1_2.getStatus()+
										"\nComment: "+fr1_2.getComment());
								// Ensure Supervisor selects a valid requestID
								System.out.println("Enter Request ID: ");
								requestID = sc.nextLine();
								 if
									("R001".equalsIgnoreCase(requestID)) 
								{
									// Determine if status is set to "Pending"
									 if (fr1_1.getStatus()=="Pending")
									 {
										 System.out.println("Accepted or Rejected?: ");
										 status = sc.nextLine();
											if(status.isEmpty())
												System.out.println("Invalid status.");
											else if("Accepted".equalsIgnoreCase(status)|| "Rejected".equalsIgnoreCase(status)) 
												System.out.print("\nEnter your comment: ");
												comment = sc.nextLine();
												break;
									 }
									 else
									 {
										 System.out.println("Status is not pending");
										 break;
									 }
								}
									// Determine if status is set to "Pending"
								else if
								("R002".equalsIgnoreCase(requestID)) 
								{
								 if (fr1_2.getStatus()=="Pending")
								 {
									 System.out.println("Accepted or Rejected?: ");
									 status = sc.nextLine();
										if(status.isEmpty())
											System.out.println("Invalid status.");
										else if("Accepted".equalsIgnoreCase(status)|| "Rejected".equalsIgnoreCase(status)) 
											System.out.print("\nEnter your comment: ");
											comment = sc.nextLine();
											break;
								 }
								 else
								 {
									 System.out.println("Status is not pending");
									 break;
								 }
								}
								 else
								 {
									 System.out.println("Invalid Request ID.");
								 }
								}
							else if("E200".equalsIgnoreCase(employeeID)) 
							{
								// Display available FWA Requests  
								System.out.println("\nRequest ID: "+fr2_1.getRequestID()+
										"\nRequest Date: "+fr2_1.getRequestDate()+
										"\nWork Type: "+fr2_1.getWorkType()+
										"\nDescription: "+fr2_1.getDescription()+
										"  Reason: "+fr2_1.getReason()+
										"\nStatus: "+fr2_1.getStatus()+
										"\nComment: "+fr2_1.getComment());
								
								System.out.println("\nRequest ID: "+fr2_2.getRequestID()+
										"\nRequest Date: "+fr2_2.getRequestDate()+
										"\nWork Type: "+fr2_2.getWorkType()+
										"\nDescription: "+fr2_2.getDescription()+
										"  Reason: "+fr2_2.getReason()+
										"\nStatus: "+fr2_2.getStatus()+
										"\nComment: "+fr2_2.getComment());
								// Ensure Supervisor selects a valid requestID
								System.out.println("Enter Request ID: ");
								requestID = sc.nextLine();
								if (requestID.isEmpty())
									System.out.println("Invalid Request ID.");
								else if
									("R003".equalsIgnoreCase(requestID)) 
								{
									// Determine if status is set to "Pending"

									 if (fr2_1.getStatus()=="Pending")
									 {
										 System.out.println("Accepted or Rejected?: ");
										 status = sc.nextLine();
											if(status.isEmpty())
												System.out.println("Invalid status.");
											else if("Accepted".equalsIgnoreCase(status)|| "Rejected".equalsIgnoreCase(status)) 
												System.out.print("\nEnter your comment: ");
												comment = sc.nextLine();
												break;
									 }
									 else
									 {
										 System.out.println("Status is not pending");
										 break;
									 }
								}
								// Determine if status is set to "Pending"
								else if
								("R004".equalsIgnoreCase(requestID)) 
								{
								 if (fr2_2.getStatus()=="Pending")
								 {
									 System.out.println("Accepted or Rejected?: ");
									 status = sc.nextLine();
										if(status.isEmpty())
											System.out.println("Invalid status.");
										else if("Accepted".equalsIgnoreCase(status)|| "Rejected".equalsIgnoreCase(status)) 
											System.out.print("\nEnter your comment: ");
											comment = sc.nextLine();
											break;
								 }
								 else
								 {
									 System.out.println("Status is not pending");
									 break;
								 }
								}
								 else
								 {
									 System.out.println("Invalid Request ID.");
								 }
								}
							else if("E300".equalsIgnoreCase(employeeID)) 
							{
								// Display available FWA Requests  
								System.out.println("\nRequest ID: "+fr3_1.getRequestID()+
										"\nRequest Date: "+fr3_1.getRequestDate()+
										"\nWork Type: "+fr3_1.getWorkType()+
										"\nDescription: "+fr3_1.getDescription()+
										"  Reason: "+fr3_1.getReason()+
										"\nStatus: "+fr3_1.getStatus()+
										"\nComment: "+fr3_1.getComment());
								
								System.out.println("\nRequest ID: "+fr3_2.getRequestID()+
										"\nRequest Date: "+fr3_2.getRequestDate()+
										"\nWork Type: "+fr3_2.getWorkType()+
										"\nDescription: "+fr3_2.getDescription()+
										"  Reason: "+fr3_2.getReason()+
										"\nStatus: "+fr3_2.getStatus()+
										"\nComment: "+fr3_2.getComment());
								// Ensure Supervisor selects a valid requestID
								System.out.println("Enter Request ID: ");
								requestID = sc.nextLine();
								if (requestID.isEmpty())
									System.out.println("Invalid Request ID.");
								else if
								// Determine if status is set to "Pending"
									("R005".equalsIgnoreCase(requestID)) 
								{
									 if (fr3_1.getStatus()=="Pending")
									 {
										 System.out.println("Accepted or Rejected?: ");
										 status = sc.nextLine();
											if(status.isEmpty())
												System.out.println("Invalid status.");
											else if("Accepted".equalsIgnoreCase(status)|| "Rejected".equalsIgnoreCase(status)) 
												System.out.print("\nEnter your comment: ");
												comment = sc.nextLine();
												break;
									 }
									 else
									 {
										 System.out.println("Status is not pending");
										 break;
									 }
								}
								else if
								// Determine if status is set to "Pending"
								("R006".equalsIgnoreCase(requestID)) 
								{
								 if (fr3_2.getStatus()=="Pending")
								 {
									 System.out.println("Accepted or Rejected?: ");
									 status = sc.nextLine();
										if(status.isEmpty())
											System.out.println("Invalid status.");
										else if("Accepted".equalsIgnoreCase(status)|| "Rejected".equalsIgnoreCase(status)) 
											System.out.print("\nEnter your comment: ");
											comment = sc.nextLine();
											break;
								 }
								 else
								 {
									 System.out.println("Status is not pending");
									 break;
								 }
								}
								 else
								 {
									 System.out.println("Invalid Request ID.");
								 }
								}
							else if("E400".equalsIgnoreCase(employeeID)) 
							{
								// Display available FWA Requests  
								System.out.println("\nRequest ID: "+fr4_1.getRequestID()+
										"\nRequest Date: "+fr4_1.getRequestDate()+
										"\nWork Type: "+fr4_1.getWorkType()+
										"\nDescription: "+fr4_1.getDescription()+
										"  Reason: "+fr4_1.getReason()+
										"\nStatus: "+fr4_1.getStatus()+
										"\nComment: "+fr4_1.getComment());
								
								System.out.println("\nRequest ID: "+fr4_2.getRequestID()+
										"\nRequest Date: "+fr4_2.getRequestDate()+
										"\nWork Type: "+fr4_2.getWorkType()+
										"\nDescription: "+fr4_2.getDescription()+
										"  Reason: "+fr4_2.getReason()+
										"\nStatus: "+fr4_2.getStatus()+
										"\nComment: "+fr4_2.getComment());
								// Ensure Supervisor selects a valid requestID
								System.out.println("Enter Request ID: ");
								requestID = sc.nextLine();
								if (requestID.isEmpty())
									System.out.println("Invalid Request ID.");
								else if
									("R007".equalsIgnoreCase(requestID)) 
								{
									// Determine if status is set to "Pending"
									 if (fr4_1.getStatus()=="Pending")
									 {
										 System.out.println("Accepted or Rejected?: ");
										 status = sc.nextLine();
											if(status.isEmpty())
												System.out.println("Invalid status.");
											else if("Accepted".equalsIgnoreCase(status)|| "Rejected".equalsIgnoreCase(status)) 
												System.out.print("\nEnter your comment: ");
												comment = sc.nextLine();
												break;
									 }
									 else
									 {
										 System.out.println("Status is not pending");
										 break;
									 }
								}
								else if
								// Determine if status is set to "Pending"
								("R008".equalsIgnoreCase(requestID)) 
								{
								 if (fr4_2.getStatus()=="Pending")
								 {
									 System.out.println("Accepted or Rejected?: ");
									 status = sc.nextLine();
										if(status.isEmpty())
											System.out.println("Invalid status.");
										else if("Accepted".equalsIgnoreCase(status)|| "Rejected".equalsIgnoreCase(status)) 
											System.out.print("\nEnter your comment: ");
											comment = sc.nextLine();
											break;
								 }
								 else
								 {
									 System.out.println("Status is not pending");
									 break;
								 }
								}
								 else
								 {
									 System.out.println("Invalid Request ID.");
								 }
								}
							else
							{
								System.out.println("Invalid employee ID");
							}
									
							}
								
						break;
						}
					break;
				
				// Option 4 - Update Employee Schedules			
				case 4:
					// Date validation
					while(true) {
						System.out.print("Select a date (yyyy-MM-dd): ");
						date = sc.nextLine();
						if(date.isEmpty())
							System.out.println("Invalid date.");
						else
							break;
					}
					// Work location validation
					while(true) {
						System.out.print("\nEnter work location: ");
						workLocation = sc.nextLine();
						if(workLocation.isEmpty())
							System.out.println("Invalid work location.");
						else
							break;
					}
					while(true) {
						// Work hours validation
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
					// Work report validation	
					while(true) {
						System.out.print("\nEnter work report: ");
						workReport = sc.nextLine();	
						if(workReport.isEmpty())
							System.out.println("Invalid work report.");
						else
							break;
						}
					System.out.println("\nYour daily schedule have been updated successfully.");
					break;
				
				// Option 5 - Review Employee Schedules
				case 5:
					
					// Supervisor selects a date by option
					while(true) {
						System.out.println("List of available dates"+
											"\n1."+ds1.getDate()+
											"\n2."+ds2.getDate()+
											"\n3."+ds3.getDate()+
											"\n4."+ds4.getDate());
						System.out.print("Select a Date (by option): ");
						date = sc.nextLine();
						if(date.isEmpty() )
							System.out.println("Invalid date");
						else
							break;
					}
					// Ensure Supervisor selects a valid employeeID
					while(true) {
						System.out.println("E100 - Adam"
											+ "\nE200 - Lucas"
											+ "\nE300 - Sara"
											+ "\nE400 - John");
						System.out.print("\nSelect an employee ID: ");
						employeeID = sc.nextLine();
						if(employeeID.isEmpty()) {
							System.out.println("Invalid employee ID");
						}
						
						else if("E100".equalsIgnoreCase(employeeID)) {
							System.out.println("Work location: "+ds1.getWorkLocation()+
											   "\nWork hours: "+ds1.getWorkHours()+
											  "\nWork report: "+ds1.getWorkReport());
							break;}
						
						else if("E200".equalsIgnoreCase(employeeID)) {
							System.out.println("Work location: "+ds2.getWorkLocation()+
											  "\nWork hours: "+ds2.getWorkHours()+
											  "\nWork report: "+ds2.getWorkReport());
						break;}
						
						else if("E300".equalsIgnoreCase(employeeID)) {
							System.out.println("Work location: "+ds3.getWorkLocation()+
											"\nWork hours: "+ds3.getWorkHours()+
											"\nWork report: "+ds3.getWorkReport());
							break;}
						
						else if("E400".equalsIgnoreCase(employeeID))
							System.out.println("Work location: "+ds4.getWorkLocation()+
											"\nWork hours: "+ds4.getWorkHours()+
											"\nWork report: "+ds4.getWorkReport());
							break;
					}
					
					// Supervisor's comment is optional
					System.out.print("\nEnter your comment: ");
					supervisorComments = sc.nextLine();
					break;
				
				// Option 6 - View FWA Analytics
				case 6:
					break;
					
				// Option 7: Display Employee details
				case 7:
					f.displayEmployeeInfo();
					break;
				
				// Option 8: Display daily schedule details
				case 8:
					break;
					
						}
			} while(choice != 0);
			
			
			// If user wants to exit program
			while(choice == 0) {
				System.out.println("--------The End--------");
				break;
			}
		}		
}
	private static String toString(int i) {
		// TODO Auto-generated method stub
		return null;
	}
}
