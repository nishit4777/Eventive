<!DOCTYPE html>
<%@page import="java.sql.PreparedStatement"%>
<html>
<head>
<script>(function(w, d) { w.CollectId = "60182e508255d2479d7323b2"; var h = d.head || d.getElementsByTagName("head")[0]; var s = d.createElement("script"); s.setAttribute("type", "text/javascript"); s.async=true; s.setAttribute("src", "https://collectcdn.com/launcher.js"); h.appendChild(s); })(window, document);</script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
</style>
<link rel="stylesheet" href="css/adminhome.css" type="text/css">
</head>
<body>
<div class="topnav">
 <b class="active" href="#home">
 <img src="images/lo.png" alt="">
</b>

  <a href="signin.html">Logout</a>
  <a href="Profile.html">Profile</a>
 
  
</div>
<div class="bg-image">

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="bootcamp.signin"%>

<%
String driverName = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String dbName = "eventive";
String userId = "root";
String password = "";
String value=request.getParameter("email");
session.setAttribute("value", value);
try {
Class.forName(driverName);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;
Statement statement = null;
ResultSet resultSet,rs,r = null;

try{ 
connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
statement=connection.createStatement();

String sql1 = ("SELECT name FROM signup WHERE email=?");
PreparedStatement ps=connection.prepareStatement(sql1);
ps.setString(1,request.getParameter("email"));
r = ps.executeQuery();

while(r.next()){
%>
<div class="about-section">
<h3>Welcome back! <%=r.getString("name") %></h3>
<h3>hello <%=value %></h3>
</div>

<%
}

%>
<div class="about-section">
  <h1>Welcome to Dashboard</h1>
</div>
<div class="about-section1">
<div class="row">
  <div class="column">
    <div class="card">
      
      <div class="container">
       <br><h2>Register for Admin Events</h2>
        <p>You can register for the events here.</p>
        <p><button class="button" onclick="window.location.href='exploreevents.jsp';">Click Here</button></p>
      </div>
    </div>
  </div>

  <div class="column">
    <div class="card">
      
      <div class="container">
         <br><h2>Delete Registration</h2>
        <p>You can delete for events registered here</p>
        <p><button class="button" onclick="window.location.href='deleteregistration.jsp';">Click Here</button></p>
      </div>
    </div>
  </div>
  
  <div class="column">
    <div class="card">
     
      <div class="container">
         <br><h2>Add Events</h2>
        <p>Add the events here.</p>
        <p><button class="button" onclick="window.location.href='studentaddevent.jsp';">Click Here</button></p>
      </div>
    </div>
  </div>
  </div>
    
</div>
<div class="about-section1">
<div class="row">
  <div class="column">
    <div class="card">
      
      <div class="container">
       <br><h2>Register for Student Events</h2>
        <p>You can register for the events here.</p>
        <p><button class="button" onclick="window.location.href='exploreeventsstudents.jsp';">Click Here</button></p>
      </div>
    </div>
  </div>

  <div class="column">
    <div class="card">
      
      <div class="container">
         <br><h2>Delete Events added</h2>
        <p>You can delete the events you added</p>
        <p><button class="button" onclick="window.location.href='studenteventdelete.jsp';">Click Here</button></p>
      </div>
    </div>
  </div>
  
  <div class="column">
    <div class="card">
     
      <div class="container">
         <br><h2>Statistics</h2>
        <p>You can view statistics here.</p>
        <p><button class="button" onclick="window.location.href='statistic.jsp';">Click Here</button></p>
      </div>
    </div>
  </div>
  </div>
    
</div>

<%

String sql = "SELECT * FROM dashboard WHERE email=?";
PreparedStatement ps2=connection.prepareStatement(sql);
ps2.setString(1,request.getParameter("email"));
resultSet = ps2.executeQuery();
int i=0;
while(resultSet.next()){
	if(i==0) {
%>
<div class="about-section">
  <h1>Your registered events</h1>
</div>

<%
	}
%>
<div class="about-section1">
<div class="row">
 <div class="column">
    <div class="card">
      <div class="container">
      <h3>Event name: </h3><p><%=resultSet.getString("eventname") %></p>
      <h3>Place: </h3><p><%=resultSet.getString("place") %></p>
      <h3>Description: </h3><p><%=resultSet.getString("description") %></p>
      <h3>Start-Date: </h3><p><%=resultSet.getString("date1") %></p>
      <h3>Start-Time: </h3><p><%=resultSet.getString("time1") %></p>
      <h3>End-Date: </h3><p><%=resultSet.getString("date2") %></p>
      <h3>End-Time: </h3><p><%=resultSet.getString("time2") %></p>
      </div>
    </div>
  </div>

<%
	i++;
}
} catch (Exception e) {
e.printStackTrace();
}
%>
</div>
</div>
</div>
</div>
</body>
</html>