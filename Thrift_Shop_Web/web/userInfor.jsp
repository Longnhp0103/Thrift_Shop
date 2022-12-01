<%-- 
    Document   : userInfor
    Created on : Oct 5, 2022, 10:14:06 AM
    Author     : Admiz
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    
    <c:if test="${sessionScope.LOGIN_USER == null}"> 
            <c:redirect url="login.jsp"></c:redirect>
    </c:if> 
    <!--Header Start-->
    <jsp:include page="header.jsp"/>
    <!--Header End-->
    <section style="background-color: #eee;">
        <div class="container py-5">
            <div class="row">           
                <div class="col-lg-12">
                    <form action="MainController">
                        <div class="card mb-2">
                            <div class="card-body">

<!--                                <div class="row ">
                                    <div class="col-sm-3">
                                        <p class="mb-0">Username</p>
                                    </div>
                                    <div class="col-sm-9">
                                        <input type="text" name="userName" value="${sessionScope.LOGIN_USER.userName}" readonly="" class="text-muted mb-0 form-control form-control-sm border-0"/>
                                    </div>
                                </div>-->
                                <hr>
                                <div class="row">
                                    <div class="col-sm-3">
                                        <p class="mb-0">Full Name</p>
                                    </div>
                                    <div class="col-sm-9">
                                        <input type="text" name="fullName" value="${sessionScope.LOGIN_USER.fullName}" required="" class="text-muted mb-0 form-control form-control-sm border-0"/>
                                    </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-sm-3">
                                        <p class="mb-0">Email</p>
                                    </div>
                                    <div class="col-sm-9">
                                        <input type="text" name="email" value="${sessionScope.LOGIN_USER.email}" readonly="" class="text-muted mb-0 form-control form-control-sm border-0"/>
                                    </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-sm-3">
                                        <p class="mb-0">Phone</p>
                                    </div>
                                    <div class="col-sm-9">
                                        <input type="text" name="phone" value="${sessionScope.LOGIN_USER.phone}" required="" class="text-muted mb-0 form-control form-control-sm border-0"/>
                                    </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-sm-3">
                                        <p class="mb-0">Address</p>
                                    </div>
                                    <div class="col-sm-9">
                                        <input type="text" name="address" value="${sessionScope.LOGIN_USER.address}" required="" class="text-muted mb-0 form-control form-control-sm border-0"/>
                                    </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-sm-3">
                                        <p class="mb-0">Amount</p>
                                    </div>
                                    <div class="col-sm-9">                                  
                                        <a href="wallet.jsp" class="btn btn-outline-warning btn-sm">View Balances</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row mb-5">
                            <div class="col-sm-6 d-grid">
                                <input type="submit" name="action" value="Update" class="btn btn-success"/>
                            </div>

                            <div class="col-sm-6 d-grid">
                                <a href="change.jsp" class="btn btn-outline-success">Change Password</a>
                            </div>
                        </div>
                    </form>
                    ${requestScope.CHANGE_SUCCESS}
                    ${sessionScope.UPDATE_SUCCESS}                        
                    <div class="row mb-5">

                        
                    <!--                    <div class="col-md-12">
                                            <div class="card mb-4 mb-md-0">
                                                <div class="card-body">
                                                    <p class="mb-4"><span class="text-primary font-italic me-1">History Order</span>
                                                    </p>
                                                    <div class="row ">
                                                        <div class="col-sm-6">
                                                            <p class="mb-0">Iphone 13</p>
                                                        </div>
                                                        <div class="col-sm-3">
                                                            <p>10/10/2022</p>
                                                        </div>
                                                        <div class="col-sm-3 d-flex justify-content-end">
                                                            <p>$150</p>
                                                        </div>
                                                    </div>
                    
                                                    <div class="row ">
                                                        <div class="col-sm-6">
                                                            <p class="mb-0">Iphone 13</p>
                                                        </div>
                                                        <div class="col-sm-3">
                                                            <p>10/10/2022</p>
                                                        </div>
                                                        <div class="col-sm-3 d-flex justify-content-end">
                                                            <p>$150</p>
                                                        </div>
                                                    </div>
                                                    <div class="row ">
                                                        <div class="col-sm-6">
                                                            <p class="mb-0">Iphone 13</p>
                                                        </div>
                                                        <div class="col-sm-3">
                                                            <p>10/10/2022</p>
                                                        </div>
                                                        <div class="col-sm-3 d-flex justify-content-end">
                                                            <p>$150</p>
                                                        </div>
                                                    </div>
                                                    <div class="row ">
                                                        <div class="col-sm-6">
                                                            <p class="mb-0">Iphone 13</p>
                                                        </div>
                                                        <div class="col-sm-3">
                                                            <p>10/10/2022</p>
                                                        </div>
                                                        <div class="col-sm-3 d-flex justify-content-end">
                                                            <p>$150</p>
                                                        </div>
                                                    </div>
                                                    <div class="row ">
                                                        <div class="col-sm-6">
                                                            <p class="mb-0">Iphone 13</p>
                                                        </div>
                                                        <div class="col-sm-3">
                                                            <p>10/10/2022</p>
                                                        </div>
                                                        <div class="col-sm-3 d-flex justify-content-end">
                                                            <p>$150</p>
                                                        </div>
                                                    </div>
                                                    <div class="row ">
                                                        <div class="col-sm-6">
                                                            <p class="mb-0">Iphone 13</p>
                                                        </div>
                                                        <div class="col-sm-3">
                                                            <p>10/10/2022</p>
                                                        </div>
                                                        <div class="col-sm-3 d-flex justify-content-end">
                                                            <p>$150</p>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>-->
                </div>
            </div>
        </div>
    </section>
    <!-- Footer Start -->
    <jsp:include page="footer.jsp"/>
    <!-- Footer End -->

</html>
