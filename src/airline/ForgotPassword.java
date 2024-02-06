package airline;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class ForgotPassword extends JFrame implements ActionListener{
	
	
	TextField t1, t2, t3;
	JLabel l1, l2, l3, label;
	JButton b1, b2, b3, b4;
	GridBagLayout gbl;
	GridBagConstraints gbc;
	Font f1, f2;
	
	public ForgotPassword() {
		super("Forgot Password");
		
		setBackground(Color.WHITE);
		
		f1 = new Font("TimesRoman", Font.PLAIN, 20);
		f2 = new Font("TimesRoman", Font.PLAIN, 15);
		
		gbl = new GridBagLayout();
		gbc = new GridBagConstraints();
		setLayout(gbl);	
		
		
		l1 = new JLabel("Username");
		l1.setFont(f1);
		
		l2 = new JLabel("New Password");
		l2.setFont(f1);
		
		l3 = new JLabel("Confrim Password");
		l3.setFont(f1);
		
		
		t1 = new TextField(15);
		t2 = new TextField(15);
		t3 = new TextField(15);
		
		t2.setEchoChar('*');
		t3.setEchoChar('*');
	
		
		b2 = new JButton("Save");
		b2.setFont(f2);
		
		b3 = new JButton("Cancel");
		b3.setFont(f2);
		
		
	
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbl.setConstraints(l1, gbc);
		add(l1);
		
		gbc.gridx = 4;
		gbc.gridy = 0;
		gbl.setConstraints(t1, gbc);
		add(t1);
		
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbl.setConstraints(l2, gbc);
		add(l2);
		
		
		gbc.gridx = 4;
		gbc.gridy = 2;
		gbl.setConstraints(t2, gbc);
		add(t2);
		
		
	
		gbc.gridx = 2;
		gbc.gridy = 4;
		gbl.setConstraints(l3, gbc);
		add(l3);
		
		gbc.gridx = 4;
		gbc.gridy = 4;
		gbl.setConstraints(t3, gbc);
		add(t3);
		
		
		
		JLabel l5 = new JLabel(".");
		gbc.gridx = 10;
		gbc.gridy = 12;
		gbl.setConstraints(l5, gbc);
		add(l5);
		
		JLabel l7 = new JLabel(".");
		gbc.gridx = 10;
		gbc.gridy = 13;
		gbl.setConstraints(l7, gbc);
		add(l7);
		
		
		gbc.gridx = 3;
		gbc.gridy = 14;
		gbl.setConstraints(b2, gbc);
		add(b2);
		
		gbc.gridx = 4;
		gbc.gridy = 14;
		gbl.setConstraints(b3, gbc);
		add(b3);
		
		
		
		
		
		b2.setBackground(Color.CYAN);
		b3.setBackground(Color.CYAN);
//		b2.setForeground(Color.WHITE);
	

		b2.addActionListener(this);
		b3.addActionListener(this);
		
		
		
		setVisible(true);
		setSize(400, 400);
		setLocation(400, 200);
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == b2) {
			try {
				
				try {
	        		Conn c = new Conn();
	        		String str1 = "SELECT COUNT(*) AS count FROM login WHERE username = ?";
	        	    PreparedStatement pstmt = c.conn.prepareStatement(str1);
	        	    pstmt.setString(1, t1.getText());
	        	    ResultSet rs = pstmt.executeQuery();

	        	    rs.next();
	        	    int count = rs.getInt("count");

	        	    if (count > 0) {
	        	    	String username = t1.getText();
	        	    	String password = t2.getText();
	        	    	String password1 = t3.getText();
	        	    	
	        	    	if(!password.equals(password1) || password.isEmpty() || password1.isEmpty() ) {
	    					JOptionPane.showMessageDialog(null, "Confirm Password is Matching with the password you Entered!");
	    				} else {
	    					try {
	    						
	    						Conn conn = new Conn();
	    						
	    						String updateQuery = "UPDATE Login SET password = ? WHERE username = ?";
	    						PreparedStatement pstmt1 = conn.conn.prepareStatement(updateQuery);
	    					    pstmt1.setString(1, password);
	    					    pstmt1.setString(2, username);

	    					    int rowsUpdated = pstmt1.executeUpdate(); // Use executeUpdate for update queries

	    					    if (rowsUpdated > 0) {
	    					        JOptionPane.showMessageDialog(null, "Password Updated Successfully");
	    					        setVisible(false);
	    					        new Login();
	    					    } else {
	    					        JOptionPane.showMessageDialog(null, "Invalid Login");
	    					    }
	    						
	    					} catch(Exception e1) {
	    						System.out.println(e1);
	    					}
	    				}
	        	    	           	        	    	
	        	    } else {	            	        	     
	        	    	JOptionPane.showMessageDialog(null, "Please enter your username.");
	        	    }

	
	        	} catch (Exception ee) {
	        	    ee.printStackTrace();
	        	}
				
			} catch(Exception e1) {
				System.out.println(e1);
			}
		} else if(e.getSource() == b3) {
			new Login();
			dispose();
		}
	}

	public static void main(String[] args) {
		new ForgotPassword();

	}

}
