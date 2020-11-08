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
<title>Registration</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<script>
function myFunction() {
  alert("User registered successfully.\nLogin with new Credentials.");
}
</script>
<hr/>
<div align=center>
	<h2>eLoan Login</h2>
	<form action="user?action=registernewuser" method="post">
		<div>
			<div><label for="loginid">Enter login Id</label> </div>
			<div><input type="text" id="username" name="username" required> </div>
		</div>
		<div>
			<div><label for="password">Enter password</label> </div>
			<div><input type="text" id="password" name="password" required> </div>
		</div>
		<div>
			<div><input type="submit" value="submit" onclick="myFunction()"></div>
		</div>
		<%--<a href="user?action=registernewuser">New User? register here</a> --%>
	</form>
	</div>
<hr/>
<jsp:include page="footer.jsp"/>
</body>
</html>