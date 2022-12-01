<%-- 
    Document   : ProfileManagement
    Created on : Oct 20, 2022, 4:08:09 PM
    Author     : htmlo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

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
                                <h5>@${requestScope.USER_PROFILE.fullName}</h5>
                            </div>
                            <div class="col-sm-6 d-flex justify-content-end"><a onclick="ConfirmDelete()"
                                                                                style="text-decoration: none; color: #E50914;" href="#">Delete</a></div>
                        </div>
                    </nav>
                </div>
            </div>
            <%--UPDATE USER --%>
            <div class="row">
                <form action="SettingProfileController" method="POST">
                    <div class="col-lg-12">
                        <form>
                            <div class="card mb-2">
                                <div class="card-body">

                                    <div class="row ">
                                        <div class="col-sm-3">
                                            <p class="mb-0">Username</p>
                                        </div>
                                        <div class="col-sm-9">
                                            <input type="text" name="userName" id="typeUsernameX"
                                                   class="text-muted mb-0 form-control form-control-sm border-0"
                                                   value="${requestScope.USER_PROFILE.userName}" readonly/>
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <p class="mb-0">Full Name</p>
                                        </div>
                                        <div class="col-sm-9">
                                            <input type="text" name="fullName" id="typeUsernameX"
                                                   class="text-muted mb-0 form-control form-control-sm border-0"
                                                   value="${requestScope.USER_PROFILE.fullName}" />
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <p class="mb-0">Email</p>
                                        </div>
                                        <div class="col-sm-9">
                                            <input type="text" name="email" id="typeUsernameX"
                                                   class="text-muted mb-0 form-control form-control-sm border-0"
                                                   value="${requestScope.USER_PROFILE.email}" readonly />
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <p class="mb-0">Phone</p>
                                        </div>
                                        <div class="col-sm-9">
                                            <input type="text" name="phone" id="typeUsernameX"
                                                   class="text-muted mb-0 form-control form-control-sm border-0"
                                                   value="${requestScope.USER_PROFILE.phone}" />
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <p class="mb-0">Address</p>
                                        </div>
                                        <div class="col-sm-9">
                                            <input type="text" name="address" id="typeUsernameX"
                                                   class="text-muted mb-0 form-control form-control-sm border-0"
                                                   value="${requestScope.USER_PROFILE.address}" />
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <p class="mb-0">Role</p>
                                        </div>
                                        <div class="col-sm-9">
                                            <select class="rounded" name="role" id="role"> 
                                                <option value="1">Admin</option>
                                                <option value="2">User</option>
                                                <option value="3">Seller</option>
                                            </select>
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
                                    <a href="AdminController" class="btn btn-outline-danger">Return</a>
                                </div>
                                <div class="col-sm-6 d-grid">

                                    <%--<button type="button" class="btn btn-success">Save</button> --%>
                                    <input class="btn btn-success" type="submit" name="action" value="Save"/>
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