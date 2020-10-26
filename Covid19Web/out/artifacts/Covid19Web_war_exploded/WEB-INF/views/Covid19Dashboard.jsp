<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Emre
  Date: 24.05.2020
  Time: 01:25
  To change this template use File | Settings | File Templates.

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Covid19 Dashboard</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>jQuery UI Datepicker - Default functionality</title>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="/resources/demos/style.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
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
--%>
<%--
<label>Select Date Format :</label>
<select id="format">
    <option value="mm/dd/yy">Default - mm/dd/yyyy</option>
    <option value="dd/mm/yy">dd/mm/yyyy</option>
    <option value="yy-mm-dd">ISO 8601 - yyyy-mm-dd</option>
    <option value="d M, y">Short - d M, y</option>
    <option value="d MM, y">Medium - d MM, y</option>
    <option value="DD, d MM, yy">Full - DD, d MM, yyyy</option>
    <option value="&apos;day&apos; d &apos;of&apos; MM &apos;in the year&apos; yy">With text - 'day' d 'of' MM 'in the year' yyyy</option>
</select>
--%>
<!doctype html>
<html>
<head>
    <title>COVID19 USER PANEL</title>
    <meta name="robots" content="noindex, nofollow"/>
    <!------------ Including jQuery Date UI with CSS -------------->
    <script src="http://code.jquery.com/jquery-1.10.2.js"></script>
    <script src="http://code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/dashboard.css">

</head>
<body>
<div class="container">
    <h2>COVID19 USER PANEL</h2>
    <div class="main">
        <form:form action="${pageContext.request.contextPath}/covid19dashb" method="post" modelAttribute="myday">
            <label>Day :   </label>
            <form:input path="dayof" type="text" name="sname"/>
            <br><br>
            <label>Month : </label>
            <form:input type="text2" id="" path="month"/>
            <br><br>
            <label>Year : </label>
            <form:input type="text3" id="" path="year"/>
            <br><br>
            <label for="country">Choose Country:</label>
            <form:select path="countryString" name="country" id="country">
                <form:option value="TURKIYE">Turkiye</form:option>
                <form:option value="AZERBAYCAN">Azerbaycan</form:option>
            </form:select>
            <br><br>
            <input type="submit" id="submit" value="Get Data">
        </form:form>
    </div>
</div>
<style>
    input[type=submit] {
        background-color: #4FC3A1;
        border: none;
        color: white;
        padding: 8px 12px;
        text-decoration: none;
        margin: 4px 2px;
        cursor: pointer;
    }
</style>

<style>
    input[type=text], input[type=text2], input[type=text3] {
        background-color: #afaeaa;
        border: none;
        color: white;
        padding: 8px 12px;
        text-decoration: none;
        margin: 4px 2px;
        cursor: pointer;
    }
</style>
<style>
    table.GeneratedTable {
        width: 150px;

        background-color: white;
        border-collapse: collapse;
        border-width: 4px;
        border-color: #6a9581;
        border-style: solid;
        color: #000000;
    }
    table.GeneratedTable td, table.GeneratedTable th {
        border-width: 4px;
        border-color: #6a9581;
        border-style: solid;
        padding: 3px;
    }
    table.GeneratedTable thead {
        background-color: #0bf4c6;
    }
</style>
<!--<table class="GeneratedTable"> -->
    <table class="fl-table">
    <thead>
    <tr>
        <th>Data</th>
        <th>Daily</th>
        <th>Total</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>TEST</td>
        <td>${test}</td>
        <td>${ttest}</td>
    </tr>
    <tr>
        <td>CASE</td>
        <td>${dailycase}</td>
        <td>${tdaily}</td>
    </tr>
    <tr>
        <td>INTUBATED</td>
        <td>${intubated}</td>
        <td>${tintubated}</td>
    </tr>
    <tr>
        <td>ICU</td>
        <td>${icu}</td>
        <td>${ticu}</td>
    </tr>
    <tr>
        <td>DECEASED</td>
        <td>${deceased}</td>
        <td>${tdeceased}</td>
    </tr>
    <tr>
        <td>RECOVERED</td>
        <td>${recovered}</td>
        <td>${trecovered}</td>
    </tr>
    </tbody>
</table>

</body>
</html>