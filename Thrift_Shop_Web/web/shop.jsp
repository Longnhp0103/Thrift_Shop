
<%-- 
    Document   : shop
    Created on : Oct 11, 2022, 9:20:24 PM
    Author     : Le Nguyen Nhat Minh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <div class="col-lg-3 text-right">              
                    <a href="post.jsp" class="btn border">
                        <i class="fa-solid fa-pen-to-square text-primary"></i>
                    </a>
                </div>
            </div>
        </div>
        <!-- Topbar End -->


        <!-- Navbar Start -->
        <div class="container-fluid mb-5">
            <div class="row border-top px-xl-5">
                <div class="col-lg-3 d-none d-lg-block">
                    <a class="btn shadow-none d-flex align-items-center justify-content-between bg-primary text-white w-100" data-toggle="collapse" href="#navbar-vertical" style="height: 65px; margin-top: -1px; padding: 0 30px;">
                        <h6 class="m-0">Categories</h6>
                        <i class="fa fa-angle-down text-dark"></i>
                    </a>
                    <nav class="collapse show navbar navbar-vertical navbar-light align-items-start p-0 border border-top-0 border-bottom-0" id="navbar-vertical">
                        <div class="navbar-nav w-100 overflow-hidden" style="height: 410px">
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
                    <hr>
                    <div class="mt-5 row">                       
                        <c:forEach var="pro" items="${listShop}" >
                            <div style="" class="col-lg-3">
                                <div class="card product-item border-0 mb-4">
                                    <div class="card-header product-img position-relative overflow-hidden bg-transparent border p-0">
                                        <img class="img-fluid w-100" src="<c:url value="img/${pro.imageLink}"/>"/>
                                    </div>
                                    <div class="card-body border-left border-right text-left p-0 pt-4 pb-3">
                                        <h6 class="ml-2"><a href="MainController?action=Detail&pid=${pro.productID}&cid=${pro.categoryID}" class="text-dark">${pro.productName}</a></h6>
                                        <div class="d-flex justify-content-lg-start ">
                                            <h6 class="ml-2 text-danger"> ${pro.productPrice} đ</h6>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>

                    <div class="pagination-lg">
                        <c:forEach begin="1" end="${endPage}" varStatus="loop">
                            <a class="p-3 border ${index == loop.count?"active":""}" href="<c:url value="MainController?action=Shop&index=${loop.count}" />">${loop.count}</a>
                        </c:forEach>
                    </div> 

                </div>
            </div>
        </div>
        <!-- Navbar End --> 
        <!-- Footer Start -->
        <jsp:include page="footer.jsp"/>
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