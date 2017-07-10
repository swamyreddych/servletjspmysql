<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>show all users</title>
</head>
<body>
<table border =1 >
 <thead>
 <tr>
               <th>Userid</th>
                <th>fName</th>
                <th>lName</th>
                <th>dob</th>
                <th>email</th>
                <th>colspan = 2>action</th>
 </tr>
 </thead>
 <tbody>
 <c:forEach items ="${users }"  var = "user"> 
<tr>
 <td><c:out value="${user.userid }"/></td>
 <td><c:out value="${user.fname }"></c:out></td>
 <td><c:out value="${user.lname }"/></td>
 <td><c:out value="${user.dob }"></c:out></td>
 <td><c:out value="${user.email }"/></td>
 <td><a href = "UserController?action=delete&userId=<c:out value = "${user.userid}"/>">delete</a>
  <td><a href="UserController?action=edit&userId=<c:out value="${user.userid}"/>">edit</a></td>
 </tr>
 </c:forEach>
 </tbody>
 </table>
 <p><a href = "UserController?action=insert">add user</a></p>
</body>
</html>