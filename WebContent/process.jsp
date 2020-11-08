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
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"/>
	<!-- write the code to read application number, and send it to admincontrollers
	     callemi method to calculate the emi and other details also provide links
	     to logout and admin home page
	-->
	
	<div align="right"><a href="index.jsp">Logout</a></div>
	<div align="right"><a href="adminhome1.jsp">Home Page</a></div>
	<% 
	if (request.getAttribute("message")!=null){
		String message = request.getAttribute("message").toString();
	%>
		<h2 align="center" style="color:white;background-color:red;"><%=message %></h2>
	<% } %>
	
	<form action="admin?action=callemi" method="post">
	<h2>Enter Application Number</h2>
		<table>
			<tr>
				<td><label>Application Number</label></td>
			</tr>
			<tr>
				<td align="center"><input type="text" name="applicationNumber" required/></td>
		    </tr>
		    <tr>
				<td align="center"><label>Term</label></td>
			</tr>
			<tr>
				<td align="center"><input type="text" name="term" required/></td>
		    </tr>
		    <tr>
				<td align="center"><label>Interest Rate</label></td>
			</tr>
			<tr>
				<td align="center"><input type="text" name="interestRate" required/></td>
		    </tr>
		    <tr>
		    	<td align="center"><input type="submit" value="submit" required/></td>
		    </tr>
		</table>
	</form>
<jsp:include page="footer.jsp"/>
</body>
</html>