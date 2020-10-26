<%--
  Created by IntelliJ IDEA.
  User: Emre
  Date: 24.05.2020
  Time: 01:18
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix ="spring" uri ="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="springform" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head><!--
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css"/>
     Include JS File Here
    <script type="text/javascript" defer src="${pageContext.request.contextPath}/resources/js/login.js"></script>
    -->
    <title>Javascript Login Form Validation</title>
</head>
<body>
    <form:form method = "POST" modelAttribute="user" action="success">
    <table>
    <tr>
        <td>User Id:</td>
        <td><springform:input path="username" /> </td>
    </tr>
    <tr>
        <td>Password:</td>
        <td><springform:input path="password" /> </td>
    </tr>
        <tr>
            <td colspan = "3"><input type="submit" value="Login"></td>
        </tr>
    </table>
        <td>${message}</td>
    </form:form>
</body>
</html>
