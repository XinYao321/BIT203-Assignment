package bit203Assignment2;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JCalendar;

//Date: 7th April 2023

/*Update Daily Schedule GUI class
 * This GUI class is for employee to update their schedule*/

//@author Lee Xin Yao B2100617

@SuppressWarnings("serial")
public class UpdateDailySchedule extends JFrame {

	private JPanel contentPane;
	private JTextField workLocationTF;
	private JTextField workReportTF;
	String[] workHours = {"----Select work hour----","8am-4pm","9am-5pm","10am-6pm"};
	private JTextField empNameTF;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateDailySchedule frame = new UpdateDailySchedule();
					frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UpdateDailySchedule() {
		setTitle("Update Daily Schedule");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1081, 862);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton dashboardBtn = new JButton("Back to Dashboard");
		dashboardBtn.setForeground(Color.WHITE);
		dashboardBtn.setBackground(Color.BLACK);
		dashboardBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HRAdminDashboard dashboard = new HRAdminDashboard();
				dashboard.setVisible(true);
			}
		});
		dashboardBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		dashboardBtn.setBounds(10, 9, 203, 43);
		dashboardBtn.setFocusable(false);
		contentPane.add(dashboardBtn);
		
		JLabel updateDailySchedule = new JLabel("Update Your Daily Schedule");
		updateDailySchedule.setFont(new Font("Tahoma", Font.BOLD, 25));
		updateDailySchedule.setBounds(330, 75, 376, 40);
		contentPane.add(updateDailySchedule);
		
		JButton LogOutBtn = new JButton("Log Out");
		LogOutBtn.setForeground(Color.WHITE);
		LogOutBtn.setBackground(Color.BLACK);
		LogOutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignIn signIn = new SignIn();
				signIn.setVisible(true);
				signIn.setResizable(false);
				
			}
		});
		LogOutBtn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		LogOutBtn.setBounds(954, 6, 103, 47);
		LogOutBtn.setFocusable(false);
		contentPane.add(LogOutBtn);
		
		JLabel lblNewLabel = new JLabel("Select your date:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(223, 247, 167, 47);
		contentPane.add(lblNewLabel);
		
		JLabel lblEnterWorkLocation = new JLabel("Enter work location:");
		lblEnterWorkLocation.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblEnterWorkLocation.setBounds(223, 347, 183, 47);
		contentPane.add(lblEnterWorkLocation);
		
		JLabel lblEnterWorkHour = new JLabel("Enter work hour:");
		lblEnterWorkHour.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblEnterWorkHour.setBounds(223, 453, 183, 47);
		contentPane.add(lblEnterWorkHour);
		
		JLabel lblEnterWorkReport = new JLabel("Enter work report:");
		lblEnterWorkReport.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblEnterWorkReport.setBounds(223, 555, 183, 47);
		contentPane.add(lblEnterWorkReport);
		
		workLocationTF = new JTextField();
		workLocationTF.setFont(new Font("Tahoma", Font.PLAIN, 17));
		workLocationTF.setBounds(222, 390, 515, 47);
		contentPane.add(workLocationTF);
		workLocationTF.setColumns(10);
		
		workReportTF = new JTextField();
		workReportTF.setHorizontalAlignment(SwingConstants.LEFT);
		workReportTF.setFont(new Font("Tahoma", Font.PLAIN, 17));
		workReportTF.setColumns(10);
		workReportTF.setBounds(222, 598, 515, 107);
		contentPane.add(workReportTF);
		
		JComboBox workHoursCombo = new JComboBox(workHours);
		workHoursCombo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		workHoursCombo.setBounds(222, 496, 515, 47);
		contentPane.add(workHoursCombo);
		
		JLabel empNameLabel = new JLabel("Enter your name:");
		empNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		empNameLabel.setBounds(224, 147, 183, 47);
		contentPane.add(empNameLabel);
		
		empNameTF = new JTextField();
		empNameTF.setFont(new Font("Tahoma", Font.PLAIN, 17));
		empNameTF.setColumns(10);
		empNameTF.setBounds(222, 190, 515, 47);
		contentPane.add(empNameTF);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(222, 291, 515, 47);
		contentPane.add(dateChooser);
		
		// Save button
		JButton saveBtn = new JButton("Save");
		saveBtn.setForeground(Color.WHITE);
		saveBtn.setBackground(Color.BLACK);
		saveBtn.setFocusable(false);
		saveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date date = dateChooser.getDate();
				String employeeName = empNameTF.getText();
				String workLocation = workLocationTF.getText();
				String workHours = (String) workHoursCombo.getSelectedItem();
				String workReport = workReportTF.getText();
				
				// Input validations
				if(employeeName.isEmpty()|| workLocation.isEmpty()|| "----Select work hour----".equalsIgnoreCase(workHours)|| workReport.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Input fields cannot be empty", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else {
					// Display success message
					JOptionPane.showMessageDialog(null, "Updated Schedule successfully", "MESSAGE", JOptionPane.INFORMATION_MESSAGE);
					// Display Employee schedule table
					ReviewEmployeeSchedule schedule = new ReviewEmployeeSchedule();
					schedule.setVisible(true);;
					// Insert into scheduleTable
					Object[] data = {employeeName,date,workLocation,workHours,workReport};
					ReviewEmployeeSchedule.AddRowToTable(data);
				}
			}
		});
		saveBtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		saveBtn.setBounds(383, 733, 241, 55);
		contentPane.add(saveBtn);
		}
}
