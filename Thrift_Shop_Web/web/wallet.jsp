<%-- 
    Document   : wallet
    Created on : Oct 12, 2022, 4:31:17 PM
    Author     : Admiz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    </head>
    <%@include  file="header.jsp" %>
    <body>
        <section  style="background-color: #eee;">
            <div class="container py-5">
                <div class="row">
                    <div class="col">
                        <nav aria-label="breadcrumb" class="bg-light rounded-3 p-3 mb-4">
                            <div class="row">
                                <div class="col-sm-6">
                                    <h5 class="text-warning">Balance: ${sessionScope.AMOUNT.amount}VND</h5>
                                </div>

                                <div class="col-sm-6 d-flex justify-content-end">                               
                                    <a class="btn btn-success " href="addmoney.jsp">Add Money</a>
                                </div>
                        </nav>
                    </div>
                </div>
                <div class="container mt-3 bg-light rounded-3 p-3">
                    <h3 class="mb-4">Transaction history</h3>
                    <table class="table">
                        <thead>
                            <tr>                               
                                <th>Description</th>
                                <th>Money</th>  
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="transaction" items="${sessionScope.TRANSACTION}" >
                                <tr>
                                    <td>${transaction.description}</td>
                                    <td>${transaction.amount}</td>
                                </tr>
                            </c:forEach>


                        </tbody>
                    </table>
                </div>
            </div>
    </body>

</html>
<%@include  file="footer.jsp" %>