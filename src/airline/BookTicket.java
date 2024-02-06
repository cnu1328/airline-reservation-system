package airline;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class BookTicket extends JFrame {
	
	JTextField tf, tf1, tf2, tf3, tf4, tf5, tf6, tf7;
	
	private String flight_amount;
	private String Date;
	private String Time;
	
	BookTicket(String src, String dst, String cls, String flight, PassengerInfo p) {
		getContentPane().setForeground(Color.BLUE);
        getContentPane().setBackground(Color.WHITE);
        
        setTitle("Book Ticket");
        
        JLabel Payment = new JLabel("PAYMENT PROCESS");
        Payment.setForeground(Color.BLUE);
        Payment.setFont(new Font("Tahoma", Font.PLAIN, 31));
        Payment.setBounds(450, 24, 442, 35);
        add(Payment);
        
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/payment.png"));
      JLabel image = new JLabel(i1);
      image.setBounds(450,80,280,410);
      add(image);
        
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(778,500);
        getContentPane().setLayout(null);
        
        JLabel Username = new JLabel("UserName	:");
        Username.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Username.setBounds(60, 80, 150, 27);
        add(Username);
        
        JLabel tf = new JLabel(p.getUsername());
        tf.setFont(new Font("Tahoma", Font.BOLD, 17));
        tf.setBounds(230, 80, 150, 27);
        add(tf);
        
        JLabel Flightcode = new JLabel("FLIGHT CODE		:");
        Flightcode.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Flightcode.setBounds(60, 120, 150, 27);
        add(Flightcode);
        
        
        JLabel tf1 = new JLabel(flight);
        tf1.setBounds(230, 120, 150, 27);
        tf1.setFont(new Font("Tahoma", Font.BOLD, 17));
        add(tf1);
        
        JLabel Source = new JLabel("Source	:");
        Source.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Source.setBounds(60, 170, 150, 27);
        add(Source);
        
        
        JLabel tf2 = new JLabel(src);
        tf2.setBounds(230, 170, 150, 27);
        tf2.setFont(new Font("Tahoma", Font.BOLD, 17));
        add(tf2);
        
        
        
        JLabel Destination = new JLabel("Destination	:");
        Destination.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Destination.setBounds(60, 220, 150, 27);
        add(Destination);
        
        JLabel tf3 = new JLabel(dst);
        tf3.setBounds(230, 220, 150, 27);
        tf3.setFont(new Font("Tahoma", Font.BOLD, 17));
        add(tf3);
        
        LocalDate today = LocalDate.now();
        
        LocalDate futureDate = today.plus(5, ChronoUnit.DAYS);
        
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Date = futureDate.format(dateFormatter);
        
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
        Time = LocalDateTime.now().format(timeFormatter);

      
        
        JLabel time = new JLabel("Journey Time		:");
        time.setFont(new Font("Tahoma", Font.PLAIN, 17));
        time.setBounds(60, 270, 150, 27);
        add(time);
        
        
        JLabel tf4 = new JLabel(Time);
        tf4.setBounds(230, 270, 150, 27);
        tf4.setFont(new Font("Tahoma", Font.BOLD, 17));
        add(tf4);
        
        JLabel date = new JLabel("Journey Date	:");
        date.setFont(new Font("Tahoma", Font.PLAIN, 17));
        date.setBounds(60, 320, 150, 27);
        add(date);
        
        JLabel tf5 = new JLabel(Date);
        tf5.setBounds(230, 320, 150, 27);
        tf5.setFont(new Font("Tahoma", Font.BOLD, 17));
        add(tf5);
        
        
        JLabel amount = new JLabel("Amount	:");
        amount.setFont(new Font("Tahoma", Font.PLAIN, 17));
        amount.setBounds(60, 370, 150, 27);
        add(amount);
        
        try {
    		Conn c = new Conn();
    		String str = "SELECT amount FROM Flight WHERE flight_code = ? AND source = ? AND destination = ? AND class_code = ?";
    	    PreparedStatement pstmt = c.conn.prepareStatement(str);
    	    
    	    pstmt.setString(1, flight);
    	    pstmt.setString(2, src);
    	    pstmt.setString(3, dst);
    	    pstmt.setString(4, cls);
    	    ResultSet rs = pstmt.executeQuery();

    	   
    	    if (rs.next()) {
    	        flight_amount = rs.getString("amount");
    	    }


    	} catch (Exception e) {
    	    e.printStackTrace();
    	}
       
        
        JLabel tf6 = new JLabel(flight_amount);
        tf6.setBounds(230, 370, 150, 27);
        tf6.setFont(new Font("Tahoma", Font.BOLD, 17));
        add(tf6);
        
        JLabel Camount = new JLabel("Conform Amount	:");
        Camount.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Camount.setBounds(60, 420, 150, 27);
        add(Camount);
        
        JTextField tf7 = new JTextField();
        tf7.setBounds(230, 420, 150, 27);
        tf7.setFont(new Font("Tahoma", Font.BOLD, 17));
        add(tf7);
        
        JButton b1_2 = new JButton("Cancel");
		b1_2.setBounds(80, 480, 150, 30);
		add(b1_2);
		
		JButton pay = new JButton("Book");
		pay.setBounds(250, 480, 150, 30);
		add(pay);
		
		pay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String conform = tf7.getText();
				
				if(conform.isEmpty() || !flight_amount.equals(conform)) {
					JOptionPane.showMessageDialog(null, "Please Conform the amount Correctly!");
				} else {
					
					int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to book the ticket?", "Confirmation", JOptionPane.YES_NO_OPTION);
		            
					if (option == JOptionPane.YES_OPTION) {
						
						try {
				    		Conn c = new Conn();
				    		
				    	    // Insert into Reservation table
				    	    String reserve = "INSERT INTO Reservation (username, flight_code, source, destination, time, date, amount) VALUES (?, ?, ?, ?, ?, ?, ?)";
				    	    PreparedStatement pstmt = c.conn.prepareStatement(reserve);
				    	    pstmt.setString(1, p.getUsername());
				    	    pstmt.setString(2, flight);
				    	    pstmt.setString(3, src);
				    	    pstmt.setString(4, dst);
				    	    pstmt.setString(5, Time);
				    	    pstmt.setString(6, Date); 
				    	    pstmt.setString(7, flight_amount);

				    	    // Insert into Payment table
				    	    String insertPaymentQuery = "INSERT INTO Payment (username, flight_code, pay_date, source, destination, time, date, amount) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
				    	    PreparedStatement pstmt1 = c.conn.prepareStatement(insertPaymentQuery);
				    	    pstmt1.setString(1, p.getUsername());
				    	    pstmt1.setString(2, flight);
				    	    pstmt1.setDate(3, java.sql.Date.valueOf(LocalDate.now()));
				    	    pstmt1.setString(4, src);
				    	    pstmt1.setString(5, dst);
				    	    pstmt1.setString(6, Time);
				    	    pstmt1.setString(7, Date);
				    	    pstmt1.setString(8, flight_amount);

				    	    // Execute both insert statements
				    	    int reservationInserted = pstmt.executeUpdate();
				    	    int paymentInserted = pstmt1.executeUpdate();

				    	    // Check for successful insertion
//				    	    if (reservationInserted > 0 && paymentInserted > 0) {
//				    	        System.out.println("Data inserted into Reservation and Payment tables successfully.");
//				    	        // Add further logic if needed
//				    	    } else {
//				    	        System.out.println("Insertion failed. Please check your data and try again.");
//				    	    }



				    	} catch (Exception ee) {
				    	    ee.printStackTrace();
				    	}
						
		                
		                JOptionPane.showMessageDialog(null, "Ticket booked successfully!");
		                dispose();
		            } else {
		                
		                JOptionPane.showMessageDialog(null, "Ticket booking canceled.");
		                dispose();
		            }
				}
				
				
			}
		});
		
		
		 b1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
        
        
        setSize(900,600);
        setVisible(true);
        setLocation(200,60);
        
        
	}

	public static void main(String[] args) {
		new BookTicket("Hyd","Del", "Econ","", null);
	}

}




//class TicketBookingFrame extends JFrame {
//    private JTextField cardNumberField;
//    private JTextField cvvField;
//
//    public TicketBookingFrame() {
//    	
//        setTitle("Ticket Booking");
//        setSize(400, 400);
//        setLocation(400, 200);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        JLabel cardLabel = new JLabel("Credit Card Number:");
//        cardLabel.setBounds(50, 50, 300, 40);
//        add(cardLabel);
//        
//        JLabel cvvLabel = new JLabel("CVV:");
//        cvvLabel.setBounds(50, 100, 300, 40);
//        add(cvvLabel);
//
//        cardNumberField = new JTextField(15);
//        cardNumberField.setBounds(100, 50,0, 0);
//        add(cardNumberField);
//        
//        cvvField = new JTextField(4);
//        add(cvvField);
//        
//
//        JButton bookButton = new JButton("Book Ticket");
//
//        bookButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                String cardNumber = cardNumberField.getText();
//                String cvv = cvvField.getText();
//
//                if (cardNumber.isEmpty() || cvv.isEmpty()) {
//                    JOptionPane.showMessageDialog(null, "Please fill in all fields.");
//                } else {
//                    
//                    JOptionPane.showMessageDialog(null, "Ticket booked successfully!");
//                }
//            }
//        });
//        
//        
//
//        
//        setVisible(true);
//    }
//
//    
//}

