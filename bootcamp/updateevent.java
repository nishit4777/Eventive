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
import bootcamp.connection;

/**
 * Servlet implementation class deleteevent
 */
@WebServlet("/updateevent")
public class updateevent extends HttpServlet {


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		//out.println("<html><body>");
		try {
			//String name=request.getParameter("username");
			Connection con = connection.initializeDatabase();
			  
			PreparedStatement st = con.prepareStatement("UPDATE addevent SET place=?,description=?,date1=?,time1=?,date2=?,time2=? WHERE eventname=?");

			st.setString(1,request.getParameter("place"));
			st.setString(2,request.getParameter("description"));
			st.setString(3,request.getParameter("date1"));
			st.setString(4,request.getParameter("time1"));
			st.setString(5,request.getParameter("date2"));
			st.setString(6,request.getParameter("time2"));
			st.setString(7,request.getParameter("eventname"));
			//out.print(st);
			int i = st.executeUpdate();

			   if(i > 0) {
			       //out.println("You are successfully registered");
			      RequestDispatcher r = request.getRequestDispatcher("updateevent.jsp");
			       r.forward(request, response);
			   }
		}
		
		catch(Exception e) {
            out.print("error");
            }
	}

}
