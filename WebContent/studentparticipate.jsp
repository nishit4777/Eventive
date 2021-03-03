<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
</style>
<link rel="stylesheet" href="css/addevent.css" type="text/css">
</head>
<body>
<div class="topnav">
 <b class="active" href="#home">
 <img src="images/lo.png" alt="">
</b>
  
</div>


<div class="about-section">
  <h1>EVENT PARTICIPATION</h1>
  <br>
</div>

<div class="about-section1">


<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<%
String id = request.getParameter("userId");
String driverName = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String dbName = "eventive";
String userId = "root";
String password = "";
String v=(String)session.getAttribute("value");

try {
Class.forName(driverName);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;
Statement statement = null;
ResultSet resultSet,rs = null;
%>

<br>

<%

%>






<h2 align="center"><font><strong>Your Selected Events</strong></font></h2>
<table align="center" cellpadding="5" cellspacing="5" border="1">
<tr>

</tr>
<tr bgcolor="#A52A2A">
<td><b>Event Name</b></td>
<td><b>Place</b></td>
<td><b>Description</b></td>
<td><b>Start-Date</b></td>
<td><b>Start-Time</b></td>
<td><b>End-Date</b></td>
<td><b>End-Time</b></td>
<td><b>Status</b></td>

</tr>

<%
try{ 
connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
//statement=connection.createStatement();
//String delname=request.getParameter("eventname");
//out.print(delname);
 PreparedStatement st = connection.prepareStatement("SELECT * FROM approveevents where eventname=?"); 
			 st.setString(1,request.getParameter("ename"));
			 
			//out.print(st);
			 ResultSet i = st.executeQuery();
PreparedStatement t = connection.prepareStatement("INSERT into dashboard values(?,?,?,?,?,?,?,?,?)");  
while(i.next()){
%>
<tr bgcolor="#DEB887">
<form action="" method="post">
<td><%=i.getString("eventname") %></td>
<td><%=i.getString("place") %></td>
<td><%=i.getString("description") %></td>
<td><%=i.getString("date1") %></td>
<td><%=i.getString("time1") %></td>
<td><%=i.getString("date2") %></td>
<td><%=i.getString("time2") %></td>
<td><%=i.getString("status") %></td>

</tr>
<%
t.setString(1, v);
t.setString(2, i.getString("eventname"));
t.setString(3, i.getString("place"));
t.setString(4, i.getString("description"));
t.setString(5, i.getString("date1"));
t.setString(6, i.getString("time1"));
t.setString(7, i.getString("date2"));
t.setString(8, i.getString("time2"));
t.setString(9, "student");
t.executeUpdate();

%>

</form>
<%
}


//statement.executeUpdate("DELETE * FROM addevent where eventname="+delname);

} catch (Exception e) {
e.printStackTrace();
}
%>
</table>
<br><br>
<p><button class="button">Get Ticket</button></p><br><br>
</div>

</body>
</html>