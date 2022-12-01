<%-- 
    Document   : login
    Created on : Sep 14, 2022, 3:42:26 PM
    Author     : Admiz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    </head>
    <style>
        /*style mở ra một khu vực để viết mã CSS*/
        body{
            font-family: "Cairo", sans-serif; background-color: black
        }
    </style>

    <section class="vh-100 gradient-custom">
        <div class="container py-5 h-100" >
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                    <div style="background-color: #a87e62" class="card text-dark" style="border-radius: 1rem;">
                        <div class="card-body p-5 text-center">

                            <div class="md-5 mt-md-4 ">

                                <h2 class="fw-bold mb-2 text-uppercase">Login</h2>
                                <p class="text-white-50 mb-5">Please enter your login and password!</p>
                                <form action="MainController" method="POST">
                                    <div class="form-outline form-white mb-4">
                                        <label class="form-label" for="typeUsername">Username</label>
                                        <input type="text" name="userName" class="form-control form-control-lg"/>

                                    </div>

                                    <div class="form-outline form-white mb-4">
                                        <label class="form-label" for="typePasswordX">Password</label>
                                        <input type="password" name="password" class="form-control form-control-lg" />

                                    </div>

                                    <p class="small mb-3 pb-lg-2"><a class="text-white-50" href="#!">Forgot password?</a></p>


                                    <input type="submit" name="action" value="Login" class="btn btn-outline-light btn-lg px-5"/>
                                </form>
                                ${ERROR}
                                ${REGISTER_SUCCESS}
                                <div class="d-flex justify-content-center text-center mt-4 mb-3 pt-1">

                                    <a href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8084/SWP-Thrift-Shop/LoginGoogleHandler&response_type=code
                                       &client_id=141214771854-33rnar1snvr2bv4b32bmqsafl4aopssn.apps.googleusercontent.com&approval_prompt=force" class="text-white"><i style="font-size:30px" class="fab fa-google fa-lg"></i></a>
                                </div>

                            </div>

                            <div>
                                <p class="mb-0">Don't have an account? <a href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8084/SWP-Thrift-Shop/RegisterGoogleController&response_type=code
                                       &client_id=141214771854-33rnar1snvr2bv4b32bmqsafl4aopssn.apps.googleusercontent.com&approval_prompt=force" class="text-white-50 fw-bold">Sign Up</a>
                                </p>
                                <a href="index.jsp">Home</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

</html>
