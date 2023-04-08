package bit203Assignment2;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class WelcomeMessage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeMessage frame = new WelcomeMessage();
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
	public WelcomeMessage() {
		setTitle("Welcome to FlexIS System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 739, 811);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to FlexIS System");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel.setBounds(198, 25, 348, 48);
		contentPane.add(lblNewLabel);
		
		JLabel optionLabel = new JLabel("Users can choose the options below:");
		optionLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		optionLabel.setBounds(198, 83, 295, 48);
		contentPane.add(optionLabel);
		
		JLabel Label1 = new JLabel("1. Register Employee or Supervisor");
		Label1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Label1.setBounds(198, 146, 295, 48);
		contentPane.add(Label1);
		
		JLabel Label2 = new JLabel("2. Submit FWA Request");
		Label2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Label2.setBounds(198, 204, 295, 48);
		contentPane.add(Label2);
		
		JLabel Label3 = new JLabel("3. Review FWA Request");
		Label3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Label3.setBounds(198, 262, 295, 48);
		contentPane.add(Label3);
		
		JLabel Label4 = new JLabel("4. Update Daily Schedule");
		Label4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Label4.setBounds(198, 320, 295, 48);
		contentPane.add(Label4);
		
		JLabel Label5 = new JLabel("5. Review Employee Schedule");
		Label5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Label5.setBounds(198, 378, 295, 48);
		contentPane.add(Label5);
		
		JLabel Label6 = new JLabel("6. View FWA Analytics");
		Label6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Label6.setBounds(198, 436, 295, 48);
		contentPane.add(Label6);
		
		JLabel lblDisplayEmployee = new JLabel("7. Display Employee details");
		lblDisplayEmployee.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDisplayEmployee.setBounds(198, 494, 295, 48);
		contentPane.add(lblDisplayEmployee);
		
		JLabel Label8 = new JLabel("8. Display Daily Schedule details of all employees");
		Label8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Label8.setBounds(198, 552, 368, 48);
		contentPane.add(Label8);
		
		JLabel Label9 = new JLabel("9. Save and Load Data");
		Label9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Label9.setBounds(198, 610, 368, 48);
		contentPane.add(Label9);
		
		JButton getStartedBtn = new JButton("Get Started");
		getStartedBtn.setForeground(Color.WHITE);
		getStartedBtn.setBackground(Color.BLACK);
		getStartedBtn.setFocusable(false);
		getStartedBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignIn signIn = new SignIn();
				signIn.setResizable(false);
				signIn.setVisible(true);
			}
		});
		getStartedBtn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		getStartedBtn.setBounds(256, 683, 157, 45);
		contentPane.add(getStartedBtn);
	}
}
