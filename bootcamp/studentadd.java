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
 * Servlet implementation class studentadd
 */
@WebServlet("/studentadd")
public class studentadd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
	try { 
		Connection con = connection.initializeDatabase();
		  String e="18eucs134@skcet.ac.in";
		  String s="not accepted";
		 PreparedStatement st = con.prepareStatement("INSERT INTO approveevents values(?,?,?,?,?,?,?,?,?)"); 
		/*// st.setString(1,"18eucs134@skcet.ac.in");
		 st.setString(1,request.getParameter("eventname"));
		 st.setString(2,request.getParameter("place"));
		 st.setString(3,request.getParameter("description"));
		 st.setString(4,request.getParameter("date1"));
		 st.setString(5,request.getParameter("time1"));
		 st.setString(6,request.getParameter("date2"));
		 st.setString(7,request.getParameter("time2"));
		// st.setString(9,"notaccepted");*/
		  st.setString(1,e);
		 st.setString(2,request.getParameter("eventname"));
		 st.setString(3,request.getParameter("place"));
		 st.setString(4,request.getParameter("description"));
		 st.setString(5,request.getParameter("date1"));
		 st.setString(6,request.getParameter("time1"));
		 st.setString(7,request.getParameter("date2"));
		 st.setString(8,request.getParameter("time2"));
		st.setString(9,s);
		//out.print(st);
		 int i = st.executeUpdate();
		 
            if(i > 0) {
                //out.println("You are successfully registered");
                RequestDispatcher rs = request.getRequestDispatcher("studentaddevent.jsp");
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

	