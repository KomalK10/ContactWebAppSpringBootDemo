<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value=""/>

<!DOCTYPE html>
<html lang="en">
 <head>
 <style>
body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.hero-image {
  background-image: url("/images/Contactimg.jpg");
  background-color: #cccccc;
  height: 720px;
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  position: relative;
}

.hero-text {
  text-align: center;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  color: white;
}
</style>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Login Page</title>
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
                                    <div class="card-header"><h3 class="text-center font-weight-light my-4">Login</h3></div>
                                    <div class="card-body">
                                     <form:form method="POST" action="login" modelAttribute="user" >
                                     		<p style="color: red;">${errorMsg}</p>
                                            <div class="form-floating mb-3">
                                             	 <input name="username" type="text" class="form-control" placeholder="Username" /> <form:errors path="username" style="color: red;" />
												 <label for="User Name">User Name</label>
                                            </div>
                                            <div class="form-floating mb-3">
                                                <input name="password" type="password" class="form-control" placeholder="Password"/> <form:errors path="password" style="color: red;"/>
                                                <label for="Password">Password</label>
                                            </div>
                                           <div class="d-flex align-items-center justify-content-between mt-4 mb-0">
                                              
                                                <input class="btn btn-primary" type="submit" align="right" value="Login">
                                            </div>
                                        </form:form>
   		
 									</div>
                                    <div class="card-footer text-center py-3">
                                        <div class="small"><a href="register">Need an account? Sign up!</a></div>
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