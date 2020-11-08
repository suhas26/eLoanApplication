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
<title>Loan Application Form</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
</head>
<body onload="myFunction()">
<jsp:include page="header.jsp"/>
<!--
	write the html code to accept laon info from user and send to placeloan servlet
-->
	<div align="right"><a href="index.jsp">Logout</a></div>
	<div align="right"><a href="userhome1.jsp">Home Page</a></div>
	
	<% 
	if (request.getAttribute("message")!=null){
		String message = request.getAttribute("message").toString();
		String applicationNumber = request.getAttribute("applicationNumber").toString();
	%>
		<h2 style="color:red;"><%=message %></h2>
		<h2 style="color:red;"><%=applicationNumber %></h2>
	<% //request.setAttribute("message","");
		//request.setAttribute("applicationNumber","");
	} %>
	<div align="center">
		<form action="user?action=placeloan" method="post">
			<h2>Loan Application Form</h2>
			<table>
				<tr>
					<td><label>Purpose</label></td>
					<td><input type="text" name="purpose" required/></td>
				</tr>
			    <tr>
					<td><label>Loan Amount Requested</label></td>
					<td><input type="text" name="amtrequest" required/></td>
			    </tr>
			    <tr>
					<td><label>Loan Application Date</label></td>
					<td><input type="text" name="applicationDate" required/></td>
			    </tr>
			    <tr>
					<td><label>Business Structure</label></td>
					<td><input type="radio" name="businessStructure" value="individual" required>Individual 
			 		<input type="radio" name="businessStructure" value="organization" required>Organization</td>
			    </tr>
			    <tr>
					<td><label>Billing Indicator</label></td>
					<td><input type="radio" name="billingIndicator" value="salaried" required>Salaried 
			 		<input type="radio" name="billingIndicator" value="notSalaried" required>Not Salaried</td>
			    </tr>
			    <tr>
					<td><label>Contact Address</label></td>
					<td><input type="text" name="contactAddress" required/></td>
			    </tr>
			    <tr>
					<td><label>Mobile Number</label></td>
					<td><input type="text" name="mobileNumber" required/></td>
			    </tr>
			    <tr>
					<td><label>Email Address</label></td>
					<td><input type="text" name="emailAddress" required/></td>
			    </tr>
			    <tr>
			    	<td></td>
			    	<td><input type="submit" value="submit" required/></td>
			    </tr>
			    
			</table>
		</form>
	</div>
	
<jsp:include page="footer.jsp"/>
</body>
</html>