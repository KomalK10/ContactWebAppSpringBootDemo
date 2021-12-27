
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>User Page</title>
        <link href="css/styles.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
    </head>
<body class="sb-nav-fixed">
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <!-- Navbar Brand-->
              <h1 class="navbar-brand ps-3"> ${profileName}</h1>
            <!-- Sidebar Toggle-->
            <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i class="fas fa-bars"></i></button>
            <!-- Navbar Search-->
            <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
                <div class="input-group">
                    <input class="form-control" type="text" placeholder="Search for..." aria-label="Search for..." aria-describedby="btnNavbarSearch" />
                    <button class="btn btn-primary" id="btnNavbarSearch" type="button"><i class="fas fa-search"></i></button>
                </div>
            </form>
            <!-- Navbar-->
            <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                        
                        <li><a class="dropdown-item" href="#!">Logout</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-light" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                           
                            <a class="nav-link" href="userContact?userId=${userId}">
                                
                                Add New Contact
                            </a>
                            
                        </div>
                    </div>
                    
            </div>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">Add New Contact</h1>
                        
                        <div class="card mb-4">
                            <div class="card-body">
        						<form:form method="post" action="userContact" modelAttribute="contact" >
        						<input type="hidden" value="${userId}" name="userId">
        							<div class="form-group row mb-3">
    									<label for="First Name" class="col-sm-2 col-form-label">First Name</label>
    										<div class="col-sm-5">
      											<form:input class="form-control" path="firstName" id="firstName" />
      											<form:errors path="firstName" style="font-style: italic; color: red;"/>
    										</div>
    								</div>
    								<div class="form-group row mb-3">
    									<label for="Last Name" class="col-sm-2 col-form-label">Last Name</label>
    										<div class="col-sm-5">
      											<form:input class="form-control" path="lastname" id="lastname" />
      											<form:errors path="lastname" style="font-style: italic; color: red;"/>
    										</div>
    								</div>
    								<div class="form-group row mb-3">
    									<label for="Email" class="col-sm-2 col-form-label">Email</label>
    										<div class="col-sm-5">
      											<form:input class="form-control" path="email" id="email" />
      											<form:errors path="email" style="font-style: italic; color: red;"/>
    										</div>
    								</div>
    								<div class="form-group row mb-3">
    									<label for="Mobile No" class="col-sm-2 col-form-label">Mobile No</label>
    										<div class="col-sm-5">
      											<form:input class="form-control" path="mobile" id="mobile" />
      											<form:errors path="mobile" style="font-style: italic; color: red;"/>
    										</div>
    								</div>
    								 <div class="col-sm-5">
                                              
                                                <input class="btn btn-primary" type="submit" value="Add Contact">
                                            	<a class="btn btn-primary" href="viewContact?userId=${userId}" role="button">Back</a>
                                            </div>
        								
        						</form:form>
                            </div>
                        </div>
                    </div>
                </main>
                
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="js/datatables-simple-demo.js"></script>
    </body>
</html>