<%-- 
    Document   : header
    Created on : Nov 2, 2022, 4:52:28 PM
    Author     : LENOVO
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>ThriftShop</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="Free HTML Templates" name="keywords">
        <meta content="Free HTML Templates" name="description">

        <!-- Favicon -->
        <link href="img/favicon.ico" rel="icon">

        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet"> 

        <!-- Font Awesome -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

        <!-- Libraries Stylesheet -->
        <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

        <!-- Customized Bootstrap Stylesheet -->
        <link href="css/style.css" rel="stylesheet">

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    </head>
    <body>
        <!-- Topbar Start -->
        <div class="container-fluid">
            <div class="row align-items-center py-3 px-xl-5">
                <div class="col-lg-3 d-none d-lg-block">
                    <a href="MainController?action=Home" class="text-decoration-none">
                        <h1 class="m-0 display-5 font-weight-semi-bold"><span class="text-primary font-weight-bold border px-3 mr-1">Thrift</span>Shop</h1>
                    </a>
                </div>
                <div class="col-lg-6 text-left">
                    <form action="MainController" method="post">
                        <div class="input-group">
                            <input name="search" type="text" class="form-control" placeholder="Search for products" value="${param.search}">
                            <div class="input-group-append">
                                <button type="submit" name="action" value="Search" class="input-group-text bg-transparent text-primary">
                                    <i class="fa fa-search"></i>
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="col-lg-3 text-right">              
                    <a href="post" class="btn border">
                        <i class="fa-solid fa-pen-to-square text-primary"></i>
                    </a>
                </div>
            </div>
        </div>
        <!--Topbar End--> 


        <!--Navbar Start -->
        <div class="container-fluid">
            <div class="row border-top px-xl-5">
                <div class="col-lg-3 d-none d-lg-block">
                    <a class="btn shadow-none d-flex align-items-center justify-content-between bg-primary text-white w-100" data-toggle="collapse" href="#navbar-vertical" style="height: 65px; margin-top: -1px; padding: 0 30px;">
                        <h6 class="m-0">Categories</h6>
                        <i class="fa fa-angle-down text-dark"></i>
                    </a>
                    <nav class="collapse position-absolute navbar navbar-vertical navbar-light align-items-start p-0 border border-top-0 border-bottom-0 bg-light" id="navbar-vertical" style="width: calc(100% - 30px); z-index: 1;">
                        <div class="navbar-nav w-100 overflow-hidden" style="height: 245px">
                            <c:forEach items="${listCategory}" var="cat">
                                <a href="MainController?action=Category&categoryID=${cat.categoryID}" class="nav-item nav-link">${cat.categoryName}</a>
                            </c:forEach>
                        </div>
                    </nav>
                </div>
                <div class="col-lg-9">
                    <nav class="navbar navbar-expand-lg bg-light navbar-light py-3 py-lg-0 px-0">
                        <a href="" class="text-decoration-none d-block d-lg-none">
                            <h1 class="m-0 display-5 font-weight-semi-bold"><span class="text-primary font-weight-bold border px-3 mr-1">Thrift</span>Shop</h1>
                        </a>
                        <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                            <div class="navbar-nav mr-auto py-0">
                                <a href="MainController?action=Home" class="nav-item nav-link active">Home</a>
                                <a href="MainController?action=Shop" class="nav-item nav-link">Shop</a>
                                <c:if test="${sessionScope.LOGIN_USER != null}">
                                    <a href="MainController?action=User&type=Sell" class="nav-item nav-link">Sell Items</a>
                                    <a href="MainController?action=User&type=Buy" class="nav-item nav-link">Purchased Items</a>
                                </c:if>
                            </div>
                            <div class="navbar-nav ml-auto py-0">
                                <c:if test="${sessionScope.LOGIN_USER != null}">
                                    <a href="userInfor.jsp" class="nav-item nav-link">${sessionScope.LOGIN_USER.fullName}</a>
                                    <c:url var="logoutLink" value="MainController" >
                                        <c:param name="action" value="Logout"></c:param>
                                    </c:url>
                                    <a href="${logoutLink}" class="nav-item nav-link">Logout</a>
                                </c:if>
                                <c:if test="${sessionScope.LOGIN_USER == null}">
                                    <div class="navbar-nav ml-auto py-0">
                                        <a href="login.jsp" class="nav-item nav-link">Login</a>
                                        <a href="register.jsp" class="nav-item nav-link">Register</a>
                                    </div>
                                </c:if>
                            </div>
                        </div>
                    </nav>
                </div>
            </div>
        </div>
        <!-- Navbar End -->
    </body>
</html>
