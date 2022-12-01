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
        <!-- Checkout Start -->
        <form action="MainController">
            <div class="container-fluid pt-5">
                <div class="row px-xl-5">
                    <div class="col-lg-8">
                        <div class="mb-4">
                            <h4 class="font-weight-semi-bold mb-4">Billing Address</h4>
                            <div class="row">
                                <div class="col-md-12 form-group">
                                    <label>Full Name</label>
                                    <input class="form-control" type="text" value="${sessionScope.LOGIN_USER.fullName}">
                                </div>
                                <div class="col-md-12 form-group">
                                    <label>Address</label>
                                    <input class="form-control" type="text" value="${sessionScope.LOGIN_USER.address}">
                                </div>
                                <div class="col-md-6 form-group">
                                    <label>E-mail</label>
                                    <input class="form-control" type="text" value="${sessionScope.LOGIN_USER.email}">
                                </div>
                                <div class="col-md-6 form-group">
                                    <label>Mobile No</label>
                                    <input class="form-control" type="text" value="${sessionScope.LOGIN_USER.phone}">
                                </div>
                                <div class="col-md-12 form-group">
                                    <label>Ship Address</label>
                                    <input class="form-control" type="text" name="ShipAddress" value="FPTU Thrift Shop">
                                </div>

                            </div>
                        </div>

                    </div>
                    <div class="col-lg-4">
                        <div class="card border-secondary mb-5">
                            <div class="card-header bg-secondary border-0">
                                <h4 class="font-weight-semi-bold m-0">Order Total</h4>
                            </div>
                            <div class="card-body">
                                <h5 class="font-weight-medium mb-3">Product</h5>
                                <div class="d-flex justify-content-between">
                                    <p>${product.productName}</p>
                                    <p>${product.productPrice} đ</p>
                                </div>
                                <hr class="mt-0">
                                <div class="d-flex justify-content-between">
                                    <h6 class="font-weight-medium">Shipping</h6>
                                    <h6 class="font-weight-medium">10.000 đ</h6>
                                </div>
                            </div>
                            <div class="card-footer border-secondary bg-transparent">
                                <div class="d-flex justify-content-between mt-2">
                                    <h5 class="font-weight-bold">Total</h5>
                                    <h5 class="font-weight-bold"><i name="TotalPrice">${product.productPrice + 10} đ</i></h5>
                                    <input type="hidden" name="amount" value="${product.productPrice}"/>
                                    <input type="hidden" name="walletID" value="${sessionScope.AMOUNT.walletID}"/>
                                    <input type="hidden" name="userID" value="${sessionScope.LOGIN_USER.ID}"/>
                                    <input type="hidden" name="balance" value="${sessionScope.AMOUNT.amount}"/>
                                    <input type="hidden" name="sellerID" value="${product.userID}"/>
                                    
                                </div>
                            </div>
                        </div>
                        <div class="card border-secondary mb-5">
                            <div class="card-header bg-secondary border-0">
                                <h4 class="font-weight-semi-bold m-0">Payment</h4>
                            </div>
                            
                            <div class="card-body">
                                <div class="form-group">
                                    <div class="custom-control custom-radio">
                                        <input type="radio" class="custom-control-input" name="discription" value="Payment via Cash" id="paypal" required="">
                                        <label class="custom-control-label" for="paypal">Cash</label>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="custom-control custom-radio">
                                        <input type="radio" class="custom-control-input" name="discription" value="Payment via wallet" id="directcheck">
                                        <label class="custom-control-label" for="directcheck">Wallet</label>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="card-footer border-secondary bg-transparent">
                                <input type="hidden" name="productID" value="${product.productID}" />
                                <input class="btn btn-lg btn-block btn-primary font-weight-bold my-3 py-3" type="submit" name="action" value="Checkout"/>
                            </div>
                            ${sessionScope.WARNING}    
                        </div>
                    </div>
                </div>
            </div>
        </form>

        <!-- Checkout End -->


        <!-- Footer Start -->
        <div class="container-fluid bg-secondary text-dark mt-5 pt-5">
            <div class="row px-xl-5 pt-5">
                <div class="col-lg-5 col-md-12 mb-5 pr-3 pr-xl-5">
                    <a href="" class="text-decoration-none">
                        <h1 class="mb-4 display-5 font-weight-semi-bold"><span class="text-primary font-weight-bold border border-white px-3 mr-1">Thrift</span>Shop</h1>
                    </a>
                    <p>Selling used things for FU students</p>
                    <p class="mb-2"><i class="fa fa-map-marker-alt text-primary mr-3"></i>Block E2a-7, D1 Street Saigon Hi-tech Park, <br>Long Thanh My Ward, District 9, Ho Chi Minh City, Vietnam</p>
                    <p class="mb-2"><i class="fa fa-envelope text-primary mr-3"></i>daihoc.hcm@fpt.edu.vn</p>
                    <p class="mb-0"><i class="fa fa-phone-alt text-primary mr-3"></i>+84 28 7300 1866</p>
                </div>
            </div>
            <div class="row border-top border-light mx-xl-5 py-4">
                <div class="col-md-6 px-xl-0">
                    <p class="mb-md-0 text-center text-md-left text-dark">
                        &copy; <a class="text-dark font-weight-semi-bold" href="index.jsp">SWP301 - Thrift Shop</a>. All Rights Reserved. Designed
                        by
                        <a class="text-dark font-weight-semi-bold" href="index.jsp">Group Thrift Shop</a><br>
                    </p>
                </div>
            </div>
        </div>
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