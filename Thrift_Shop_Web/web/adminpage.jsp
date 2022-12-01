<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ThriftShop</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" rel="stylesheet">
    <style>
    body {
            color: #566787;
            background: #f5f5f5;
            font-family: "Varela Round", sans-serif;
            font-size: 13px;
        }
        .table-responsive {
            margin: 30px 0;
        }
        .table-wrapper {
            min-width: 1000px;
            background: #fff;
            padding: 20px 25px;
            border-radius: 3px;
            box-shadow: 0 1px 1px rgba(0, 0, 0, 0.05);
        }
        .table-title {
            padding-bottom: 15px;
            background: #a87e62;
            color: #fff;
            padding: 16px 30px;
            margin: -20px -25px 10px;
            border-radius: 3px 3px 0 0;
        }
        .table-title h2 {
            margin: 5px 0 0;
            font-size: 24px;
        }
        .table-title .btn {
            color: #566787;
            float: right;
            font-size: 13px;
            background: #fff;
            border: none;
            min-width: 50px;
            border-radius: 2px;
            border: none;
            outline: none !important;
            margin-left: 10px;
        }
        .table-title .btn:hover,
        .table-title .btn:focus {
            color: #566787;
            background: #f2f2f2;
        }
        .table-title .btn i {
            float: left;
            font-size: 21px;
            margin-right: 5px;
        }
        .table-title .btn span {
            float: left;
            margin-top: 2px;
        }
        table.table tr th,
        table.table tr td {
            border-color: #e9e9e9;
            padding: 12px 15px;
            vertical-align: middle;
        }
        table.table tr th:first-child {
            width: 60px;
        }
        table.table tr th:last-child {
            width: 100px;
        }
        table.table-striped tbody tr:nth-of-type(odd) {
            background-color: #fcfcfc;
        }
        table.table-striped.table-hover tbody tr:hover {
            background: #f5f5f5;
        }
        table.table th i {
            font-size: 13px;
            margin: 0 5px;
            cursor: pointer;
        }
        table.table td:last-child i {
            opacity: 0.9;
            font-size: 22px;
            margin: 0 5px;
        }
        table.table td a {
            font-weight: bold;
            color: #566787;
            display: inline-block;
            text-decoration: none;
        }
        table.table td a:hover {
            color: #2196f3;
        }
        table.table td a.settings {
            color: #2196f3;
        }

        table.table td a.success {
            color: #348655;
        }

        table.table td i {
            font-size: 19px;
        }
        table.table .avatar {
            border-radius: 50%;
            vertical-align: middle;
            margin-right: 10px;
        }
        .status {
            font-size: 30px;
            margin: 2px 2px 0 0;
            display: inline-block;
            vertical-align: middle;
            line-height: 10px;
        }
        .text-success {
            color: #10c469;
        }
        .text-info {
            color: #62c9e8;
        }
        .text-warning {
            color: #ffc107;
        }
        .text-danger {
            color: #ff5b5b;
        }
        .pagination {
            float: right;
            margin: 0 0 5px;
        }
        .pagination li a {
            border: none;
            font-size: 13px;
            min-width: 30px;
            min-height: 30px;
            color: #999;
            margin: 0 2px;
            line-height: 30px;
            border-radius: 2px !important;
            text-align: center;
            padding: 0 6px;
        }
        .pagination li a:hover {
            color: #666;
        }
        .pagination li.active a,
        .pagination li.active a.page-link {
            background: #03a9f4;
        }
        .pagination li.active a:hover {
            background: #0397d6;
        }
        .pagination li.disabled i {
            color: #ccc;
        }
        .pagination li i {
            font-size: 16px;
            padding-top: 6px;
        }
        .hint-text {
            float: left;
            margin-top: 10px;
            font-size: 13px;
        }
        .dropbtn {
            background-color: #111;
            color: white;
            padding: 16px;
            font-size: 16px;
            border: none;
            cursor: pointer;
        }
        .dropdown {
            position: relative;
            display: inline-block;
        }

        .dropdown-content {
            display: none;
            position: absolute;
            background-color: #f1f1f1;
            min-width: 160px;
            overflow: auto;
            box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
            z-index: 1;
        }

        .dropdown-content a {
            color: black;
            padding: 12px 16px;
            text-decoration: none;
            display: block;
        }

        .dropdown a:hover {
            background-color: #ddd;
        }

        .show {
            display: block;
        }
        .sidebar {
            height: 100%;
            position: fixed;
            z-index: 1;
            top: 0;
            left: 0;
            background-color: #111;
            overflow-x: hidden;
            padding-top: 16px;
            padding-right: 5px;
        }

        .sidebar a {
            padding: 6px 8px 6px 16px;
            text-decoration: none;
            font-size: 20px;
            color: #818181;
            display: block;
        }
        .sidebar a:hover{
            color: #111;
        }
        .sidebar_up a:hover {
            color: #f1f1f1;
        }
        .dropdown button{
            font-size: 20px;
        }
        .text-success {
            color: #10c469;
        }
        .text-info {
            color: #62c9e8;
        }
        .text-warning {
            color: #FFC107;
        }
        .text-danger {
            color: #ff5b5b;
        }
    </style>
</head>
<body>

    <%--        <c:if test="${sessionScope.LOGIN_USER == null || sessionScope.LOGIN_USER.roleName ne 'Admin'}"> 
                <c:redirect url="login.jsp"></c:redirect>
            </c:if> --%>
    <div class="col-sm-1">
        <div class="sidebar">
            <div class="sidebar_up">
                <a href="OrderController"><i class="fa-solid fa-calendar-days"></i> Order</a>
                <a href="ProductController"><i class="fa-sharp fa-solid fa-list"></i> Product</a>
                <a href="AdminController"><i class="fa-solid fa-users"></i> User</a>   
            </div>

            <hr/>
            <div class="dropdown">
                <button onclick="myFunction()" class="dropbtn"> <i class="fa-solid fa-user"></i>  Admin</button>
                <div  id="myDropdown" class="dropdown-content">
                    <a style="font-size: 15px;" href="LoginController"><i class="fa-solid fa-right-from-bracket"></i> Sign out</a>
                </div>
            </div>
        </div>
    </div>
    
    
    <div class="table-responsive">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-4">
                        <h2>User <b>Management</b></h2>
                    </div>
                    <div class="col-sm-8 d-flex justify-content-end">
                        <FORM action="SearchController" method="POST">
                            <input class="text-dark" name="search" type="text" placeholder="Search Full Name"/>
                            <button style="background-color: #a87e62; border:none" type="submit" name="action" value="adminUserSearch"><i style="background-color: #a87e62;" class="fa-solid fa-magnifying-glass"></i></button>
                        </FORM>

                    </div>                 
                </div>
            </div>
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
                        <th>No</th>                       
                        <th>Username</th>
                        <th>Full Name</th>
                        <th>Email </th>
                        <th>Pass </th>
                        <th>Status</th>
                        <th>Phone </th> 
                        <th>Address</th>
                        <th>Role</th> 
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="acount" items="${listAccount}" varStatus="counter">
                    <form action="AdminController" method="POST">
                        <tr>
                            <td>${counter.count}</td>
                            <td>${acount.userName}</td>
                            <td>${acount.fullName}</td>
                            <td>${acount.email}</td>
                            <td>******</td>
                            <td <c:if test="${acount.status==false}"> class="text-danger"</c:if>  class="text-success"> ${acount.status}</th>
                            <th>${acount.phone} </th> 
                            <th>${acount.address}</th>
                            <th>${acount.roleName}</th> 
                            <td>                          
                                <input class="btn btn-primary" type="submit" name="action" value="Setting"/>
                                <input type="hidden" name="email" value="${acount.email}"/>
                            </td> 
                        </tr>
                    </form>  
                </c:forEach>             
                </tbody>
            </table>

        </div>        
    </div>
    <script>
        /* When the user clicks on the button, 
         toggle between hiding and showing the dropdown content */
        function myFunction() {
            document.getElementById("myDropdown").classList.toggle("show");
        }

        // Close the dropdown if the user clicks outside of it
        window.onclick = function (event) {
            if (!event.target.matches(".dropbtn")) {
                var dropdowns = document.getElementsByClassName("dropdown-content");
                var i;
                for (i = 0; i < dropdowns.length; i++) {
                    var openDropdown = dropdowns[i];
                    if (openDropdown.classList.contains("show")) {
                        openDropdown.classList.remove("show");
                    }
                }
            }
        };
    </script>
</body>