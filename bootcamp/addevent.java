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
import bootcamp.connection;
/**
 * Servlet implementation class addevent
 */
@WebServlet("/addevent")
public class addevent extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
	try { 
		Connection con = connection.initializeDatabase();
		  
		 PreparedStatement st = con.prepareStatement("insert into addevent values(?,?,?,?,?,?,?)"); 
		 st.setString(1,request.getParameter("eventname"));
		 st.setString(2,request.getParameter("place"));
		 st.setString(3,request.getParameter("description"));
		 st.setString(4,request.getParameter("date1"));
		 st.setString(5,request.getParameter("time1"));
		 st.setString(6,request.getParameter("date2"));
		 st.setString(7,request.getParameter("time2"));
		 
		//out.print(st);
		 int i = st.executeUpdate();
		 
            if(i > 0) {
                //out.println("You are successfully registered");
                RequestDispatcher rs = request.getRequestDispatcher("adminhome.html");
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

	

