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
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;


// Date: 7th April 2023

/*RegisterEmployee GUI class
 * This class enables HR Admin to register an employee or supervisor*/

// @author: Lee Xin Yao B2100617

@SuppressWarnings("serial")
public class RegisterEmployee extends JFrame {

	private JPanel contentPane;
	private JTextField empIdTF;
	private JTextField nameTF;
	private JTextField positionTF;
	private JTextField emailTF;
	
	// Department objects
	Department d1 = new Department("A0001","Accounting");
	Department d2 = new Department("HR0001","Human Resource");
	Department d3 = new Department("PR0001","Public Relation");
	Department d4 = new Department("IT0001","IT");
	
	// Supervisor object
	Supervisor sp = new Supervisor("S100","IamAli","Ali","Supervisor","alimuhamad@gmail.com","-");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterEmployee frame = new RegisterEmployee();
					frame.dispose();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	// Method to validate email address
	public static boolean patternMatches(String email, String regexPattern) {
	    return Pattern.compile(regexPattern)
	      .matcher(email)
	      .matches();
	}

	/**
	 * Create the frame.
	 */
	public RegisterEmployee() {
		setTitle("Register Employee Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 872, 696);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Register an Employee or Supervisor");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(268, 33, 376, 36);
		contentPane.add(lblNewLabel);
		
		JLabel department = new JLabel("Department:");
		department.setFont(new Font("Tahoma", Font.BOLD, 17));
		department.setBounds(217, 110, 110, 30);
		contentPane.add(department);
		
		JLabel empID = new JLabel("Employee ID:");
		empID.setFont(new Font("Tahoma", Font.BOLD, 17));
		empID.setBounds(217, 172, 123, 30);
		contentPane.add(empID);
		
		JLabel name = new JLabel("Name:");
		name.setFont(new Font("Tahoma", Font.BOLD, 17));
		name.setBounds(217, 244, 110, 30);
		contentPane.add(name);
		
		JLabel position = new JLabel("Position:");
		position.setFont(new Font("Tahoma", Font.BOLD, 17));
		position.setBounds(217, 318, 110, 30);
		contentPane.add(position);
		
		JLabel email = new JLabel("Email:");
		email.setFont(new Font("Tahoma", Font.BOLD, 17));
		email.setBounds(217, 396, 110, 30);
		contentPane.add(email);
		
		empIdTF = new JTextField();
		empIdTF.setFont(new Font("Tahoma", Font.PLAIN, 17));
		empIdTF.setColumns(10);
		empIdTF.setBounds(359, 170, 238, 36);
		contentPane.add(empIdTF);
		
		nameTF = new JTextField();
		nameTF.setFont(new Font("Tahoma", Font.PLAIN, 17));
		nameTF.setColumns(10);
		nameTF.setBounds(359, 242, 238, 36);
		contentPane.add(nameTF);
		
		positionTF = new JTextField();
		positionTF.setFont(new Font("Tahoma", Font.PLAIN, 17));
		positionTF.setColumns(10);
		positionTF.setBounds(359, 313, 238, 36);
		contentPane.add(positionTF);
		
		emailTF = new JTextField();
		emailTF.setFont(new Font("Tahoma", Font.PLAIN, 17));
		emailTF.setColumns(10);
		emailTF.setBounds(359, 391, 238, 36);
		contentPane.add(emailTF);
		
		JLabel supervisorName = new JLabel("Supervisor Name:");
		supervisorName.setFont(new Font("Tahoma", Font.BOLD, 17));
		supervisorName.setBounds(167, 462, 169, 30);
		contentPane.add(supervisorName);
		
		// Back to dashboard button
		JButton dashboardBtn = new JButton("Back to Dashboard");
		dashboardBtn.setForeground(Color.WHITE);
		dashboardBtn.setBackground(Color.BLACK);
		dashboardBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HRAdminDashboard hrAdmin = new HRAdminDashboard();
				hrAdmin.setVisible(true);
			}
		});
		dashboardBtn.setFocusable(false);
		dashboardBtn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		dashboardBtn.setBounds(10, 10, 186, 36);
		contentPane.add(dashboardBtn);
		
		// Log Out button
		JButton logOutButton = new JButton("Log Out");
		logOutButton.setForeground(Color.WHITE);
		logOutButton.setBackground(Color.BLACK);
		logOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Display Sign in page
				SignIn signIn = new SignIn();
				signIn.setVisible(true);
			}
		});
		logOutButton.setFocusable(false);
		logOutButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		logOutButton.setBounds(738, 5, 110, 45);
		contentPane.add(logOutButton);

		// Department List
		JComboBox<Department> departmentComboBox = new JComboBox<>();
		departmentComboBox.addItem(d1);
		departmentComboBox.addItem(d2);
		departmentComboBox.addItem(d3);
		departmentComboBox.addItem(d4);
		departmentComboBox.setFont(new Font("Tahoma", Font.PLAIN, 17));
		departmentComboBox.setBounds(359, 110, 238, 36);
		contentPane.add(departmentComboBox);
		
		JLabel userType = new JLabel("User Type:");
		userType.setFont(new Font("Tahoma", Font.BOLD, 17));
		userType.setBounds(190, 533, 146, 30);
		contentPane.add(userType);
		
		// User Type List
		JComboBox<String> userTypeCombo = new JComboBox<String>();
		userTypeCombo.addItem("---Select user type---");
		userTypeCombo.addItem("Supervisor");
		userTypeCombo.addItem("Employee");
		userTypeCombo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		userTypeCombo.setBounds(359, 530, 238, 36);
		contentPane.add(userTypeCombo);
		
		// Supervisor List 
		JComboBox<String> supervisorCombo = new JComboBox<>();
		supervisorCombo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		supervisorCombo.addItem("---Select Supervisor---");
		supervisorCombo.addItem("None");
		supervisorCombo.addItem(sp.getName());
		supervisorCombo.setBounds(359, 462, 238, 36);
		contentPane.add(supervisorCombo);
		
		// Register button
		JButton registerBtn = new JButton("Register");
		registerBtn.setForeground(Color.WHITE);
		registerBtn.setBackground(Color.BLACK);
		registerBtn.setFocusable(false);
		registerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Department department = (Department) departmentComboBox.getSelectedItem();
				String employeeID = empIdTF.getText();
				String name = nameTF.getText();
				String position = positionTF.getText();
				String email = emailTF.getText();
				String supervisor = (String) supervisorCombo.getSelectedItem();
				String userType = (String) userTypeCombo.getSelectedItem();
				
				// Input validation
				if(employeeID.isEmpty() || name.isEmpty() || position.isEmpty() || email.isEmpty() || 
					"---Select user type---".equalsIgnoreCase(userType) || "---Select Supervisor---".equalsIgnoreCase(supervisor)) {
					JOptionPane.showMessageDialog(null, "Input fields cannot be empty", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				else if(patternMatches(email, "^[A-Za-z0-9+_.-]+@(.+)$") ==false) {
					JOptionPane.showMessageDialog(null, "Invalid email address", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else {
					// Display registered successful message
					JOptionPane.showMessageDialog(null, "Registered successfully", "MESSAGE", JOptionPane.INFORMATION_MESSAGE);
					// Open Employee Table
					DisplayEmployeeDetails table = new DisplayEmployeeDetails();
					table.setVisible(true);
					// Insert data into Employee table
					Object[] data = {department, employeeID, name, position, email, supervisor, userType};
					DisplayEmployeeDetails.AddRowToTable(data);
				}
				
			}
		});
		registerBtn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		registerBtn.setBounds(328, 597, 174, 52);
		contentPane.add(registerBtn);
	}
}
