package bootcamp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bootcamp.connection;

/**
 * Servlet implementation class adminlogin
 */
@WebServlet("/adminlogin")
public class adminlogin extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	try { 
		
		 Connection con = connection.initializeDatabase(); 
		 String email = request.getParameter("email");
	        String pass = request.getParameter("psw");
	        
	        if(Validateadmin.checkUser(email, pass))
	        {
	            RequestDispatcher rs = request.getRequestDispatcher("adminhome.html");
	            rs.forward(request, response);
	        }
	        else
	        {
	          out.println("Username or Password incorrect");
	           //RequestDispatcher rs = request.getRequestDispatcher("signup.html");
	          // rs.include(request, response);
	        }
		
		 
		 
    } 
    catch (Exception e) { 
        e.printStackTrace(); 
      
       
    } 
		
	}
	

}
