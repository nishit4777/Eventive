package bootcamp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class participate
 */
@WebServlet("/participate")
public class participate extends HttpServlet {
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		//out.println("<html><body>");
		
		try {
			//String name=request.getParameter("username");
			Connection con = connection.initializeDatabase();
			  
			 PreparedStatement st = con.prepareStatement("SELECT * FROM addevent where eventname=?"); 
			 st.setString(1,request.getParameter("ename"));
			 
			//out.print(st);
			 ResultSet i = st.executeQuery();
			 
	            while(i.next()) {
	                //out.println("You are successfully registered");
	                RequestDispatcher rs = request.getRequestDispatcher("participate.jsp");
	                rs.forward(request, response);
	            }
		}
		
		catch(Exception e) {
            out.print("error");
            }
	}

}