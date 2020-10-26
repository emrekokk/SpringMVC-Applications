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
<head>
    <spring:url value="/resources/css/style.css" var="crunchifyCSS" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <link href="${crunchifyCSS}" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css"/>
    <!-- Include JS File Here -->
    <script type="text/javascript" defer src="${pageContext.request.contextPath}/resources/js/login.js"></script>
    <title>Javascript Login Form Validation</title>
</head>
<body class="body">
<div class="loginbox">
    <img src="${pageContext.request.contextPath}/resources/images/avatar.png" class="avatar">

    <h1>Login Here</h1>
    <form:form method="POST" action="success" modelAttribute="user">
        <p>Username</p>
        <form:input type="text" path="username" placeholder="Enter Username" />
        <p>Password</p>
        <form:input type="password" path="password" placeholder="Enter Password"/>
        <input type="submit" value="Login">
    </form:form>
    <a href="${pageContext.request.contextPath}/createaccount">Create Account</a>

    <td>${message}</td>
    <script>
        {
            var message = ${result};
            if (message === false)
            {
                alert("Login was unsuccessful, please check your username and password");
            }
            else
            {
                alert("Login Succesfull")
            }
        }
    </script>
</div>

</body>
</html>
