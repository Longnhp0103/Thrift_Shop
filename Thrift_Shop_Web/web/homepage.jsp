<%-- x
    Document   : home
    Created on : Oct 14, 2022, 5:04:47 PM
    Author     : Le Nguyen Nhat Minh
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
                <!--Search-->
                <div class="col-lg-6 col-6 text-left">
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
                <c:if test="${sessionScope.LOGIN_USER == null}">
                    <div class="col-lg-3 text-right">              
                        <a href="login.jsp" class="btn border">
                            <i class="fa-solid fa-pen-to-square text-primary"></i>
                        </a>
                    </div>
                </c:if>            

                <c:if test="${sessionScope.LOGIN_USER != null}">
                    <div class="col-lg-3 text-right">              
                        <a href="post.jsp" class="btn border">
                            <i class="fa-solid fa-pen-to-square text-primary"></i>
                        </a>
                    </div>
                </c:if>
            </div>
        </div>
        <!-- Topbar End -->

        <!-- Navbar Start -->
        <div class="container-fluid mb-5">
            <div class="row border-top px-xl-5">
                <div class="col-lg-12 ">
                    <nav class="navbar navbar-expand-lg bg-light navbar-light py-3 py-lg-0 px-0">
                        <a href="MainController?action=Home" class="text-decoration-none d-block d-lg-none">
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
                                    <a href="MainController?action=User" class="nav-item nav-link">${sessionScope.LOGIN_USER.fullName}</a>
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
                    <div id="header-carousel" class="carousel slide" data-ride="carousel">
                        <div class="carousel-inner">
                            <div class="carousel-item active" style="height: 410px;">
                                <img class="img-fluid" src="img/car.jpg" alt="Image">
                                <div class="carousel-caption d-flex flex-column align-items-center justify-content-center">
                                    <div class="p-3" style="max-width: 700px;">
                                        <a href="MainController?action=Shop" class="btn btn-light py-2 px-3">Shop Now</a>
                                    </div>
                                </div>
                            </div>
                            <div class="carousel-item" style="height: 410px;">
                                <img class="img-fluid" src="img/caro.jpg" alt="Image">
                                <div class="carousel-caption d-flex flex-column align-items-center justify-content-center">
                                    <div class="p-3" style="max-width: 700px;">
                                        <a href="MainController?action=Shop" class="btn btn-light py-2 px-3">Shop Now</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <a class="carousel-control-prev" href="#header-carousel" data-slide="prev">
                            <div class="btn btn-dark" style="width: 45px; height: 45px;">
                                <span class="carousel-control-prev-icon mb-n2"></span>
                            </div>
                        </a>
                        <a class="carousel-control-next" href="#header-carousel" data-slide="next">
                            <div class="btn btn-dark" style="width: 45px; height: 45px;">
                                <span class="carousel-control-next-icon mb-n2"></span>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <!-- Navbar End -->

        <!-- Categories Start -->
        <div class="container-fluid pt-5">
            <div class="row px-xl-5 pb-3">
                <div class="col-lg-2 col-md-4 pb-1">
                    <div class="cat-item d-flex flex-column " style="padding: 30px;">
                        <a href="MainController?action=Category&categoryID=1" class="cat-img position-relative overflow-hidden mb-3">
                            <h5 class="font-weight-semi-bold m-0">Electronics</h5>
                        </a>

                    </div>
                </div>
                <div class="col-lg-2 col-md-4 pb-1">
                    <div class="cat-item d-flex flex-column  " style="padding: 30px;">
                        <a href="MainController?action=Category&categoryID=2" class="cat-img position-relative overflow-hidden mb-3">
                            <h5 class="font-weight-semi-bold m-0">Fashions</h5>
                        </a>

                    </div>
                </div>
                <div class="col-lg-2 col-md-4 pb-1">
                    <div class="cat-item d-flex flex-column  " style="padding: 30px;">
                        <a href="MainController?action=Category&categoryID=3" class="cat-img position-relative overflow-hidden mb-3">
                            <h5 class="font-weight-semi-bold m-0">Bike</h5>
                        </a>

                    </div>
                </div>
                <div class="col-lg-2 col-md-4 pb-1">
                    <div class="cat-item d-flex flex-column " style="padding: 30px;">
                        <a href="MainController?action=Category&categoryID=4" class="cat-img position-relative overflow-hidden mb-3">
                            <h5 class="font-weight-semi-bold m-0">Books</h5>
                        </a>

                    </div>
                </div>
                <div class="col-lg-2 col-md-4 pb-1">
                    <div class="cat-item d-flex flex-column " style="padding: 30px;">
                        <a href="MainController?action=Category&categoryID=5" class="cat-img position-relative overflow-hidden mb-3">
                            <h5 class="font-weight-semi-bold m-0">Hobbies</h5>
                        </a>

                    </div>
                </div>
                <div class="col-lg-2 col-md-4 pb-1">
                    <div class="cat-item d-flex flex-column " style="padding: 30px;">
                        <a href="MainController?action=Category&categoryID=6" class="cat-img position-relative overflow-hidden mb-3">
                            <h5 class="font-weight-semi-bold m-0">Stationery</h5>
                        </a>

                    </div>
                </div>
            </div>
        </div>
        <!-- Categories End -->

        <!-- Products Start -->
        <div class="container-fluid pt-5">
            <div class="text-left mb-4">
                <h2 class=" px-5"><span class="px-2"><b>All Products</b></span></h2>
            </div>
            <div class="row px-xl-5 pb-3">
                <c:forEach var="pro" items="${listProduct}" >
                    <div class="col-lg-2 col-md-6 col-sm-12 pb-1">
                        <div class="card product-item border-0 mb-4">
                            <div class="card-header product-img position-relative overflow-hidden bg-transparent border p-0">
                                <a href="MainController?action=Detail&pid=${pro.productID}" class="text-dark">
                                    <img class="img-fluid w-100" src="<c:url value="img/${pro.imageLink}" />"/>
                                </a>
                            </div>
                            <div class="card-body border-left border-right text-left p-0 pt-4 pb-3">
                                <h6><a href="MainController?action=Detail&pid=${pro.productID}" class="text-dark">${pro.productName}</a></h6>
                                <div class="d-flex justify-content-lg-start ">
                                    <h6 class="text-danger"> ${pro.productPrice} đ</h6>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
        <!-- Products End -->



        <!-- Footer Start -->
        <%@include  file="footer.jsp" %>
        <!-- Footer End -->


        <!-- Back to Top -->
        <a href="#" class="btn btn-primary back-to-top"><i class="fa fa-angle-double-up"></i></a>


        <!-- JavaScript Libraries -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
        <script src="lib/easing/easing.min.js"></script>
        <script src="lib/owlcarousel/owl.carousel.min.js"></script>

        <!-- Contact Javascript File -->
        <script src="mail/jqBootstrapValidation.min.js"></script>
        <script src="mail/contact.js"></script>

        <!-- Template Javascript -->
        <script src="js/main.js"></script>
    </body>

</html>