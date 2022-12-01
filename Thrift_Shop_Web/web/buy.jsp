<%-- 
    Document   : buy
    Created on : Nov 11, 2022, 9:03:00 PM
    Author     : Le Nguyen Nhat Minh
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
        <!--Header Start-->
        <jsp:include page="header.jsp"/>
        <!--Header End-->
        <!--Feed Start-->
        <div class="col-lg-12">
            <div class="container">
                <h1>Purchased Items</h1>
                <hr>
                <div class="col-md-12">
                    <div class="card mb-12 mb-md-0">
                        <div class="card-body">
                            <p class="mb-4"><span class="text-primary font-italic me-1">History Order</span>
                            </p>
                            <div class="row">
                                <div class="col-sm-4">
                                    <p class="mb-4">Image</p>
                                </div>
                                <div class="col-sm-4">
                                    <p class="mb-4">Product Name</p>
                                </div>
                                <div class="col-sm-4">
                                    <p class="mb-4">Product Price</p>
                                </div>
                            </div>
                            <c:forEach var="pro" items="${sessionScope.historyOrder}">
                                <div class="row ">
                                    <div class="col-sm-4" >
                                        <img class="img-fluid w-50" src="<c:url value="img/${pro.imageLink}" />" />
                                        <!--<img width="30" height="40" src="<c:url value="img/${pro.imageLink}" />" />-->
                                    </div>
                                    <div class="col-sm-4">

                                        <p class="mb-0">${pro.productName}</p>
                                    </div>
                                    <div class="col-sm-4">

                                        <p>${pro.productPrice} đ</p>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--Feed End-->
        <!-- Footer Start -->
        <%@include  file="footer.jsp" %>
        <!-- Footer End -->
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
