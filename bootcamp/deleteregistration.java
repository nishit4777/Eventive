package bootcamp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jcraft.jsch.Session;

/**
 * Servlet implementation class deleteregistration
 */
@WebServlet("/deleteregistration")
public class deleteregistration extends HttpServlet {
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		//String temp=bootcamp.signin()
		//out.println("<html><body>");
		try {
			//String name=request.getParameter("username");
			Connection con = connection.initializeDatabase();
			  
			 PreparedStatement st = con.prepareStatement("DELETE FROM dashboard where eventname=? "); 
			 st.setString(1,request.getParameter("ename"));
			 //st.setString(2, request.getParameter("email") );
			 
			//out.print(st);
			 int i = st.executeUpdate();
			 
	            if(i > 0) {
	                //out.println("You are successfully registered");
	                RequestDispatcher rs = request.getRequestDispatcher("dashboard.jsp");
	                rs.forward(request, response);
	            }
		}
		
		catch(Exception e) {
            out.print("error");
            }
	}

}

