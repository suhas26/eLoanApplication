<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
	
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
		margin-top: 25px;
		padding-top: 50px;
	    width: 300px;
	    margin: 0 auto;
	}
</style>
<title>eLoan system</title>
</head>
<body>
	<!-- write the html code to read user credentials and send it to validateservlet
	    to validate and user servlet's registernewuser method if create new user
	    account is selected
	-->
	<div align="center">
		<form action="user?action=validate" method="post">
			<table>
				<tr>
					<td><label>Username</label></td>
					<td><input type="text" name="username" required/></td>
				</tr>
				<tr>
					<td><label>Password</label></td>
					<td><input type="password" name="password" required/></td>
			    </tr>
			    <tr>
			    	<td></td>
			    	<td><input type="submit" value="submit" required/></td>
			    </tr>
			    <tr>
			    <td>New User ?</td>
			    <td><a href="register.jsp">Register</a></td>
			    </tr>
			</table>
		</form>
	</div>
	
</body>
</html>