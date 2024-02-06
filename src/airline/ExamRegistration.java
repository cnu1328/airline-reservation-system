 package airline;

import java.awt.EventQueue;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class ExamRegistration extends JFrame { 

        public ExamRegistration() {
        	
            getContentPane().setForeground(Color.BLUE);
            getContentPane().setBackground(Color.WHITE);
            setTitle("ENTER YOUR DETAILS"); 
            
            JLabel AddPassengers = new JLabel("Student Exam Registration");
            AddPassengers.setForeground(Color.BLUE);
            AddPassengers.setFont(new Font("Tahoma", Font.PLAIN, 31));
            AddPassengers.setBounds(250, 24, 562, 35);
            add(AddPassengers);
            
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            setSize(778,486);
            getContentPane().setLayout(null);
			
            JLabel Name = new JLabel("Name");
            Name.setFont(new Font("Serif Bold", Font.PLAIN, 17));
            Name.setBounds(350,84, 100, 37);
            add(Name);
            
            JTextField nametf = new JTextField();
            nametf.setBounds(450, 84, 250, 37);
            nametf.setFont(new Font("Tohoma",Font.PLAIN,17));
            add(nametf);
	
            
            JLabel email = new JLabel("E-Mail");
            email.setFont(new Font("Tahoma", Font.PLAIN, 17));
            email.setBounds(350, 140, 150, 27);
            add(email);
            
            
            
            JTextField emailtf = new JTextField();
            emailtf.setBounds(450, 140, 150, 27);
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
            Gender.setBounds(350, 190, 150, 27);
            add(Gender);
            
            JRadioButton male = new JRadioButton("Male");
            male.setBounds(450,190,80,27);
            JRadioButton female = new JRadioButton("Female");
            female.setBounds(540,190,80,27);
            
            ButtonGroup bg = new ButtonGroup();
            bg.add(male);
            bg.add(female);
            add(male);
            add(female);

            
            JLabel Id = new JLabel("Identity No.");
            Id.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Id.setBounds(300, 240, 150, 27);
            add(Id);
            
            JTextField Idtf = new JTextField();
            Idtf.setBounds(450, 240, 150, 27);
            add(Idtf);
            
            Idtf.setText("Example : B193927"); // Placeholder text initially

            Idtf.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (Idtf.getText().equals("Example : B193927")) {
                        Idtf.setText("");
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (Idtf.getText().isEmpty()) {
                        Idtf.setText("Example : B193927");
                    }
                }
            });
            
            JLabel collegeName = new JLabel("College_Name");
            collegeName.setFont(new Font("Tohoma",Font.PLAIN,17));
            collegeName.setBounds(280,290,150,27);
            
            add(collegeName);
            
            JTextField collegeNametf = new JTextField();
            collegeNametf.setBounds(450,290,150,27);
            collegeNametf.setFont(new Font("Tohoma",Font.PLAIN,17));
            add(collegeNametf);
            
            JLabel address = new JLabel("College_Address");
            address.setBounds(280,340,150,27);
            address.setFont(new Font("Tohoma",Font.PLAIN,17));
            add(address);
            
            JTextField addresstf = new JTextField();
            addresstf.setBounds(450,340,150,27);
            addresstf.setFont(new Font("Tohoma",Font.PLAIN,17));
            add(addresstf);
            
       
		    JLabel Subjects = new JLabel("Subjects");
            Subjects.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Subjects.setBounds(350, 390, 150, 27);
            add(Subjects);
            
            JRadioButton oops = new JRadioButton("oops");
            oops.setBounds(450,390,80,27);
            JRadioButton os = new JRadioButton("os");
            os.setBounds(540,390,80,27);
			
			JRadioButton AI = new JRadioButton("AI");
            AI.setBounds(630,390,80,27);
			JRadioButton MEFA = new JRadioButton("MEFA");
            MEFA.setBounds(720,390,80,27);
            
            //ButtonGroup bg1 = new ButtonGroup();
            
           
            add(oops);
            add(os);
            add(AI);
			add(MEFA);
			
            
          
  
            JButton save = new JButton("Save");
            save.setBounds(350,440,80,27);
            save.setFont(new Font("Tohoma",Font.PLAIN,17));
            add(save);
            
            JButton cancel = new JButton("Cancel");
            cancel.setBounds(450,440,100,27);
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
    				String collegeName = collegeNametf.getText();
    				String Id = Idtf.getText();
    				String collegeAddress = addresstf.getText();
    				
    				String subjects = "";
    				
    				if(oops.isSelected()) {
    					subjects += "OPPs ";
    				} if(os.isSelected()) {
    					subjects += "Operating Systems ";
    				} if(AI.isSelected()) {
    					subjects += "Artificial Intelligence ";
    				} if(MEFA.isSelected()) {
    					subjects += "MEFA ";
    				}
    				
    				
    				
    				String gender = null;
    				if(male.isSelected()) {
    					gender = "male";
    				} else if(female.isSelected()) {
    					gender = "female";
    				}
    				
    				if (name.isEmpty() || email.isEmpty() || collegeName.isEmpty() || Id.isEmpty() || collegeAddress.isEmpty() || gender == "") {
    		            JOptionPane.showMessageDialog(null, "Please fill in all required fields!");
    		            
    		        } 
    				
    		        else {
                      try {
                    	  Conn c = new Conn();
                    	  
                    	  String insertQuery = "INSERT INTO Students (name, email, gender, Id, collegeName, CollegeAddress, Subjects) VALUES ('" + name + "', '" + email + "', '" + gender + "','" + Id + "', '" + collegeName + "', '" + collegeAddress + "', '" + subjects + "')";

	                       
	                       c.stmt.executeUpdate(insertQuery);
	                       JOptionPane.showMessageDialog(null,"Your are successfully Registered For The Exam!!");
	                       setVisible(false);
                           
                      } catch (Exception ee) {
                          ee.printStackTrace();
                      }
                  }
    				
    			}
    		});
           
            
            setSize(1000,650);
            setVisible(true);
            setLocation(200,50);
			
	}
        
    public static void main(String[] args)
    {
        new ExamRegistration();
    }   
}

