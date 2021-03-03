package bootcamp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import bootcamp.connection;
public class Validateadmin {
	 public static boolean checkUser(String email,String pass) 
	    {
	        boolean st =false;
	        try {

	        	Connection con = connection.initializeDatabase(); 
	            PreparedStatement ps = con.prepareStatement("select * from adminlogin where email=? and password=?");
	            ps.setString(1, email);
	            ps.setString(2, pass);
	            ResultSet rs =ps.executeQuery();
	            st = rs.next();

	        }
	        catch(Exception e) {
	            e.printStackTrace();
	        }
	        return st;                 
	    }   

}
