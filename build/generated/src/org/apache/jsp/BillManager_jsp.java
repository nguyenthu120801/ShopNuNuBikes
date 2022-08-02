package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import entity.Bill;
import entity.Order;
import java.util.Vector;
import entity.staff;
import java.sql.ResultSet;

public final class BillManager_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("\n");
      out.write("        <!-- Basic Page Needs\n");
      out.write("  ================================================== -->\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <title>Nunushop | E-commerce template</title>\n");
      out.write("\n");
      out.write("        <!-- Mobile Specific Metas\n");
      out.write("  ================================================== -->\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"description\" content=\"Construction Html5 Template\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=5.0\">\n");
      out.write("        <meta name=\"author\" content=\"Themefisher\">\n");
      out.write("        <meta name=\"generator\" content=\"Themefisher Constra HTML Template v1.0\">\n");
      out.write("\n");
      out.write("        <!-- Favicon -->\n");
      out.write("        <link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"images/favicon.png\" />\n");
      out.write("\n");
      out.write("        <!-- Themefisher Icon font -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"plugins/themefisher-font/style.css\">\n");
      out.write("        <!-- bootstrap.min css -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"plugins/bootstrap/css/bootstrap.min.css\">\n");
      out.write("\n");
      out.write("        <!-- Animate css -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"plugins/animate/animate.css\">\n");
      out.write("        <!-- Slick Carousel -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"plugins/slick/slick.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"plugins/slick/slick-theme.css\">\n");
      out.write("\n");
      out.write("        <!-- Main Stylesheet -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    ");

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
    
      out.write("\n");
      out.write("    <body id=\"body\">\n");
      out.write("        <!-- Start Top Header Bar -->\n");
      out.write("        <section class=\"top-header\" >\n");
      out.write("            <div class=\"container-fluid row\">\n");
      out.write("                <div class=\"col-lg-7 col-md-5\">\n");
      out.write("                    <div class=\"col-md-4 col-xs-12 col-sm-4\">\n");
      out.write("                        <!-- Site Logo -->\n");
      out.write("                        <div class=\"logo \" style=\"width: 100%;height: 100%;\" >\n");
      out.write("                            <a href=\"ControllerProduct\">\n");
      out.write("                                <!-- replace logo here -->\n");
      out.write("                                <span style=\"font-size: 40px; font-family: 'Times New Roman', Times, serif, Helvetica, sans-serif;\" >NUNUSHOP</span>\n");
      out.write("                            </a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div id=\"navbar\" class=\"navbar-collapse collapse text-center\">\n");
      out.write("                        <ul class=\"nav navbar-nav\">\n");
      out.write("\n");
      out.write("                            <!-- Home -->\n");
      out.write("                            <li class=\"dropdown \">\n");
      out.write("                                <a href=\"ControllerProduct\">HOME</a>\n");
      out.write("                            </li><!-- / Home -->\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"col-lg-4 col-md-4\" >\n");
      out.write("                    <ul class=\"nav navbar-nav\" style=\"margin-top: 15px\">\n");
      out.write("                        <a href=\"#!\" data-delay=\"350\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\" style=\"font-size: 18px;\"> RollNumber:");
      out.print(idSt);
      out.write(" |FullName:");
      out.print(fullname);
      out.write(" |WelCome ");
      out.print(username);
      out.write(" </a>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-lg-1 col-md-1\">\n");
      out.write("                    <button class=\"btn btn-outline-primary ms-lg-2\" style=\"margin-top: 10px\" ><a href=\"logoutController\">Logout</button>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </section><!-- End Top Header Bar -->\n");
      out.write("\n");
      out.write("    ");

        Vector<Bill> vector = (Vector<Bill>) request.getAttribute("Bill");
        String[] status = {"New", "Wait", "Process", "Done"};
    
      out.write("\n");
      out.write("\n");
      out.write("    <section class=\"products section bg-gray\" style=\"height: 100vh\">\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-lg-3 title \" >\n");
      out.write("                    <h2>Manager</h2>\n");
      out.write("                    <ul class=\"list-group text-center\" style=\"max-width: 80%; margin-left: 15px\">\n");
      out.write("                        <li class=\"list-group-item\" style=\"margin-left: 5%\"><a href=\"ControllerCustomer?s=displayAllCustomer\">Customer Manager</a></li>\n");
      out.write("                        <li class=\"list-group-item\" style=\"margin-left: 5%\"><a href=\"ProductSevlet?s=displayAllProduct\">Product Manager</a></li>\n");
      out.write("                        <li class=\"list-group-item\" style=\"margin-left: 5%;background-color: #1bbb1b\"><a href=\"BillServlet?s=Bill\">Bill Manager</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                    <div style=\"margin-left: 35px\">\n");
      out.write("                        <div>\n");
      out.write("                            <form style=\"margin-top: 12px;\" action=\"BillServlet\">\n");
      out.write("                                <input type=\"hidden\" name=\"s\" value=\"searchCustomerbyName\">\n");
      out.write("                                <input type=\"search\" placeholder=\"Search\" name=\"nameCus\"/>\n");
      out.write("                                <button class=\"btn btn-outline-success\" type=\"submit\">Search Name</button>\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                        <div>\n");
      out.write("                            <form style=\"margin-top: 12px;\" action=\"BillServlet\">\n");
      out.write("                                <input type=\"hidden\" name=\"s\" value=\"SearchBillID\">\n");
      out.write("                                <input type=\"search\" placeholder=\"Search\" name=\"ID\"/>\n");
      out.write("                                <button class=\"btn btn-outline-success\" type=\"submit\"> Search ID </button>\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div >\n");
      out.write("                <div class=\"col-lg-9 title text-center\">\n");
      out.write("                    <h2>Detail</h2> \n");
      out.write("                    <table class=\"table table-bordered\">\n");
      out.write("                        <thead>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>Bill ID</th>\n");
      out.write("                                <th>Customer Name</th>\n");
      out.write("                                <th>Date</th>\n");
      out.write("                                <th>Total</th>\n");
      out.write("                                <th>Status</th>\n");
      out.write("                                <th>View</th>\n");
      out.write("                            </tr>\n");
      out.write("                        </thead>\n");
      out.write("                        <tbody>\n");
      out.write("                            ");
 for (Bill b : vector) {
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <td>");
      out.print(b.getID());
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(b.getCustomerName());
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(b.getDate());
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(b.getTotal());
      out.write("</td>\n");
      out.write("                                <td>\n");
      out.write("                                    <input type=\"hidden\" name=\"order_id\" value=\"");
      out.print(b.getID());
      out.write("\">\n");
      out.write("                                    ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                </td>\n");
      out.write("<!--                                <td>");
      out.print(status[b.getStatus() - 1]);
      out.write("</td>-->\n");
      out.write("                                <td><a class=\"btn btn-success\" href=\"BillServlet?s=detail&OrderID=");
      out.print(b.getID());
      out.write("\">Detail</a></td>\n");
      out.write("                            </tr>\n");
      out.write("                            ");
}
      out.write("\n");
      out.write("                        </tbody>\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </section>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    <!-- \n");
      out.write("Essential Scripts\n");
      out.write("=====================================-->\n");
      out.write("\n");
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Status}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("S");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                    <select name=\"status\">\n");
          out.write("                                        <option onchange=\"this.form.submit()\" name = \"status\" >");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${status[S.status - 1]}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</option>\n");
          out.write("                                    </select>\n");
          out.write("                                    ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}
