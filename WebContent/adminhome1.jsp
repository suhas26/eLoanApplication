<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<title>admin home</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div align="right"><a href="index.jsp">Logout</a></div>
<h2 align="center">Admin Dash Board</h2>
	<div align="center">
		<a href="admin?action=listall">List All</a><br>
		<a href="admin?action=process">Process Loan</a><br>
	</div>
<jsp:include page="footer.jsp"/>
</body>
</html>