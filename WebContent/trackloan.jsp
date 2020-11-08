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
<title>Track Loan Application</title>
</head>
<body>
<jsp:include page="header.jsp"/>
	<!-- write html code to read the application number and send to usercontrollers'
             displaystatus method for displaying the information
	-->
	<div align="right"><a href="index.jsp">Logout</a></div>
	<div align="right"><a href="userhome1.jsp">Home Page</a></div>
	<form action="user?action=displaystatus" method="post">
		<h2 align="center">Enter Application Number</h2>
		<table>
			<tr>
				<td align="center"><input type="text" name="applicationNumber" required/></td>
		    </tr>
		    <tr>
		    	<td align="center"><input type="submit" value="submit" required/></td>
		    </tr>
		</table>
	</form>
<jsp:include page="footer.jsp"/>
</body>
</html>