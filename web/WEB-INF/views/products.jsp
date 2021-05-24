<%-- 
    Document   : product
    Created on : May 21, 2021, 8:00:44 PM
    Author     : George.Pasparakis
--%>

<%@page import="models.User"%>
<%@page import="java.util.List"%>
<%@page import="models.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
        <link rel="stylesheet" href="css/mystyle.css" />
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.3/css/all.css">
    </head>
    <body>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
        <h3>Product: </h3>

        <div class="container">
            <div class="row">
                <%
                    List<Product> products = (List<Product>) request.getAttribute("products");
                    if (request.getAttribute("user") != null) {
                        User user = (User) request.getAttribute("user");
                        for (Product product : products) {
                            out.println(product.getId());
                            out.println("<div class=\"col-sm\">");
                            out.println("<form method=\"POST\" action=\"checkOut\">");
                            out.println("<p>" + product.getName() + "</p>");
                            out.println("<p><img src=\"" + product.getImage() + "\"alt=\"PEN\"/></p>");
                            out.println("<p>" + product.getPrice() + "&euro;</p>");
                            out.println("<p>" + product.getDescription() + "</p>");
                            out.println("<input type='hidden' name= 'p_id' value='"+product.getId()+"' />"); //+product.getId()+
                            out.println("<input type='hidden' name= 'user_id' value='"+user.getId()+"' />"); //user.getId()
                            out.println("<button type='submit' ><i class='fas fa-shopping-basket'></i>Buy</button>");
                            
                            out.println("</form>");
                            out.println("</div>");
                        }

                    } else {
                        for (Product product : products) {

                            out.println("<div class=\"col-sm\">");
                            out.println("<p>" + product.getName() + "</p>");
                            out.println("<p><img src=\"" + product.getImage() + "\"alt=\"PEN\"/></p>");
                            out.println("<p>" + product.getPrice() + "&euro;</p>");
                            out.println("<p>" + product.getDescription() + "</p>");
                            out.println("<button ><i class=\"fas fa-shopping-basket\"></i>Buy</button>");

                            out.println("</div>");

                        }
                    }

                %>



            </div>
        </div>


    </body>
</html>
