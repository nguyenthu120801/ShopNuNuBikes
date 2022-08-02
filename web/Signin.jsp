<%-- 
    Document   : Signin
    Created on : Mar 2, 2022, 4:59:39 PM
    Author     : PC
--%>

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

<section class="signin-page account">
  <div class="container">
    <div class="row">
      <div class="col-md-6 col-md-offset-3">
        <div class="block text-center">
          <h2 class="text-center">Create Your Account</h2>
          <p style="color: red">${error}</p>
          <form class="text-left clearfix" action="ControllerCustomer">
            <p><input type="hidden" name="s" value="insertCustomer"></p>
            <div class="form-group">
                <input type="text" class="form-control"  placeholder="First Name" name="fName">
            </div>
            <div class="form-group">
                <input type="text" class="form-control"  placeholder="Last Name" name="lName">
            </div>
            <div class="form-group">
                <input type="text" class="form-control"  placeholder="Phone" name="phone">
            </div>
            <div class="form-group">
                <input type="email" class="form-control"  placeholder="Email" name="email">
            </div>
            <div class="form-group">
                <input type="text" class="form-control"  placeholder="Street" name="street">
            </div>
            <div class="form-group">
                <input type="text" class="form-control"  placeholder="City" name="city">
            </div>
            <div class="form-group">
                <input type="text" class="form-control"  placeholder="State" name="state">
            </div>
            <div class="form-group">
                <input type="text" class="form-control"  placeholder="Zipcode" name="zipCode">
            </div>
            <div class="form-group">
                <input type="text" class="form-control"  placeholder="Username" name="username">
            </div>
            <div class="form-group">
                <input type="password" class="form-control"  placeholder="Password" name="password">
            </div>
            <div class="text-center">
                <button type="submit" class="btn btn-main text-center" value="Sign">Sign In</button>
            </div>
          </form>
          <!--<p style="color: red">${error}</p>-->
          <p style="color: blue">${Sign}</p>
          <p class="mt-20">Already have an account ?<a href="login.jsp"> Login</a></p>
          <p><a href="forget-password.html"> Forgot your password?</a></p>
        </div>
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