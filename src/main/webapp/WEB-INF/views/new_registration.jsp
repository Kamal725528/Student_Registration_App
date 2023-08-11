<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
  <%@ include file="menu.jsp" %>  
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
   <h2>Register your self...</h2>
   
  <form action="savereg" method="post">
     <pre>
        Name   <input type="text" name="name"><br>
        Email  <input type="email" name="email"><br>
        City   <input type="text" name="city"><br>
        Mobile <input type="text" name="mobile"> <br>
        <br>
        <input type="submit" value="save">
      </pre>
  </form>
  
   <br>
   <h4 style="color:red">
   <%
     if(request.getAttribute("msg")!=null){
    	 out.println(request.getAttribute("msg"));
     }
   %>
   </h4>
   
   

</body>
</html>