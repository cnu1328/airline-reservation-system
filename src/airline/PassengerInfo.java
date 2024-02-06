package airline;

import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class PassengerInfo {
	
    private String username;
    private String gmail;
    private String name;
    private String gender;
    private String nationality;
    private String passport;
    private String phonenumber;
    private String address;

    // Getters and setters for each field
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Getter and setter for 'nationality' field
    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    // Getters and setters for other fields similarly...
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPh_no(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPassport_no() {
        return passport;
    }

    public void setPassport_no(String passport_no) {
        this.passport = passport_no;
    }
    
    public void setGmail(String gmail) {
    	this.gmail = gmail;
    }
    
    public String getGmail() {
    	return gmail;
    }
 
    
    public static PassengerInfo getPassengerDataFromDB(String passengerNumber) {
        
         PassengerInfo passenger = new PassengerInfo();
         
         try {
        	 Conn c = new Conn();
             String str = "SELECT * FROM Passenger WHERE username = '" + passengerNumber + "';";
             
             ResultSet rs = c.stmt.executeQuery(str);// Execute SQL query to fetch passenger data using passengerNumber
    	     if (rs.next()) {
    	         passenger.setUsername(rs.getString("username"));
    	         passenger.setAddress(rs.getString("address"));
    	         passenger.setNationality(rs.getString("nationality"));
    	         passenger.setName(rs.getString("name"));
    	         passenger.setGender(rs.getString("gender"));
    	         passenger.setPh_no(rs.getString("phonenumber"));
    	         passenger.setPassport_no(rs.getString("passport"));
    	         passenger.setGmail(rs.getString("gmail"));
    	         
    	     }
             
             
        } catch (Exception e) {
            e.printStackTrace();
        }
         
        return passenger;
    }

    public static void main(String[] args) {
//        String passengerNumber = LoginType.obj.username; 
        // Get passenger data using the passenger number
//        PassengerInfo p = PassengerInfo.getPassengerDataFromDB(passengerNumber);
//
//        // Example of accessing passenger details
//        if (p != null) {
//        	System.out.println("Passenger Number: " + p.getPnr_no());
//        	System.out.println("Address: " + p.getAddress());
//        	System.out.println("Nationality: " + p.getNationality());
//        	System.out.println("Name: " + p.getName());
//        	System.out.println("Gender: " + p.getGender());
//        	System.out.println("Phone Number: " + p.getPh_no());
//        	System.out.println("Passport Number: " + p.getPassport_no());
//        	System.out.println("Flight Code: " + p.getFl_code());
//        }
    }
}
