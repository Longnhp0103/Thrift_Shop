<%-- 
    Document   : thankyou
    Created on : Nov 8, 2022, 3:31:17 PM
    Author     : Le Nguyen Nhat Minh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <div class="jumbotron text-center">
            <h1 class="display-3">Thank you for support our store!</h1>
            <p class="lead"><strong>Please come by the store</strong> to pick up for order </p>
            <hr>
            <p class="lead">
                <a class="btn btn-primary btn-sm" href="MainController?action=Home" role="button">Continue to homepage</a>
            </p>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
