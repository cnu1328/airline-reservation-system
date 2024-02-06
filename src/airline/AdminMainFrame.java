package airline;



import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class AdminMainFrame extends JFrame{

    public static void main(String[] args) {
        new AdminMainFrame().setVisible(true);
    }
    
    public AdminMainFrame() {
        super("AIRLINE RESERVATION MANAGEMENT SYSTEM");
        initialize();
    }

    
    private void initialize() {
	
	    setForeground(Color.CYAN);
	    setLayout(null); 
	    Font f2 = new Font("TimesRoman", Font.BOLD, 15);
	
//	    JLabel NewLabel = new JLabel("");
//		NewLabel.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/logo.jpg")));
//		NewLabel.setBounds(0, 0, 1920, 990); 
//		add(NewLabel); 
//	        
	    JLabel AirlineManagementSystem = new JLabel("Welcome To Hyderabad Airline, Your home in the sky");
		AirlineManagementSystem.setForeground(Color.BLUE);
	    AirlineManagementSystem.setFont(new Font("Tahoma", Font.PLAIN, 36));
	    AirlineManagementSystem.setHorizontalAlignment(JLabel.CENTER);
		AirlineManagementSystem.setBounds(150, 0, 1000, 55);
		add(AirlineManagementSystem);
		
		JLabel AdminInstruction = new JLabel("Admin, Please Choose Your Action To Do...!!!");
		AdminInstruction.setForeground(Color.BLUE);
		AdminInstruction.setFont(new Font("Tahoma", Font.PLAIN, 36));
		AdminInstruction.setHorizontalAlignment(JLabel.CENTER);
		AdminInstruction.setBounds(150, 100, 1000, 55);
		add(AdminInstruction);
			
			
		JButton b1 = new JButton("Add Flight");
		b1.setFont(f2);
		
		JButton b2 = new JButton("Customer Info");
		b2.setFont(f2);
		
		JButton b3 = new JButton("Flight Info");
		b3.setFont(f2);
		
		JButton b4 = new JButton("Delete Passenger");
		b4.setFont(f2);
		
		JButton b5 = new JButton("Back To Login Page");
		b5.setFont(f2);
		
		JButton b6 = new JButton("About");
		b6.setFont(f2);
		
		
		
		b1.setBounds(430, 250, 200, 40);
		b2.setBounds(680, 250, 200, 40);
		b3.setBounds(430, 350, 200, 40);
		b4.setBounds(680, 350, 200, 40);
		b5.setBounds(430, 450, 200, 40);
		b6.setBounds(680, 450, 200, 40);
		
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		add(b6);
		
		
	
	        
			
		b1.addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent ae){
	                new AddFlight();
	            }
		});
		
		b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new  CustomerInfo();
            }
		});
		
		b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new FlightInfo();
            }
		});
		
		b4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new DeletePassenger();
            }
		});
		
		b5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new LoginType();
                dispose();
            }
		});
		
		b6.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new About();
                
            }
		});
		
		
		
			
	    setSize(1950,1090);
		setVisible(true);
    }
}
