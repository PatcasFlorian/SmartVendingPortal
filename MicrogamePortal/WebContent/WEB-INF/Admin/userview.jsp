<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
       <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>microgameportal</title>


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
<h3 id="myHeader" > <a style="color:red" href="back-userlist.htm"><==Back</a> MicrogamePortal  <a style="color:red" href="login-portal.htm">. LogOut</a></h3>
<h3 id="myHeader"><button id="button2" onclick="location.href='administrare-locatii.htm'" type="button">ListareAnuntVanzare</button><button id="button2" onclick="location.href='administrare-locatii.htm'" type="button">ListareAnuntCumparare</button><button id="button2" onclick="location.href='administrare-locatii.htm'" type="button">ListareBlackList</button><button id="button2" onclick="location.href='administrare-locatii.htm'" type="button">ListareComentariiForum</button>  </h3>

<table id="Stable" class="center" >
 <caption style="color: Tomato" >Vizualizare/Editare User</caption>
 
<caption style=" background: #245f91;color:#eee;text-align: center;padding: 10px;border-radius: 55px;font-weight: bold;" > Organizator : Microgame srl<br>Oradea Str Muntele Gaina Nr.18,Bihor</caption>
  <tr>
     <th>NR.</th>
    <th>Ful Name</th>
    <th>Phone Number</th>
    <th>Company Name</th>
    <th>VAT Number</th>
    <th>Nr. ONRC </th>
     <th>Company Adress</th>
      <th>Email</th>
       <th>Role</th>
        <th>Statut</th>
    
    </tr>
       <form:form action="update-rolestatute.htm?fullName=${user.fullName}" metod="post" commandName="updateUser">
    <tr> 
      
     <td style="color: Red" ><c:out value="${user.id}"></c:out></td>  
  <td style="color: Green"><c:out value="${user.fullName}"></c:out></td>
  
   <td style="color: Green"><c:out value="${user.phoneNumber}"></c:out>
   
  <label for="fname"></label>
  <input type="text" id="phoneNumber" name="phoneNumber"> 
 
  </td>
  <td style="color: Green"><c:out value="${user.companyName}"></c:out>
  
  <label for="fname"></label>
  <input type="text" id="companyName" name="companyName"> 
 
  </td>
  <td style="color: Green"><c:out value="${user.vatNumber}"></c:out>
 
  <label for="fname"></label>
  <input type="text" id="vatNumber" name="vatNumber"> 
  
  </td>
  <td style="color: Green"><c:out value="${user.nrOnrc}"></c:out>
  
  <label for="fname"></label>
  <input type="text" id="nrOnrc" name="nrOnrc"> 
 
  </td>
  <td style="color: Green"><c:out value="${user.companyAdress}"></c:out>
  
  <label for="fname"></label>
  <input type="text" id="companyAdress" name="companyAdress"> 
  </td>
  <td style="color: Green"><c:out value="${user.email}"></c:out>
<label for="fname"></label>
  <input type="text" id="email" name="email"> 
  </td>
  <td style="color: Green">
 
  <label for="role1"><c:out  value="${user.role1}"></c:out></label>
  <input list="browsers" name="role1" id="browser">
  <datalist id="browsers">
    <option value="ADMIN">
    <option value="USER">
  </datalist>
  </td>
  <td style="color: Green">
  <label for="role1"><c:out  value="${user.statute1}"></c:out></label>
  <input list="browsers1" name="statute1" id="browser1">
  <datalist id="browsers1">
    <option value="ACTIVE">
    <option value="FORBIDDEN">
  </datalist>
  <td style="color: Green">
   </td>
 </table>
 <input type="submit" value="Salveaza"/>
</form:form>
</body>
</html>