package bit203Assignment2;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
//Date: 7th April 2023

/*Sign In GUI class
 * This class is for FlexIS users to sign in with their employee ID and password
 * Input validation is required for employee ID and password*/

// @author: Lee Xin Yao B2100617 
@SuppressWarnings("serial")
public class SignIn extends JFrame {

	private JPanel contentPane;
	private JTextField employeeIDTF;
	private JPasswordField passwordField;
	
	// Employee objects
	Employee em1 = new Employee("E100","IamAdam","Adam","Accountant","adam246@gmail.com","Work-from-home");
	Employee em2 = new Employee("E200","IamLucas","Lucas","Assistant Manager","lucaslee@gmail.com","Hybrid");
	Employee em3 = new Employee("E300","IamSara","Sara","Assistant Manager","sara578@gmail.com","Flexi-hours");
	Employee em4 = new Employee("E400","IamJohn","John","Software developer","johnwong88@gmail.com","Work-from-home");
	
	// Supervisor objects
	Supervisor sp = new Supervisor("S100","IamAli","Ali","Supervisor","alimuhamad@gmail.com","-");
	
	// HR Admin objects
	HRAdmin hr = new HRAdmin("HR100","IamNicholas","Nicholas","HRAdmin","nicholaszz@gmail.com","-");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignIn frame = new SignIn();
					frame.setVisible(true);
					frame.setResizable(false);
					frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SignIn() {
		setTitle("Sign In Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 688, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel empIDLabel = new JLabel("Employee ID:");
		empIDLabel.setBounds(58, 71, 567, 107);
		empIDLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.add(empIDLabel);
		
		employeeIDTF = new JTextField();
		employeeIDTF.setFont(new Font("Tahoma", Font.PLAIN, 17));
		employeeIDTF.setBounds(258, 100, 218, 41);
		contentPane.add(employeeIDTF);
		employeeIDTF.setColumns(10);
		
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(58, 151, 567, 107);
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.add(passwordLabel);
		
				
		JLabel welcomeMessage = new JLabel("Welcome to FlexIS System");
		welcomeMessage.setFont(new Font("Tahoma", Font.BOLD, 25));
		welcomeMessage.setBounds(151, 20, 372, 29);
		contentPane.add(welcomeMessage);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(258, 188, 218, 41);
		contentPane.add(passwordField);
		
		// Sign In button
		JButton signInBtn = new JButton("Sign In");
		signInBtn.setForeground(Color.WHITE);
		signInBtn.setBackground(Color.BLACK);
		signInBtn.setFocusable(false);
		signInBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String employeeID = employeeIDTF.getText();
				@SuppressWarnings("deprecation")
				String password = passwordField.getText();
				// Input Validation for HR Admin
				if(hr.getEmployeeID().equalsIgnoreCase(employeeID) && hr.getPassword().equalsIgnoreCase(password)) {
					// Go to HR Admin dashboard
					HRAdminDashboard hrAdmin= new HRAdminDashboard();
					hrAdmin.setVisible(true);
					}
						
				// Input Validation for Supervisor
				else if(sp.getEmployeeID().equalsIgnoreCase(employeeID) && sp.getPassword().equalsIgnoreCase(password)) {
					// Navigate to supervisor dashboard
					SupervisorDashboard supervisor = new SupervisorDashboard();
					supervisor.setVisible(true);
						}
						
				// Input Validation for Employee
				else if((em1.getEmployeeID().equalsIgnoreCase(employeeID) && em1.getPassword().equalsIgnoreCase(password)) || 
						(em2.getEmployeeID().equalsIgnoreCase(employeeID)&& em2.getPassword().equalsIgnoreCase(password))||
						(em3.getEmployeeID().equalsIgnoreCase(employeeID)&& em3.getPassword().equalsIgnoreCase(password))||
						(em4.getEmployeeID().equalsIgnoreCase(employeeID)&& em4.getPassword().equalsIgnoreCase(password))) {
					// Navigate to Employee dashboard
					EmployeeDashboard employee = new EmployeeDashboard();
					employee.setVisible(true);
							
						}
				// If input fields are empty
				else if(employeeID.isEmpty() || password.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Input fields cannot be empty", "ERROR", JOptionPane.ERROR_MESSAGE);;
						}
						
				// If users entered invalid employee ID or password
				else {
					JOptionPane.showMessageDialog(null, "Invalid employee ID or password", "ERROR", JOptionPane.ERROR_MESSAGE);;
					employeeIDTF.setText("");
					passwordField.setText("");
						}
					}
				});
				signInBtn.setFont(new Font("Tahoma", Font.PLAIN, 17));
				signInBtn.setBounds(258, 289, 133, 47);
				contentPane.add(signInBtn);
	}
}
