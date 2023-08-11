<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
</head>
<body>
   
   <h2>Please login here...</h2>
   
   <form action="login" method="post">
   
    username <input type="email" name="email"><br>
    password <input type="password" name="password"><br>
    <input type="submit" value="login">
  
   </form>
   <br>
   <% if(request.getAttribute("error")!=null){
	   out.println(request.getAttribute("error"));
	   
       }
	%>
   
   
   
   
</body>
</html>