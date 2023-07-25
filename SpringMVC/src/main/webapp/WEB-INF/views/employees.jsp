<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Employee List</h1>

<table border="1">
<tr>
  <th>Id</th>
  <th>Name</th>
  <th>Age</th>
</tr>
<c:forEach items="${employeeList}" var="employee">
	<tr>
		<td>${employee.id}</td>
		<td>${employee.name}</td>
		<td>${employee.age}</td>	
	</tr>


</c:forEach>

</table>
</body>
</html>