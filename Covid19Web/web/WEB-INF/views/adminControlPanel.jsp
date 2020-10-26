<%@ page import="Connects.DailyData" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE HTML>
<html>
<head>
<script>
</script>
    <script>
        window.onload = function () {
            var chart = new CanvasJS.Chart("chartContainer", {
                animationEnabled: true,
                title:{
                    text: "Daily High Temperature at Different Beaches"
                },
                axisX: {
                    valueFormatString: "DD MMM,YY"
                },
                axisY: {
                    title: "Temperature (in °C)",
                    includeZero: false,
                    suffix: " °C"
                },
                legend:{
                    cursor: "pointer",
                    fontSize: 16,
                    itemclick: toggleDataSeries
                },
                toolTip:{
                    shared: true
                },
                data: [{
                    name: "Myrtle Beach",
                    type: "spline",
                    yValueFormatString: "#0.## °C",
                    showInLegend: true,
                    dataPoints: [
                        { x: new Date(2017,6,1), y: 55 },
                        { x: new Date(2017,6,2), y: 22 },
                        { x: new Date(2017,6,3), y: 22 },
                        { x: new Date(2017,6,4), y: 22 },
                        { x: new Date(2017,6,5), y: 22 },
                        { x: new Date(2017,6,6), y: 22 },
                        { x: new Date(2017,6,7), y: 22 },
                        { x: new Date(2017,6,8), y: 31 },
                        { x: new Date(2017,6,9), y: 29 },
                        { x: new Date(2017,6,10), y: 29 },
                        { x: new Date(2017,6,11), y: 31 },
                        { x: new Date(2017,6,12), y: 30 },
                        { x: new Date(2017,6,13), y: 29 },
                        { x: new Date(2017,6,14), y: 22 },
                        { x: new Date(2017,6,15), y: 22 },
                        { x: new Date(2017,6,16), y: 22 },
                        { x: new Date(2017,6,17), y: 22 },
                        { x: new Date(2017,6,18), y: 22 },
                        { x: new Date(2017,6,19), y: 22 },
                        { x: new Date(2017,6,20), y: 22 },
                        { x: new Date(2017,6,21), y: 31 },
                        { x: new Date(2017,6,22), y: 29 },
                        { x: new Date(2017,6,23), y: 29 },
                        { x: new Date(2017,6,24), y: 31 },
                        { x: new Date(2017,6,25), y: 30 },
                        { x: new Date(2017,6,26), y: 29 },
                        { x: new Date(2017,6,27), y: 31 },
                        { x: new Date(2017,6,28), y: 29 },
                        { x: new Date(2017,6,29), y: 29 },
                        { x: new Date(2017,6,30), y: 31 },
                        { x: new Date(2017,6,31), y: 30 }
                    ]
                },
                    {
                        name: "Martha Vineyard",
                        type: "spline",
                        yValueFormatString: "#0.## °C",
                        showInLegend: true,
                        dataPoints: [
                            { x: new Date(2017,6,1), y: 22 },
                            { x: new Date(2017,6,2), y: 22 },
                            { x: new Date(2017,6,3), y: 22 },
                            { x: new Date(2017,6,4), y: 22 },
                            { x: new Date(2017,6,5), y: 22 },
                            { x: new Date(2017,6,6), y: 22 },
                            { x: new Date(2017,6,7), y: 22 },
                            { x: new Date(2017,6,8), y: 31 },
                            { x: new Date(2017,6,9), y: 29 },
                            { x: new Date(2017,6,10), y: 29 },
                            { x: new Date(2017,6,11), y: 31 },
                            { x: new Date(2017,6,12), y: 30 },
                            { x: new Date(2017,6,13), y: 29 },
                            { x: new Date(2017,6,14), y: 22 },
                            { x: new Date(2017,6,15), y: 22 },
                            { x: new Date(2017,6,16), y: 22 },
                            { x: new Date(2017,6,17), y: 22 },
                            { x: new Date(2017,6,18), y: 22 },
                            { x: new Date(2017,6,19), y: 22 },
                            { x: new Date(2017,6,20), y: 22 },
                            { x: new Date(2017,6,21), y: 31 },
                            { x: new Date(2017,6,22), y: 29 },
                            { x: new Date(2017,6,23), y: 29 },
                            { x: new Date(2017,6,24), y: 31 },
                            { x: new Date(2017,6,25), y: 30 },
                            { x: new Date(2017,6,26), y: 29 },
                            { x: new Date(2017,6,27), y: 31 },
                            { x: new Date(2017,6,28), y: 29 },
                            { x: new Date(2017,6,29), y: 29 },
                            { x: new Date(2017,6,30), y: 31 },
                            { x: new Date(2017,6,31), y: 30 }
                        ]
                    },
                    {
                        name: "Nantucket",
                        type: "spline",
                        yValueFormatString: "#0.## °C",
                        showInLegend: true,
                        dataPoints: [
                            { x: new Date(2017,6,1), y: 22 },
                            { x: new Date(2017,6,2), y: 22 },
                            { x: new Date(2017,6,3), y: 22 },
                            { x: new Date(2017,6,4), y: 4 },
                            { x: new Date(2017,6,5), y: 22 },
                            { x: new Date(2017,6,6), y: 5 },
                            { x: new Date(2017,6,7), y: 22 },
                            { x: new Date(2017,6,8), y: 31 },
                            { x: new Date(2017,6,9), y: 54 },
                            { x: new Date(2017,6,10), y: 29 },
                            { x: new Date(2017,6,11), y: 31 },
                            { x: new Date(2017,6,12), y: 5 },
                            { x: new Date(2017,6,13), y: 29 },
                            { x: new Date(2017,6,14), y: 22 },
                            { x: new Date(2017,6,15), y: 22 },
                            { x: new Date(2017,6,16), y: 22 },
                            { x: new Date(2017,6,17), y: 22 },
                            { x: new Date(2017,6,18), y: 22 },
                            { x: new Date(2017,6,19), y: 22 },
                            { x: new Date(2017,6,20), y: 2 },
                            { x: new Date(2017,6,21), y: 31 },
                            { x: new Date(2017,6,22), y: 29 },
                            { x: new Date(2017,6,23), y: 29 },
                            { x: new Date(2017,6,24), y: 31 },
                            { x: new Date(2017,6,25), y: 30 },
                            { x: new Date(2017,6,26), y: 3 },
                            { x: new Date(2017,6,27), y: 31 },
                            { x: new Date(2017,6,28), y: 29 },
                            { x: new Date(2017,6,29), y: 29 },
                            { x: new Date(2017,6,30), y: 31 },
                            { x: new Date(2017,6,31), y: 30 }
                        ]
                    }]
            });
            chart.render();

            function toggleDataSeries(e){
                if (typeof(e.dataSeries.visible) === "undefined" || e.dataSeries.visible) {
                    e.dataSeries.visible = false;
                }
                else{
                    e.dataSeries.visible = true;
                }
                chart.render();
            }

        }
    </script>
</head>
<body>
<div id="chartContainer" style="height: 370px; width: 100%;"></div>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</body>
</html>