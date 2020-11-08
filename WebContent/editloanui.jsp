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
<title>Edit Loan UI</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<!-- <div align="right"><a href="adminhome1.jsp">Admin Home</a></div>-->

<script>
function myFunction() {
  alert("Loan Application edited successfully");
}
</script>

<div align="right"><a href="index.jsp">Logout</a></div>
<div align="right"><a href="userhome1.jsp">Home Page</a></div>
	
	<%
		LoanInfo loanInfo = (LoanInfo)request.getAttribute("loaninfo");
	%>
	<div>
		<form action="user?action=editLoanProcess" method="post">
			<h2 align="center">Application Details</h2>
			<table>
				<tr>
					<th>Loan Application Number</th>
					<td><input id="applicationNo" name="applicationNo" value="<%= loanInfo.getApplno()%>" required readonly></input></td>
				</tr>
				<tr>
					<th>Loan Purpose</th>
					<td><input type="text" id="purpose" name="purpose" value="<%= loanInfo.getPurpose()%>" required></td>
				</tr>
				<tr>
					<th>Loan Amount requested</th>
					<td><input type="text" id="amtrequest" name="amtrequest" value="<%= loanInfo.getAmtrequest()%>" required></td>
				</tr>
				<tr>
					<th>Application Date</th>
					<td><input type="text" id="applicationDate" name="applicationDate" value="<%= loanInfo.getDoa()%>" required></td>
				</tr>
				<tr>
					<th>Business Structure</th>
					<td><input type="text" id="businessStructure" name="businessStructure" value="<%= loanInfo.getBstructure()%>" required></td>
				</tr>
				<tr>
					<th>Business Indicator</th>
					<td><input type="text" id="billingIndicator" name="billingIndicator" value="<%= loanInfo.getBindicator()%>" required></td>
				</tr>
				<tr>
					<th>Applicant Address</th>
					<td><input type="text" id="contactAddress" name="contactAddress" value="<%= loanInfo.getAddress()%>" required></td>
				</tr>
				<tr>
					<th>Applicant Email</th>
					<td><input type="text" id="emailAddress" name="emailAddress" value="<%= loanInfo.getEmail()%>" required></td>
				</tr>
				<tr>
					<th>Applicant Mobile Number</th>
					<td><input type="text" id="mobileNumber" name="mobileNumber" value="<%= loanInfo.getMobile()%>" required></td>
				</tr>
				<tr>
					<th>Application Status</th>
					<td><%= loanInfo.getStatus()%></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="submit" onclick="myFunction()" required/></td>
				</tr>
			</table>
		</form>
	</div>
<jsp:include page="footer.jsp"/>
</body>
</html>