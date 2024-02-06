package airline;



import net.proteanit.sql.DbUtils;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

import net.proteanit.sql.DbUtils;

public class FlightInfo extends JFrame{  //Second Frame

    private JTable table;
//    private JTextField textField;
    
    public static void main(String[] args){		 
    	new FlightInfo().setVisible(true);    
    }
    
    public FlightInfo(){
        
	    getContentPane().setBackground(Color.WHITE);
	    getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 13));
			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(860,523);
		setLayout(null);
		setVisible(true);
			
			
		JLabel FlightDetails = new JLabel("Flights");
		FlightDetails.setFont(new Font("Tahoma", Font.PLAIN, 31));
		FlightDetails.setForeground(new Color(100, 149, 237));
		FlightDetails.setBounds(40, 40, 570, 35);
		add(FlightDetails);
			
		
		table = new JTable();
	    table.setBackground(Color.WHITE);
		table.setBounds(40, 100, 800, 450);
	        
		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(40, 100, 800, 450);
	    pane.setBackground(Color.WHITE);
	    add(pane);
	    
	    try {
            Conn c = new Conn();
            String str = "select * from flight";

            ResultSet rs = c.stmt.executeQuery(str);
            table.setModel(DbUtils.resultSetToTableModel(rs));	
            
        }catch(SQLException e){
            e.printStackTrace();
        }
	    
	    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setSize(900,650);
	    setVisible(true);
	    setLocation(200,50);
		
    }
}