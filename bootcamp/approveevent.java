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
 * Servlet implementation class approveevent
 */
@WebServlet("/approveevent")
public class approveevent extends HttpServlet {
	
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		//String stat="accepted";
		//out.println("<html><body>");
		try {
			//String name=request.getParameter("username");
			Connection con = connection.initializeDatabase();
			  
			 PreparedStatement st = con.prepareStatement("UPDATE approveevents SET status='accepted' WHERE eventname=?"); 
			 //st.setString(1,stat);
			 st.setString(1,request.getParameter("ename"));
			 
			//out.print(st);
			 int i = st.executeUpdate();
			 
	            if(i > 0) {
	                //out.println("You are successfully registered");
	                RequestDispatcher rs = request.getRequestDispatcher("approve.jsp");
	                rs.forward(request, response);
	            }
		}
		
		catch(Exception e) {
            out.print("error");
            }
	}

}
