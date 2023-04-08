package bit203Assignment2;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/*ReviewFWARequest GUI class
 * This class display a list of FWA Requests to be accepted or rejected
 * It stores information such as */


//@author Chai Wern Yong Sebastian B2000080
@SuppressWarnings("serial")
public class ReviewFWARequest extends JFrame {

	private JPanel contentPane;
	private JTextField employeeIDTF;
	private static JTable table;
	private static JScrollPane scrollPane;

	FWARequest fr1_1 = new FWARequest("R001","2023-03-01", "Work-from-home", "Can set for 3 days?", "Not well", "Accepted", "Understood, take care");
	FWARequest fr1_2 = new FWARequest("R002","2023-03-07", "Flexi-Hours", "I can work for 1 week at office", "Home Wi-Fi not working", "Pending", "");
	FWARequest fr2_1 = new FWARequest("R003","2023-03-01", "Hybrid", "May I for 1 month?", "-", "Rejected", "Reason must be given");
	FWARequest fr2_2 = new FWARequest("R004","2023-03-08", "Flexi-Hours", "I can do for 3 weeks", "None", "Pending", "");
	FWARequest fr3_1 = new FWARequest("R005","2023-02-27", "Work-from-home", "-", "-", "Rejected", "");
	FWARequest fr3_2 = new FWARequest("R006","2023-03-08", "Hybrid", "Can set until changes are needed?", "Preferred", "Pending", "");
	FWARequest fr4_1 = new FWARequest("R007","2023-03-01", "Work-from-home", "Need 3 days", "Need to take care of son", "Accepted", "");
	FWARequest fr4_2 = new FWARequest("R008","2023-03-08", "Work-from-home", "Can set for 3 days?", "Not feeling well", "Pending", "");
	
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
					ReviewFWARequest frame = new ReviewFWARequest();
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
	public ReviewFWARequest() {
		setTitle("FWA Request List");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1098, 736);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel empIDLabel = new JLabel("Employee ID:");
		empIDLabel.setBounds(58, 100, 567, 107);
		empIDLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.add(empIDLabel);
		
		employeeIDTF = new JTextField();
		employeeIDTF.setFont(new Font("Tahoma", Font.PLAIN, 17));
		employeeIDTF.setBounds(258, 130, 218, 41);
		contentPane.add(employeeIDTF);
		employeeIDTF.setColumns(10);

		JLabel fwaReqLabel = new JLabel("FWA Request List");
		fwaReqLabel.setBounds(387, 52, 288, 57);
		fwaReqLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
		contentPane.add(fwaReqLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 222, 1074, 434);
		contentPane.add(scrollPane);
		
		// Sign In button
				JButton selectEmpBtn = new JButton("Review");
				selectEmpBtn.setForeground(Color.WHITE);
				selectEmpBtn.setBackground(Color.BLACK);
				selectEmpBtn.setFocusable(false);
				selectEmpBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String employeeID = employeeIDTF.getText();
						if(em1.getEmployeeID().equalsIgnoreCase(employeeID) || 
							em2.getEmployeeID().equalsIgnoreCase(employeeID)||
							em3.getEmployeeID().equalsIgnoreCase(employeeID)||
							em4.getEmployeeID().equalsIgnoreCase(employeeID)) 
						{
							
						}
					}
				});
		table = new JTable();
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		FWARequest frame = new FWARequest();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{em1.getEmployeeID(),fr1_1.getRequestID(),fr1_1.getRequestDate(),fr1_1.getDescription(),fr1_1.getReason(),fr1_1.getStatus(),fr1_1.getComment()},
				{em1.getEmployeeID(),fr1_2.getRequestID(),fr1_2.getRequestDate(),fr1_2.getDescription(),fr1_2.getReason(),fr1_2.getStatus(),fr1_2.getComment()},
				{em2.getEmployeeID(),fr2_1.getRequestID(),fr2_1.getRequestDate(),fr2_1.getDescription(),fr2_1.getReason(),fr2_1.getStatus(),fr2_1.getComment()},
				{em2.getEmployeeID(),fr2_2.getRequestID(),fr2_2.getRequestDate(),fr2_2.getDescription(),fr2_2.getReason(),fr2_2.getStatus(),fr2_2.getComment()},
				{em3.getEmployeeID(),fr3_1.getRequestID(),fr3_1.getRequestDate(),fr3_1.getDescription(),fr3_1.getReason(),fr3_1.getStatus(),fr3_1.getComment()},
				{em3.getEmployeeID(),fr3_2.getRequestID(),fr3_2.getRequestDate(),fr3_2.getDescription(),fr3_2.getReason(),fr3_2.getStatus(),fr3_2.getComment()},
				{em4.getEmployeeID(),fr4_1.getRequestID(),fr4_1.getRequestDate(),fr4_1.getDescription(),fr4_1.getReason(),fr4_1.getStatus(),fr4_1.getComment()},
				{em4.getEmployeeID(),fr4_2.getRequestID(),fr4_2.getRequestDate(),fr4_2.getDescription(),fr4_2.getReason(),fr4_2.getStatus(),fr4_2.getComment()},
				},
			new String[] {
				"Employee ID", "Request ID", "Request Date", "Description", "Reason", "Status", "Supervisor comments"
			}
					
		));
		// Back to dashboard button
				JButton dashboardBtn = new JButton("Back to dashboard");
				dashboardBtn.setForeground(Color.WHITE);
				dashboardBtn.setBackground(Color.BLACK);
				dashboardBtn.setFocusable(false);
				dashboardBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						HRAdminDashboard hrAdmin = new HRAdminDashboard();
						hrAdmin.setVisible(true);
					}
				});
				dashboardBtn.setFont(new Font("Tahoma", Font.PLAIN, 17));
				dashboardBtn.setBounds(10, 21, 193, 45);
				contentPane.add(dashboardBtn);
	}
}
