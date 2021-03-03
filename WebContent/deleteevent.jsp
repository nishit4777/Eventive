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
  <a href="adminhome.html">Home</a>
</div>


<div class="about-section">
  <h1>Delete Event</h1>
</div>

<div class="about-section1">
<div class="row">
  <div class="column">
    <div class="card">
      
      <div class="container">
        <form action="deleteevent" method="post">
            <div class="container1">
              <p>Please fill in this form to delete an event.</p>
              <hr>
          		
          	   <label for="name"><b>Event Name</b></label>
              <input type="text" placeholder="Enter Event Name" name="ename" required>

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

<%
String id = request.getParameter("userId");
String driverName = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String dbName = "eventive";
String userId = "root";
String password = "";

try {
Class.forName(driverName);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;
Statement statement = null;
ResultSet resultSet,rs = null;
%>
<h2 align="center"><font><strong>Events on Live</strong></font></h2>
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
</tr>

<%
try{ 
connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
statement=connection.createStatement();
String delname=request.getParameter("eventname");
//out.print(delname);
String sql ="SELECT * FROM addevent";

resultSet = statement.executeQuery(sql);
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

</tr>

<%

}
statement.executeUpdate("DELETE * FROM addevent where eventname="+delname);

} catch (Exception e) {
e.printStackTrace();
}
%>
</table>
</div>

</body>
</html>