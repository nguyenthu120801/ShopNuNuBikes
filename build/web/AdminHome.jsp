<%-- 
    Document   : index
    Created on : Mar 2, 2022, 2:56:00 PM
    Author     : PC
--%>

<%@page import="entity.staff"%>
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
        java.util.Enumeration em = session.getAttributeNames();
        int idSt = 0;
        String fullname = null;
        String username = null;
        while (em.hasMoreElements()) {
            String key = em.nextElement().toString();
            if (key.equals("admin")) {
                staff st = (staff) session.getAttribute(key);
                idSt = st.getStaffID();
                fullname = st.getFirstName() + st.getLastName();
                username = st.getUsername();
            }
        }
    %>
    <body id="body">
        <!-- Start Top Header Bar -->
        <section class="top-header" >
            <div class="container-fluid row">
                <div class="col-lg-7 col-md-5">
                    <div class="col-md-4 col-xs-12 col-sm-4">
                        <!-- Site Logo -->
                        <div class="logo " style="width: 100%;height: 100%;" >
                            <a href="ControllerProduct">
                                <!-- replace logo here -->
                                <span style="font-size: 40px; font-family: 'Times New Roman', Times, serif, Helvetica, sans-serif;" >NUNUSHOP</span>
                            </a>
                        </div>
                    </div>
                    <div id="navbar" class="navbar-collapse collapse text-center">
                        <ul class="nav navbar-nav">

                            <!-- Home -->
                            <li class="dropdown ">
                                <a href="ControllerProduct">HOME</a>
                            </li><!-- / Home -->
                        </ul>
                    </div>
                </div>

                <div class="col-lg-4 col-md-4" >
                    <ul class="nav navbar-nav" style="margin-top: 15px">
                        <a href="#!" data-delay="350" role="button" aria-haspopup="true" aria-expanded="false" style="font-size: 18px;"> RollNumber:<%=idSt%> |FullName:<%=fullname%> |WelCome <%=username%> </a>
                    </ul>
                </div>
                <div class="col-lg-1 col-md-1">
                    <button class="btn btn-outline-primary ms-lg-2" style="margin-top: 10px" ><a href="logoutController">Logout</button>
                </div>
            </div>
        </div>
    </section><!-- End Top Header Bar -->

    <section class="products section bg-gray" style="height: 100vh">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-3 title text-center">
                    <h2>Manager</h2>
                    <ul class="list-group">
                        <li class="list-group-item"><a href="ControllerCustomer?s=displayAllCustomer">Customer Manager</a></li>
                        <li class="list-group-item"><a href="ProductSevlet?s=displayAllProduct">Product Manager</a></li>
                        <li class="list-group-item"><a href="BillServlet?s=Bill">Bill Manager</a></li>
                    </ul>
                </div >
                <div class="col-lg-9 title text-center">
                    <h2>Detail</h2> 
                </div>
            </div>
        </div>
    </section>




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


