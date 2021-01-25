<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
      <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>


<link rel="stylesheet" type="text/css" href="Comun/lista-style.css">

<style type="text/css">
table.center {
  margin-left:auto; 
  margin-right:auto;
}
</style>
<style>
a:hover {
  background-color: yellow;
 
}
</style>
</head>
<body id="myBody">
<p style="color: Red">SuperAdmin :<c:out value="${myUser}"></c:out> </p>
<h3 id="myHeader"> <a style="color:red" href="home.htm"  metod="post" commandName="isLogin"  >DashBoard</a>  MicrogamePortal  <a  style="color:red" href="login-portal.htm">. LogOut</a> </h3>
<table id="Stable" class="center">
 <caption style="color: Tomato" >Lista cu utilizatori</caption>
<caption style=" background: #245f91;color:#eee;text-align: center;padding: 10px;border-radius: 55px;font-weight: bold;" > Organizator : Microgame srl<br>Oradea Str Muntele Gaina Nr.18,Bihor</caption>
  <tr>
     <th>NR.</th>
    <th>Full Name</th>
    <th>Phone Number</th>
    <th>Company Name</th>
    <th>VAT Number</th>
    <th>Nr. ONRC </th>
     <th>Company Adress</th>
      <th>Email</th>
       <th>Role</th>
        <th>Statut</th>
    
    </tr>
     <c:forEach var="user" items="${model.userList1 }">  
     
    <tr> 
     <td style="color: Red" ><c:out value="${user.id}"></c:out></td>  
  <td style="color: Green"><a style="color: Blue" href ="<c:url value='edit-user.htm?fullName=${user.fullName}'/>"><c:out value="${user.fullName}"></c:out></a></td>
  <td style="color: Green"><c:out value="${user.phoneNumber}"></c:out></td>
  <td style="color: Green"><c:out value="${user.companyName}"></c:out></td>
  <td style="color: Green"><c:out value="${user.vatNumber}"></c:out></td>
  <td style="color: Green"><c:out value="${user.nrOnrc}"></c:out></td>
  <td style="color: Green"><c:out value="${user.companyAdress}"></c:out></td>
   <td style="color: Green"><c:out value="${user.email}"></c:out></td>
    <td style="color: Green"><c:out  value="${user.role1}"></c:out></td>
     <td style="color: Green"> <c:out  value="${user.statute1}"></c:out> </td>
  </tr>
  
  </c:forEach>
 
</body>
</html>