<%-- 
    Document   : register
    Created on : Sep 14, 2022, 3:42:47 PM
    Author     : Admiz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>ThriftShop</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    </head>

    <section class="vh-100 gradient-custom">
        <div class="container py-5 h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                    <div class="card bg-dark text-white" style="border-radius: 1rem;">
                        <div class="card-body p-5 text-center">

                            <div class="md-5 mt-md-4 pb-5">

                                <h2 class="fw-bold mb-2 text-uppercase">Register</h2>

                                <form action="MainController" method="POST">
<!--                                    <div class="form-outline form-white mb-4 mt-4">

                                        <input type="text" name="userName" required="" class="form-control form-control-lg" placeholder="Username" />
                                        ${requestScope.USER_ERROR.userNameError}
                                    </div>
-->                                 <div class="form-outline form-white mb-4">

                                        <input type="text" name="fullName" required="" class="form-control form-control-lg" placeholder="Full Name" />
                                        ${requestScope.USER_ERROR.fullNameError}
                                    </div>
                                    <div class="form-outline form-white mb-4">

                                        <input type="email" name="email" required="" class="form-control form-control-lg" placeholder="${sessionScope.EMAIL}" value="${sessionScope.EMAIL}" />
                                    </div>
<!--                                    <div class="form-outline form-white mb-4">

                                        <input type="password" name="password" required="" class="form-control form-control-lg" placeholder="Password" />
                                    </div>
                                    <div class="form-outline form-white mb-4">

                                        <input type="password" name="confirm" required="" class="form-control form-control-lg" placeholder="Confirm" />
                                        ${requestScope.USER_ERROR.confirmError}
                                    </div>-->
                                    <div class="form-outline form-white mb-4">

                                        <input type="number" name="phone" class="form-control form-control-lg" placeholder="Phone"/>
                                    </div>

                                    <div class="form-outline form-white mb-4">

                                        <input type="text" name="address" class="form-control form-control-lg" placeholder="Address" />
                                    </div>
                                    
                                    <input type="submit" name="action" value="Register" class="btn btn-outline-light btn-lg px-5"/>
                                    <input type="reset"  value="Reset" class="btn btn-outline-light btn-lg px-5"/>
                                </form>
                            </div>

                            <div>
                                <p class="mb-0">Already have an account? <a href="login.jsp" class="text-white-50 fw-bold">Sign In</a>
                                </p>            
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

</html>
