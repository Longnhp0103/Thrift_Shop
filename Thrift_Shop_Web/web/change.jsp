<%-- 
    Document   : change
    Created on : Oct 5, 2022, 4:38:38 PM
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

        <style>
            #form label {
                float: left;
                width: 140px;
            }

            #error_msg {
                color: red;
                font-weight: bold;
            }
        </style>

        <script>
            $(document).ready(function () {
                var $submitBtn = $("#form input[type='submit']");
                var $passwordBox = $("#password");
                var $confirmBox = $("#confirm_password");
                var $errorMsg = $('<span id="error_msg">Passwords do NOT match. Try Again !</span>');

                // This is incase the user hits refresh - some browsers will maintain the disabled state of the button.
                $submitBtn.removeAttr("disabled");

                function checkMatchingPasswords() {
                    if ($confirmBox.val() != "" && $passwordBox.val != "") {
                        if ($confirmBox.val() != $passwordBox.val()) {
                            $submitBtn.attr("disabled", "disabled");
                            $errorMsg.insertAfter($confirmBox);
                        }
                    }
                }

                function resetPasswordError() {
                    $submitBtn.removeAttr("disabled");
                    var $errorCont = $("#error_msg");
                    if ($errorCont.length > 0) {
                        $errorCont.remove();
                    }
                }


                $("#confirm_password, #password")
                        .on("keydown", function (e) {
                            /* only check when the tab or enter keys are pressed
                             * to prevent the method from being called needlessly  */
                            if (e.keyCode == 13 || e.keyCode == 9) {
                                checkMatchingPasswords();
                            }
                        })
                        .on("blur", function () {
                            // also check when the element looses focus (clicks somewhere else)
                            checkMatchingPasswords();
                        })
                        .on("focus", function () {
                            // reset the error message when they go to make a change
                            resetPasswordError();
                        })

            });
        </script>

    </head>
    <%@include  file="header.jsp" %>
    <body >
        <section style="background-color: #eee;">
            <div class="container py-5">
                <div class="row">
                    <div class="col">
                        <nav aria-label="breadcrumb" class="bg-light rounded-3 p-3 mb-4">
                            <div class="row">
                                <form action="MainController">
                                    <div class="col-sm-12">

                                        <input class="h5 bg-light border-0 form-control" name="userName" placeholder="${sessionScope.LOGIN_USER.userName}" value="${sessionScope.LOGIN_USER.userName}" readonly=""/>
                                    </div>

                                    </nav>
                            </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="card mb-2">
                                <div class="card-body">

                                    <div class="row ">
                                        <div class="col-sm-3">
                                            <p class="mb-0">Current Password</p>
                                        </div>
                                        <div class="col-sm-9">
                                            <input type="password" name="currentPassword"
                                                   class="text-muted mb-0 form-control form-control-sm border-0"
                                                   placeholder="Current Password" 
                                                   required/>
                                            <p class="text-danger"> ${requestScope.USER_ERROR.passwordError}</p>    
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="row ">
                                        <div class="col-sm-3">
                                            <p class="mb-0">New Password</p>
                                        </div>
                                        <div class="col-sm-9">
                                            <input name="newPassword" type="password"
                                                   class="text-muted mb-0 form-control form-control-sm border-0"
                                                   placeholder="New Password" 
                                                   required/>
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="row ">
                                        <div class="col-sm-3">
                                            <p class="mb-0">Confirm Password</p>
                                        </div>
                                        <div class="col-sm-9">
                                            <input type="password" name="confirm"
                                                   class="text-muted mb-0 form-control form-control-sm border-0"
                                                   placeholder="Confirm password" 
                                                   required/>
                                            <p class="text-danger"> ${requestScope.USER_ERROR.confirmError} </p>   
                                        </div>
                                    </div>                              
                                </div>
                            </div>
                            <div class="row"> 
                                <div class="col-sm-6 d-grid mt-3">

                                    <a href="userInfor.jsp" class="btn btn-outline-danger">Return</a>
                                </div>
                                <div class="col-sm-6 d-grid mt-3">
                                    <input type="submit" name="action" value="Change" class="btn btn-success"/>
                                </div>
                                </form>
                            </div>                       
                        </div>
                    </div>
                </div>
        </section>
    </body>
    <%@include  file="footer.jsp" %>
