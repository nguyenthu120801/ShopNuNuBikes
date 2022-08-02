package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("\n");
      out.write("  <!-- Basic Page Needs\n");
      out.write("  ================================================== -->\n");
      out.write("  <meta charset=\"utf-8\">\n");
      out.write("  <title>Nunushope | E-commerce template</title>\n");
      out.write("\n");
      out.write("  <!-- Mobile Specific Metas\n");
      out.write("  ================================================== -->\n");
      out.write("  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("  <meta name=\"description\" content=\"Construction Html5 Template\">\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=5.0\">\n");
      out.write("  <meta name=\"author\" content=\"Themefisher\">\n");
      out.write("  <meta name=\"generator\" content=\"Themefisher Constra HTML Template v1.0\">\n");
      out.write("  \n");
      out.write("  <!-- Favicon -->\n");
      out.write("  <link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"images/favicon.png\" />\n");
      out.write("  \n");
      out.write("  <!-- Themefisher Icon font -->\n");
      out.write("  <link rel=\"stylesheet\" href=\"plugins/themefisher-font/style.css\">\n");
      out.write("  <!-- bootstrap.min css -->\n");
      out.write("  <link rel=\"stylesheet\" href=\"plugins/bootstrap/css/bootstrap.min.css\">\n");
      out.write("  \n");
      out.write("  <!-- Animate css -->\n");
      out.write("  <link rel=\"stylesheet\" href=\"plugins/animate/animate.css\">\n");
      out.write("  <!-- Slick Carousel -->\n");
      out.write("  <link rel=\"stylesheet\" href=\"plugins/slick/slick.css\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"plugins/slick/slick-theme.css\">\n");
      out.write("  \n");
      out.write("  <!-- Main Stylesheet -->\n");
      out.write("  <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body id=\"body\">\n");
      out.write("\n");
      out.write("<section class=\"signin-page account\">\n");
      out.write("  <div class=\"container\">\n");
      out.write("    <div class=\"row\">\n");
      out.write("      <div class=\"col-md-6 col-md-offset-3\">\n");
      out.write("        <div class=\"block text-center\">\n");
      out.write("          <h2 class=\"text-center\">Welcome Back</h2>\n");
      out.write("          <form class=\"text-left clearfix\" action=\"LoginController\" method=\"POST\">\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("              <input type=\"text\" class=\"form-control\"  placeholder=\"username\" name=\"username\">\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                <input type=\"password\" class=\"form-control\" placeholder=\"Password\" name=\"password\">\n");
      out.write("            </div>\n");
      out.write("            <div class=\"text-center\">\n");
      out.write("                <button type=\"submit\" class=\"btn btn-main text-center\" value=\"Login\" >Login</button>\n");
      out.write("            </div>\n");
      out.write("          </form>\n");
      out.write("          <p class=\"mt-20\">New in this site ?<a href=\"Signin.jsp\"> Create New Account</a></p>\n");
      out.write("        <p style=\"color: red\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${error}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("        <p style=\"color: red\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${login}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</section>\n");
      out.write("\n");
      out.write("    <!-- \n");
      out.write("    Essential Scripts\n");
      out.write("    =====================================-->\n");
      out.write("    \n");
      out.write("    <!-- Main jQuery -->\n");
      out.write("    <script src=\"plugins/jquery/dist/jquery.min.js\"></script>\n");
      out.write("    <!-- Bootstrap 3.1 -->\n");
      out.write("    <script src=\"plugins/bootstrap/js/bootstrap.min.js\"></script>\n");
      out.write("    <!-- Bootstrap Touchpin -->\n");
      out.write("    <script src=\"plugins/bootstrap-touchspin/dist/jquery.bootstrap-touchspin.min.js\"></script>\n");
      out.write("    <!-- Instagram Feed Js -->\n");
      out.write("    <script src=\"plugins/instafeed/instafeed.min.js\"></script>\n");
      out.write("    <!-- Video Lightbox Plugin -->\n");
      out.write("    <script src=\"plugins/ekko-lightbox/dist/ekko-lightbox.min.js\"></script>\n");
      out.write("    <!-- Count Down Js -->\n");
      out.write("    <script src=\"plugins/syo-timer/build/jquery.syotimer.min.js\"></script>\n");
      out.write("\n");
      out.write("    <!-- slick Carousel -->\n");
      out.write("    <script src=\"plugins/slick/slick.min.js\"></script>\n");
      out.write("    <script src=\"plugins/slick/slick-animation.min.js\"></script>\n");
      out.write("\n");
      out.write("    <!-- Google Mapl -->\n");
      out.write("    <script src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyCC72vZw-6tGqFyRhhg5CkF2fqfILn2Tsw\"></script>\n");
      out.write("    <script type=\"text/javascript\" src=\"plugins/google-map/gmap.js\"></script>\n");
      out.write("\n");
      out.write("    <!-- Main Js File -->\n");
      out.write("    <script src=\"js/script.js\"></script>\n");
      out.write("    \n");
      out.write("\n");
      out.write("\n");
      out.write("  </body>\n");
      out.write("  </html>\n");
      out.write("\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
