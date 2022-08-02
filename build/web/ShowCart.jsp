<%-- 
    Document   : ItemListCart
    Created on : Feb 25, 2022, 8:35:12 AM
    Author     : PC
--%>

<%@page import="entity.Customers"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <!-- Basic Page Needs
  ================================================== -->
        <meta charset="utf-8">
        <title>Aviato | E-commerce template</title>

        <!-- Mobile Specific Metas
  ================================================== -->
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="description" content="Construction Html5 Template">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=5.0">
        <meta name="author" content="Themefisher">
        <meta name="generator" content="Themefisher Constra HTML Template v1.0">

        <!-- Favicon -->
        <link rel="shortcut icon" type="image/x-icon" href="images/favicon.png" />

        <!-- Themefisher Icon font -->
        <link rel="stylesheet" href="plugins/themefisher-font/style.css">
        <!-- bootstrap.min css -->
        <link rel="stylesheet" href="plugins/bootstrap/css/bootstrap.min.css">

        <!-- Animate css -->
        <link rel="stylesheet" href="plugins/animate/animate.css">
        <!-- Slick Carousel -->
        <link rel="stylesheet" href="plugins/slick/slick.css">
        <link rel="stylesheet" href="plugins/slick/slick-theme.css">

        <!-- Main Stylesheet -->
        <link rel="stylesheet" href="css/style.css">

    </head>
    <%
        java.util.Enumeration em = session.getAttributeNames();
        int idCus = 0;
        String fullname = null;
        String username = null;
        while (em.hasMoreElements()) {
            String key = em.nextElement().toString();
            if (key.equals("username")) {
                Customers customer = (Customers) session.getAttribute(key);
                idCus = customer.getCustomerID();
                fullname = customer.getFirstName() + customer.getLastName();
                username = customer.getUsername();
            }
        }
    %>

    <body id="body">
        <!-- Start Top Header Bar -->
        <section class="top-header">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-4 col-xs-12 col-sm-4">
                        <div class="contact-number">
                            <i class="tf-ion-ios-telephone"></i>
                            <span >0984- 739-0845</span>
                        </div>
                    </div>
                    <div class="col-md-4 col-xs-12 col-sm-4">
                        <!-- Site Logo -->
                        <div class="logo text-center">
                            <div class="logo " style="width: 100%;height: 100%;">
                                <a href="ControllerProduct">
                                    <!-- replace logo here -->
                                    <span
                                        style="font-size: 40px; font-family: 'Times New Roman', Times, serif, Helvetica, sans-serif;">NUNUSHOP</span>
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-4" >
                        <ul class="nav navbar-nav" style="margin-top: 15px">
                            <a href="#!" data-delay="350" role="button" aria-haspopup="true" aria-expanded="false" style="font-size: 18px;"> RollNumber:<%=idCus%> |FullName:<%=fullname%> |WelCome <%=username%> </a>
                        </ul>
                    </div>
                </div>
            </div>
        </section><!-- End Top Header Bar -->


        <section class="page-header">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="content">
                            <h1 class="page-name">Show Cart</h1>
                            <ol class="breadcrumb">
                                <li><a href="ControllerProduct">Home</a></li>
                                <li class="active">Cart</li>
                            </ol>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <c:set var="total" value="0.00"></c:set>
        <section class="user-dashboard page-wrapper" style="height: 100vh">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="dashboard-wrapper user-dashboard">
                                <div class="table-responsive" >
                                <c:choose>
                                    <c:when test="${sessionScope.carts== null || sessionScope.carts.size()==0}">
                                        <h1>List Cart is Empty!</h1>
                                    </c:when>
                                    <c:otherwise>
                                        <table class="table">
                                            <thead>
                                                <tr>
                                                    <th>ID</th>
                                                    <th>Name</th>
                                                    <th>Quantity</th>
                                                    <th>Price</th>
                                                    <th>Total</th>
                                                    <th class="col-md-2 col-sm-3">Actions</th>
                                                    <th></th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${carts}" var="C" >
                                                    <c:set var="total" value="${total + C.value.quantity*C.value.p.listPrice}"></c:set>
                                                    <form action="UpdateCartQuantityCtroller">
                                                        <input type="hidden" name="productid" value="${C.value.p.productID}">
                                                    <tr>
                                                        <td>${C.value.p.productID}</td>
                                                        <td>${C.value.p.productName}</td>
                                                        <td><input onchange="this.form.submit()" type="number" name="quantity" value="${C.value.quantity}"></td>
                                                        <td>${C.value.p.listPrice}</td>
                                                        <td>${C.value.quantity*C.value.p.listPrice}</td>
                                                        <td><a href="DeleteCartController?productid=${C.value.p.productID}" class="btn btn-danger"> Delete</a></td>
                                                    </tr>
                                                </form>
                                            </c:forEach>
                                            </tbody>
                                        </table>
                                        <h3>Total Amount: $${total}</h3>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                    </div>
                </div>
                <a href="CartsController?s=CheckoutCart" class="btn btn-success w-100">check out</a>
            </div>
        </section>
        <footer class="footer section text-center">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <ul class="social-media">
                            <li>
                                <a href="https://www.facebook.com/themefisher">
                                    <i class="tf-ion-social-facebook"></i>
                                </a>
                            </li>
                            <li>
                                <a href="https://www.instagram.com/themefisher">
                                    <i class="tf-ion-social-instagram"></i>
                                </a>
                            </li>
                            <li>
                                <a href="https://www.twitter.com/themefisher">
                                    <i class="tf-ion-social-twitter"></i>
                                </a>
                            </li>
                            <li>
                                <a href="https://www.pinterest.com/themefisher/">
                                    <i class="tf-ion-social-pinterest"></i>
                                </a>
                            </li>
                        </ul>
                        <ul class="footer-menu text-uppercase">
                            <li>
                                <a href="#">CONTACT</a>
                            </li>
                            <li>
                                <a href="shop.html">SHOP</a>
                            </li>
                            <li>
                                <a href="#">Pricing</a>
                            </li>
                            <li>
                                <a href="#">PRIVACY POLICY</a>
                            </li>
                        </ul>
                        <p class="copyright-text">Copyright &copy;2021, Designed &amp; Developed by <a
                                href="#">ThuThu</a></p>
                    </div>
                </div>
            </div>
        </footer>
        <!-- 
    Essential Scripts
    =====================================-->

        <!-- Main jQuery -->
        <script src="plugins/jquery/dist/jquery.min.js"></script>
        <!-- Bootstrap 3.1 -->
        <script src="plugins/bootstrap/js/bootstrap.min.js"></script>
        <!-- Bootstrap Touchpin -->
        <script src="plugins/bootstrap-touchspin/dist/jquery.bootstrap-touchspin.min.js"></script>
        <!-- Instagram Feed Js -->
        <script src="plugins/instafeed/instafeed.min.js"></script>
        <!-- Video Lightbox Plugin -->
        <script src="plugins/ekko-lightbox/dist/ekko-lightbox.min.js"></script>
        <!-- Count Down Js -->
        <script src="plugins/syo-timer/build/jquery.syotimer.min.js"></script>

        <!-- slick Carousel -->
        <script src="plugins/slick/slick.min.js"></script>
        <script src="plugins/slick/slick-animation.min.js"></script>

        <!-- Google Mapl -->
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCC72vZw-6tGqFyRhhg5CkF2fqfILn2Tsw"></script>
        <script type="text/javascript" src="plugins/google-map/gmap.js"></script>

        <!-- Main Js File -->
        <script src="js/script.js"></script>



    </body>

</html>

