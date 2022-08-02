<%-- 
    Document   : index
    Created on : Mar 2, 2022, 2:56:00 PM
    Author     : PC
--%>

<%@page import="entity.Customers"%>
<%@page import="java.sql.ResultSet"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <!-- Basic Page Needs
  ================================================== -->
        <meta charset="utf-8">
        <title>Nunushop | E-commerce template</title>

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
        ResultSet rscategory = (ResultSet) request.getAttribute("category");
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
        <section class="top-header" >
            <div class="container-fluid row">
                <div class="col-lg-5 col-md-5">
                    <div class="col-md-4 col-xs-12 col-sm-4">
                        <!-- Site Logo -->
                        <div class="logo " style="width: 100%;height: 100%;" >
                            <a href="ControllerProduct">
                                <!-- replace logo here -->
                                <span style="font-size: 30px; font-family: 'Times New Roman', Times, serif, Helvetica, sans-serif;" >NUNUSHOP</span>
                            </a>
                        </div>
                    </div>
                    <div id="navbar" class="col-md-1 navbar-collapse collapse text-center">
                        <ul class="nav navbar-nav">

                            <!-- Home -->
                            <li class="dropdown ">
                                <a href="ControllerProduct">HOME</a>
                            </li><!-- / Home -->


                            <!-- Elements -->
                            <li class="dropdown dropdown-slide">
                                <a href="#!" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown"
                                   data-delay="350" role="button" aria-haspopup="true" aria-expanded="false">SHOPE <span
                                        class="tf-ion-ios-arrow-down"></span></a>
                                <div class="dropdown-menu">
                                    <div class="row">

                                        <!-- Basic -->
                                        <div class="col-lg-6 col-md-6 mb-sm-3">
                                            <ul>
                                                <li><a href="ControllerStore">Store</a></li>
                                            </ul>
                                        </div>

                                    </div><!-- / .row -->
                                </div><!-- / .dropdown-menu -->
                            </li><!-- / Elements -->
                        </ul><!-- / .nav .navbar-nav -->

                    </div>
                </div>

                <!-- Search -->
                <div class="col-lg-3 col-md-5">
                    <form class="d-flex" style="margin-top: 12px;" action="ControllerProduct">
                        <input type="hidden" name="s" value="searchProductbyName">
                        <input type="search" placeholder="Search Product" name="nameproduct"/>
                        <button class="btn btn-outline-success" type="submit">Search</button>
                    </form>
                </div>
                <!-- / Search -->
                <div class="col-lg-2 col-md-2 col-xs-12 col-sm-4" style="margin-top: 12px;">
                    <!-- Cart -->
                    <ul class="top-menu text-right list-inline">
                        <li class="dropdown cart-nav dropdown-slide">
                            <a href="#!" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" style="font-size: 20px;top:auto">
                                <i class="tf-ion-android-cart mx-auto" style="font-size: 25px;top:auto"></i>Cart 
                                <span class="badge bg-dark text-white ms-1 rounded-pill">${sessionScope.carts.size()}</span>
                            </a>
                            <div class="dropdown-menu cart-dropdown">
                                <ul class="text-center cart-buttons">
                                    <li><a href="/SE1605_MVC/ShowCart.jsp" class="btn btn-small">View Cart</a></li>
                                    <li><a href="CartsController?s=CheckoutCart" class="btn btn-small btn-solid-border">Checkout</a></li>
                                </ul>
                            </div>
                        </li><!-- / Cart -->
                    </ul><!-- / .nav .navbar-nav .navbar-right -->
                </div>
                <%if(username == null){ %>
                <div class="col-lg-2 col-md-2" style="margin-top: 12px;">
                    <button class="btn btn-outline-primary ms-lg-2"><a href="Login.jsp">Login</button>
                    <button class="btn btn-outline-primary ms-lg-2">Register</button>
                </div>
                <%} else {%>
                <div class="col-lg-2 col-md-2" >
                    <ul class="nav navbar-nav">
                        <li class="dropdown dropdown-slide">
                            <a href="#!" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown"
                               data-delay="350" role="button" aria-haspopup="true" aria-expanded="false" style="font-size: 18px">WelCome <%=username%>
                               <span class="tf-ion-ios-arrow-down"></span></a>
                            <div class="dropdown-menu">
                                <div class="row">
                                    <div class="col-lg-6 col-md-6 mb-sm-3">
                                        <ul>
                                            <li>RollNumber:<%=idCus%></li>
                                            <li>FullName:<%=fullname%></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </li>
                    </ul>
                | <button class="btn btn-outline-primary ms-lg-2" style="margin-top: 10px" ><a href="logoutController">Logout</button>
                </div>
                <%}%>
            </div>
        </div>
    </section><!-- End Top Header Bar -->


    <!-- Main Menu Section -->
    <div class="hero-slider" style="background-image: url(images/slider/slider-1.jpg);">
        <div class="slider-item th-fullpage hero-area" style="background-image: url(images/slider/slider-1.jpg);">
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 text-center">
                        <p data-duration-in=".3" data-animation-in="fadeInUp" data-delay-in=".1">PRODUCTS</p>
                        <h1 data-duration-in=".3" data-animation-in="fadeInUp" data-delay-in=".5">The beauty of nature
                            <br> is hidden in details.
                        </h1>
                        <a data-duration-in=".3" data-animation-in="fadeInUp" data-delay-in=".8" class="btn"
                           href="ControllerStore">Store Now</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="slider-item th-fullpage hero-area" style="background-image: url(images/slider/slider-3.jpg);">
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 text-left">
                        <p data-duration-in=".3" data-animation-in="fadeInUp" data-delay-in=".1">PRODUCTS</p>
                        <h1 data-duration-in=".3" data-animation-in="fadeInUp" data-delay-in=".5">The beauty of nature
                            <br> is hidden in details.
                        </h1>
                        <a data-duration-in=".3" data-animation-in="fadeInUp" data-delay-in=".8" class="btn"
                           href="ControllerStore">Store Now</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="slider-item th-fullpage hero-area" style="background-image: url(images/slider/slider-2.jpg);">
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 text-right">
                        <p data-duration-in=".3" data-animation-in="fadeInUp" data-delay-in=".1">PRODUCTS</p>
                        <h1 data-duration-in=".3" data-animation-in="fadeInUp" data-delay-in=".5">The beauty of nature
                            <br> is hidden in details.
                        </h1>
                        <a data-duration-in=".3" data-animation-in="fadeInUp" data-delay-in=".8" class="btn"
                           href="ControllerStore">Store Now</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <section class="products section bg-gray">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-3 title text-center">
                    <h2>Category</h2>
                    <ul class="list-group" style="margin-top: 10%">
                        <%while (rscategory.next()) {%>
                        <li class="list-group-item list-group-item-action list-group-item-warning" style="margin-left: 8%"><a href="ControllerProduct?s=selectcategory&categoryName=<%=rscategory.getString(1)%>"><%=rscategory.getString(1)%></a></li>
                            <%}%>
                    </ul>
                </div >
                <div class="col-lg-9 title text-center">
                    <h2>Product</h2>
                    <div class="row" style="margin-left: 3%">
                        <c:forEach items="${ProductList}" var="P">
                            <div  class="col-lg-4 text-center" style="border: 1px solid black; border-radius: 10px ; margin: 2%;margin-left: 3%; width: 20vw; height: 45vh">
                                <h2>${P.productName}</h2>
                                <p>${P.brandName}</p>
                                <br>
                                <p>Price: $${P.listPrice}</p>
                                <br>
                                <p>${p.categoryName}</p>
                                <br>
                                <button class="posision-fixed" type="submit" style="radius: 10px" ><a href="AddtoCartController?productid=${P.productID}">Add to Cart</a></button>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </section>


    <!--
Start Call To Action
==================================== -->
    <footer class="footer section text-center">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <ul class="social-media">
                        <li>
                            <a href="#">
                                <i class="tf-ion-social-facebook"></i>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <i class="tf-ion-social-instagram"></i>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <i class="tf-ion-social-twitter"></i>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <i class="tf-ion-social-pinterest"></i>
                            </a>
                        </li>
                    </ul>
                    <ul class="footer-menu text-uppercase">
                        <li>
                            <a href="#">CONTACT</a>
                        </li>
                        <li>
                            <a href="#">SHOP</a>
                        </li>
                        <li>
                            <a href="#">Pricing</a>
                        </li>
                        <li>
                            <a href="#">PRIVACY POLICY</a>
                        </li>
                    </ul>
                    <p class="copyright-text">Copyright &copy;2021, Designed &amp; Developed by <a
                            href="#">Thuthu</a></p>
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
