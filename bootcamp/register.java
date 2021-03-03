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

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			
		try { 
			Connection con = connection.initializeDatabase();
			String emailid=request.getParameter("v");
			String name="Bhavik";
			 PreparedStatement st = con.prepareStatement("insert into dashboard values(?,?,?,?,?,?,?,?,?)"); 
			 st.setString(1,emailid);
			 st.setString(2,name);
			 st.setString(3,request.getParameter("eventname"));	
			 st.setString(4,request.getParameter("place"));	
			 st.setString(5,request.getParameter("discription"));	
			 st.setString(6,request.getParameter("date1"));	
			 st.setString(7,request.getParameter("time1"));	
			 st.setString(8,request.getParameter("date2"));	
			 st.setString(9,request.getParameter("time2"));	
			//out.print(st);
			 int i = st.executeUpdate();
			 
	            if(i > 0) {
	                //out.println("You are successfully registered");
	                RequestDispatcher rs = request.getRequestDispatcher("dashboard.html");
	                rs.forward(request, response);
	            }
			// st.executeUpdate();
			 //st.close();
			 //con.close();
			
			 
			 
     } 
     catch (Exception e) { 
         e.printStackTrace(); 
       
        
     } 
	}

}