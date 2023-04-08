package bit203Assignment2;

import java.awt.Color; 
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date; 
import java.util.UUID;
import java.awt.event.ActionEvent;

import javax.swing.*; 
//Date: 7th April 2023

/*Submit FWA Request
* This class is for FlexIS employees to submit an FWA Request
* for their supervisor to view*/
@SuppressWarnings("serial")
public class SubmitFWARequest extends JFrame {

	private JPanel contentPane;
	String[] workType = {"----Select work type----","Work-from-home","Flexi-Hours","Hybrid"}; 
	private JTextField descriptionTF;
	private JTextField reasonTF;
	
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
	
	// Set current date
    LocalDate currentDate = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String formattedDate = currentDate.format(formatter);
    
	JLabel welcomeMessage = new JLabel("Submit FWA Request Page");
	welcomeMessage.setFont(new Font("Tahoma", Font.BOLD, 25));
	welcomeMessage.setBounds(151, 20, 372, 29);
	contentPane.add(welcomeMessage);
	
	JLabel workTypeLabel = new JLabel("Work Type:");
	workTypeLabel.setBounds(43, 156, 567, 41);
	workTypeLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
	contentPane.add(workTypeLabel);
	
	JComboBox workTypeCB = new JComboBox(workType);
	workTypeCB.setFont(new Font("Tahoma", Font.PLAIN, 17));
	workTypeCB.setBounds(258, 156, 218, 41);
	contentPane.add(workTypeCB);
	
	
	descriptionTF = new JTextField();
	descriptionTF.setFont(new Font("Tahoma", Font.PLAIN, 17));
	descriptionTF.setBounds(258, 207, 218, 41);
	contentPane.add(descriptionTF);
	descriptionTF.setColumns(10);
	
	JLabel reasonLabel = new JLabel("Reason:");
	reasonLabel.setBounds(43, 258, 567, 41);
	reasonLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
	contentPane.add(reasonLabel);
	
	
	reasonTF = new JTextField();
	reasonTF.setFont(new Font("Tahoma", Font.PLAIN, 17));
	reasonTF.setBounds(258, 258, 218, 41);
	contentPane.add(reasonTF);
	reasonTF.setColumns(10);
	
	JLabel empIDLabel = new JLabel("Employee ID:");
	empIDLabel.setBounds(43, 105, 567, 41);
	empIDLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
	contentPane.add(empIDLabel);
	
	JTextField employeeIDTF = new JTextField();
	employeeIDTF.setFont(new Font("Tahoma", Font.PLAIN, 17));
	employeeIDTF.setBounds(258, 105, 218, 41);
	contentPane.add(employeeIDTF);
	employeeIDTF.setColumns(10);
	
	// Submit button
	JButton subBtn = new JButton("Submit");
	subBtn.setForeground(Color.WHITE);
	subBtn.setBackground(Color.BLACK);
	subBtn.setFocusable(false);
	subBtn.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	    	String employeeID = employeeIDTF.getText();
	    	String requestID = UUID.randomUUID().toString();
	        String date = formattedDate;
			String status = "Pending";
			String workType = (String)workTypeCB.getSelectedItem();
			String description = descriptionTF.getText();
			@SuppressWarnings("deprecation")
			String reason = reasonTF.getText();
			
			
			// If input fields are empty
						if("----Select work type----".equalsIgnoreCase(workType) || description.isEmpty() || reason.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Input fields cannot be empty", "ERROR", JOptionPane.ERROR_MESSAGE);;
								}
								
						// Display success message 
						JOptionPane.showMessageDialog(null, "Submitted Request successfully", "MESSAGE", JOptionPane.INFORMATION_MESSAGE); 

						// Display Employee request table 
						ReviewFWARequest request = new ReviewFWARequest(); 
						request.setVisible(true); 

						// Insert into requestTable 
						Object[] data = {employeeID,requestID,date,workType,description,reason,status}; 
						ReviewFWARequest.AddRowToTable(data); 
	    }
	});
	subBtn.setFont(new Font("Tahoma", Font.PLAIN, 20)); 
	subBtn.setBounds(258, 325, 133, 47);
	contentPane.add(subBtn); 
	
	JLabel descriptionLabel = new JLabel("Description:");
	descriptionLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
	descriptionLabel.setBounds(43, 207, 567, 41);
	contentPane.add(descriptionLabel);

			
		}
}
