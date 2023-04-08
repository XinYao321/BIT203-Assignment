package bit203Assignment2;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
//Date: 7th April 2023

/*Submit FWA Request
* This class is for FlexIS employees to submit an FWA Request
* for their supervisor to view*/
@SuppressWarnings("serial")
public class SubmitFWARequest extends JFrame {

	private JPanel contentPane;
	private JTextField workTypeTF;
	private JTextField descriptionTF;
	private JTextField reasonTF;
	private int r=1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SubmitFWARequest frame = new SubmitFWARequest();
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
	public SubmitFWARequest() {setTitle("Submit FWA Request Page");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 688, 459);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel welcomeMessage = new JLabel("Submit FWA Request Page");
	welcomeMessage.setFont(new Font("Tahoma", Font.BOLD, 25));
	welcomeMessage.setBounds(151, 20, 372, 29);
	contentPane.add(welcomeMessage);
	
	JLabel workTypeLabel = new JLabel("Work Type:");
	workTypeLabel.setBounds(58, 71, 567, 107);
	workTypeLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
	contentPane.add(workTypeLabel);
	
	workTypeTF = new JTextField();
	workTypeTF.setFont(new Font("Tahoma", Font.PLAIN, 17));
	workTypeTF.setBounds(258, 100, 218, 41);
	contentPane.add(workTypeTF);
	workTypeTF.setColumns(10);
	
	JLabel descriptionLabel = new JLabel("Description:");
	descriptionLabel.setBounds(58, 151, 567, 107);
	descriptionLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
	contentPane.add(descriptionLabel);
	
	
	descriptionTF = new JTextField();
	descriptionTF.setFont(new Font("Tahoma", Font.PLAIN, 17));
	descriptionTF.setBounds(258, 188, 218, 41);
	contentPane.add(descriptionTF);
	descriptionTF.setColumns(10);
	
	JLabel reasonLabel = new JLabel("Reason:");
	reasonLabel.setBounds(58, 231, 567, 107);
	reasonLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
	contentPane.add(reasonLabel);
	
	
	reasonTF = new JTextField();
	reasonTF.setFont(new Font("Tahoma", Font.PLAIN, 17));
	reasonTF.setBounds(258, 276, 218, 41);
	contentPane.add(reasonTF);
	reasonTF.setColumns(10);
	
	// Submit button
	JButton signInBtn = new JButton("Submit");
	signInBtn.setForeground(Color.WHITE);
	signInBtn.setBackground(Color.BLACK);
	signInBtn.setFocusable(false);
	signInBtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String workType = workTypeTF.getText();
			@SuppressWarnings("deprecation")
			String description = descriptionTF.getText();
			@SuppressWarnings("deprecation")
			String reason = reasonTF.getText();
			
			// Input Validation for work type
			if(workType == "Work-from-home") {
				// Set to Work-from-home
				
				}
					
			else if(workType == "Flexi-Hours") {
				// Set to Flexi-Hours
				
				}
					
			else if(workType == "Hybrid") {
				// Set to Hybrid
				
				}
			
			// If input fields are empty
			else if(workType.isEmpty() || description.isEmpty() || reason.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Input fields cannot be empty", "ERROR", JOptionPane.ERROR_MESSAGE);;
					}
					
			// If users entered invalid work type
			else {
				JOptionPane.showMessageDialog(null, "Invalid Work Type", "ERROR", JOptionPane.ERROR_MESSAGE);;
				workTypeTF.setText("");
				descriptionTF.setText("");
				reasonTF.setText("");
					}
				}
			});
			signInBtn.setFont(new Font("Tahoma", Font.PLAIN, 17));
			signInBtn.setBounds(258, 350, 133, 47);
			contentPane.add(signInBtn);
	}

}
