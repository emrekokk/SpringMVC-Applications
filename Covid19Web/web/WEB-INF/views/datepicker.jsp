<%--
  Created by IntelliJ IDEA.
  User: Emre
  Date: 28.05.2020
  Time: 20:13
  To change this template use File | Settings | File Templates.

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>jQuery UI Datepicker - Default functionality</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/dashboard.css">
    <script>
        function validate()
        {
            //var date = $( ".selector" ).datepicker({ dateFormat: 'yy-mm-dd' }).value();
            var currentDate = $( ".selector" ).getAttribute( "getDate" );
            alert(currentDate);
        }
    </script>
</head>
<body>
<p>Date: <input type="text" id="datepicker"></p>
<button onclick="validate()">Click me</button>
<script>
    function validate()
    {
        //var date = $( ".selector" ).datepicker({ dateFormat: 'yy-mm-dd' }).value();
        var currentDate = $( ".selector" ).getAttribute( "getDate" );
        alert(currentDate);
    }
</script>
</body>
</html>
--%>