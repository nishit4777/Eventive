package bootcamp;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ticket extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String driverName = "com.mysql.jdbc.Driver";
		String connectionUrl = "jdbc:mysql://localhost:3306/";
		String dbName = "eventive";
		String userId = "root";
		String password = "";
		
		try {
		Class.forName(driverName);
		} catch (ClassNotFoundException e) {
		//e.printStackTrace();
		out.println("hello");
		}

		try {
		Connection connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
		String sql1 = ("SELECT * FROM dashboard where email=?");
		PreparedStatement ps=connection.prepareStatement(sql1);
		ps.setString(1,request.getParameter("name"));
		ResultSet resultSet = ps.executeQuery();
		while(resultSet.next()){
			ticketgeneration.hello(resultSet.getString("eventname"),resultSet.getString("place"),resultSet.getString("description"),resultSet.getString("date1"),resultSet.getString("time1"),resultSet.getString("date2"),resultSet.getString("time2"));
		}
		} catch (Exception e) {
			//e.printStackTrace();
			out.println("hello");
		}
		
	}

}