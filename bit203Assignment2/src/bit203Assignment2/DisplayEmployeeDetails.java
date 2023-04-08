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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
// Date: 7th April 2023

/*DisplayEmployeeDetails GUI class
 * This class stores a list of employees and supervisor
 * It stores information such as department, employee ID, name, position, 
 * email, supervisor name and user type*/

//@author Lee Xin Yao B2100617
@SuppressWarnings("serial")
public class DisplayEmployeeDetails extends JFrame {

	private JPanel contentPane;
	private static JTable table;
	private static JScrollPane scrollPane;
	
	Department d1 = new Department("A0001","Accounting");
	Department d2 = new Department("HR0001","Human Resource");
	Department d3 = new Department("PR0001","Public Relation");
	Department d4 = new Department("IT0001","IT");
	
	// Employee objects
	Employee em1 = new Employee("E100","IamAdam","Adam","Accountant","adam246@gmail.com","Work-from-home");
	Employee em2 = new Employee("E200","IamLucas","Lucas","Assistant Manager","lucaslee@gmail.com","Hybrid");
	Employee em3 = new Employee("E300","IamSara","Sara","Assistant Manager","sara578@gmail.com","Flexi-hours");
	Employee em4 = new Employee("E400","IamJohn","John","Software developer","johnwong88@gmail.com","Work-from-home");
	
	// Supervisor object
	Supervisor sp = new Supervisor("S100","IamAli","Ali","Supervisor","alimuhamad@gmail.com","-");
		
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayEmployeeDetails frame = new DisplayEmployeeDetails();
					frame.setVisible(true);
					sortByName();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public  static void AddRowToTable(Object[] dataRow) {
		DefaultTableModel model =  (DefaultTableModel) table.getModel();
		table.setModel(model);
		model.addRow(dataRow);
	}
	
	// Method to sort the table
	public static void sortByName() {
		table.setAutoCreateRowSorter(true);
	}

	/**
	 * Create the frame.
	 */
	public DisplayEmployeeDetails() {
		setTitle("Employee Table List");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1098, 736);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel employeeTableLabel = new JLabel("Employee Table List");
		employeeTableLabel.setBounds(387, 52, 288, 57);
		employeeTableLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
		contentPane.add(employeeTableLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 222, 1074, 434);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		RegisterEmployee frame = new RegisterEmployee();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"None",sp.getEmployeeID(),sp.getName(),sp.getPosition(),sp.getEmail(),"None","Supervisor"},
				{d2,em1.getEmployeeID(),em1.getName(),em1.getPosition(),em1.getEmail(),"Ali","Employee"},
				{d2,em2.getEmployeeID(),em2.getName(),em2.getPosition(),em2.getEmail(),"Ali","Employee"},
				{d2,em3.getEmployeeID(),em3.getName(),em3.getPosition(),em3.getEmail(),"Ali","Employee"},
				{d2,em4.getEmployeeID(),em4.getName(),em4.getPosition(),em4.getEmail(),"Ali","Employee"}
			},
			new String[] {
				"Department", "Employee ID", "Name", "Position", "Email", "Supervisor Name", "User Type"
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
