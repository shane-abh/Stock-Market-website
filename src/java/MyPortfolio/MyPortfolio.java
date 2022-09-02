
package MyPortfolio;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "MyPortfolio", urlPatterns = {"/MyPortfolio"})
public class MyPortfolio extends HttpServlet {

    /*In this method users would be able to login and the this servlet would fetch the data from the database 
    and display it to the user. The user will be able to add, update and delete their data.*/
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String user = request.getParameter("username");
        
        if(user==null){
            RequestDispatcher rd=request.getRequestDispatcher("login.html");
            rd.forward(request, response);
        }
        
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MyPortfolio</title>");    
            out.println("<link href=\"CSS/MyPortfolio.css\" rel=\"stylesheet\" type=\"text/css\" />");
            out.println("</head>");
            out.println("<body>");
            out.println("    <div class=\"header\">\n" +
                        "       <h1><img src=\"icons/Portfolio.png\" alt=\"\" height=30 width=30 class=\"icon\"></img> My Portfolio</h1>\n" +
                        "    </div>\n" );
                        
           out.println("<div class=\"row\">\n" +
                        "  <div class=\"col-1 menu\">\n" +
                        "    <ul>\n" +
                        "      <li><form method=\"get\" action=\"Search\">\n"+
                                    "<button type=\"submit\" value=\"Search\" class=\"start\" ><img src=\"icons/search.png\" alt=\"\" height=20 width=20 class=\"icon\"></img> Search</button>\n" +
                        "          </form></li>\n" +
                                
                        "      <li><form method=\"get\" action=\"FinancialData\">\n" +         
                               
                        "            <button type=\"submit\" value=\"Financial Data\" class=\"start\" ><img src=\"icons/Finance.png\" alt=\"\" height=20 width=20 class=\"icon\"></img> Financial Data</button>\n" +
                        "          </form></li>\n" +  
                        
                        "      <li><form method=\"get\" action=\"LivePriceMonitor\">\n" +         
                        "            <button type=\"submit\" value=\"Live Price Monitor\" class=\"start\" ><img src=\"icons/price_monitor.png\" alt=\"\" height=20 width=20 class=\"icon\"></img> Live Price Monitor</button>\n" +
                        "          </form></li>\n" + 
                                
                        
                        "      <li><form method=\"post\" action=\"MyPortfolio\">\n"
                                + "" +         
                        "            <button type=\"submit\" value=\"My Portfolio\" class=\"start\" ><img src=\"icons/Portfolio.png\" alt=\"\" height=20 width=20 class=\"icon\"></img> My Portfolio</button>\n" +
                        "          </form></li>\n" +
                        "    </ul>\n" +
                        "  </div>\n");
            
            out.println("<div class=\"col-9\">\n"
                    + "<h1>My Stocks</h1>"
                    );  
            
            try{
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Test","root","root");
            Statement stmt = conn.createStatement();
            
            ResultSet rs1 = stmt.executeQuery("SELECT * from stock WHERE username='"+user+"'"); 
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
            
            } catch (SQLException e) 
            {  
             out.println("error" + e);  
            }
            
            out.println("<center>");
            out.println("<div class=\"form-group\">");
            out.println("<form method=\"get\" action=\"insert_html\">");
            out.println("<input type=\"hidden\" value=\""+user+"\" class=\"button\" name=\"user\">");
            out.println("<input type=\"submit\" value=\"Add values\" class=\"button\">");
            out.println("</form>");
            out.println("</div>");
            
            out.println("<div class=\"form-group\">");
            out.println("<form method=\"get\" action=\"update_html\">");
            out.println("<input type=\"hidden\" value=\""+user+"\" class=\"button\" name=\"user\">");
            out.println("<input type=\"submit\" value=\"Update values\" class=\"button\">");
            out.println("</form>");
            out.println("</div>");
            
            out.println("<div class=\"form-group\">");
            out.println("<form method=\"get\" action=\"delete_html\">");
            out.println("<input type=\"hidden\" value=\""+user+"\" class=\"button\" name=\"user\">");
            out.println("<input type=\"submit\" value=\"Delete values\" class=\"button\">");
            out.println("</form>");
            out.println("</div>");
            out.println("</center>");
            
            out.println("</div>"
                    + "</div>");
            out.println("</div>");
             out.println("<div class=\"footer\">\n" +
                        "      <p></p>\n" +
                        "      <h1 style=\"color: #1D2E3E\">Footer</h1>\n" +
                        "    </div>");
            
            out.println("</body>");
            out.println("</html>");
        }
    }

}
