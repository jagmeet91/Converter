<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="css/a.css" type="text/css" />
</head>
<body>
<div>
<h2 align="center" >CURRENCY CONVERTER</h1>

<form:form action="converter" modelAttribute="formPOJO" method="POST" align="center">
	
	<form:select path="fromCurr">
		<form:option value="USD" />
		
</form:select>

	<Label>To</Label>

	<form:select path="toCurr">
		<form:option value="EUR" />
		<form:option value="GBP" />
		<form:option value="CAD" />
		<form:option value="PLN" />
	</form:select>

<br><br><br>

	<form:input type="text" path="fromValue"/>
	

	<pre></pre>

	
<input type="submit" value=" Equals To " />
<br>
<br>
<br>
<label >ANSWER : </label>${answer}
</form:form>

</div>
</body>
</html>