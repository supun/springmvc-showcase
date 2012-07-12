<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="vikram.demo.springmvc.domain.*" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<%
	Person person = (Person)request.getAttribute("data");
%>
<c:if test="${person != null}">
	<p>FirstName: ${person.firstName}</p>
	<p>LastName: ${person.lastName}</p>
	<p>Age: ${person.age}</p>
</c:if>
</body>
</html>
