package bit203Assignment2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;

/*HRAdminDashboard GUI class
 * It act as the dashboard page and display options for HR Admin*/

//@author Lee Xin Yao B2100617

@SuppressWarnings("serial")
public class HRAdminDashboard extends JFrame {
	
	JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HRAdminDashboard frame = new HRAdminDashboard();
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
	public HRAdminDashboard() {
		setTitle("HR Admin dashboard");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 723, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel optionLabel = new JLabel("Select option below:");
		optionLabel.setBounds(223, 88, 250, 67);
		optionLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		contentPane.add(optionLabel);
		
		// Register Employee button
		JButton registerEmployeeBtn = new JButton("Register Employee");
		registerEmployeeBtn.setBackground(Color.BLACK);;
		registerEmployeeBtn.setForeground(Color.WHITE);
		registerEmployeeBtn.setFocusable(false);
		registerEmployeeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterEmployee registerEmp = new RegisterEmployee();
				registerEmp.setVisible(true);
			}
		});
		registerEmployeeBtn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		registerEmployeeBtn.setBounds(234, 170, 224, 41);
		contentPane.add(registerEmployeeBtn);
		
		// View FWA Analytics button
		JButton ViewFwaAnalyticsBtn = new JButton("View FWA Analytics");
		ViewFwaAnalyticsBtn.setBackground(Color.BLACK);
		ViewFwaAnalyticsBtn.setForeground(Color.WHITE);
		ViewFwaAnalyticsBtn.setFocusable(false);
		ViewFwaAnalyticsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewFWAAnalytics analytics = new ViewFWAAnalytics();
				analytics.setVisible(true);
				
			}
		});
		ViewFwaAnalyticsBtn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		ViewFwaAnalyticsBtn.setBounds(234, 238, 224, 41);
		contentPane.add(ViewFwaAnalyticsBtn);
		
		// Log Out button
		JButton logOutBtn = new JButton("Log Out");
		logOutBtn.setBackground(Color.BLACK);
		logOutBtn.setForeground(Color.WHITE);
		logOutBtn.setFocusable(false);
		logOutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignIn signIn = new SignIn();
				signIn.setResizable(false);
				signIn.setVisible(true);
			}
		});
		logOutBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		logOutBtn.setBounds(602, 10, 97, 41);
		contentPane.add(logOutBtn);
		
		// Display Employee details button
		JButton displayEmpDetailBtn = new JButton("Display Employee details");
		displayEmpDetailBtn.setBackground(Color.BLACK);
		displayEmpDetailBtn.setForeground(Color.WHITE);
		displayEmpDetailBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DisplayEmployeeDetails empDetails = new DisplayEmployeeDetails();
				empDetails.setVisible(true);
			}
		});
		displayEmpDetailBtn.setFocusable(false);
		displayEmpDetailBtn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		displayEmpDetailBtn.setBounds(234, 305, 224, 41);
		contentPane.add(displayEmpDetailBtn);
		
		// Display Daily Schedule details button
		JButton displayDSDetailBtn = new JButton("Display Daily Schedule details");
		displayDSDetailBtn.setBackground(Color.BLACK);
		displayDSDetailBtn.setForeground(Color.WHITE);
		displayDSDetailBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DisplayDailyScheduleDetails dsDetails = new DisplayDailyScheduleDetails();
				dsDetails.setVisible(true);
			}
		});
		displayDSDetailBtn.setFocusable(false);
		displayDSDetailBtn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		displayDSDetailBtn.setBounds(234, 372, 224, 41);
		contentPane.add(displayDSDetailBtn);

		
		JLabel welcomeLabel = new JLabel("Welcome!");
		welcomeLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		welcomeLabel.setBounds(263, 6, 147, 41);
		contentPane.add(welcomeLabel);
	}
}
