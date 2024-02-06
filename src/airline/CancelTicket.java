package airline;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class CancelTicket extends JFrame { 
    
    private JTextField textField_1,textField_2;

    public static void main(String[] args) {
        new CancelTicket(null);
    }
    
    public CancelTicket(String username) {
        initialize(username);
    }
    
    private void initialize(String name) {
        setTitle("Cancel Booking");
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 801, 472);
		setLayout(null);
		
		JLabel Cancellation = new JLabel("Reservation Control Panel");
		Cancellation.setForeground(Color.BLUE);
		Cancellation.setFont(new Font("Tahoma", Font.PLAIN, 31));
		Cancellation.setBounds(50, 24, 350, 38);
		add(Cancellation);
		
	
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/cancel.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel NewLabel = new JLabel(i3);
		NewLabel.setBounds(470, 80, 250, 250);
		add(NewLabel);
		
		JLabel username = new JLabel("Username");
		username.setFont(new Font("Tahoma", Font.PLAIN, 20));
		username.setBounds(60, 150, 132, 26);
		add(username);
		
		JLabel flight = new JLabel("Flight Code");
		flight.setFont(new Font("Tahoma", Font.PLAIN, 20));
		flight.setBounds(60, 200, 150, 27);
		add(flight);
		
		JLabel label = new JLabel("View details of your canceled reservation.");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(30, 380, 280, 30);
		add(label );
		
		JButton CancelData = new JButton("Canceled Tickets");
		CancelData.setFont(new Font("Tahoma", Font.PLAIN, 14));
        CancelData.setBackground(Color.BLACK);
        CancelData.setForeground(Color.WHITE);
		CancelData.setBounds(320, 380, 150, 30);
		add(CancelData);
		
		JButton Proceed = new JButton("Proceed");
		Proceed.setFont(new Font("Tahoma", Font.PLAIN, 14));
        Proceed.setBackground(Color.CYAN);
        Proceed.setForeground(Color.BLACK);
		Proceed.setBounds(250, 290, 150, 30);
		add(Proceed);
		
		JButton Cancel = new JButton("Cancel");
		Cancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        Cancel.setBackground(Color.CYAN);
        Cancel.setForeground(Color.BLACK);
		Cancel.setBounds(60, 290, 150, 30);
		add(Cancel);
		
		
        textField_1 = new JTextField();
		textField_1.setBounds(250, 150, 150, 27);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(250, 200, 150, 27);
		add(textField_2);
	
        Proceed.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
		
				String username = textField_1.getText();
				String flight_code = textField_2.getText();
				
				
				if (username.isEmpty() || flight_code.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill in all required fields!");
  				} else {
					int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel this ticket?", "Confirmation", JOptionPane.YES_NO_OPTION);
	
					if(dialogResult == JOptionPane.YES_OPTION) {
	  					try {
	  					    // Step 1: Select reservation details
	  						Conn c = new Conn();
	  						
	  					    String reserve = "SELECT * FROM Reservation WHERE username = ? AND flight_code = ?";
	  					    PreparedStatement pstmt = c.conn.prepareStatement(reserve);
	  					    pstmt.setString(1, username);
	  					    pstmt.setString(2, flight_code);
	  					    ResultSet reservationResultSet = pstmt.executeQuery();
	
	  					    // Step 2: Insert into Cancellation table
	  					    
	  					    if (reservationResultSet.next()) {
	  					        String source = reservationResultSet.getString("source");
	  					        String destination = reservationResultSet.getString("destination");
	  					        String time = reservationResultSet.getString("time");
	  					        Date date = reservationResultSet.getDate("date");
	  					        double amount = reservationResultSet.getDouble("amount");
	
	  					        String insertCancellationQuery = "INSERT INTO Cancellation (username, flight_code, source, destination, time, date, amount) VALUES (?, ?, ?, ?, ?, ?, ?)";
	  					        PreparedStatement insertCancellationStmt = c.conn.prepareStatement(insertCancellationQuery);
	  					        insertCancellationStmt.setString(1, username);
	  					        insertCancellationStmt.setString(2, flight_code);
	  					        insertCancellationStmt.setString(3, source);
	  					        insertCancellationStmt.setString(4, destination);
	  					        insertCancellationStmt.setString(5, time);
	  					        insertCancellationStmt.setDate(6, date);
	  					        insertCancellationStmt.setDouble(7, amount);
	
	  					        int rowsInserted = insertCancellationStmt.executeUpdate();
	
	  					        // Step 3: Delete from Reservation table
	  					        if (rowsInserted > 0) {
	  					            String deleteReservationQuery = "DELETE FROM Reservation WHERE username = ? AND flight_code = ?";
	  					            PreparedStatement deleteReservationStmt = c.conn.prepareStatement(deleteReservationQuery);
	  					            deleteReservationStmt.setString(1, username);
	  					            deleteReservationStmt.setString(2, flight_code);
	
	  					            int rowsDeleted = deleteReservationStmt.executeUpdate();
	
	  					            if (rowsDeleted > 0) {
	  					            	JOptionPane.showMessageDialog(
  					            		    null,
  					            		    "Your ticket has been cancelled successfully!\nWe hope to see you again in the future.",
  					            		    "Ticket Cancelled",
  					            		    JOptionPane.INFORMATION_MESSAGE
  					            		);

	  					            } else {
	  					            	JOptionPane.showMessageDialog(
  					            		    null,
  					            		    "We couldn't find any reservation for the given details.\nPlease ensure your username and flight code are correct.",
  					            		    "Cancellation Unsuccessful",
  					            		    JOptionPane.INFORMATION_MESSAGE
  					            		);

	  					            }
	  					        }
	  					    } else {
	  					    	JOptionPane.showMessageDialog(null, "No reservation found for the given username and flight code.", "Reservation Not Found", JOptionPane.INFORMATION_MESSAGE);
	  					    }
	  					    
	  					} catch (SQLException e) {
	  					    e.printStackTrace();
	  					}
	  				}
  				}

            }
        });
        
        Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
        
        CancelData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CancellationInfo(name);
			}
		});
			
		setSize(860,500);
		setVisible(true);
        setLocation(200,130);
    }
}
