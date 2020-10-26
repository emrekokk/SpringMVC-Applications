<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
  <script>
    function myFunction()
    {
      var x = document.getElementById("case")
    x = x * 3;
    alert(x)
    }
  </script>
</head>
<body>

<p>Corona Virus Dashboard Admin Panel </p>

<form id="frm1" action="modify" modelattribute="date" method="POST">
  Case: <label>
  <input type="text" name="case">
</label><br>
  Death: <input type="text" name="death"><br>
  ICU: 		<input type="text" name="icu"><br>
  Intubed: 	<input type="text" name="intubed"><br>
  Recovered: <input type="text" name="recovered"><br>

  <p>${someAttribute}</p>
  <br>
  <input type="button" onclick="myFunction()" value="Delete">
  <input type="button" onclick="myFunction()" value="Modify">
  <input type="button" onclick="myFunction()" value="Show">
  <input type="button" onclick="myFunction()" value="Update">
</form>

<a href="${pageContext.request.contextPath}/Covid19Dashboard">Dashboard</a></body>
</html>