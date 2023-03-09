package bit203Assignment;
import bit203Assignment.FlexIS;
import java.util.*;
import java.text.SimpleDateFormat;


/*Driver class- FlexConsole
 * This class contains main method
 * It will display a menu program for users
 * User must login before selecting an option*
 * Prior to the display of menu:
 * A FlexIS object, Department collection,HRAdmin object, FWARequest, DailySchedule objects are created/

/*@authors:
 * Sebastian Chai B2000080
 * Lee Xin Yao B2100617
 * */

public class FlexISConsole {
	public static void main(String[] args) {
		
		FlexIS f = new FlexIS(); // FlexIS object
		ArrayList<Department> department= new ArrayList<>();
		
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
		DailySchedule ds1 = new DailySchedule("2023-03-13", "Starbucks", "8am-4pm", "I will have meeting with other staffs","");
		DailySchedule ds2 = new DailySchedule("2023-03-15", "At my house", "9am-5pm", "I will be working at my house","");
		DailySchedule ds3 = new DailySchedule("2023-03-18", "Library", "10am-6pm", "I will be scheduling the appointments for next week","");
		DailySchedule ds4 = new DailySchedule("2023-03-25", "At home", "8am-4pm", "I will be preparing the presentation slides","");
		
		// Department objects
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
			Supervisor sp = new Supervisor("S100","IamAli","Ali","Supervisor","alimuhamad@gmail.com","-");
			
			// Employee object
			Employee em1 = new Employee("E100","IamAdam","Adam","Accountant","adam246@gmail.com","Work-from-home");
			Employee em2 = new Employee("E200","IamLucas","Lucas","Assistant Manager","lucaslee@gmail.com","Hybrid");
			Employee em3 = new Employee("E300","IamSara","Sara","Assistant Manager","sara578@gmail.com","Flexi-hours");
			Employee em4 = new Employee("E400","IamJohn","John","Software developer","johnwong88@gmail.com","Work-from-home");
			
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
				// Registered employees login with valid employee and password
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
				// Prompt user to enter their option
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
							// Department name is shown
							System.out.println("Department: "+d1.getDeptName());
							break;
							}
						else if("HR0001".equalsIgnoreCase(deptID)) {
							// Department name is shown
							System.out.println("Department: "+d2.getDeptName());
							break;
						}
						else if("PR0001".equalsIgnoreCase(deptID)) {
							// Department name is shown
							System.out.println("Department: "+d3.getDeptName());
							break;
						}
						else if("IT0001".equalsIgnoreCase(deptID)) {
							// Department name is shown
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
					
					System.out.println();
					System.out.println("Employee "+name+" has been registered.");
					System.out.println("Email has been sent to "+ email);
					System.out.println("Employee's FWA Status: New");
					
					// SupervisorID validation
					while(true) {
						System.out.print("Enter supervisor ID:");
						employeeID =sc.nextLine();	
						if("S100".equalsIgnoreCase(employeeID)) {
							break;
							}
						else
							System.out.println("Invalid supervisor ID");
					}
					// Supervisor name is shown and is recorded for the employee
					System.out.println("Supervisor "+sp.getName()+" has been recorded for employee "+name);
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
						System.out.print("\n1. Flexi-hours\n"
										+ "2. Work-from-home\n"
										+ "3. Hybrid");
						System.out.print("\nEnter work type: ");
						workType = sc.nextLine();
						if("Flexi-hours".equalsIgnoreCase(workType)|| "Work-from-home".equalsIgnoreCase(workType)|| 
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
					int flexNum = 0;
					int homeNum = 0;
					int hybdNum = 0;
					while(true) {
						System.out.print("\n1. HRAdmin");
						System.out.print("\n2. Supervisor");
						System.out.print("\nEnter position: ");
						position = sc.nextLine();
						if("HRAdmin".equalsIgnoreCase(position)|| "Supervisor".equalsIgnoreCase(position))
							break;
						else
							System.out.println("Invalid position");
					}
					
						
						// Detect if user is HR Admin
						if ("HRAdmin".equalsIgnoreCase(position))
						{
							System.out.print("\nHR Admin View FWA Analytics page\n");
							//count number of employees of each FWA Status in Accounting department
							if (em1.getFWAStatus()=="Flexi-hours")
							{
								flexNum++;
							}
							else if (em1.getFWAStatus()=="Work-from-home")
							{
								homeNum++;
							}
							else if (em1.getFWAStatus()=="Hybrid")
							{
								hybdNum++;
							}
							//display count
							System.out.println("A0001, Accounting: ");
							System.out.println("Flexi-hours: "+flexNum);
							System.out.println("Work-from-home: "+homeNum);
							System.out.println("Hybrid: "+hybdNum);
							
							flexNum = 0;
							homeNum = 0;
							hybdNum = 0;
							//count number of employees of each FWA Status in Human Resource department
							if (em2.getFWAStatus()=="Flexi-hours")
							{
								flexNum++;
							}
							else if (em2.getFWAStatus()=="Work-from-home")
							{
								homeNum++;
							}
							else if (em2.getFWAStatus()=="Hybrid")
							{
								hybdNum++;
							}
							//display count
							System.out.println("HR0001, Human Resource: ");
							System.out.println("Flexi-hours: "+flexNum);
							System.out.println("Work-from-home: "+homeNum);
							System.out.println("Hybrid: "+hybdNum);
							
							flexNum = 0;
							homeNum = 0;
							hybdNum = 0;
							//count number of employees of each FWA Status in Public Relation department
							if (em3.getFWAStatus()=="Flexi-hours")
							{
								flexNum++;
							}
							else if (em3.getFWAStatus()=="Work-from-home")
							{
								homeNum++;
							}
							else if (em3.getFWAStatus()=="Hybrid")
							{
								hybdNum++;
							}
							//display count
							System.out.println("PR0001, Public Relation: ");
							System.out.println("Flexi-hours: "+flexNum);
							System.out.println("Work-from-home: "+homeNum);
							System.out.println("Hybrid: "+hybdNum);
							
							flexNum = 0;
							homeNum = 0;
							hybdNum = 0;
							//count number of employees of each FWA Status in IT department
							if (em4.getFWAStatus()=="Flexi-hours")
							{
								flexNum++;
							}
							else if (em4.getFWAStatus()=="Work-from-home")
							{
								homeNum++;
							}
							else if (em4.getFWAStatus()=="Hybrid")
							{
								hybdNum++;
							}
							//display count
							System.out.println("IT0001, IT: ");
							System.out.println("Flexi-hours: "+flexNum);
							System.out.println("Work-from-home: "+homeNum);
							System.out.println("Hybrid: "+hybdNum);
							
							flexNum = 0;
							homeNum = 0;
							hybdNum = 0;
							int j = 0;
							System.out.println("Insert department ID: ");
							deptID = sc.nextLine();
							
							//Display dates, and count number of FWA Requests made on each date
		
							if ("A0001".equalsIgnoreCase(deptID))
							{
								if (fr1_1.getRequestDate()=="2023-02-27")
										{
											j++;
										}
								if (fr1_2.getRequestDate()=="2023-02-27")
										{
											j++;
										}
								System.out.println("2023-02-27: "+j);
								j=0;

								if (fr1_1.getRequestDate()=="2023-02-28")
										{
											j++;
										}
								if (fr1_2.getRequestDate()=="2023-02-28")
										{
											j++;
										}
								System.out.println("2023-02-28: "+j);
								j=0;

								if (fr1_1.getRequestDate()=="2023-03-01")
										{
											j++;
										}
								if (fr1_2.getRequestDate()=="2023-03-01")
										{
											j++;
										}
								System.out.println("2023-03-01: "+j);
								j=0;

								if (fr1_1.getRequestDate()=="2023-03-02")
										{
											j++;
										}
								if (fr1_2.getRequestDate()=="2023-03-02")
										{
											j++;
										}
								System.out.println("2023-03-02: "+j);
								j=0;

								if (fr1_1.getRequestDate()=="2023-03-03")
										{
											j++;
										}
								if (fr1_2.getRequestDate()=="2023-03-03")
										{
											j++;
										}
								System.out.println("2023-03-03: "+j);
								j=0;

								if (fr1_1.getRequestDate()=="2023-03-04")
										{
											j++;
										}
								if (fr1_2.getRequestDate()=="2023-03-04")
										{
											j++;
										}
								System.out.println("2023-03-04: "+j);
								j=0;

								if (fr1_1.getRequestDate()=="2023-03-05")
										{
											j++;
										}
								if (fr1_2.getRequestDate()=="2023-03-05")
										{
											j++;
										}
								System.out.println("2023-03-05: "+j);
								j=0;
								if (fr1_1.getRequestDate()=="2023-03-06")
										{
											j++;
										}
								if (fr1_2.getRequestDate()=="2023-03-06")
										{
											j++;
										}
								System.out.println("2023-03-06: "+j);
								j=0;
								if (fr1_1.getRequestDate()=="2023-03-07")
										{
											j++;
										}
								if (fr1_2.getRequestDate()=="2023-03-07")
										{
											j++;
										}
								System.out.println("2023-03-07: "+j);
								j=0;
								if (fr1_1.getRequestDate()=="2023-03-08")
										{
											j++;
										}
								if (fr1_2.getRequestDate()=="2023-03-08")
										{
											j++;
										}
								System.out.println("2023-03-08: "+j);
								j=0;
								if (fr1_1.getRequestDate()=="2023-03-09")
								{
									j++;
								}
								if (fr1_2.getRequestDate()=="2023-03-09")
								{
									j++;
								}
								System.out.println("2023-03-09: "+j);
							}
						
							else if ("HR0001".equalsIgnoreCase(deptID))
							{
								if (fr2_1.getRequestDate()=="2023-02-27")
										{
											j++;
										}
								if (fr2_2.getRequestDate()=="2023-02-27")
										{
											j++;
										}
								System.out.println("2023-02-27: "+j);
								j=0;

								if (fr2_1.getRequestDate()=="2023-02-28")
										{
											j++;
										}
								if (fr2_2.getRequestDate()=="2023-02-28")
										{
											j++;
										}
								System.out.println("2023-02-28: "+j);
								j=0;

								if (fr2_1.getRequestDate()=="2023-03-01")
										{
											j++;
										}
								if (fr2_2.getRequestDate()=="2023-03-01")
										{
											j++;
										}
								System.out.println("2023-03-01: "+j);
								j=0;

								if (fr2_1.getRequestDate()=="2023-03-02")
										{
											j++;
										}
								if (fr2_2.getRequestDate()=="2023-03-02")
										{
											j++;
										}
								System.out.println("2023-03-02: "+j);
								j=0;

								if (fr2_1.getRequestDate()=="2023-03-03")
										{
											j++;
										}
								if (fr2_2.getRequestDate()=="2023-03-03")
										{
											j++;
										}
								System.out.println("2023-03-03: "+j);
								j=0;

								if (fr2_1.getRequestDate()=="2023-03-04")
										{
											j++;
										}
								if (fr2_2.getRequestDate()=="2023-03-04")
										{
											j++;
										}
								System.out.println("2023-03-04: "+j);
								j=0;

								if (fr2_1.getRequestDate()=="2023-03-05")
										{
											j++;
										}
								if (fr2_2.getRequestDate()=="2023-03-05")
										{
											j++;
										}
								System.out.println("2023-03-05: "+j);
								j=0;
								if (fr2_1.getRequestDate()=="2023-03-06")
										{
											j++;
										}
								if (fr2_2.getRequestDate()=="2023-03-06")
										{
											j++;
										}
								System.out.println("2023-03-06: "+j);
								j=0;
								if (fr2_1.getRequestDate()=="2023-03-07")
										{
											j++;
										}
								if (fr2_2.getRequestDate()=="2023-03-07")
										{
											j++;
										}
								System.out.println("2023-03-07: "+j);
								j=0;
								if (fr2_1.getRequestDate()=="2023-03-08")
										{
											j++;
										}
								if (fr2_2.getRequestDate()=="2023-03-08")
										{
											j++;
										}
								System.out.println("2023-03-08: "+j);
								j=0;
								if (fr2_1.getRequestDate()=="2023-03-09")
								{
									j++;
								}
								if (fr2_2.getRequestDate()=="2023-03-09")
								{
									j++;
								}
								System.out.println("2023-03-09: "+j);
							}
							else if ("PR0001".equalsIgnoreCase(deptID))
							{
								if (fr3_1.getRequestDate()=="2023-02-27")
										{
											j++;
										}
								if (fr3_2.getRequestDate()=="2023-02-27")
										{
											j++;
										}
								System.out.println("2023-02-27: "+j);
								j=0;

								if (fr3_1.getRequestDate()=="2023-02-28")
										{
											j++;
										}
								if (fr3_2.getRequestDate()=="2023-02-28")
										{
											j++;
										}
								System.out.println("2023-02-28: "+j);
								j=0;

								if (fr3_1.getRequestDate()=="2023-03-01")
										{
											j++;
										}
								if (fr3_2.getRequestDate()=="2023-03-01")
										{
											j++;
										}
								System.out.println("2023-03-01: "+j);
								j=0;

								if (fr3_1.getRequestDate()=="2023-03-02")
										{
											j++;
										}
								if (fr3_2.getRequestDate()=="2023-03-02")
										{
											j++;
										}
								System.out.println("2023-03-02: "+j);
								j=0;

								if (fr3_1.getRequestDate()=="2023-03-03")
										{
											j++;
										}
								if (fr3_2.getRequestDate()=="2023-03-03")
										{
											j++;
										}
								System.out.println("2023-03-03: "+j);
								j=0;

								if (fr3_1.getRequestDate()=="2023-03-04")
										{
											j++;
										}
								if (fr3_2.getRequestDate()=="2023-03-04")
										{
											j++;
										}
								System.out.println("2023-03-04: "+j);
								j=0;

								if (fr3_1.getRequestDate()=="2023-03-05")
										{
											j++;
										}
								if (fr3_2.getRequestDate()=="2023-03-05")
										{
											j++;
										}
								System.out.println("2023-03-05: "+j);
								j=0;
								if (fr3_1.getRequestDate()=="2023-03-06")
										{
											j++;
										}
								if (fr3_2.getRequestDate()=="2023-03-06")
										{
											j++;
										}
								System.out.println("2023-03-06: "+j);
								j=0;
								if (fr3_1.getRequestDate()=="2023-03-07")
										{
											j++;
										}
								if (fr3_2.getRequestDate()=="2023-03-07")
										{
											j++;
										}
								System.out.println("2023-03-07: "+j);
								j=0;
								if (fr3_1.getRequestDate()=="2023-03-08")
										{
											j++;
										}
								if (fr3_2.getRequestDate()=="2023-03-08")
										{
											j++;
										}
								System.out.println("2023-03-08: "+j);
								j=0;
								if (fr3_1.getRequestDate()=="2023-03-09")
								{
									j++;
								}
								if (fr3_2.getRequestDate()=="2023-03-09")
								{
									j++;
								}
								System.out.println("2023-03-09: "+j);
							}
							else if ("IT0001".equalsIgnoreCase(deptID))
							{
								if (fr4_1.getRequestDate()=="2023-02-27")
										{
											j++;
										}
								if (fr4_2.getRequestDate()=="2023-02-27")
										{
											j++;
										}
								System.out.println("2023-02-27: "+j);
								j=0;

								if (fr4_1.getRequestDate()=="2023-02-28")
										{
											j++;
										}
								if (fr4_2.getRequestDate()=="2023-02-28")
										{
											j++;
										}
								System.out.println("2023-02-28: "+j);
								j=0;

								if (fr4_1.getRequestDate()=="2023-03-01")
										{
											j++;
										}
								if (fr4_2.getRequestDate()=="2023-03-01")
										{
											j++;
										}
								System.out.println("2023-03-01: "+j);
								j=0;

								if (fr4_1.getRequestDate()=="2023-03-02")
										{
											j++;
										}
								if (fr4_2.getRequestDate()=="2023-03-02")
										{
											j++;
										}
								System.out.println("2023-03-02: "+j);
								j=0;

								if (fr4_1.getRequestDate()=="2023-03-03")
										{
											j++;
										}
								if (fr4_2.getRequestDate()=="2023-03-03")
										{
											j++;
										}
								System.out.println("2023-03-03: "+j);
								j=0;

								if (fr4_1.getRequestDate()=="2023-03-04")
										{
											j++;
										}
								if (fr4_2.getRequestDate()=="2023-03-04")
										{
											j++;
										}
								System.out.println("2023-03-04: "+j);
								j=0;

								if (fr4_1.getRequestDate()=="2023-03-05")
										{
											j++;
										}
								if (fr4_2.getRequestDate()=="2023-03-05")
										{
											j++;
										}
								System.out.println("2023-03-05: "+j);
								j=0;
								if (fr4_1.getRequestDate()=="2023-03-06")
										{
											j++;
										}
								if (fr4_2.getRequestDate()=="2023-03-06")
										{
											j++;
										}
								System.out.println("2023-03-06: "+j);
								j=0;
								if (fr4_1.getRequestDate()=="2023-03-07")
										{
											j++;
										}
								if (fr4_2.getRequestDate()=="2023-03-07")
										{
											j++;
										}
								System.out.println("2023-03-07: "+j);
								j=0;
								if (fr4_1.getRequestDate()=="2023-03-08")
										{
											j++;
										}
								if (fr4_2.getRequestDate()=="2023-03-08")
										{
											j++;
										}
								System.out.println("2023-03-08: "+j);
								j=0;
								if (fr4_1.getRequestDate()=="2023-03-09")
								{
									j++;
								}
								if (fr4_2.getRequestDate()=="2023-03-09")
								{
									j++;
								}
								System.out.println("2023-03-09: "+j);
								j=0;
							}
							else
								// validate department ID; if user enters invalid department ID or if department ID is empty
							{
								System.out.print("\nInvalid department ID");
							}
							
						}
						else if ("Supervisor".equalsIgnoreCase(position))
						{
							//count number of employees of each FWA Status in supervisor's department
							System.out.print("\nHR Admin View FWA Analytics page\n");
							if (em1.getFWAStatus()=="Flexi-hours")
							{
								flexNum++;
							}
							else if (em1.getFWAStatus()=="Work-from-home")
							{
								homeNum++;
							}
							else if (em1.getFWAStatus()=="Hybrid")
							{
								hybdNum++;
							}
							
							System.out.println("A0001, Accounting: ");
							System.out.println("Flexi-hours: "+flexNum);
							System.out.println("Work-from-home: "+homeNum);
							System.out.println("Hybrid: "+hybdNum);
							int j=0;
							
							//Display dates, and count number of FWA Requests made on each date
								if (fr1_1.getRequestDate()=="2023-02-27")
										{
											j++;
										}
								if (fr1_2.getRequestDate()=="2023-02-27")
										{
											j++;
										}
								System.out.println("2023-02-27: "+j);
								j=0;

								if (fr1_1.getRequestDate()=="2023-02-28")
										{
											j++;
										}
								if (fr1_2.getRequestDate()=="2023-02-28")
										{
											j++;
										}
								System.out.println("2023-02-28: "+j);
								j=0;

								if (fr1_1.getRequestDate()=="2023-03-01")
										{
											j++;
										}
								if (fr1_2.getRequestDate()=="2023-03-01")
										{
											j++;
										}
								System.out.println("2023-03-01: "+j);
								j=0;

								if (fr1_1.getRequestDate()=="2023-03-02")
										{
											j++;
										}
								if (fr1_2.getRequestDate()=="2023-03-02")
										{
											j++;
										}
								System.out.println("2023-03-02: "+j);
								j=0;

								if (fr1_1.getRequestDate()=="2023-03-03")
										{
											j++;
										}
								if (fr1_2.getRequestDate()=="2023-03-03")
										{
											j++;
										}
								System.out.println("2023-03-03: "+j);
								j=0;

								if (fr1_1.getRequestDate()=="2023-03-04")
										{
											j++;
										}
								if (fr1_2.getRequestDate()=="2023-03-04")
										{
											j++;
										}
								System.out.println("2023-03-04: "+j);
								j=0;

								if (fr1_1.getRequestDate()=="2023-03-05")
										{
											j++;
										}
								if (fr1_2.getRequestDate()=="2023-03-05")
										{
											j++;
										}
								System.out.println("2023-03-05: "+j);
								j=0;
								if (fr1_1.getRequestDate()=="2023-03-06")
										{
											j++;
										}
								if (fr1_2.getRequestDate()=="2023-03-06")
										{
											j++;
										}
								System.out.println("2023-03-06: "+j);
								j=0;
								if (fr1_1.getRequestDate()=="2023-03-07")
										{
											j++;
										}
								if (fr1_2.getRequestDate()=="2023-03-07")
										{
											j++;
										}
								System.out.println("2023-03-07: "+j);
								j=0;
								if (fr1_1.getRequestDate()=="2023-03-08")
										{
											j++;
										}
								if (fr1_2.getRequestDate()=="2023-03-08")
										{
											j++;
										}
								System.out.println("2023-03-08: "+j);
								j=0;
								if (fr1_1.getRequestDate()=="2023-03-09")
								{
									j++;
								}
								if (fr1_2.getRequestDate()=="2023-03-09")
								{
									j++;
								}
								System.out.println("2023-03-09: "+j);
						}
						break;
					
				// Option 7: Display Employee details
				case 7:
					f.displayEmployeeInfo();
					break;
				
				// Option 8: Display daily schedule details
				case 8:
					System.out.println(	"\nDepartment ID: "+ d1.getDeptID()+
									   	"\nEmployee Name: "+ em1.getName()+
									   	"\nDate: "+ ds1.getDate()+
									   	"\nWork Location: "+ ds1.getWorkLocation()+
									   	"\nWork Hours: "+ ds1.getWorkHours()+
									   	"\nWork Report: "+ ds1.getWorkReport()+
									   	"\nSupervisor Comments: "+ ds1.getSupervisorComments()
									   	);
					System.out.println(	"\nDepartment ID: "+ d2.getDeptID()+
							   			"\nEmployee Name: "+ em2.getName()+
							   			"\nDate: "+ ds2.getDate()+
							   			"\nWork Location: "+ ds2.getWorkLocation()+
							   			"\nWork Hours: "+ ds2.getWorkHours()+
							   			"\nWork Report: "+ ds2.getWorkReport()+
							   			"\nSupervisor Comments: "+ ds2.getSupervisorComments()
							   			);
					System.out.println(	"\nDepartment ID: "+ d3.getDeptID()+
				   						"\nEmployee Name: "+ em3.getName()+
				   						"\nDate: "+ ds3.getDate()+
							   			"\nWork Location: "+ ds3.getWorkLocation()+
							   			"\nWork Hours: "+ ds3.getWorkHours()+
							   			"\nWork Report: "+ ds3.getWorkReport()+
							   			"\nSupervisor Comments: "+ ds3.getSupervisorComments()
				   			);
					System.out.println(	"\nDepartment ID: "+ d4.getDeptID()+
							   			"\nEmployee Name: "+ em4.getName()+
							   			"\nDate: "+ ds4.getDate()+
							   			"\nWork Location: "+ ds4.getWorkLocation()+
							   			"\nWork Hours: "+ ds4.getWorkHours()+
							   			"\nWork Report: "+ ds4.getWorkReport()+
							   			"\nSupervisor Comments: "+ ds4.getSupervisorComments()
						   			);
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
}
