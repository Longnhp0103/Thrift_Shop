<%@page import="models.Account"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
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
        <c:if test="${sessionScope.LOGIN_USER == null}"> 
            <c:redirect url="login.jsp"></c:redirect>
        </c:if> 
        <!--Header Start-->
        <jsp:include page="header.jsp"/>
        <!--Header End-->
        <!-- Page Header Start -->
        <div class="container-fluid bg-secondary mb-5">
            <div class="d-flex flex-column align-items-center justify-content-center" style="min-height: 150px; ">
                <h1 class="font-weight-semi-bold text-uppercase mb-3">POST YOUR PRODUCT</h1>
                <!--                <div class="d-inline-flex">
                                    <p class="m-0"><a href="">Home</a></p>
                                    <p class="m-0 px-2">-</p>
                                    <p class="m-0">Post</p>
                                </div>-->
            </div>
        </div>
        <!-- Page Header End -->


        <!-- Post Start -->

        <div class="container pt-5">
            <h4 class="font-weight-semi-bold mb-4">POST</h4>
            <form action="PostController" method="POST" >
                <div class="row mx-8">

                    <div class="col-md-12 form-group">
                        <label>Name</label>
                        <input class="form-control" type="text" name="productName" placeholder="" required="">
                    </div>

                    <div class="col-md-12 form-group">
                        <label>Image</label>
                        <label class="form-control">
                            <input id="fileUpload" type="file" accept=".jpg, .png" multiple required name="img"/>
                        </label>

                    </div>
                    <div class="col-md-12 form-group">
                        <label>Categories</label>
                        <select name="categoryID" class="custom-select" required>
                            <option value="1">Electronics</option>
                            <option value="2">Fashions</option>
                            <option value="3">Bike</option>
                            <option value="4">Books</option>
                            <option value="5">Hobbies</option>
                            <option value="6">Stationery</option>
                        </select>
                    </div>
                    <input  name="userID" value="${sessionScope.LOGIN_USER.ID}" type="hidden"/>


                    <div class="col-md-12 form-group">
                        <label>Price</label>
                        <input class="form-control" type="number" name="productPrice" placeholder="" required="">
                    </div>
                    <div class="col-md-12 form-group">
                        <label>Quantity</label>
                        <input class="form-control" type="number" name="productQuantity" placeholder="" required="">
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
                                  color: #495057;" required="" name="productDesc"></textarea>
                    </div>



                    <div class="col-md-12 form-group">
                        <button type="submit" name="action" value="Post"
                                class="btn btn-lg btn-block btn-primary font-weight-bold my-1 py-1">POST</button><br>
                        ${chuaxongdau.message} 
                    </div>

                </div>
            </form>
        </div>


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