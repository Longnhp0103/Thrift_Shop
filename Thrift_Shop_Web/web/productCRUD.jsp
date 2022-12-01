<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--

<head>
    <meta charset="utf-8">
    <title>EShopper - Bootstrap Shop Template</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="Free HTML Templates" name="keywords">
    <meta content="Free HTML Templates" name="description">

     Favicon 
    <link href="img/favicon.ico" rel="icon">

     Google Web Fonts 
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet"> 

     Font Awesome 
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

     Libraries Stylesheet 
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

     Customized Bootstrap Stylesheet 
    
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
     Topbar Start 
        <div class="container-fluid">
            <div class="row bg-secondary py-2 px-xl-5">
                <div class="col-lg-6 d-none d-lg-block">
                    <div class="d-inline-flex align-items-center">
                        <a class="text-dark" href="">FAQs</a>
                        <span class="text-muted px-2">|</span>
                        <a class="text-dark" href="">Help</a>
                        <span class="text-muted px-2">|</span>
                        <a class="text-dark" href="">Support</a>
                    </div>
                </div>
                <div class="col-lg-6 text-center text-lg-right">
                    <div class="d-inline-flex align-items-center">
                        <a class="text-dark px-2" href="">
                            <i class="fab fa-facebook-f"></i>
                        </a>
                        <a class="text-dark px-2" href="">
                            <i class="fab fa-twitter"></i>
                        </a>
                        <a class="text-dark px-2" href="">
                            <i class="fab fa-linkedin-in"></i>
                        </a>
                        <a class="text-dark px-2" href="">
                            <i class="fab fa-instagram"></i>
                        </a>
                        <a class="text-dark pl-2" href="">
                            <i class="fab fa-youtube"></i>
                        </a>
                    </div>
                </div>
            </div>
            <div class="row align-items-center py-3 px-xl-5">
                <div class="col-lg-3 d-none d-lg-block">
                    <a href="" class="text-decoration-none">
                        <h1 class="m-0 display-5 font-weight-semi-bold"><span class="text-primary font-weight-bold border px-3 mr-1">E</span>Shopper</h1>
                    </a>
                </div>
                <div class="col-lg-6 col-6 text-left">
                    <form action="">
                        <div class="input-group">
                            <input type="text" class="form-control" placeholder="Search for products">
                            <div class="input-group-append">
                                <span class="input-group-text bg-transparent text-primary">
                                    <i class="fa fa-search"></i>
                                </span>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="col-lg-3 col-6 text-right">
                    <a href="" class="btn border">
                        <i class="fas fa-heart text-primary"></i>
                        <span class="badge">0</span>
                    </a>
                    <a href="" class="btn border">
                        <i class="fas fa-shopping-cart text-primary"></i>
                        <span class="badge">0</span>
                    </a>
                </div>
            </div>
        </div>
     Topbar End 


     Navbar Start 
    <div class="container-fluid">
        <div class="row border-top px-xl-5">
            <div class="col-lg-3 d-none d-lg-block">
                <a class="btn shadow-none d-flex align-items-center justify-content-between bg-primary text-white w-100" data-toggle="collapse" href="#navbar-vertical" style="height: 65px; margin-top: -1px; padding: 0 30px;">
                    <h6 class="m-0">Categories</h6>
                    <i class="fa fa-angle-down text-dark"></i>
                </a>
                <nav class="collapse position-absolute navbar navbar-vertical navbar-light align-items-start p-0 border border-top-0 border-bottom-0 bg-light" id="navbar-vertical" style="width: calc(100% - 30px); z-index: 1;">
                    <div class="navbar-nav w-100 overflow-hidden" style="height: 410px">
                        <div class="nav-item dropdown">
                            <a href="#" class="nav-link" data-toggle="dropdown">Dresses <i class="fa fa-angle-down float-right mt-1"></i></a>
                            <div class="dropdown-menu position-absolute bg-secondary border-0 rounded-0 w-100 m-0">
                                <a href="" class="dropdown-item">Men's Dresses</a>
                                <a href="" class="dropdown-item">Women's Dresses</a>
                                <a href="" class="dropdown-item">Baby's Dresses</a>
                            </div>
                        </div>
                        <a href="" class="nav-item nav-link">Shirts</a>
                        <a href="" class="nav-item nav-link">Jeans</a>
                        <a href="" class="nav-item nav-link">Swimwear</a>
                        <a href="" class="nav-item nav-link">Sleepwear</a>
                        <a href="" class="nav-item nav-link">Sportswear</a>
                        <a href="" class="nav-item nav-link">Jumpsuits</a>
                        <a href="" class="nav-item nav-link">Blazers</a>
                        <a href="" class="nav-item nav-link">Jackets</a>
                        <a href="" class="nav-item nav-link">Shoes</a>
                    </div>
                </nav>
            </div>
            <div class="col-lg-9">
                <nav class="navbar navbar-expand-lg bg-light navbar-light py-3 py-lg-0 px-0">
                    <a href="" class="text-decoration-none d-block d-lg-none">
                        <h1 class="m-0 display-5 font-weight-semi-bold"><span class="text-primary font-weight-bold border px-3 mr-1">E</span>Shopper</h1>
                    </a>
                    <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                        <div class="navbar-nav mr-auto py-0">
                            <a href="index.html" class="nav-item nav-link">Home</a>
                            <a href="shop.html" class="nav-item nav-link">Shop</a>
                            <a href="detail.html" class="nav-item nav-link">Shop Detail</a>
                            <div class="nav-item dropdown">
                                <a href="#" class="nav-link dropdown-toggle active" data-toggle="dropdown">Pages</a>
                                <div class="dropdown-menu rounded-0 m-0">
                                    <a href="cart.html" class="dropdown-item">Shopping Cart</a>
                                    <a href="checkout.html" class="dropdown-item">Checkout</a>
                                </div>
                            </div>
                            <a href="contact.html" class="nav-item nav-link">Contact</a>
                        </div>
                        <div class="navbar-nav ml-auto py-0">
                            <a href="" class="nav-item nav-link">Login</a>
                            <a href="" class="nav-item nav-link">Register</a>
                        </div>
                    </div>
                </nav>
            </div>
        </div>
    </div>
     Navbar End 


     Page Header Start 
    <div class="container-fluid bg-secondary mb-5">
        <div class="d-flex flex-column align-items-center justify-content-center" style="min-height: 300px">
            <h1 class="font-weight-semi-bold text-uppercase mb-3">PRODUCT DETAIL</h1>
            <div class="d-inline-flex">
                <p class="m-0"><a href="">Home</a></p>
                <p class="m-0 px-2">-</p>
                <p class="m-0">Product Detail</p>
            </div>
        </div>
    </div>
     Page Header End 


     Post Start 
    <div class="container pt-5">
                    <div class="row px-xl-5">
                        <div class="col-lg-8">
                            <div class="mb-4">
        <h4 class="font-weight-semi-bold mb-4">@${requestScope.PRODUCT_DETAIL.fullName}</h4>

${requestScope.SETTING}
<form action="SettingProductController" method="POST" >
    <div class="row">
        <div class="col-md-12 form-group">
            <label>Image</label>
            <label class="form-control">
                <input id="fileUpload" type="file" accept=".jpg, .png" multiple/>

            </label>
            <img class="w-50 h-50" src="<c:url value="img/${requestScope.PRODUCT_DETAIL.imageLink}" />" >

        </div>
        <div class="col-md-12 form-group">
            <label>Categories</label>
            <select name="categories" class="custom-select">
                <option value="1">Electronics</option>
                <option value="2">Fashions</option>
                <option value="3">Bike</option>
                <option value="4">Books</option>
                <option value="5">Hobbies</option>
                <option value="6">Other</option>
            </select>
        </div>
        <div class="col-md-12 form-group">
            <label>Title</label>
            <input class="form-control" type="text" name ="productName"value="${requestScope.PRODUCT_DETAIL.productName}">
        </div>
        <div class="col-md-12 form-group">
            <label>Price</label>
            <input class="form-control" type="number" name = "price" value="${requestScope.PRODUCT_DETAIL.productPrice}">
        </div>
        <div class="col-md-12 form-group">
            <label>Status</label>
            <select class="custom-select" name="status"> 
                <option  value="True">VIEW</option>
                <option  value="False">HIDE</option>
            </select>
        </div>
        <div class="col-md-12 form-group">
            <label>Description</label>
            <textarea style="width: 100%;
                      height: 150px;
                      padding: 12px 20px;
                      box-sizing: border-box;
                      border: 2px solid #ccc;
                      border-radius: 4px;
                      font-size: 16px;
                      resize: none;
                      border: 1px solid #EDF1FF;
                      border-radius: 0;
                      transition: border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;
                      font-size: 1rem;
                      font-weight: 400;
                      color: #495057;"> ${requestScope.PRODUCT_DETAIL.productDesc}</textarea>
        </div>


        <div class="col-md-6 form-group">
            <input class="btn btn-lg btn-block btn-primary font-weight-bold my-1 py-1" type="submit" name="action" value="SAVE CHANGE">
            <input type="hidden" name="productID" value="${requestScope.PRODUCT_DETAIL.productID}"/>
        </div>                
        <div class="col-md-6 form-group">
            <a href="ProductController" class="btn btn-lg btn-block btn-outline-danger font-weight-bold my-1 py-1">RETURN</a>
        </div>
    </div>
</form>


</div>

Footer Start 
<div class="container-fluid bg-secondary text-dark mt-5 pt-5">
    <div class="row px-xl-5 pt-5">
        <div class="col-lg-4 col-md-12 mb-5 pr-3 pr-xl-5">
            <a href="" class="text-decoration-none">
                <h1 class="mb-4 display-5 font-weight-semi-bold"><span class="text-primary font-weight-bold border border-white px-3 mr-1">E</span>Shopper</h1>
            </a>
            <p>Dolore erat dolor sit lorem vero amet. Sed sit lorem magna, ipsum no sit erat lorem et magna ipsum dolore amet erat.</p>
            <p class="mb-2"><i class="fa fa-map-marker-alt text-primary mr-3"></i>123 Street, New York, USA</p>
            <p class="mb-2"><i class="fa fa-envelope text-primary mr-3"></i>info@example.com</p>
            <p class="mb-0"><i class="fa fa-phone-alt text-primary mr-3"></i>+012 345 67890</p>
        </div>
        <div class="col-lg-8 col-md-12">
            <div class="row">
                <div class="col-md-4 mb-5">
                    <h5 class="font-weight-bold text-dark mb-4">Quick Links</h5>
                    <div class="d-flex flex-column justify-content-start">
                        <a class="text-dark mb-2" href="index.html"><i class="fa fa-angle-right mr-2"></i>Home</a>
                        <a class="text-dark mb-2" href="shop.html"><i class="fa fa-angle-right mr-2"></i>Our Shop</a>
                        <a class="text-dark mb-2" href="detail.html"><i class="fa fa-angle-right mr-2"></i>Shop Detail</a>
                        <a class="text-dark mb-2" href="cart.html"><i class="fa fa-angle-right mr-2"></i>Shopping Cart</a>
                        <a class="text-dark mb-2" href="checkout.html"><i class="fa fa-angle-right mr-2"></i>Checkout</a>
                        <a class="text-dark" href="contact.html"><i class="fa fa-angle-right mr-2"></i>Contact Us</a>
                    </div>
                </div>
                <div class="col-md-4 mb-5">
                    <h5 class="font-weight-bold text-dark mb-4">Quick Links</h5>
                    <div class="d-flex flex-column justify-content-start">
                        <a class="text-dark mb-2" href="index.html"><i class="fa fa-angle-right mr-2"></i>Home</a>
                        <a class="text-dark mb-2" href="shop.html"><i class="fa fa-angle-right mr-2"></i>Our Shop</a>
                        <a class="text-dark mb-2" href="detail.html"><i class="fa fa-angle-right mr-2"></i>Shop Detail</a>
                        <a class="text-dark mb-2" href="cart.html"><i class="fa fa-angle-right mr-2"></i>Shopping Cart</a>
                        <a class="text-dark mb-2" href="checkout.html"><i class="fa fa-angle-right mr-2"></i>Checkout</a>
                        <a class="text-dark" href="contact.html"><i class="fa fa-angle-right mr-2"></i>Contact Us</a>
                    </div>
                </div>
                <div class="col-md-4 mb-5">
                    <h5 class="font-weight-bold text-dark mb-4">Newsletter</h5>
                    <form action="">
                        <div class="form-group">
                            <input type="text" class="form-control border-0 py-4" placeholder="Your Name" required="required" />
                        </div>
                        <div class="form-group">
                            <input type="email" class="form-control border-0 py-4" placeholder="Your Email"
                                   required="required" />
                        </div>
                        <div>
                            <button class="btn btn-primary btn-block border-0 py-3" type="submit">Subscribe Now</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <div class="row border-top border-light mx-xl-5 py-4">
        <div class="col-md-6 px-xl-0">
            <p class="mb-md-0 text-center text-md-left text-dark">
                &copy; <a class="text-dark font-weight-semi-bold" href="#">Your Site Name</a>. All Rights Reserved. Designed
                by
                <a class="text-dark font-weight-semi-bold" href="https://htmlcodex.com">HTML Codex</a><br>
                Distributed By <a href="https://themewagon.com" target="_blank">ThemeWagon</a>
            </p>
        </div>
        <div class="col-md-6 px-xl-0 text-center text-md-right">
            <img class="img-fluid" src="img/payments.png" alt="">
        </div>
    </div>
</div>
Footer End 


Back to Top 
<a href="#" class="btn btn-primary back-to-top"><i class="fa fa-angle-double-up"></i></a>


JavaScript Libraries 
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
<script src="lib/easing/easing.min.js"></script>
<script src="lib/owlcarousel/owl.carousel.min.js"></script>

Contact Javascript File 
<script src="mail/jqBootstrapValidation.min.js"></script>
<script src="mail/contact.js"></script>

Template Javascript 
<script src="js/main.js"></script>
</body>-->

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ThriftShop</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<section style="background-color: #eee;">
    <div class="container py-5">
        <div class="row">
            <div class="col">
                <nav aria-label="breadcrumb" class="bg-light rounded-3 p-3 mb-4">
                    <div class="row">
                        <div class="col-sm-6">
                            <h5>Product Settings</h5>
                        </div>
                    </div>
                </nav>
            </div>
        </div>
        <%--UPDATE USER --%>
        <div class="row">
            <form action="SettingProductController" method="POST" >
                <div class="col-lg-12">
                    <form>
                        <div class="card mb-2">
                            <div class="card-body">

                                <div class="row ">
                                    <div class="col-sm-3">
                                        <p class="mb-0">Image</p>
                                    </div>
                                    <img class="w-25 h-25" src="<c:url value="img/${requestScope.PRODUCT_DETAIL.imageLink}" />" >
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-sm-3">
                                        <p class="mb-0">Categories</p>
                                    </div>
                                    <div class="col-sm-9">
                                        <select name="categories" class="custom-select">
                                            <option value="1">Electronics</option>
                                            <option value="2">Fashions</option>
                                            <option value="3">Bike</option>
                                            <option value="4">Books</option>
                                            <option value="5">Hobbies</option>
                                            <option value="6">Other</option>
                                        </select>
                                    </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-sm-3">
                                        <p class="mb-0">Title</p>
                                    </div>
                                    <div class="col-sm-9">
                                        <input type="text" name ="productName" id="typeUsernameX"
                                               class="text-muted mb-0 form-control form-control-sm border-0"
                                               value="${requestScope.PRODUCT_DETAIL.productName}"/>
                                    </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-sm-3">
                                        <p class="mb-0">Price</p>
                                    </div>
                                    <div class="col-sm-9">
                                        <input type="number" name = "price" id="typeUsernameX"
                                               class="text-muted mb-0 form-control form-control-sm border-0"
                                               value="${requestScope.PRODUCT_DETAIL.productPrice}" />
                                    </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-sm-3">
                                        <p class="mb-0">Status</p>
                                    </div>
                                    <div class="col-sm-9">
                                        <select class="custom-select" name="status"> 
                                            <option  value="True">VIEW</option>
                                            <option  value="False">HIDE</option>
                                        </select>
                                    </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-sm-3">
                                        <p class="mb-0">Role</p>
                                    </div>
                                    <div class="col-sm-9">
                                        <div class="col-md-12 form-group">
                                            <label>Description</label>
                                            <textarea style="width: 100%;
                                                      height: 150px;
                                                      padding: 12px 20px;
                                                      box-sizing: border-box;
                                                      border: 2px solid #ccc;
                                                      border-radius: 4px;
                                                      font-size: 16px;
                                                      resize: none;
                                                      border: 1px solid #EDF1FF;
                                                      border-radius: 0;
                                                      transition: border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;
                                                      font-size: 1rem;
                                                      font-weight: 400;
                                                      color: #495057;"> ${requestScope.PRODUCT_DETAIL.productDesc}</textarea>
                                        </div>
                                    </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-sm-3">
                                        <p class="mb-0">Status</p>
                                    </div>
                                    <div class="col-sm-9">
                                        <select class="rounded" name="status" id="role"> 
                                            <option value="true">Available</option>
                                            <option value="false">Ban</option>
                                        </select>
                                    </div>
                                </div>  
                            </div>
                        </div>
                        <div class="row mb-5">
                            <div class="col-sm-6 d-grid">
                                <a href="ProductController" class="btn btn-outline-danger">Return</a>
                            </div>
                            <div class="col-sm-6 d-grid">

                                <%--<button type="button" class="btn btn-success">Save</button> --%>
                                <input class="btn btn-success" type="submit" name="action" value="SAVE CHANGE"/>
                                <input type="hidden" name="productID" value="${requestScope.PRODUCT_DETAIL.productID}"/>
                            </div>
                        </div>
                        <div class="row mb-5"> 
                            <div class="col-sm-6 d-grid"> 
                                ${requestScope.SETTING} 
                            </div>
                        </div>
                </div>
            </form>
        </div>


        <%-- view transaction of this user --%>
        <!--            <div class="container bg-light rounded-3 p-3">
                        <h3 class="mb-4">Transaction history</h3>
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>Time</th>
                                    <th>Description</th>
                                    <th>Money</th>
                                    <th>Balances</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>08/03/2022</td>
                                    <td>Nap tien Viettel Money</td>
                                    <td>$500</td>
                                    <td>$650</td>
                                </tr>
                                <tr>
                                    <td>10/02/2022</td>
                                    <td>Thanh toan</td>
                                    <td>$50</td>
                                    <td>$150</td>
                                </tr>
                                <tr>
                                    <td>02/02/2022</td>
                                    <td>Nap tien Momo</td>
                                    <td>$200</td>
                                    <td>$200</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>-->
    </div>
</section>