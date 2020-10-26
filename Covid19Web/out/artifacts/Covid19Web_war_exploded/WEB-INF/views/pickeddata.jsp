<%--
  Created by IntelliJ IDEA.
  User: Emre
  Date: 29.05.2020
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Covid19 Dashboard</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>jQuery UI Datepicker - Default functionality</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/dashboard.css">
</head>
<body>
<p>Date: <input type="text" id="datepicker"></p>
<h3>
    Status:
    <td>${message}</td>
</h3>

<div class="divTable" style="width: 10%; border: 10px solid #00ffe1;">
    <div class="divTableBody" >
        <div class="divTableRow">
            <div class="divTableCell">&nbsp;country : ${countryid}</div>
            <div class="divTableCell">day : </div>
            <div class="divTableCell">test : ${test}</div>
            <div class="divTableCell">case : ${dailycase}</div>
            <div class="divTableCell">intubated : ${intubated}</div>
            <div class="divTableCell">icu : ${icu}</div>
            <div class="divTableCell">&nbsp;recovered : ${recovered}&nbsp;</div>
            <div class="divTableCell">deceased ${deceased}&nbsp;</div>
        </div>
    </div>
</div>
<button onclick="functionpicker()">Click me</button>
<script>
    functionpicker() {
        $( "#datepicker" ).datepicker();
        var date = $( "#datepicker" ).datepicker({ dateFormat: 'yy-mm-dd' }).val();
        alert(date);
    }
</script>
</body>
</html>
