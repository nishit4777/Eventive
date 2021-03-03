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
 * Servlet implementation class approveeventcreated
 */
@WebServlet("/approveeventcreated")
public class approveeventcreated extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		//out.println("<html><body>");
		try {
			//String name=request.getParameter("username");
			Connection con = connection.initializeDatabase();
			  
			PreparedStatement st = con.prepareStatement("UPDATE approveevents SET status=? WHERE eventname=?");

			st.setString(1,"accepted");
			st.setString(2,request.getParameter("ename"));
			//out.print(st);
			int i = st.executeUpdate();

			   if(i > 0) {
			       //out.println("You are successfully registered");
			      RequestDispatcher r = request.getRequestDispatcher("adminhome.html");
			       r.forward(request, response);
			   }
		}
		
		catch(Exception e) {
            out.print("error");
            }
	}

}
