<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Emre
  Date: 28.05.2020
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <spring:url value="/resources/css/style.css" var="crunchifyCSS" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/newuser.css"/>
    <title>Javascript Login Form Validation</title>
</head>
<body>
<div class="loginbox">
    <img src="${pageContext.request.contextPath}/resources/images/avatar.png" class="avatar">
    <h1>Complete The Form</h1>
    <form:form method="POST" action="createUser" modelAttribute="newuser">
        <p>Username</p>
        <form:input type="text" path="username" placeholder="Username" />
        <p>Password</p>
        <form:input type="password" path="password" placeholder="Password"/>
        <p>First Name</p>
        <form:input type="text" path="fname" placeholder="Firstname" />
        <p>Last Name</p>
        <form:input type="text" path="lname" placeholder="Lastname" />
        <p>Country ID</p>
        <form:input type="text" path="countryID" placeholder="countryid" />
        <input type="submit" value="Sign Up">
    </form:form>
</div>
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
</body>
</html>
