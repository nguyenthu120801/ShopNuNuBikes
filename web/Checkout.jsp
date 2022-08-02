<%-- 
    Document   : ItemListCart
    Created on : Feb 25, 2022, 8:35:12 AM
    Author     : PC
--%>

<%@page import="java.sql.ResultSet"%>
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
                </div>
            </div>
        </section><!-- End Top Header Bar -->


        <section class="page-header">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="content">
                            <h1 class="page-name">Checkout</h1>
                            <ol class="breadcrumb">
                                <li><a href="ControllerProduct">Home</a></li>
                                <li class="active">checkout</li>
                            </ol>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <c:set var="total" value="0.00"></c:set>
            <section class="user-dashboard page-wrapper">
                <div class="container">
                    <div class="row">
                        <div class="col-md-8">
                            <div class="dashboard-wrapper user-dashboard">
                                <div class="table-responsive" >
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th>ID</th>
                                                <th>Name</th>
                                                <th>Quantity</th>
                                                <th>Price</th>
                                                <th>Total</th>
                                                <th></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${carts}" var="C" >
                                            <c:set var="total" value="${total + C.value.quantity*C.value.p.listPrice}"></c:set>
                                                <tr>
                                                    <td>${C.value.p.productID}</td>
                                                <td>${C.value.p.productName}</td>
                                                <td>${C.value.quantity}</td>
                                                <td>${C.value.p.listPrice}</td>
                                                <td>${C.value.quantity*C.value.p.listPrice}</td>
                                            </tr>
                                            </form>
                                        </c:forEach>
                                    </tbody>
                                </table>
                                <h3>Total Amount: $${total}</h3>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <h3>Billing Address</h3>
                        <%ResultSet rs = (ResultSet)request.getAttribute("customerID");
                        if(rs.next()){
                        %>
                        <form class="row g-3" action="CartsController" >
                            <input type="hidden" name="s" value="AddCartDB">
                            <div class="row">
                                <div class="col-md-6">
                                    <label for="fname" class="form-label">First Name</label>
                                    <input type="text" class="form-control" id="fname" name="fname" value="<%=rs.getString(2) %>">
                                </div>
                                <div class="col-md-6">
                                    <label for="lname" class="form-label">Last Name</label>
                                    <input type="text" class="form-control" id="lname" name="lname" value="<%=rs.getString(3) %>">
                                </div>
                            </div>
                            <div class="col-12">
                                <label for="Phone" class="form-label">Phone</label>
                                <input type="text" class="form-control" id="Phone" name="Phone" placeholder="(+84)0984722341" value="<%=rs.getString(4) %>">
                            </div>
                            <div class="col-12">
                                <label for="Email" class="form-label">Email</label>
                                <input type="email" class="form-control" id="Email" name ="Email " placeholder="uername@gmail.com" value="<%=rs.getString(5) %>">
                            </div>
                            <div class="col-12">
                                <label for="Street" class="form-label">Street</label>
                                <input type="text" class="form-control" id="Street" name="Street" placeholder="1234 Main St" value="<%=rs.getString(6) %>">
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <label for="City" class="form-label">City</label>
                                    <input type="text" class="form-control" id="City" name="City" value="<%=rs.getString(7) %>">
                                </div>
                                <div class="col-md-3">
                                    <label for="State" class="form-label">State</label>
                                    <input type="text" id="State" name="State" class="form-select" name="State" value="<%=rs.getString(8) %>">
                                </div>
                                <div class="col-md-3">
                                    <label for="ZipCode" class="form-label" >ZipCode</label>
                                    <input type="text" class="form-control" id="ZipCode" name="ZipCode" value="<%=rs.getString(9) %>">
                                </div>
                            </div>
                                <%}%>
                            <br>
                            <div class="col-12">
                                <button type="submit" class="btn btn-primary w-100">Submit</button>
                            </div>
                        </form>
                    </div>
                </div>
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

