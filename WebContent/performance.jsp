<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<style type="text/css">
table, th, td {
    border: 1px solid black;
}
</style>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Student</title>
</head>
<body>

 <table style="width:100%">
   <tr>
   <th>User ID: </th>
   <th>Exam Name : </th>
   <th>Score</th>
   <th>Appeared ON</th>
   </tr> 
     <c:forEach items="${getlist}" var="user">
    <tr>
        <td><c:out value="${user.name}"/></td>
        <td><c:out value="${user.examname}"/></td>  
        <td> <c:out value="${user.score}"/></td>  
        <td> <c:out value="${user.appearedon}"/></td>  
    </tr>
</c:forEach>
        
</table>
</body>
</html>