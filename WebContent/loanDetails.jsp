<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.iiht.evaluation.eloan.model.LoanInfo" %>
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
<title>Loan Application Details</title>
</head>
<body>
<jsp:include page="header.jsp"/>
	<!-- write the code to display the loan status information 
	     received from usercontrollers' displaystatus method
	-->
	<div align="right" style="color:Tomato;"><a href="index.jsp">Logout</a></div>
	<div align="right"><a href="userhome1.jsp">Home Page</a></div>
	<%
		LoanInfo loanInfo = (LoanInfo)request.getAttribute("loaninfo");
	%>
	<div align="center">
		<h2>Application Details</h2>
		<table>
			<tr>
				<th>Loan Application Number</th>
				<td><%= loanInfo.getApplno()%></td>
			</tr>
			<tr>
				<th>Loan Purpose</th>
				<td><%= loanInfo.getPurpose()%></td>
			</tr>
			<tr>
				<th>Loan Amount requested</th>
				<td><%= loanInfo.getAmtrequest()%></td>
			</tr>
			<tr>
				<th>Application Date</th>
				<td><%= loanInfo.getDoa()%></td>
			</tr>
			<tr>
				<th>Business Structure</th>
				<td><%= loanInfo.getBstructure()%></td>
			</tr>
			<tr>
				<th>Business Indicator</th>
				<td><%= loanInfo.getBindicator()%></td>
			</tr>
			<tr>
				<th>Applicant Address</th>
				<td><%= loanInfo.getAddress()%></td>
			</tr>
			<tr>
				<th>Applicant Email</th>
				<td><%= loanInfo.getEmail()%></td>
			</tr>
			<tr>
				<th>Applicant Mobile Number</th>
				<td><%= loanInfo.getMobile()%></td>
			</tr>
			<tr>
				<th>Application Status</th>
				<td><%= loanInfo.getStatus()%></td>
			</tr>
		</table>
	</div>
<jsp:include page="footer.jsp"/>
</body>
</html>