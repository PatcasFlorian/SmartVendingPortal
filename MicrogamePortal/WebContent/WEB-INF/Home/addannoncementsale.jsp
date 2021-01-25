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
<p style="color: Red">SuperAdmin :<c:out value="${fullName}"></c:out> </p>
<h3 id="myHeader" ><a href="view-sale.htm"><==Back</a> MicrogamePortal  <a href="login-portal.htm">. LogOut</a></h3>



<form method="post" action="Sales" enctype="multipart/form-data"> 
<div> 
	<label style ="color:red">Titlu Anunt:</label> <br>
	<input type="text" name="titluAnunt" size="50" /> 
	</div> 
	 <div class="form-group">
     <label style ="color:red">Text Anunt</label><br>
     <textarea class="form-control" rows="5" placeholder="Enter ..." name="textAnunt"  ></textarea>
       </div>
	<div> 
	<label style ="color:red">Pret Anunt:</label> <br>
	<input type="text" name="pretAnunt" size="50" /> 
	</div> 
	<label style ="color:red">Profile Photo1: </label> <br>
	<input type="file" name="photo1" size="50" /> 
	</div>
	<div> 
	<label style ="color:red">Profile Photo2: </label> <br>
	<input type="file" name="photo2" size="50" /> 
	</div>
	<div> 
	<label style ="color:red">Profile Photo3: </label> <br>
	<input type="file" name="photo3" size="50" /> 
	</div>
	<div> 
	<label style ="color:red">Profile Photo4: </label> <br>
	<input type="file" name="photo4" size="50" /> 
	</div>
	<div> 
	<label style ="color:red">Profile Photo5: </label> <br>
	<input type="file" name="photo5" size="50" /> 
	</div>
	<input type="submit" value="Save"> 
	</form> <br><br>
	
</body>
</html>