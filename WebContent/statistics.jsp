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
   
      <br>
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
['CS',3],
['IT',1],
['EE',1],
['EC',1]
]);
// Optional; add a title and set the width and height of the chart
var options = {'title':'Department wise participation', 'width':1380, 'height':400};
// Display the chart inside the <div> element with id="piechart"
var chart = new google.visualization.PieChart(document.getElementById('piechart'));
chart.draw(data, options);
}
</script>
  </div>
</body>
</html>