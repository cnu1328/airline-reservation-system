package airline;

import java.awt.EventQueue;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class AddCustomer extends JFrame { 
	
		public boolean isValidEmail(String email) {
		    String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
		    return email.matches(regex);
		}
		
		public boolean isValidIndianPassport(String passportNumber) {
		    String regex = "^[A-Z]\\d{7}$";
		    return passportNumber.matches(regex);
		}


		public boolean isUsernameAvailable(String username) {
		    boolean available = false;

		    try {
		        Conn conn = new Conn();
		        String checkQuery = "SELECT * FROM Passenger WHERE username = ?";
		        PreparedStatement pstmt = conn.conn.prepareStatement(checkQuery);
		        pstmt.setString(1, username);
		        ResultSet rs = pstmt.executeQuery();

		        if (!rs.next()) {
		            // Username is available if the result set is empty
		            available = true;
		        }
		        
		        // Close result set, statement, and connection
		        rs.close();
		        pstmt.close();
		        conn.conn.close();

		    } catch (SQLException e) {
		        // Handle any SQL exceptions here
		        e.printStackTrace();
		    }

		    return available;
		}
		
		public boolean isValidPhoneNumber(String phoneNumber) {
		    return phoneNumber.matches("\\d{10}");
		}

        public AddCustomer() {
        	
            getContentPane().setForeground(Color.BLUE);
            getContentPane().setBackground(Color.WHITE);
            setTitle("ENTER YOUR DETAILS"); 
            
            JLabel AddPassengers = new JLabel("ENTER YOUR DETAILS");
            AddPassengers.setForeground(Color.BLUE);
            AddPassengers.setFont(new Font("Tahoma", Font.PLAIN, 31));
            AddPassengers.setBounds(550, 24, 442, 35);
            add(AddPassengers);
            
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            setSize(778,486);
            getContentPane().setLayout(null);
			
            JLabel Name = new JLabel("Name");
            Name.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Name.setBounds(60, 30, 150, 27);
            add(Name);
            
            JTextField nametf = new JTextField();
            nametf.setBounds(200, 30, 150, 27);
            nametf.setFont(new Font("Tohoma",Font.PLAIN,17));
            add(nametf);
	
            
            JLabel email = new JLabel("E-Mail");
            email.setFont(new Font("Tahoma", Font.PLAIN, 17));
            email.setBounds(60, 80, 150, 27);
            add(email);
            
            
            
            JTextField emailtf = new JTextField();
            emailtf.setBounds(200, 80, 150, 27);
//            emailtf.setFont(new Font("Tohoma",Font.PLAIN,17));
            add(emailtf);
            
            emailtf.setText("example@gmail.com"); // Placeholder text initially

            emailtf.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (emailtf.getText().equals("example@gmail.com")) {
                        emailtf.setText("");
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (emailtf.getText().isEmpty()) {
                        emailtf.setText("example@gmail.com");
                    }
                }
            });
                        
            JLabel Gender = new JLabel("Gender");
            Gender.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Gender.setBounds(60, 130, 150, 27);
            add(Gender);
            
            JRadioButton male = new JRadioButton("Male");
            male.setBounds(200,130,80,27);
            JRadioButton female = new JRadioButton("Female");
            female.setBounds(290,130,80,27);
            
            ButtonGroup bg = new ButtonGroup();
            bg.add(male);
            bg.add(female);
            add(male);
            add(female);

            
            JLabel passport_no = new JLabel("Passport No.");
            passport_no.setFont(new Font("Tahoma", Font.PLAIN, 17));
            passport_no.setBounds(60, 180, 150, 27);
            add(passport_no);
            
            JTextField passport_notf = new JTextField();
            passport_notf.setBounds(200, 180, 150, 27);
            add(passport_notf);
            
            passport_notf.setText("Example : H9137927"); // Placeholder text initially

            passport_notf.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (passport_notf.getText().equals("Example : H9137927")) {
                        passport_notf.setText("");
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (passport_notf.getText().isEmpty()) {
                        passport_notf.setText("Example : H9137927");
                    }
                }
            });
            
            JLabel nation = new JLabel("Nationality");
            nation.setFont(new Font("Tohoma",Font.PLAIN,17));
            nation.setBounds(60,230,150,27);
            
            add(nation);
            
            JTextField nationtf = new JTextField();
            nationtf.setBounds(200,230,150,27);
            nationtf.setFont(new Font("Tohoma",Font.PLAIN,17));
            add(nationtf);
            
            JLabel address = new JLabel("Address");
            address.setBounds(60,280,150,27);
            address.setFont(new Font("Tohoma",Font.PLAIN,17));
            add(address);
            
            JTextField addresstf = new JTextField();
            addresstf.setBounds(200,280,150,27);
            addresstf.setFont(new Font("Tohoma",Font.PLAIN,17));
            add(addresstf);
            
            JLabel phone = new JLabel("Phone Number");
            phone.setBounds(60,330,150,27);
            phone.setFont(new Font("Tohoma",Font.PLAIN,17));
            add(phone);
            
            JTextField phonetf = new JTextField();
            phonetf.setBounds(200,330,150,27);
            phonetf.setFont(new Font("Tohoma",Font.PLAIN,17));
            add(phonetf);
            
            
            JLabel user = new JLabel("Username");
            user.setBounds(60,380,150,27);
            user.setFont(new Font("Tohoma",Font.PLAIN,17));
            add(user);
            
            JTextField usertf = new JTextField();
            usertf.setBounds(200,380,150,27);
            usertf.setFont(new Font("Tohoma",Font.PLAIN,17));
            add(usertf);
            
            JLabel password = new JLabel("Password");
            password.setBounds(60,430,150,27);
            password.setFont(new Font("Tohoma",Font.PLAIN,17));
            add(password);
            
            JPasswordField passwordtf = new JPasswordField();
            passwordtf.setBounds(200,430,150,27);
            passwordtf.setFont(new Font("Tohoma",Font.PLAIN,17));
            add(passwordtf);
            
            JLabel confirm = new JLabel("Conform Password");
            confirm.setBounds(50,480,150,27);
            confirm.setFont(new Font("Tohoma",Font.PLAIN,17));
            add(confirm);
            
            JTextField confirmtf = new JTextField();
            confirmtf.setFont(new Font("Tohoma",Font.PLAIN,17));
            confirmtf.setBounds(200,480,150,27);
            add(confirmtf);
            
            JButton save = new JButton("Save");
            save.setBounds(160,530,80,27);
            save.setFont(new Font("Tohoma",Font.PLAIN,17));
            add(save);
            
            JButton cancel = new JButton("Cancel");
            cancel.setBounds(300,530,100,27);
            cancel.setFont(new Font("Tohoma",Font.PLAIN,17));
            add(cancel);
            
            cancel.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e)
    			{
    				dispose();
    			}
    		});
            		
                        
            save.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				String name = nametf.getText();
    				String email = emailtf.getText();
    				String nation = nationtf.getText();
    				String passport_no = passport_notf.getText();
    				String address = addresstf.getText();
    				String username = usertf.getText();
    				
    				char[] passwordChars = passwordtf.getPassword();
    				String password = new String(passwordChars);

    				String conform = confirmtf.getText();
    				String ph = phonetf.getText();
    				String gender = null;
    				if(male.isSelected()) {
    					gender = "male";
    				} else if(female.isSelected()) {
    					gender = "female";
    				}
    				
    				if (conform.isEmpty() || name.isEmpty() || email.isEmpty() || nation.isEmpty() || passport_no.isEmpty() || address.isEmpty() || gender == null || username.isEmpty() || password.isEmpty()) {
    		            JOptionPane.showMessageDialog(null, "Please fill in all required fields!");
    		            
    		        } else if (!password.equals(conform)) {
    		            JOptionPane.showMessageDialog(null, "Confirm Password does not match the entered password!");
    		            
    		        } else if (!isValidPhoneNumber(ph)) {
    		            JOptionPane.showMessageDialog(null, "Please enter a valid Phone Number!");
    		            
    		        }
    		        
    		        else if (!isValidEmail(email)) {
    		            JOptionPane.showMessageDialog(null, "Please enter a valid email address!");
    		            
    		        } else if (!isValidIndianPassport(passport_no)) {
    		            JOptionPane.showMessageDialog(null, "Please enter a valid Indian passport number!");
    		            
    		        } else if (!isUsernameAvailable(username)) {
    		            JOptionPane.showMessageDialog(null, "Username already exists. Please choose another username!");
    		            
    		        } else {
                      try {
                    	  Conn c = new Conn();
                    	  String str = "INSERT INTO Passenger (username, name, address, gender, passport, nationality, phonenumber, gmail) VALUES ('" + username + "', '" + name + "', '" + address + "','" + gender + "', '" + passport_no + "', '" + nation + "', '" + ph + "', '" + email + "')";

	                       String str1 = "INSERT INTO login values('"+username+"', '"+ password + "')";
	                       c.stmt.executeUpdate(str);
	                       c.stmt.executeUpdate(str1);
	                       JOptionPane.showMessageDialog(null,"Welcome to the Airline Mangement System. Your are successfully SignedUp!!!");
	                       setVisible(false);
                           
                      } catch (Exception ee) {
                          ee.printStackTrace();
                      }
                  }
    				
    			}
    		});
            
            
            
            
            
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/emp.png"));
            JLabel image = new JLabel(i1);
            image.setBounds(550,80,280,410);
            add(image);

			
            setSize(1000,650);
            setVisible(true);
            setLocation(200,50);
			
	}
        
    public static void main(String[] args)
    {
        new AddCustomer();
    }   
}

