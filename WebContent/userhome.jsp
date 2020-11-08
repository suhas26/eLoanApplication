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
<title>user home</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h4>User Dash Board</h4>
	<div align="right"><a href="index.jsp">Logout</a></div>
	<a href="user?action=application">Apply for Loan</a><br>
	<a href="trackloan.jsp">Track Loan Applicatiion</a><br>
	<a href="editloan.jsp">Edit Loan Application</a>
<jsp:include page="footer.jsp"/>
</body>
</html>