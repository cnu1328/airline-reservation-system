package airline;

import net.proteanit.sql.DbUtils;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class FlightRoutes extends JFrame{  //Second Frame

    private JTable table;
    private TextField textField;
    JLabel Book, Class, ReservationDetails, Pnrno, Ticketid, Fcode, Jnydate, Jnytime, Source, Destination, label, label1;
    JButton Show, pay;
    Font f2;
    String src, dst, cls;
    
    public static void main(String[] args){		 
    	new FlightRoutes(null, "").setVisible(true);    
    }
    
   
    
    public FlightRoutes(PassengerInfo p, String title){
    	
    	f2 = new Font("TimesRoman", Font.BOLD, 15);
        
	    getContentPane().setBackground(Color.WHITE);
	    getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 13));
			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(860,523);
		setLayout(null);
		setVisible(true);
		
			
		JLabel FlightDetails = new JLabel(title);
		FlightDetails.setFont(new Font("Tahoma", Font.PLAIN, 31));
		FlightDetails.setForeground(new Color(100, 149, 237));
		FlightDetails.setBounds(50, 20, 570, 35);
		add(FlightDetails);
			
		JButton btnShow = new JButton("SHOW");
		btnShow.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		Source = new JLabel("SOURCE");
		Source.setFont(f2);
		Source.setBounds(30, 100, 70, 30);
		add(Source);
			
		Destination = new JLabel("DESTINATION");
		Destination.setFont(f2);
		Destination.setBounds(280, 100, 110, 30);
		add(Destination);
		
		Class =  new JLabel("CLASS");
		Class.setFont(f2);
		Class.setBounds(580, 100, 50, 30);
		add(Class);
        
		String[] items1 = {"Hyderabad", "Delhi", "Mumbai","Maharashtra", "Bangalore", "Chennai", "Kolkata", "Pune", "Jaipur", "Ahmedabad", "Lucknow", "Indore"};
		JComboBox comboBox = new JComboBox(items1);
		comboBox.setBounds(100, 100, 150, 27);
		add(comboBox);
		
		
		String[] items2 = {"Hyderabad", "Delhi", "Mumbai","Maharashtra", "Bangalore", "Chennai", "Kolkata", "Pune", "Jaipur", "Ahmedabad", "Lucknow", "Indore"};
		JComboBox comboBox_1 = new JComboBox(items2);
		comboBox_1.setBounds(390, 100, 150, 27);
		add(comboBox_1);
		
		String[] items3 = {"Economy", "Business", "Premium"};
		JComboBox comboBox_2 = new JComboBox(items3);
		comboBox_2.setBounds(650, 100, 150, 27);
		add(comboBox_2);
		
		
		
		
		
	    btnShow.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent ae) {
	
	           
	            src  = (String) comboBox.getSelectedItem();
                dst  = (String) comboBox_1.getSelectedItem();
                cls = (String) comboBox_2.getSelectedItem();
	            
	            try {
	                Conn c = new Conn();
	                
	                String str = "SELECT * FROM Flight WHERE source = '" + src + "' AND destination = '" + dst + "' AND class_code = '" + cls + "'";
	                ResultSet rs = c.stmt.executeQuery(str);
	                if(!rs.isBeforeFirst()) {
                        JOptionPane.showMessageDialog(null,"No Flights between Source, Destination and Class"); 

	                } 
	                else {
	                	
	                	table.setModel(DbUtils.resultSetToTableModel(rs));
	                }
	         
	                
	            }catch(SQLException e){
	                e.printStackTrace();
	            }
	        }
	    });
	
	    
	    btnShow.setBounds(350, 150, 150, 30);
		add(btnShow);
		
		Book =  new JLabel("ENTER FLIGHT CODE");
		Book.setFont(f2);
		
		
		textField = new TextField();
		
		pay = new JButton("Book Ticket");
		pay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		Book.setBounds(150, 200, 180, 30);
		add(Book);
		
		pay.setBounds(550, 200, 150, 30);
		add(pay);
		
		textField.setBounds(350, 200, 150, 30);
		add(textField);
		
		
		pay.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent ae) {
	        	

	        	try {
	        		Conn c = new Conn();
	        		String str1 = "SELECT COUNT(*) AS count FROM flight WHERE flight_code = ?";
	        	    PreparedStatement pstmt = c.conn.prepareStatement(str1);
	        	    pstmt.setString(1, textField.getText());
	        	    ResultSet rs = pstmt.executeQuery();

	        	    rs.next();
	        	    int count = rs.getInt("count");

	        	    if (count > 0) {
	        	    	new BookTicket(src, dst, cls, textField.getText(), p);
	        	    	           	        	    	
	        	    } else {	            	        	     
	        	    	JOptionPane.showMessageDialog(null, "Please enter a valid flight code.");
	        	    }

	
	        	} catch (Exception e) {
	        	    e.printStackTrace();
	        	}

	        	
	        }
	        
		});
		
		
		table = new JTable();
 	    table.setBackground(Color.WHITE);
 		table.setBounds(23, 250, 800, 300);
 	        
 		JScrollPane pane = new JScrollPane(table);
 		pane.setBounds(23, 250, 800, 300);
 	    pane.setBackground(Color.WHITE);
 	    add(pane);
		
	    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setSize(900,650);
	    setVisible(true);
	    setLocation(200,50);
		
    }

	
}