package airline;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class AdminLogin extends JFrame implements ActionListener{
	
	TextField t1, t2;
	JLabel l1, l2, label;
	JButton b1, b2, b3;
	GridBagLayout gbl;
	GridBagConstraints gbc;
	Font f1, f2;
	
	public AdminLogin() {
		super("Admin Login Form");
		
		setBackground(Color.WHITE);
		
		f1 = new Font("TimesRoman", Font.BOLD, 20);
		f2 = new Font("TimesRoman", Font.BOLD, 15);
		
		gbl = new GridBagLayout();
		gbc = new GridBagConstraints();
		setLayout(gbl);	
		
		
		l1 = new JLabel("Username");
		l1.setFont(f1);
		
		l2 = new JLabel("Password");
		l2.setFont(f1);
		
		t1 = new TextField(15);
		t2 = new TextField(15);
		
		t2.setEchoChar('*');
		
		b1 = new JButton("Reset");
		b1.setFont(f2);
		
		b2 = new JButton("SignIn");
		b2.setFont(f2);
		
		b3 = new JButton("Close");
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
		
		JLabel l3 = new JLabel(".");
		gbc.gridx = 200;
		gbc.gridy = 8;
		gbl.setConstraints(l3, gbc);
		add(l3);
		
		
		JLabel l6 = new JLabel(".");
		gbc.gridx = 200;
		gbc.gridy = 9;
		gbl.setConstraints(l6, gbc);
		add(l6);
		
		
		gbc.gridx = 2;
		gbc.gridy = 13;
		gbl.setConstraints(b1, gbc);
		add(b1);
		
		
		gbc.gridx = 3;
		gbc.gridy = 13;
		gbl.setConstraints(b2, gbc);
		add(b2);
		
		gbc.gridx = 4;
		gbc.gridy = 13;
		gbl.setConstraints(b3, gbc);
		add(b3);
		
		
		
		
		
		b1.setBackground(Color.CYAN);
//		b1.setForeground(Color.WHITE);
		
		b2.setBackground(Color.CYAN);
//		b2.setForeground(Color.WHITE);
		
		b3.setBackground(Color.CYAN);
//		b3.setForeground(Color.WHITE);
		
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		
		setVisible(true);
		setSize(400, 400);
		setLocation(400, 200);
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1) {
			t1.setText("");
			t2.setText("");
		}
		
		if(e.getSource() == b3) {
			System.exit(0);
		}
		
		if(e.getSource() == b2) {
			try {
				
				Conn conn = new Conn();
				
				String s1 = t1.getText();
				String s2 = t2.getText();
				
				String str = "select * from admin where username = '" + s1 + "' and password = '" + s2 + "'";
				ResultSet rs = conn.stmt.executeQuery(str);
				
				if(rs.next()) {
					new AdminMainFrame();
					setVisible(false);
				}
				
				else {
					JOptionPane.showMessageDialog(null, "Invalid Login");
				}
				
			} catch(Exception e1) {
				System.out.println(e1);
			}
		}
	}

	public static void main(String[] args) {
		new AdminLogin();

	}

}

