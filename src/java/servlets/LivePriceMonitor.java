
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "LivePriceMonitor", urlPatterns = {"/LivePriceMonitor"})
public class LivePriceMonitor extends HttpServlet {

    /*This method loads data into the datalist and using JS call the API and check if the price has reached its limit or not*/
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Live Price Monitor</title>");
            out.println("<link href=\"CSS/livePriceMonitor.css\" rel=\"stylesheet\" type=\"text/css\" />"); 
            out.println("<link href=\"CSS/stockPage.css\" rel=\"stylesheet\" type=\"text/css\" />");
            out.println("</head>");
            out.println("<body>");

            try{
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Test","root","root");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Symbol,Name from stock_table"); //"SELECT Symbol,Name from stock_table where Name LIKE"+search
            
            
            out.println("    <div class=\"header\">\n" +
                        "       <h1><img src=\"icons/price_monitor.png\" alt=\"\" height=35 width=35 class=\"icon\"></img> Live Price Monitor</h1>\n" +
                        "    </div>\n" );
            
            out.println( "<div class=\"row\">\n" +
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
                                
                        
                        "      <li><form method=\"post\" action=\"MyPortfolio\">\n" +          
                        "            <button type=\"submit\" value=\"My Portfolio\" class=\"start\" ><img src=\"icons/Portfolio.png\" alt=\"\" height=20 width=20 class=\"icon\"></img> My Portfolio</button>\n" +
                        "          </form></li>\n" +
                        "    </ul>\n" +
                        "  </div>\n" );
            
            out.println("  <div class=\"col-9\">\n");
            out.println("<div class=\"instruction\">\n" +
                        "      <h2>How to Use:</h2>\n" +
                        "      <ul>\n" +
                        "        <li>If you want to sell a stock price at a particular limit above the current price, then you should set the price in the upper limit</li>\n" +
                        "        <li>If you want to buy a particular stock at a good price below the current price, then you should set the price in the lower limit</li>\n" +
                        "        <li>The price gets updated every 5s</li>\n" +
                        "        <li>To start click on the set button and to stop checking click on the stop button</li>  \n" +
                        "      </ul>\n" +
                        "    </div>");
            
             out.println("<table id=\"myTable\" class=\"table\">");  
             
            
             List<String> list=new ArrayList<>(); 
             List<String> list2=new ArrayList<>();
             while (rs.next()) 
             {  
                 String sym = rs.getString("Symbol");  
                 String name = rs.getString("Name");  
                    

                 list.add(name);
                 list2.add(sym);
                 
             }  

            out.println("<tr><th>Name</th><th>Current Price</th><th>Set Upper Limit <img src=\"icons/green.png\" alt=\"\" height=10 width=10></img></th><th>Set Lower Limit  <img src=\"icons/red.png\" alt=\"\" height=10 width=10></img></th></tr>");
            out.println("<tr><td><input list=\"stocks\" name=\"stocks\" id=\"st1\" class=\"dropdown_list\" pattern=\"^[a-zA-Z]+$\">");
            out.println("<datalist name=\"stocks\" id=\"stocks\">\n");
                           
            
            for(int i =0;i<list.size();i++){

                out.println("<option label =\""+list.get(i)+"\" id=\"li\" value=\""+list2.get(i)+"\"></option>\n");
            }
            out.println("</datalist></td>");

            out.println("<td><p id=\"currentPrice1\" class=\"currentPrice\">Price</p></td>");
            out.println("<td><input id=\"alert_p1\" type=\"number\" class=\"input_box\"></td>");
            out.println("<td><input id=\"stoploss1\" type=\"number\" class=\"input_box\"></td>");
            out.println("<td><button onclick=\"start1()\" class=\"start_btn\" id=\"start_btn1\">Set </button></td>");
            out.println("<td><button onclick=\"stop1()\" class=\"stop_btn\">Stop</button></td></tr>");
            
           
            
            out.println("<tr><td><input list=\"stocks\" name=\"stocks\" id=\"st2\" class=\"dropdown_list\" pattern=\"^[a-zA-Z]+$\">");
            out.println("<datalist name=\"stocks\" id=\"stocks\">\n");
                           
            
            for(int i =0;i<list.size();i++){

                out.println("<option label =\""+list.get(i)+"\" id=\"li\" value=\""+list2.get(i)+"\"></option>\n");
            }
            out.println("</datalist></td>");

            out.println("<td><p id=\"currentPrice2\" class=\"currentPrice\">Price</p></td>");
            out.println("<td><input id=\"alert_p2\" type=\"number\" class=\"input_box\"></td>");
            out.println("<td><input id=\"stoploss2\" type=\"number\" class=\"input_box\"></td>");
            out.println("<td><button onclick=\"start2()\" class=\"start_btn\" id=\"start_btn2\">Set</button></td>");
            out.println("<td><button onclick=\"stop2()\" class=\"stop_btn\">Stop</button></td></tr>");
            
            
            
            
            out.println("<tr><td><input list=\"stocks\" name=\"stocks\" id=\"st3\" class=\"dropdown_list\" pattern=\"^[a-zA-Z]+$\">");
            out.println("<datalist name=\"stocks\" id=\"stocks\">\n");
                           
            
            for(int i =0;i<list.size();i++){

                out.println("<option label =\""+list.get(i)+"\" id=\"li\" value=\""+list2.get(i)+"\"></option>\n");
            }
            out.println("</datalist></td>");

            out.println("<td><p id=\"currentPrice3\" class=\"currentPrice\">Price</p></td>");
            out.println("<td><input id=\"alert_p3\" type=\"number\" class=\"input_box\"></td>");
            out.println("<td><input id=\"stoploss3\" type=\"number\" class=\"input_box\"></td>");
            out.println("<td><button onclick=\"start3()\" class=\"start_btn\" id=\"start_btn3\">Set</button></td>");
            out.println("<td><button onclick=\"stop3()\" class=\"stop_btn\">Stop</button></td></tr>");
            
            
           
            
            out.println("<tr><td><input list=\"stocks\" name=\"stocks\" id=\"st4\" class=\"dropdown_list\" pattern=\"^[a-zA-Z]+$\">");
            out.println("<datalist name=\"stocks\" id=\"stocks\">\n");
                           
            
            for(int i =0;i<list.size();i++){

                out.println("<option label =\""+list.get(i)+"\" id=\"li\" value=\""+list2.get(i)+"\"></option>\n");
            }
            out.println("</datalist></td>");

            out.println("<td><p id=\"currentPrice4\" class=\"currentPrice\">Price</p></td>");
            out.println("<td><input id=\"alert_p4\" type=\"number\" class=\"input_box\"></td>");
            out.println("<td><input id=\"stoploss4\" type=\"number\" class=\"input_box\"></td>");
            out.println("<td><button onclick=\"start4()\" class=\"start_btn\" id=\"start_btn4\">Set</button></td>");
            out.println("<td><button onclick=\"stop4()\" class=\"stop_btn\">Stop</button></td></tr>");
            
            
            
            
            
            out.println("<tr><td><input list=\"stocks\" name=\"stocks\" id=\"st5\" class=\"dropdown_list\" pattern=\"^[a-zA-Z]+$\">");
            out.println("<datalist name=\"stocks\" id=\"stocks\">\n");
                           
            
            for(int i =0;i<list.size();i++){

                out.println("<option label =\""+list.get(i)+"\" id=\"li\" value=\""+list2.get(i)+"\"></option>\n");
            }
            out.println("</datalist></td>");

            out.println("<td><p id=\"currentPrice5\" class=\"currentPrice\">Price</p></td>");
            out.println("<td><input id=\"alert_p5\" type=\"number\" class=\"input_box\"></td>");
            out.println("<td><input id=\"stoploss5\" type=\"number\" class=\"input_box\"></td>");
            out.println("<td><button onclick=\"start5()\" class=\"start_btn\" id=\"start_btn5\">Set</button></td>");
            out.println("<td><button onclick=\"stop5()\" class=\"stop_btn\">Stop</button></td></tr>");
            out.println("</table>");
            
            } catch (SQLException e) 
            {  
             out.println("error");  
            }

            out.println("  </div>\n");
            out.println("  </div>\n");
            
            out.println("<div class=\"footer\">\n" +
                        "      <p></p>\n" +
                        "      <h1 style=\"color: #1D2E3E\">Footer</h1>\n" +
                        "    </div>");
            
            out.println("<script src=\"JS/livePriceMonitor.js\"></script>");
            
            out.println("</body>");
            out.println("</html>");
        }
        
    }

}
