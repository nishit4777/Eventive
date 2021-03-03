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
  <h1>View User Details</h1>
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

try {
Class.forName(driverName);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;
Statement statement = null;
ResultSet resultSet,rs = null;
%>

<table align="center" cellpadding="5" cellspacing="5" border="1">
<tr>

</tr>
<tr bgcolor="#A52A2A">
<td><b>Name</b></td>
<td><b>Email</b></td>

<td><b>Resgister No</b></td>
<td><b>Year</b></td>
<td><b>Department</b></td>
</tr>

<%
try{ 
connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
statement=connection.createStatement();
String delname=request.getParameter("eventname");
//out.print(delname);
String sql ="SELECT * FROM signup";

resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr bgcolor="#DEB887">

<td><%=resultSet.getString("name") %></td>
<td><%=resultSet.getString("email") %></td>

<td><%=resultSet.getString("register") %></td>
<td><%=resultSet.getString("year") %></td>
<td><%=resultSet.getString("department") %></td>


</tr>

<%

}
statement.executeUpdate("DELETE * FROM addevent where eventname="+delname);

} catch (Exception e) {
e.printStackTrace();
}
%>
</table>
<br><br><br><br><br><br><br><br><br><br><br><br><br>
</div>

</body>
</html>