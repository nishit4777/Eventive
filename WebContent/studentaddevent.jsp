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
  <h1>Add Events</h1>
</div>

<div class="about-section1">
<div class="row">
  <div class="column">
    <div class="card">
      
      <div class="container">
        <form action="studentadd" method="post">
              <div class="container1">
              <p>Please fill in this form to Add events.</p>
              <hr>
          		
          	   <label for="name"><b>Event Name</b></label>
              <input type="text" placeholder="Enter Event Name" name="eventname" required>
              	
              <label for="name"><b>Place</b></label>
              <input type="text" placeholder="Enter the place where the event is held" name="place" required>

              <label for="name"><b>Description</b></label>
              <input type="text" placeholder="Enter the description of the event" name="description" required>
        
              <label for="email"><b>Event-Start Date and time</b></label><br>
              <input type="name" name="date1" required>
              <input type="name" name="time1" required>

              <br><br>

              <label for="email"><b>Event-End Date and time</b></label><br>
              <input type="name" name="date2" required>
              <input type="name" name="time2" required>
          
          	  
        <p><button class="button">Submit</button></p>
            </div>
          </form>

      </div>
    </div>
  </div>

 
 
</div>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="bootcamp.signin"%>
<%
String id = request.getParameter("userId");
String driverName = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String dbName = "eventive";
String userId = "root";
String password = "";
//String value=request.getParameter("email");
String v=(String)session.getAttribute("value");

try {
Class.forName(driverName);

} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;
Statement statement = null;
ResultSet resultSet,rs,r= null;
%>
<h2 align="center"><font><strong>Events You Added</strong></font></h2>
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
statement=connection.createStatement();
//String delname=request.getParameter("eventname");
//out.print(delname);



String sql ="SELECT * FROM approveevents WHERE email= ?";
PreparedStatement p=connection.prepareStatement(sql);
p.setString(1,v);
resultSet=p.executeQuery();
//resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr bgcolor="#DEB887">

<td><%=resultSet.getString("eventname") %></td>
<td><%=resultSet.getString("place") %></td>
<td><%=resultSet.getString("description") %></td>
<td><%=resultSet.getString("date1") %></td>
<td><%=resultSet.getString("time1") %></td>
<td><%=resultSet.getString("date2") %></td>
<td><%=resultSet.getString("time2") %></td>
<td><%=resultSet.getString("status") %></td>
</tr>

<%

}
//statement.executeUpdate("DELETE * FROM addevent where eventname="+delname);

} catch (Exception e) {
e.printStackTrace();
}
%>
</table>
</div>

</body>
</html>