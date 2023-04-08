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

/*DisplayDailyScheduleDetails GUI class
 * This class display a list of daily schedules
 * It stores information such as */


//@author Chai Wern Yong Sebastian B2000080
@SuppressWarnings("serial")
public class DisplayDailyScheduleDetails extends JFrame {

	private JPanel contentPane;
	private static JTable table;
	private static JScrollPane scrollPane;
	
	DailySchedule ds1 = new DailySchedule("2023-04-10", "Starbucks", "8am-4pm", "I will have meeting with other staffs","");
	DailySchedule ds2 = new DailySchedule("2023-04-15", "At my house", "9am-5pm", "I will be working at my house","");
	DailySchedule ds3 = new DailySchedule("2023-04-20", "Library", "10am-6pm", "I will be scheduling the appointments for next week","");
	DailySchedule ds4 = new DailySchedule("2023-04-25", "Shah Alam", "8am-4pm", "I will be preparing the presentation slides","");
	
	// Employee objects
	Employee em1 = new Employee("E100","IamAdam","Adam","Accountant","adam246@gmail.com","Work-from-home");
	Employee em2 = new Employee("E200","IamLucas","Lucas","Assistant Manager","lucaslee@gmail.com","Hybrid");
	Employee em3 = new Employee("E300","IamSara","Sara","Assistant Manager","sara578@gmail.com","Flexi-hours");
	Employee em4 = new Employee("E400","IamJohn","John","Software developer","johnwong88@gmail.com","Work-from-home");

	// Supervisor objects
	Supervisor sp = new Supervisor("S100","IamAli","Ali","Supervisor","alimuhamad@gmail.com","-");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayDailyScheduleDetails frame = new DisplayDailyScheduleDetails();
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
	public DisplayDailyScheduleDetails() {
		setTitle("Daily Schedule List");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1098, 736);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel dailyScheduleLabel = new JLabel("Daily Schedule List");
		dailyScheduleLabel.setBounds(387, 52, 288, 57);
		dailyScheduleLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
		contentPane.add(dailyScheduleLabel);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 222, 1074, 434);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		DailySchedule frame = new DailySchedule();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{sp.getEmployeeID(),sp.getName(),"Supervisor","None","None","None","None","None"},
				{em1.getEmployeeID(),em1.getName(),"Employee",ds1.getDate(),ds1.getWorkLocation(),ds1.getWorkHours(),ds1.getWorkReport(),ds1.getSupervisorComments()},
				{em2.getEmployeeID(),em2.getName(),"Employee",ds2.getDate(),ds2.getWorkLocation(),ds2.getWorkHours(),ds2.getWorkReport(),ds2.getSupervisorComments()},
				{em3.getEmployeeID(),em3.getName(),"Employee",ds3.getDate(),ds3.getWorkLocation(),ds3.getWorkHours(),ds3.getWorkReport(),ds3.getSupervisorComments()},
				{em4.getEmployeeID(),em4.getName(),"Employee",ds4.getDate(),ds4.getWorkLocation(),ds4.getWorkHours(),ds4.getWorkReport(),ds4.getSupervisorComments()}
			},
			new String[] {
				"Employee ID", "Name", "Position", "Date", "Work Location", "Work Hours", "Work Report", "Supervisor comments"
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
