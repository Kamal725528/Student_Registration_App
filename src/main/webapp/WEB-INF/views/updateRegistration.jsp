<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ include file="menu.jsp" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>update</title>
</head>
<body>
    <h3>Update the detail..</h3>
    <form action="updateReg" method="post">
     <pre>
        <br>
        Email  <input type="email" name="email" value="<%=request.getAttribute("email")%>"><br>
        Mobile <input type="text" name="mobile" value="<%=request.getAttribute("mobile")%>"> <br>
        <br>
        <input type="submit" value="update">
      </pre>
  </form>
  
   <br>
   

</body>
</html>