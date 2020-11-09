<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
 <%@ page import="com.iiht.evaluation.eloan.dto.LoanDto" %>
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
<title>Approve Loan Page</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<script>
function myFunction() {
  alert("Loan Approved successfully");
}
</script>
 <!--
     Read the values from the admin servlet and cal emi and other details and send to
     to the same admin servlet to update the values in the database 
  -->  
  <div align="right"><a href="adminhome1.jsp">Home Page</a></div>
	<h2 align="center">Loan Details</h2>
	
	<%
	LoanDto loanDto = (LoanDto)request.getAttribute("loanDto");
	if(loanDto.getStatus().equals("Approved")) {
		%>
		<h2 align="center" style="color:white;background-color:red;">Loan Already Approved.</h2>
		<h2 align="center" style="color:white;background-color:red;">Cannot Approve again.</h2>
	<% } %>
	<div>
		<form action="admin?action=updatestatus" method="post">
			<table>
				<tr>
					<th>Loan Application Number</th>
					<td><input id="applicationNo" name="applicationNumber" value="<%= loanDto.getApplno()%>" required readonly></input></td>
				</tr>
				<tr>
					<th>Loan Purpose</th>
					<td><input type="text" id="purpose" name="purpose" value="<%= loanDto.getPurpose()%>" required readonly></td>
				</tr>
				<tr>
					<th>Loan Amount requested</th>
					<td><input type="text" id="amtrequest" name="amtSanctioned" value="<%= loanDto.getAmtSanctioned()%>" required></td>
				</tr>
				<tr>
					<th>Term of Loan</th>
					<td><input type="text" id="term" name="term" value="<%= loanDto.getTerm()%>" required></td>
				</tr>
				<tr>
					<th>Interest Rate</th>
					<td><input type="text" id="interestRate" name="interestRate" value="<%= loanDto.getInterestRate()%>" required></td>
				</tr>
				<tr>
					<th>EMI</th>
					<td><input type="text" id="emi" name="emi" value="<%= loanDto.getEmi()%>" required></td>
				</tr>
				<tr>
					<th>Payment Start Date</th>
					<td><input type="text" id="paymentStartDate" name="paymentStartDate" value="<%= loanDto.getStartDate()%>" required></td>
				</tr>
				<tr>
					<th>Payment End Date</th>
					<td><input type="text" id="paymentEndDate" name="paymentEndDate" value="<%= loanDto.getEndDate()%>" required></td>
				</tr>
				<tr>
					<th>Application Status</th>
					<td><%= loanDto.getStatus()%></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Approve Loan" onclick="myFunction()" required/></td>
				</tr>
			</table>
		</form>
	</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
