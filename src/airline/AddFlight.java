package airline;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


public class AddFlight extends JFrame {
	
	JTextField tf, tf1, tf2;
	JLabel Source, Destination, Class;
    Font f2;
	
	public AddFlight() {
		
		f2 = new Font("Tahoma", Font.PLAIN, 17);
		
		getContentPane().setForeground(Color.BLUE);
        getContentPane().setBackground(Color.WHITE);
        
        setTitle("ADD FLIGHT DETAILS");
        
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(778,486);
        getContentPane().setLayout(null);
        
        JLabel flight_code = new JLabel("Flight Code");
        flight_code.setFont(new Font("Tahoma", Font.PLAIN, 17));
        flight_code.setBounds(80, 100, 150, 27);
        add(flight_code);
        
        tf = new JTextField();
        tf.setBounds(250, 100, 150, 27);
        add(tf);
        
        JButton Next = new JButton("Add Flight");
        Next.setBounds(250, 450, 150, 30);
        Next.setBackground(Color.BLACK);
        Next.setForeground(Color.WHITE);
        add(Next);
        
        JButton b1_2 = new JButton("Cancel");
		b1_2.setBounds(80, 450, 150, 30);
		add(b1_2);
        
        JLabel flight_name = new JLabel("Flight Name");
        flight_name.setFont(new Font("Tahoma", Font.PLAIN, 17));
        flight_name.setBounds(80, 150, 150, 27);
        add(flight_name);
        
      
        tf1 = new JTextField();
        tf1.setBounds(250, 150, 150, 27);
        add(tf1);
        
        Source = new JLabel("Source");
        Source.setFont(f2);
		Source.setBounds(80, 200, 150, 27);
		add(Source);
		
		String[] items1 = {"Select City", "Ahmedabad", "Bangalore", "Chennai", "Delhi", "Hyderabad", "Indore", "Jaipur", "Kolkata", "Lucknow", "Maharashtra", "Mumbai", "Pune"};
		JComboBox comboBox = new JComboBox(items1);
		comboBox.setBounds(250, 200, 150, 27);
		add(comboBox);
			
		Destination = new JLabel("Destination");
		Destination.setFont(f2);
		Destination.setBounds(80, 250, 150, 27);
		add(Destination);
		
		String[] items2 = {"Select City", "Ahmedabad", "Bangalore", "Chennai", "Delhi", "Hyderabad", "Indore", "Jaipur", "Kolkata", "Lucknow", "Maharashtra", "Mumbai", "Pune"};
		JComboBox comboBox_1 = new JComboBox(items2);
		comboBox_1.setBounds(250, 250, 150, 27);
		add(comboBox_1);
		
		Class =  new JLabel("Class");
		Class.setFont(f2);
		Class.setBounds(80, 300,150, 27);
		add(Class);
        
		
		String[] items3 = {"Business", "Economy", "Premium"};
		JComboBox comboBox_2 = new JComboBox(items3);
		comboBox_2.setBounds(250, 300, 150, 27);
		add(comboBox_2);
		
        
        
        JLabel destination = new JLabel("Cost of Service");
        destination.setFont(new Font("Tahoma", Font.PLAIN, 17));
        destination.setBounds(80, 350, 150, 27);
        add(destination);
        
        tf2 = new JTextField();
        tf2.setBounds(250, 350, 150, 27);
        add(tf2);
        
        JLabel AddPassengers = new JLabel("ADD FLIGHT DETAILS");
        AddPassengers.setForeground(Color.BLUE);
        AddPassengers.setFont(new Font("Tahoma", Font.PLAIN, 31));
        AddPassengers.setBounds(450, 20, 442, 35);
        add(AddPassengers);
        
        
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/flight.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(450,80,280,410);
        add(image);
        
        
        Next.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                String flight_code = tf.getText();
                String flight_name = tf1.getText();
                String source  = (String) comboBox.getSelectedItem();
                String destination  = (String) comboBox_1.getSelectedItem();
                String Class = (String) comboBox_2.getSelectedItem();
                String amount = tf2.getText();
    
                
                if (source.isEmpty() || destination.isEmpty() || source.equals(destination) || Class.isEmpty() || amount.isEmpty()|| flight_code.isEmpty() | flight_name.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please, check all fields and Submit!");
                } else {
                    try {
                    	 Conn c = new Conn();
                         String str = "INSERT INTO flight values( '"+flight_code+"', '"+flight_name+"', '"+source+"','"+destination+"', '" + Class + "', '"+ amount + "')";
                         
                         c.stmt.executeUpdate(str);
                         JOptionPane.showMessageDialog(null,"Flight Added");
                         
                         tf.setText(null); 
                         tf1.setText(null);
                         tf2.setText(null);
                         comboBox.setSelectedIndex(0);
                         comboBox_1.setSelectedIndex(0);
                         comboBox_2.setSelectedIndex(0);
                         
                    } catch (Exception e) {
                        e.printStackTrace();
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
        setLocation(200,100);
        
               
 
	}
	
	public static void main(String[] args) {
		new AddFlight();
	}

}

