<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<!-- <%--
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
<h3>
    <td>COVID19 ADMIN PANEL</td>
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
<div class="divTable" style="width: 10%; border: 10px solid #00ffe1;">
    <div class="divTableBody" >
        <div class="divTableRow">
            <div class="divTableCell">Total test : ${ttest}</div>
            <div class="divTableCell">Total case : ${tdaily}</div>
            <div class="divTableCell">Total intubated : ${tintubated}</div>
            <div class="divTableCell">Total icu : ${ticu}</div>
            <div class="divTableCell">Total&nbsp;recovered : ${trecovered}&nbsp;</div>
            <div class="divTableCell">Total deceased ${tdeceased}&nbsp;</div>
        </div>
    </div>
</div>
<div class="container">
    <h2>Modify Form</h2>
    <div class="main">
        <form:form action="${pageContext.request.contextPath}/modify" method="post" modelAttribute="modifydata">
            <label>CountryID:</label>
            <form:input path="countryID" type="text"/><br>
            <label>Day :</label>
            <form:input path="gun" type="text"/><br>
            <label>Month :</label>
            <form:input path="ay" type="text" id="" /><br>
            <label>Year :</label>
            <form:input path="yil" type="text" id="" /><br>
            <br> <td></td>
            <label>Case :</label>
            <form:input path="numCase" type="text"/><br>
            <label>Death:</label>
            <form:input path="numDeceased" type="text" name="death" /><br>
            <label>ICU:</label>
            <form:input path="numICU" type="text" name="icu"/><br>
            <label>Intubed:</label>
            <form:input path="numIntubated" type="text" name="intubed"/><br>
            <label>Recovered:</label>
            <form:input path="numRecovered" type="text" name="recovered"/><br>
            <label>Test:</label>
            <form:input path="numTest" type ="text" /><br>
            <input type="submit" id="submit" value="Update Data" formaction="modifieradmin">
            <input type="submit" formaction="deleteadmin" value="Delete">
            <input type="submit" formaction="newdaily" value="New daily data">
            <input type="submit" formaction="success2" value="Get data by date and countr id">

        </form:form>
    </div>
</div>
</body>
</html>
--!>
<!-- CSS Code: Place this code in the document's head (between the 'head' tags) -->
--%>
<style>
    table.GeneratedTable {
        width: 100%;
        background-color: #ffffff;
        border-collapse: collapse;
        border-width: 2px;
        border-color: #6a9581;
        border-style: solid;
        color: #000000;
    }

    table.GeneratedTable td, table.GeneratedTable th {
        border-width: 2px;
        border-color: #6a9581;
        border-style: solid;
        padding: 3px;
    }

    table.GeneratedTable thead {
        background-color: #0bf4c6;
    }
</style>

 HTML Code: Place this code in the document's body (between the 'body' tags) where the table should appear -->
<html>
<head>

</head>
<body>
<style>
    table.GeneratedTable {
        width: 100px;
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
<table class="GeneratedTable">
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
<form:form action="${pageContext.request.contextPath}/modify" method="post" modelAttribute="modifydata">
    <tr>
    <label>CountryID:</label>
    <form:input path="countryID" type="text" id="label1"/><br>
    </tr>
    <label>Day :</label>
    <form:input path="gun" type="text" id="label2" /><br>
    <label>Month :</label>
    <form:input path="ay" type="text" id="label3" /><br>
    <label>Year :</label>
    <form:input path="yil" type="text" id="label4" /><br>
    <br> <td></td>
    <label>Case :</label>
    <form:input path="numCase" type="text" id="label5"/><br>
    <label>Death:</label>
    <form:input path="numDeceased" type="text" name="death" id="label6"/><br>
    <label>ICU:</label>
    <form:input path="numICU" type="text" name="icu" id="label7"/><br>
    <label>Intubed:</label>
    <form:input path="numIntubated" type="text" name="intubed"/><br>
    <label>Recovered:</label>
    <form:input path="numRecovered" type="text" name="recovered"/><br>
    <label>Test:</label>
    <form:input path="numTest" type ="text" /><br>
    <input type="submit" id="submit" value="Update Data" formaction="modifieradmin">
    <input type="submit" formaction="deleteadmin" value="Delete">
    <input type="submit" formaction="newdaily" value="New daily data">
    <input type="submit" formaction="success2" value="Get data by date and countr id">
    <input type="submit" formaction="delete" value="Delete All Data">
</form:form>
</body>
<script>
    var cnt = ${stt}
    if ( cnt === 0 )
    {
        alert("Username is already taken");
    }
    else if (cnt === 1){
        alert("Complate all informations")
    }
</script>
</html>
<!-- Codes by QHMit.com -->

