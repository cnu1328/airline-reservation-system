package airline;

import java.awt.EventQueue;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class About extends JFrame { 

        public About() {
        	
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/airline.png"));
            JLabel image = new JLabel(i1);
            image.setBounds(0,0,0,0);
            add(image);

			
            setSize(1000,650);
            setVisible(true);
            setLocation(200,50);
			
	}
        
    public static void main(String[] args)
    {
        new About();
    }   
}

