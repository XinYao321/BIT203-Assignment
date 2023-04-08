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

/*EmployeeDashboard GUI class
 * It acts as the dashboard page and display options for Employees*/

//@author Chai Wern Yong Sebastian B2000080

@SuppressWarnings("serial")
public class EmployeeDashboard extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeDashboard frame = new EmployeeDashboard();
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
	public EmployeeDashboard() {
		setTitle("Employee dashboard");
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
		
		// Submit FWA Request button
		JButton submitFWARequestbtn = new JButton("Submit FWA Request");
		submitFWARequestbtn.setBackground(Color.BLACK);;
		submitFWARequestbtn.setForeground(Color.WHITE);
		submitFWARequestbtn.setFocusable(false);
		submitFWARequestbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SubmitFWARequest submitReq = new SubmitFWARequest();
				submitReq.setVisible(true);
			}
		});
		submitFWARequestbtn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		submitFWARequestbtn.setBounds(234, 170, 224, 41);
		contentPane.add(submitFWARequestbtn);
		
		// Update Daily Schedule button
		JButton updateDSBtn = new JButton("Update Daily Schedule");
		updateDSBtn.setBackground(Color.BLACK);
		updateDSBtn.setForeground(Color.WHITE);
		updateDSBtn.setFocusable(false);
		updateDSBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateDailySchedule updateDS = new UpdateDailySchedule();
				updateDS.setVisible(true);
				
			}
		});
		updateDSBtn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		updateDSBtn.setBounds(234, 238, 224, 41);
		contentPane.add(updateDSBtn);
		
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
