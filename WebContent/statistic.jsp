<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
</style>
<link rel="stylesheet" href="css/event.css" type="text/css">
</head>
<body>
<div class="topnav">
 <b class="active" href="#home">
 <img src="images/lo.png" alt="">
</b>
</div>
<div class="about-section">
  <h1>GRAPHS AND STATISTICS</h1>
</div>

<div class="about-section1">
    
        <div class="container" >
            <div class="center1">
          <h1><t>SEARCH BY EVENT</t> </h1>
        </div>
          
          <hr>
      
          <label for="email"><b>EVENT NAME</b></label>
          <input type="text" placeholder="Enter EventName" name="event" required>
      
      
          <div class="center1">
           <br>
            <button type="submit" class="cancelbtn" onclick="window.location.href='statistics.jsp';">Show Graph</button>
          </div>
        </div>
      
      <br>

  </div>
  <%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="bootcamp.signin"%>
<%
int cs=0,it=0,ee=0,ec=0;
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

String sql1 = ("SELECT name FROM dashboard");
r=statement.executeQuery(sql1);

while(r.next()) {
	if(value.substring(4,6).equalsIgnoreCase("cs")) {
		cs++;
	}
	else if(value.substring(4,6).equalsIgnoreCase("it")) {
		it++;
	}
	else if(value.substring(4,6).equalsIgnoreCase("ee")) {
		ee++;
	}
	else if(value.substring(4,6).equalsIgnoreCase("ec")) {
		ec++;
	}
}
}

 catch (Exception e) {
e.printStackTrace();
 }
 
%>

<div id="piechart"></div>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
// Load google charts
google.charts.load('current', {'packages':['corechart']});
google.charts.setOnLoadCallback(drawChart);
// Draw the chart and set the chart values
function drawChart() {
var data = google.visualization.arrayToDataTable([
['Task', 'Page visit per Day'],
['CS',cs],
['IT',it],
['EE',ee],
['EC',ec]
]);
// Optional; add a title and set the width and height of the chart
var options = {'title':'Department wise participation', 'width':1380, 'height':400};
// Display the chart inside the <div> element with id="piechart"
var chart = new google.visualization.PieChart(document.getElementById('piechart'));
chart.draw(data, options);
}
</script>
</body>
</html>