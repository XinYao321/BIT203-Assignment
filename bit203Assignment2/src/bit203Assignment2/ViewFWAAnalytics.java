package bit203Assignment2;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/*ViewFWAAnalytics GUI class
 * This class display a list of FWA Requests */


//@author Chai Wern Yong Sebastian B2000080
@SuppressWarnings("serial")
public class ViewFWAAnalytics extends JFrame {

	private JPanel contentPane;
	private static JTable table;
	private static JScrollPane scrollPane;

	FWARequest fr1_1 = new FWARequest("R001","2023-04-09", "Work-from-home", "Can set for 3 days?", "Not well", "Pending", "U");
	FWARequest fr2_1 = new FWARequest("R002","2023-04-09", "Hybrid", "May I for 1 month?", "-", "Pending", "");
	FWARequest fr3_1 = new FWARequest("R003","2023-04-09", "Hybrid", "-", "-", "Pending", "");
	FWARequest fr4_1 = new FWARequest("R004","2023-04-09", "Flexi-Hours", "Need 3 days", "Can work in office", "Pending", "");
	
	// Employee objects
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
					ViewFWAAnalytics frame = new ViewFWAAnalytics();
					frame.setVisible(true);
					sortByName();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void AddRowToTable(Object[] dataRow) {
		DefaultTableModel model =  (DefaultTableModel) table.getModel();
		table.setModel(model);
		model.addRow(dataRow);
	}

	public static void sortByName() {
		table.setAutoCreateRowSorter(true);
	}

	/**
	 * Create the frame.
	 */
	public ViewFWAAnalytics() {
		setTitle("FWA Analytics Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1098, 736);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JLabel fwaReqLabel = new JLabel("FWA Analytics Page");
		fwaReqLabel.setBounds(387, 52, 288, 57);
		fwaReqLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
		contentPane.add(fwaReqLabel);
		
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 222, 1074, 434);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		new FWARequest();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{em1.getEmployeeID(),fr1_1.getRequestID(),fr1_1.getRequestDate(),fr1_1.getWorkType(),fr1_1.getDescription(),fr1_1.getReason(),fr1_1.getStatus(),fr1_1.getComment()},
				{em2.getEmployeeID(),fr2_1.getRequestID(),fr2_1.getRequestDate(),fr2_1.getWorkType(),fr2_1.getDescription(),fr2_1.getReason(),fr2_1.getStatus(),fr2_1.getComment()},
				{em3.getEmployeeID(),fr3_1.getRequestID(),fr3_1.getRequestDate(),fr3_1.getWorkType(),fr3_1.getDescription(),fr3_1.getReason(),fr3_1.getStatus(),fr3_1.getComment()},
				{em4.getEmployeeID(),fr4_1.getRequestID(),fr4_1.getRequestDate(),fr4_1.getWorkType(),fr4_1.getDescription(),fr4_1.getReason(),fr4_1.getStatus(),fr4_1.getComment()},
				},
			new String[] {
				"Employee ID", "Request ID", "Request Date", "Work Type", "Description", "Reason", "Status", "Supervisor comments"
			}
					
		));
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
	
