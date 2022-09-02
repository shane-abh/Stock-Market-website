
package MyPortfolio;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "delete_html", urlPatterns = {"/delete_html"})
public class delete_html extends HttpServlet {
    
    /*This method is used for acquiring the username from MyPortfolio servlet and then provides an
    interface to let the user choose which stock to delete */   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String user = request.getParameter("user");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet delete_html</title>");  
            out.println("<link href=\"CSS/add_update_delete.css\" rel=\"stylesheet\" type=\"text/css\" />");
            out.println("</head>");
            out.println("<body>");

            out.println("    <div class=\"header\">\n" +
                        "       <h1><img src=\"icons/delete.png\" alt=\"\" height=30 width=30 class=\"icon\"></img> Delete Details</h1>\n" +
                       
                        "    </div>\n");
            
            
            out.println("      <form method=\"post\" action=\"MyPortfolio\">\n" +         
                        "            <input type=\"hidden\" value=\""+user+"\" class=\"start\" name=\"username\"/>\n" +        
                        "            <input type=\"image\" src=\"icons/back.png\" width=30 height=30 class=\"backicon\"/>" +
                        "      </form>\n" );
            
            try{
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Test","root","root");
            Statement stmt = conn.createStatement();
            
            ResultSet rs1 = stmt.executeQuery("SELECT * from stock WHERE username = '"+user+"'"); 
            out.println("<table class=\"stock\"");
            out.println("<tr><th>ID</th><th>Stock Symbol</th><th>Company Name</th><th>Stock Quantity</th><th>Buy Price</th><th>Date</th></tr>");
            while(rs1.next()){
                int id = rs1.getInt("id");
                String username = rs1.getString("username");
                String stocksymbol = rs1.getString("stockname");
                String stockName = rs1.getString("longstockname");
                int qty = rs1.getInt("qty");
                double price = rs1.getDouble("priceboughtat");
                Date date = rs1.getDate("dateboughtat");
                
                out.println("<tr><td>"+id+"</td><td>"+stocksymbol+"</td><td>"+stockName+"</td><td>"+qty+"</td><td>"+price+"</td><td>"+date+"</td></tr>");
            }
            out.println("</table>");
            
            
            out.println(" <div class=\"card\">\n" +
                    "      <form method=\"get\" action=\"Delete\">\n" +
                    "          <h2>Delete row</h2>\n" +
                    "          <div class=\"row\">\n" +
                    "\n" +
                    "            <div class=\"col\">\n" +
                    "              <div class=\"form-group\">\n" +
                    "                <label>Enter ID</label>\n" +
                    "                <input type=\"number\" id=\"id\" name=\"id\">\n" +
                    "              </div>\n" +
                    "            </div>\n" +
                    "\n" +
                    "            \n" +
                    "\n" +
                    "            <div class=\"col\">\n" +
                    "<input type=\"hidden\" value=\""+user+"\" class=\"button\" name=\"user\">"+
                    "              <input type=\"submit\" value=\"Delete\">\n" +
                    "            </div>\n" +
                    "          </div>\n" +
                    "\n" +
                    "      </form>\n" +
                    
                    "</div>");
             
             } catch (SQLException e) 
            {  
             out.println("error" + e);  
            }
            
            out.println("<div class=\"footer\">\n" +
                        "      <p></p>\n" +
                        "      <h1 style=\"color: #1D2E3E\">Footer</h1>\n" +
                        "    </div>" );
            out.println("</body>");
            out.println("</html>");
        }
    }

}
