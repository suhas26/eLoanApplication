<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
	table, th, td {
	  border: 1px solid black;
	  border-collapse: collapse;
	  padding: 10px;
	}
	thead {
	  background: #395870;
	  color: #fff;
	}
	body {
	    background-color : #FAF0E6;
	    margin: 0;
	    padding: 0;
	}
	h1 {
	    color : #000000;
	    text-align : center;
	    font-family: "SIMPSON";
	}
	form {
	    width: 300px;
	    margin: 0 auto;
	}
</style>
<title>Error</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<hr/>
	<div>
		<h3>Something went wrong! We regret the inconvenience!</h3>
		<p>Error Message : <%=exception.getMessage()%> </p>
		<p>Please Contact Administrator</p>
	</div>
<hr/>	
	<jsp:include page="footer.jsp"/>
</body>
</html>