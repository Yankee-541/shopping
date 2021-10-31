package org.apache.jsp.View;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class edit_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");
      out.write("       <head>\n");
      out.write("              <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("              <title>JSP Page</title>\n");
      out.write("              <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Roboto|Varela+Round\">\n");
      out.write("              <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/icon?family=Material+Icons\">\n");
      out.write("              <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("              <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n");
      out.write("              <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>\n");
      out.write("              <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n");
      out.write("              <link href=\"css/manager.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("       </head>\n");
      out.write("       <body>aaaa\n");
      out.write("              <div id=\"editEmployeeModal\" class=\"modal fade\">\n");
      out.write("                     <div class=\"modal-dialog\">\n");
      out.write("                            <div class=\"modal-content\">\n");
      out.write("                                   <form action=\"\" method=\"POST\">\n");
      out.write("                                          <div class=\"modal-header\">\t\t\t\t\t\t\n");
      out.write("                                                 <h4 class=\"modal-title\">Edit Employee</h4>\n");
      out.write("                                                 <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>\n");
      out.write("                                          </div>\n");
      out.write("                                          <div class=\"modal-body\">\t\t\t\t\t\n");
      out.write("                                                 <div class=\"form-group\">\n");
      out.write("                                                        <label>Name</label>\n");
      out.write("                                                        <input type=\"text\" class=\"form-control\" required >\n");
      out.write("                                                 </div>\n");
      out.write("                                                 <div class=\"form-group\">\n");
      out.write("                                                        <label>Email</label>\n");
      out.write("                                                        <input type=\"email\" class=\"form-control\" required>\n");
      out.write("                                                 </div>\n");
      out.write("                                                 <div class=\"form-group\">\n");
      out.write("                                                        <label>Address</label>\n");
      out.write("                                                        <textarea class=\"form-control\" required></textarea>\n");
      out.write("                                                 </div>\n");
      out.write("                                                 <div class=\"form-group\">\n");
      out.write("                                                        <label>Phone</label>\n");
      out.write("                                                        <input type=\"text\" class=\"form-control\" required>\n");
      out.write("                                                 </div>\n");
      out.write("                                                 <div class=\"form-group\">\n");
      out.write("                                                        <label>Category</label>\n");
      out.write("                                                        <select name=\"category\" class=\"\">\n");
      out.write("                                                               <c:forEach items=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.allCate}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" var=\"c\">\n");
      out.write("                                                                      <option value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${c.cid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write('"');
      out.write('>');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${c.cname}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</option>\n");
      out.write("                                                               </c:forEach>\n");
      out.write("                                                        </select>\n");
      out.write("                                                 </div>\n");
      out.write("                                          </div>\n");
      out.write("                                          <div class=\"modal-footer\">\n");
      out.write("                                                 <input type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\" value=\"Cancel\">\n");
      out.write("                                                 <input type=\"submit\" class=\"btn btn-info\" value=\"Save\">\n");
      out.write("                                          </div>\n");
      out.write("                                   </form>\n");
      out.write("                            </div>\n");
      out.write("                     </div>\n");
      out.write("              </div>\n");
      out.write("       </body>\n");
      out.write("</html>\n");
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
