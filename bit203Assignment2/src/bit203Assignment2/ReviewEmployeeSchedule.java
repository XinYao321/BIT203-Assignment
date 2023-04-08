package bit203Assignment2;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
// Date: 7th April 2023

/*Review Employee Schedule GUI class
 * This class enables supervisor to review their employee's schedule*/

//@author Lee Xin Yao B2100617

@SuppressWarnings("serial")
public class ReviewEmployeeSchedule extends JFrame {

	private JPanel contentPane;
	private static JTable scheduleTable;
	
	// DailySchedule objects for update and review purposes
	DailySchedule ds1 = new DailySchedule("2023-04-10", "Starbucks", "8am-4pm", "I will have meeting with other staffs","");
	DailySchedule ds2 = new DailySchedule("2023-04-15", "At my house", "9am-5pm", "I will be working at my house","");
	DailySchedule ds3 = new DailySchedule("2023-04-20", "Library", "10am-6pm", "I will be scheduling the appointments for next week","");
	DailySchedule ds4 = new DailySchedule("2023-04-25", "Shah Alam", "8am-4pm", "I will be preparing the presentation slides","");
	DailySchedule ds5 = new DailySchedule("2023-04-27","Kepong","9am-5pm","I'm having a meeting","");
	DailySchedule ds6 = new DailySchedule("2023-05-01","Sunway Velocity","10am-6pm","I have an appoinment","");
	
	Employee em1 = new Employee("E100","IamAdam","Adam","Accountant","adam246@gmail.com","Work-from-home");
	Employee em2 = new Employee("E200","IamLucas","Lucas","Assistant Manager","lucaslee@gmail.com","Hybrid");
	Employee em3 = new Employee("E300","IamSara","Sara","Assistant Manager","sara578@gmail.com","Flexi-hours");
	Employee em4 = new Employee("E400","IamJohn","John","Software developer","johnwong88@gmail.com","Work-from-home");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReviewEmployeeSchedule frame = new ReviewEmployeeSchedule();
					frame.setVisible(true);
					frame.setResizable(false);
					sortSchedule();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	// Method for adding data to the table
	public  static void AddRowToTable(Object[] dataRow) {
		DefaultTableModel model =  (DefaultTableModel) scheduleTable.getModel();
		scheduleTable.setModel(model);
		model.addRow(dataRow);
	}
	// Method to sort schedule table
	public static void sortSchedule() {
		scheduleTable.setAutoCreateRowSorter(true);
	}
		
	/**
	 * Create the frame.
	 */
	public ReviewEmployeeSchedule() {
		setTitle("Employee Schedule Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1036, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("List of Employees' Schedule");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel.setBounds(343, 87, 340, 45);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 171, 1002, 361);
		contentPane.add(scrollPane);
		
		scheduleTable = new JTable();
		scheduleTable.setFillsViewportHeight(true);
		scrollPane.setViewportView(scheduleTable);
		scheduleTable.setModel(new DefaultTableModel(
			new Object[][] {
				{em1.getName(),ds1.getDate(),ds1.getWorkLocation(),ds1.getWorkHours(),ds1.getWorkReport(),""},
				{em2.getName(),ds2.getDate(),ds2.getWorkLocation(),ds2.getWorkHours(),ds2.getWorkReport(),""},
				{em3.getName(),ds3.getDate(),ds3.getWorkLocation(),ds3.getWorkHours(),ds3.getWorkReport(),""},
				{em4.getName(),ds4.getDate(),ds4.getWorkLocation(),ds4.getWorkHours(),ds4.getWorkReport(),""},
				{em1.getName(),ds5.getDate(),ds5.getWorkLocation(),ds5.getWorkHours(),ds5.getWorkReport(),""},
				{em2.getName(),ds6.getDate(),ds6.getWorkLocation(),ds6.getWorkHours(),ds6.getWorkReport(),""}
				
			},
			new String[] {
				"Employee Name", "Date", "Work Location", "Work Hours", "Work Report", "Supervisor Comment"
			}
		));
		scheduleTable.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		// Back to dashboard button
		JButton dashboardBtn = new JButton("Back to dashboard");
		dashboardBtn.setForeground(Color.WHITE);
		dashboardBtn.setBackground(Color.BLACK);
		dashboardBtn.setFocusable(false);
		dashboardBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Display Supervisor dashboard
				SupervisorDashboard supervisor = new SupervisorDashboard();
				supervisor.setVisible(true);
			}
		});
		dashboardBtn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		dashboardBtn.setBounds(20, 10, 187, 45);
		contentPane.add(dashboardBtn);
		
		// Log out button
		JButton logOutBtn = new JButton("Log Out");
		logOutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignIn signIn = new SignIn();
				signIn.setVisible(true);
				signIn.setResizable(false);
			}
		});
		logOutBtn.setForeground(Color.WHITE);
		logOutBtn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		logOutBtn.setFocusable(false);
		logOutBtn.setBackground(Color.BLACK);
		logOutBtn.setBounds(874, 10, 138, 45);
		contentPane.add(logOutBtn);
	}
}
