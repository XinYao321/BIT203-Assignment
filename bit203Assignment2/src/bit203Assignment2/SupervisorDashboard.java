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

/*SupervisorDashboard GUI class
 * It act as the dashboard page and display options for Supervisor*/

//@author Chai Wern Yong Sebastian B2000080

@SuppressWarnings("serial")
public class SupervisorDashboard extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SupervisorDashboard frame = new SupervisorDashboard();
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
	public SupervisorDashboard() {
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
		
		// Review FWA Request button
		JButton reviewFWARequestbtn = new JButton("Review FWA Request");
		reviewFWARequestbtn.setBackground(Color.BLACK);;
		reviewFWARequestbtn.setForeground(Color.WHITE);
		reviewFWARequestbtn.setFocusable(false);
		reviewFWARequestbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReviewFWARequest reviewFWA = new ReviewFWARequest();
				reviewFWA.setVisible(true);
			}
		});
		reviewFWARequestbtn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		reviewFWARequestbtn.setBounds(234, 170, 224, 41);
		contentPane.add(reviewFWARequestbtn);
		
		// Review Daily Schedule button
		JButton ReviewDSBtn = new JButton("Review Daily Schedule");
		ReviewDSBtn.setBackground(Color.BLACK);
		ReviewDSBtn.setForeground(Color.WHITE);
		ReviewDSBtn.setFocusable(false);
		ReviewDSBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReviewEmployeeSchedule reviewDS = new ReviewEmployeeSchedule();
				reviewDS.setVisible(true);
				
			}
		});
		ReviewDSBtn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		ReviewDSBtn.setBounds(234, 238, 224, 41);
		contentPane.add(ReviewDSBtn);
		
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
				ViewFwaAnalyticsBtn.setBounds(234, 305, 224, 41);
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
		
		
		
		JLabel welcomeLabel = new JLabel("Welcome!");
		welcomeLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		welcomeLabel.setBounds(263, 6, 147, 41);
		contentPane.add(welcomeLabel);
	}

}
