package airline;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


public class PassengerDetail extends JFrame {
	
	JTextField tf, tf1, tf2, tf3, tf4, tf5, tf6, tf7;
	
	public PassengerDetail(PassengerInfo p) {
		
		getContentPane().setForeground(Color.BLUE);
        getContentPane().setBackground(Color.WHITE);
        
        setTitle("PASSENGER DETAILS");
        
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(778,486);
        getContentPane().setLayout(null);
        
        JLabel username = new JLabel("Username		:");
        username.setFont(new Font("Tahoma", Font.PLAIN, 17));
        username.setBounds(60, 80, 150, 27);
        add(username);
        
        JLabel tf = new JLabel(p.getUsername());
        tf.setFont(new Font("Tahoma", Font.BOLD, 17));
        tf.setBounds(230, 80, 200, 27);
        add(tf);
        
        JButton b1_2 = new JButton("Cancel");
		b1_2.setBounds(350, 480, 150, 30);
		add(b1_2);
        
        JLabel name = new JLabel("Name		:");
        name.setFont(new Font("Tahoma", Font.PLAIN, 17));
        name.setBounds(60, 120, 150, 27);
        add(name);
        
      
        JLabel tf1 = new JLabel(p.getName());
        tf1.setFont(new Font("Tahoma", Font.BOLD, 17));
        tf1.setBounds(230, 120, 200, 27);
        add(tf1);
        
        JLabel Gmail = new JLabel("Gmail	:");
        Gmail.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Gmail.setBounds(60, 170, 150, 27);
        add(Gmail);
        
        
        JLabel tf2 = new JLabel(p.getGmail());
        tf2.setFont(new Font("Tahoma", Font.BOLD, 17));
        tf2.setBounds(230, 170, 200, 27);
        add(tf2);
        
        
        JLabel Gender = new JLabel("Gender	:");
        Gender.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Gender.setBounds(60, 220, 150, 27);
        add(Gender);
        
        JLabel tf3 = new JLabel(p.getGender());
        tf3.setFont(new Font("Tahoma", Font.BOLD, 17));
        tf3.setBounds(230, 220, 200, 27);
        add(tf3);
        
        JLabel Natioinality = new JLabel("Natioinality		:");
        Natioinality.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Natioinality.setBounds(60, 270, 150, 27);
        add(Natioinality);
        
        
        JLabel tf4 = new JLabel(p.getNationality());
        tf4.setFont(new Font("Tahoma", Font.BOLD, 17));
        tf4.setBounds(230, 270, 200, 27);
        add(tf4);
        
        JLabel Passport = new JLabel("Passport		:");
        Passport.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Passport.setBounds(60, 320, 150, 27);
        add(Passport);
        
        JLabel tf7 = new JLabel(p.getPassport_no());
        tf7.setFont(new Font("Tahoma", Font.BOLD, 17));
        tf7.setBounds(230, 320, 200, 27);
        add(tf7);
        
        
        JLabel Phno = new JLabel("PH NO		:");
        Phno.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Phno.setBounds(60, 370, 150, 27);
        add(Phno);
        
        JLabel tf5 = new JLabel(p.getPhonenumber());
        tf5.setFont(new Font("Tahoma", Font.BOLD, 17));
        tf5.setBounds(230, 370, 200, 27);
        add(tf5);
        
        JLabel AddPassengers = new JLabel("Your Credentials");
        AddPassengers.setForeground(Color.BLUE);
        AddPassengers.setFont(new Font("Tahoma", Font.PLAIN, 31));
        AddPassengers.setBounds(530, 24, 442, 35);
        add(AddPassengers);
        
        JLabel Address = new JLabel("Address		:");
        Address.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Address.setBounds(60, 420, 150, 27);
        add(Address);
        
        
        JLabel tf6 = new JLabel(p.getAddress());
        tf6.setFont(new Font("Tahoma", Font.BOLD, 17));
        tf6.setBounds(230, 420, 200, 27);
        add(tf6);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/emp.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(500,80,280,410);
        add(image);
        
      
        
        
        b1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
        
        
        
        setSize(900,600);
        setVisible(true);
        setLocation(200,100);
        
               
 
	}
	
	public static void main(String[] args) {
		new PassengerDetail(null);
	}

}
