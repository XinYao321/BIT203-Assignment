package bit203Assignment2;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.util.*;
import java.io.*;
// Date: 7th April 2023

/*Save and Load Data GUI class
 * This class is for saving and loading data*/

// author: Lee Xin Yao B2100617
@SuppressWarnings("serial")
public class SaveAndLoadData extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SaveAndLoadData frame = new SaveAndLoadData();
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
	public SaveAndLoadData() {
		setTitle("Save and Load Data Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 952, 673);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		//textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField.setBounds(80, 219, 745, 327);
		textField.setColumns(10);
		contentPane.add(textField);
		
		// Open file button
		JButton departmentBtn = new JButton("Department File");
		departmentBtn.setForeground(Color.WHITE);
		departmentBtn.setBackground(Color.BLACK);
		departmentBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Include department.txt file path
				File file = new File("C:\\Users\\User\\Desktop\\department.txt");
				try {
					BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
					textField.read(input, e);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		departmentBtn.setFocusable(false);
		departmentBtn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		departmentBtn.setBounds(80, 109, 166, 44);
		contentPane.add(departmentBtn);
		
		JButton employeeFileBtn = new JButton("Employee File");
		employeeFileBtn.setForeground(Color.WHITE);
		employeeFileBtn.setBackground(Color.BLACK);
		employeeFileBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Include department.txt file path
				File file = new File("C:\\Users\\User\\Desktop\\employee.txt");
				try {
					BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
					textField.read(input, e);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		employeeFileBtn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		employeeFileBtn.setFocusable(false);
		employeeFileBtn.setBounds(285, 109, 142, 44);
		contentPane.add(employeeFileBtn);
		
		JButton dailyScheduleBtn = new JButton("Daily Schedule File");
		dailyScheduleBtn.setForeground(Color.WHITE);
		dailyScheduleBtn.setBackground(Color.BLACK);
		dailyScheduleBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file = new File("C:\\Users\\User\\Desktop\\dailySchedule.txt");
				try {
					BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
					textField.read(input, e);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		dailyScheduleBtn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		dailyScheduleBtn.setFocusable(false);
		dailyScheduleBtn.setBounds(451, 109, 182, 44);
		contentPane.add(dailyScheduleBtn);
		
		// Clear button
		JButton clearBtn = new JButton("Clear");
		clearBtn.setForeground(Color.WHITE);
		clearBtn.setBackground(Color.BLACK);
		clearBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
			}
		});
		clearBtn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		clearBtn.setFocusable(false);
		clearBtn.setBounds(658, 109, 124, 44);
		contentPane.add(clearBtn);
		
		// Back to dashboard button
		JButton dashboardBtn = new JButton("Back to dashboard");
		dashboardBtn.setForeground(Color.WHITE);
		dashboardBtn.setBackground(Color.BLACK);
		dashboardBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HRAdminDashboard hrAdmin = new HRAdminDashboard();
				hrAdmin.setVisible(true);
			}
		});
		dashboardBtn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		dashboardBtn.setBounds(10, 10, 187, 44);
		contentPane.add(dashboardBtn);
		
		// Log out button
		JButton logOutBtn = new JButton("Log Out");
		logOutBtn.setForeground(Color.WHITE);
		logOutBtn.setBackground(Color.BLACK);
		logOutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignIn signIn = new SignIn();
				signIn.setVisible(true);
			}
		});
		logOutBtn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		logOutBtn.setBounds(798, 13, 130, 44);
		contentPane.add(logOutBtn);
	}
}
