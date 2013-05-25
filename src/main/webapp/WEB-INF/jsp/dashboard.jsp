<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Spring 3 MVC Series - Operation Manager</title>
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
	<script type="text/javascript">
	$(function () {
        $('#container').highcharts({
            chart: {
                type: 'column',
                margin: [ 50, 50, 100, 80]
            },
            title: {
                text: 'Operation History'
            },
            xAxis: {
                categories: [
					<%
					for (String title : (java.util.List<String>)request.getAttribute("titleList")) {
						out.print("'" + title + "',");
					}
					%>       
                ],
                labels: {
                    rotation: -45,
                    align: 'right',
                    style: {
                        fontSize: '13px',
                        fontFamily: 'Verdana, sans-serif'
                    }
                }
            },
            yAxis: {
                min: 0,
                title: {
                    text: 'Value (PLN)'
                }
            },
            legend: {
                enabled: false
            },
            tooltip: {
                formatter: function() {
                    return '<b>'+ this.x +'</b><br/>'+
                        'Value in 03.2013: '+ Highcharts.numberFormat(this.y, 1) +
                        ' PLN';
                }
            },
            series: [{
                name: 'Value',
                data: [
   					<%
					for (Double value : (java.util.List<Double>)request.getAttribute("valueList")) {
						out.print(java.lang.Math.abs(value) + ",");
					}
					%>  
				],
                dataLabels: {
                    enabled: true,
                    rotation: -90,
                    color: '#FFFFFF',
                    align: 'right',
                    x: 4,
                    y: 10,
                    style: {
                        fontSize: '13px',
                        fontFamily: 'Verdana, sans-serif'
                    }
                }
            }]
        });
    });
    </script>
	<style type="text/css">
		body {
			font-family: sans-serif;
		}
	</style>
</head>

<body>
	<h2>Dashboard</h2>	
	<h3>Chart</h3>
		<script src="../resources/js/highcharts.js"></script>
		<script src="../resources/js/modules/exporting.js"></script>
		<div id="container" style="min-width: 400px; height: 400px; margin: 0 auto"></div>
		
<h3>Operations</h3>
<c:if  test="${!empty operationList}">
<table>
<tr>
	<th>Month</th>
	<th>Year</th>
	<th>Value</th>
	<th>Category</th>
</tr>
<c:forEach items="${operationList}" var="operation">
	<tr>
		<td>${operation[0]}</td>
		<td>${operation[1]}</td>
		<td>${operation[2]}</td>
		<td>${operation[3]}</td>
	</tr>
</c:forEach>
</table>
</c:if>		
		
</body>

</html>
