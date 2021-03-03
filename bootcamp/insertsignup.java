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
@WebServlet("/insertsignup")
public class insertsignup extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			
		try { 
			Connection con = connection.initializeDatabase();
			String emailid=request.getParameter("email"),temp=null,register=emailid.substring(0,9),year="20"+emailid.substring(0,2);
			if(emailid.substring(4,6).equalsIgnoreCase("cs")) {
				temp="Computer Science and Engineering";
			 }
			 if(emailid.substring(4,6).equalsIgnoreCase("it")) {
				 temp="Information Technology";
			 }
			 if(emailid.substring(4,6).equalsIgnoreCase("ee")) {
				 temp="Electricals and Electronics Engineering";
			 }
			  if(emailid.substring(4,6).equalsIgnoreCase("ec")) {
				 temp="Electronics and Communications Engineering";
			 }			  
			 PreparedStatement st = con.prepareStatement("insert into signup values(?,?,?,?,?,?)"); 
			 st.setString(1,request.getParameter("name"));
			 st.setString(2,emailid);
			 st.setString(3,request.getParameter("psw"));			 
			 st.setString(4,register);
			 st.setString(5,year);
			 st.setString(6,temp);
			//out.print(st);
			 int i = st.executeUpdate();
			 
	            if(i > 0) {
	                //out.println("You are successfully registered");
	                RequestDispatcher rs = request.getRequestDispatcher("signin.html");
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