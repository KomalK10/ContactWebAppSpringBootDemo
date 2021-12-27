
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<html lang="en">
 <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Registration Page</title>
        <link href="css/styles.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
    </head>
    <body class="bg-secondary">
        <div id="layoutAuthentication">
            <div id="layoutAuthentication_content">
                <main>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-5">
                                <div class="card shadow-lg border-0 rounded-lg mt-5">
                                    <div class="card-header"><h3 class="text-center font-weight-light my-4">Create Account</h3></div>
                                    <div class="card-body">
                                        <form:form method="post" action="register" modelAttribute="user"> 
                                            <p style="color: red;">${message}</p>
                                               
                                                    <div class="form-floating mb-3">
                                                        <input class="form-control" name="profileName" id="profileName" type="text" placeholder="Enter your Profile name" />
                                                        <form:errors path="profileName" style="font-style: italic; color: red;"/>
                                                        <label for="inputFirstName">Profile name</label>
                                                    </div>
                                                
                                                    <div class="form-floating mb-3">
                                                        <input class="form-control" name="username" id="username" type="text" placeholder="Enter your last name" />
                                                        <form:errors path="username" style="font-style: italic; color: red;"/>
                                                        <label for="inputLastName">User name</label>
                                                    </div>
                                              
                                                    <div class="form-floating mb-3">
                                                        <input class="form-control" name="password" id="password" type="password" placeholder="Create a password" />
                                                        <form:errors path="password" style="font-style: italic; color: red;"/>
                                                        <label for="inputPassword">Password</label>
                                                    </div>
                                             
                                                
                                           
                                            <div class="mt-4 mb-0">
                                                <div class="d-grid"><input class="btn btn-primary" type="submit" align="right" value="Create Account"></div>
                                            </div>
                                        </form:form>
                                    </div>
                                    <div class="card-footer text-center py-3">
                                        <div class="small"><a href="login">Have an account? Go to login</a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
           
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
    </body>
</html>