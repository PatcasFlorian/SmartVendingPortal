<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>viewsale</title>
 <!-- Font Awesome -->
  <link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  <!-- overlayScrollbars -->
  <link rel="stylesheet" href="dist/css/adminlte.min.css">
  <!-- Google Font: Source Sans Pro -->
  <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">

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
<h3 id="myHeader" ><a href="back-userlist.htm"><==Back</a> MicrogamePortal  <a href="login-portal.htm">. LogOut</a></h3>
<h3 id="myHeader"><button id="button2" onclick="location.href='add-sale.htm'" type="button">AdaugaAnuntVanzare</button><button id="button2" onclick="location.href='administrare-locatii.htm'" type="button">AnunturileMeleCumparare</button><button id="button2" onclick="location.href='administrare-locatii.htm'" type="button">MyBlackList</button><button id="button2" onclick="location.href='administrare-locatii.htm'" type="button">MyForumList</button>  </h3>
 
 
 <div class="card card-solid">
 
 
        <div class="card-body pb-0">
          <div class="row d-flex align-items-stretch">
     
             
             <c:forEach var="anunt" items="${model.listAnunt}">
              <div class="col-12 col-sm-8 col-md-2 d-flex align-items-stretch">
              <div class="card bg-light">
                <div class="card-header text-muted border-bottom-7 ">
                  Titlu Anunt:<br>
                  <c:out value="${anunt.titluAnunt}"></c:out>
                </div>
                <div class="card-body pt-0">
                  <div class="row">
                    <div class="col-7">
                      <h2 class="lead">Data Anuntului:<br>
                        <c:out value="${anunt.dataAnunt}"></c:out>
                      </h2>
                      <p class="text-muted text-sm"><b>Stare Anunt: </b><br>  <c:out value="${anunt.statute}"></c:out></p>
                       <p class="text-muted text-sm"><b>Pret: </b><br>  <c:out value="${anunt.pretAnunt}"></c:out></p>
                      <ul class="ml-4 mb-0 fa-ul text-muted">
                        <li class="small"><span class="fa-li"><i class="fas fa-lg fa-building"></i></span> Address : <br><c:out value="${model.user.companyAdress}"></c:out></li>
                        <li class="small"><span class="fa-li"><i class="fas fa-lg fa-phone"></i></span> Phone : <br><c:out value="${model.user.phoneNumber}"></c:out></li>
                      </ul>
                    </div>
                    <div class="col-5 text-center">
                      <img src="../../dist/img/user1-128x128.jpg" alt="" class="img-circle img-fluid">
                    </div>
                  </div>
                </div>
                <div class="card-footer">
                  <div class="text-right">
                    
                    <a href="anunt-vanzare.html" class="btn btn-sm btn-primary">
                      <i class="fas fa-user"></i> Vizualizare/Editare Anunt
                    </a>
                  </div>
                </div>
              </div>
               </div>
               </c:forEach>
           
          </div>
          
        </div>
        
    </div>
    
      <!-- /.card -->
<footer id="myHeader" style="background-color:powderblue;">
    <div class="float-right d-none d-sm-block">
      <b>Version</b> 3.0.5
    </div>
    <strong>Copyright &copy; 2020-2025 .</strong> All rights
    reserved.
  </footer>

<!-- jQuery -->
<script src="plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="dist/js/demo.js"></script>
</body>
</html>
