package airline;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;


public class LoginType extends JFrame {
	
	public Login obj;

	private JPanel contentPane;

	
//************************ Launch the application ************************************************
	 
	public static void main(String[] args) {
		LoginType frame = new LoginType();
		
	}

//************************ Create The Frame ************************************************

	public LoginType() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 579, 368);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		
		JLabel la = new JLabel("Welcome To Hyderabad Airline, Your home in the sky");
		la.setForeground(Color.BLUE);
		la.setFont(new Font("Tahoma", Font.PLAIN, 18));
		la.setHorizontalAlignment(JLabel.CENTER);
		la.setBounds(50, 11, 450, 29);
		contentPane.add(la);
		
		JButton b1 = new JButton("Admin");
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminLogin ad = new AdminLogin();
				dispose();
			}
		});
		
		
		b1.setBounds(220, 113, 106, 23);
		contentPane.add(b1);
		
		JButton b1_1 = new JButton("Passenger");
		b1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				obj = new Login();
				dispose();
			}
		});
		
		
		b1_1.setBounds(220, 178, 106, 23);
		contentPane.add(b1_1);
		
		JLabel la_1 = new JLabel("Select your login type");
		la_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		la_1.setForeground(Color.BLUE);
		la_1.setHorizontalAlignment(JLabel.CENTER);
		la_1.setBounds(80, 51, 414, 29);
		contentPane.add(la_1);
		
		JButton b1_2 = new JButton("Back");
		b1_2.setBounds(450, 234, 89, 23);
		contentPane.add(b1_2);
		b1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
}

