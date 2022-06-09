<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   
   <form action="/addEmployee">
   <input type="text" name="eid"></br>
   <input type="text" name="ename"></br>
   <input type="text" name="salary"></br>
   <input type="text" name="desiganation"></br>
   <input type="text" name="department"></br>
      <input type="submit">
   </form>
   
   
   </br>
   <form action="getEmployees">
   <input type="text" name="desiganation"></br>
   <input type="submit">
   </form>
</body>
</html>