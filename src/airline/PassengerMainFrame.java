package airline;



import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class PassengerMainFrame extends JFrame{
	
	PassengerInfo p;
    public static void main(String[] args) {
        new PassengerMainFrame(null).setVisible(true);
    }
    
    public PassengerMainFrame(PassengerInfo p) {
    	super("AIRLINE RESERVATION MANAGEMENT SYSTEM");
    	this.p = p;
        initialize(p);
    }

    
    private void initialize(PassengerInfo p) {
	
	    setForeground(Color.CYAN);
	    setLayout(null); 
	    Font f2 = new Font("TimesRoman", Font.BOLD, 15);
	
//	    JLabel NewLabel = new JLabel("");
//		NewLabel.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/logo.jpg")));
//		NewLabel.setBounds(0, 0, 1920, 990); 
//		add(NewLabel); 
		
	    JLabel AirlineManagementSystem = new JLabel("Welcome To Hyderabad Airline, Your home in the sky");
		AirlineManagementSystem.setForeground(Color.BLUE);
	    AirlineManagementSystem.setFont(new Font("Tahoma", Font.PLAIN, 36));
	    AirlineManagementSystem.setHorizontalAlignment(JLabel.CENTER);
		AirlineManagementSystem.setBounds(150, 0, 1000, 55);
		add(AirlineManagementSystem);
		
		String name = p.getName() +", Please Choose Your Action To Do...!!!";
		
		JLabel AdminInstruction = new JLabel(name);
		AdminInstruction.setForeground(Color.BLUE);
		AdminInstruction.setFont(new Font("Tahoma", Font.PLAIN, 36));
		AdminInstruction.setHorizontalAlignment(JLabel.CENTER);
		AdminInstruction.setBounds(150, 100, 1000, 55);
		add(AdminInstruction);
			
			
		JButton b1 = new JButton("Passenger Details");
		b1.setFont(f2);
		
		JButton b2 = new JButton("Flight Routes");
		b2.setFont(f2);
		
		JButton b3 = new JButton("Book Ticket");
		b3.setFont(f2);
		
		JButton b4 = new JButton("Reservation Details");
		b4.setFont(f2);
		
		JButton b5 = new JButton("Payment History");
		b5.setFont(f2);
		
		JButton b6 = new JButton("Cancel Ticket");
		b6.setFont(f2);
		
		JButton b7 = new JButton("Cancellation History");
		b7.setFont(f2);
		
		JButton b8 = new JButton("Back To Login Page");
		b8.setFont(f2);
		
		
		b1.setBounds(430, 250, 200, 40);
		b2.setBounds(680, 250, 200, 40);
		b3.setBounds(430, 350, 200, 40);
		b4.setBounds(680, 350, 200, 40);
		b5.setBounds(430, 450, 200, 40);
		b6.setBounds(680, 450, 200, 40);
		b7.setBounds(430, 550, 200, 40);
		b8.setBounds(680, 550, 200, 40);

		
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		add(b6);
		add(b7);
		add(b8);
		
	
	        
			
		b1.addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent ae){
	                new PassengerDetail(p);
	            }
		});
		
		b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new FlightRoutes(p, "FLIGHT INFORMATION");
            }
		});
		
		b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
            	new FlightRoutes(p, "FIND FLIGHT AND BOOK FLIGHT");
            }
		});
		
		b4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new ReservationInfo(p.getUsername());
            }
		});
		
		b5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new PaymentInfo(p.getUsername());
            }
		});
		
		b6.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new CancelTicket(p.getUsername());
            }
		});
		
		b7.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new CancellationInfo(p.getUsername());
            }
		});
		
		b8.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new LoginType();
                dispose();
            }
		});
		
		

	    setSize(1950,1090);
		setVisible(true);
    }
}
