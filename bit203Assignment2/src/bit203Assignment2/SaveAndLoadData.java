package bit203Assignment2;

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

/*Save and Load Data GUI class*/

// author: Lee Xin Yao B2100617
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
		setBounds(100, 100, 886, 576);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		//textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField.setBounds(45, 163, 745, 327);
		textField.setColumns(10);
		contentPane.add(textField);
		
		// Open file button
		JButton openBtn = new JButton("Department File");
		openBtn.addActionListener(new ActionListener() {
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
		openBtn.setFocusable(false);
		openBtn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		openBtn.setBounds(45, 53, 166, 44);
		contentPane.add(openBtn);
		
		JButton employeeFileBtn = new JButton("Employee File");
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
		employeeFileBtn.setBounds(250, 53, 142, 44);
		contentPane.add(employeeFileBtn);
		
		JButton btnFwaRequestFile = new JButton("Daily Schedule File");
		btnFwaRequestFile.addActionListener(new ActionListener() {
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
		btnFwaRequestFile.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnFwaRequestFile.setFocusable(false);
		btnFwaRequestFile.setBounds(431, 53, 165, 44);
		contentPane.add(btnFwaRequestFile);
		
		// Clear button
		JButton clearBtn = new JButton("Clear");
		clearBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
			}
		});
		clearBtn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		clearBtn.setFocusable(false);
		clearBtn.setBounds(623, 53, 124, 44);
		contentPane.add(clearBtn);
	}
}
