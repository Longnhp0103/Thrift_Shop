<%-- 
    Document   : detail
    Created on : Oct 11, 2022, 11:35:24 PM
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

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A==" crossorigin="anonymous" referrerpolicy="no-referrer" />

    </head>

    <body>
        <jsp:include page="header.jsp"/>
        <!-- Shop Detail Start -->
        <div style="background-color: #f4f4f4" class="pt-5">
            <div style="background-color: white" class="container pt-2 pb-5">
                <div class="row">
                    <div class="col-sm-8">
                        <div id="product-carousel" class="carousel slide" data-ride="carousel">
                            <div class="carousel-inner border">
                                <div style="text-align: center" class="carousel-item active">
                                    <img class="w-90 h-80" src="<c:url value="img/${detail.imageLink}" />" >
                                </div>
                            </div>

                            <h3 class="font-weight-semi-bold mt-3">${detail.productName}</h3>
                            <div class="d-flex mb-3">
                                <div class="text-primary mr-2">
                                    <c:forEach begin="1" end="${detail.rating}">
                                        <i class="fa fa-star"></i>
                                    </c:forEach>
                                    <c:if test="${detail.rating < 5}">
                                        <c:forEach begin="${detail.rating+1}" end="5">
                                            <i class="fa fa-star-o"></i>
                                        </c:forEach>
                                    </c:if>
                                </div>

                            </div>
                            <div class="row">
                                <div class="col-md-2">
                                    <h3 class="font-weight-semi-bold mb-4 text-danger">${detail.productPrice} đ</h3>  

                                </div>

                                <!--                            them checkout vao day-->
                                <div class="col-md-10">
                                    <c:choose>
                                        <c:when test="${sessionScope.LOGIN_USER.fullName eq detail.fullName}">
                                            <div class="d-flex align-items-center ml-2">
                                                <p>You are the owner</p>
                                            </div>
                                        </c:when>
                                        <c:when test="${not empty sessionScope.LOGIN_USER}">
                                            <!--<a href="<c:url value="/home/shoping-cart.do?op=add&pid=${pid}" />" class="primary-btn" > Add to Cart</a>-->
                                            <form action="MainController">
                                                <div class="d-flex align-items-center ml-2">
                                                    <input type="hidden" name="productID" value="${detail.productID}" /> 
                                                    <button type="submit" name="action" value="View" class="btn btn-primary px-3">
                                                        <i class="fa fa-shopping-cart mr-1"></i>Checkout</button>
                                                </div>
                                            </form>
                                        </c:when>
                                        <c:otherwise>
                                            <a href="login.jsp" class="btn btn-primary px-3" ><i class="fa fa-shopping-cart mr-1"></i> Checkout</a>
                                        </c:otherwise>
                                    </c:choose> 
                                </div>

                            </div>



                            <p class="mb-4">${detail.productDesc}</p>

                        </div>




                    </div>
                    <div class="col-sm-4">
                        <div style="display: flex;                                      
                             " class="card-avatar">
                            <img style="width: 50px; height: 50px; border-radius: 100rem; object-fit: cover; flex-shrink: 0" src="https://png.pngtree.com/png-vector/20191027/ourlarge/pngtree-avatar-vector-icon-white-background-png-image_1884971.jpg">
                            <h5 style="margin-top: 15px; margin-left: 10px">${detail.fullName}</h5>
                        </div>
                        <div class="mt-2 h6">                  
                            <p>Phone number: ${detail.phone} </p>
                            <p>Email:  ${detail.email}</p>
                            <p>Address: ${detail.address}</p>
                            <p>Number of All Sell Items: ${numberofOrder}</p>
                            <p>Number of Successfully Sold Item: ${successOrderSold}</p>
                            <p>Latest Product posted: <br> ${product.productName}<br> ${product.productPrice} đ</p>
                        </div>
                    </div>
                </div>

            </div>
        </div>

        <!-- Shop Detail End -->


        <!-- Products Start -->
        <div class="container py-5">
            <div class="text-center mb-4">
                <h2 class="section-title px-5"><span class="px-2">Related Product</span></h2>
            </div>
            <div class="row px-xl-5">
                <div class="col">
                    <div class="owl-carousel related-carousel">
                        <c:forEach var="pro" items="${listRelated}" >
                            <div class="card product-item border-0">
                                <div class="card-header product-img position-relative overflow-hidden bg-transparent border p-0">
                                    <img class="img-fluid w-100" src="<c:url value="img/${pro.imageLink}" />" alt="">
                                </div>
                                <div class="card-body border-left border-right p-0 pt-4 pb-3">
                                    <h6><a href="MainController?action=Detail&pid=${pro.productID}" class="text-dark">${pro.productName}</a></h6>
                                    <div class="d-flex justify-content-lg-start ">
                                        <h6 class="text-danger"> ${pro.productPrice} đ</h6>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
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