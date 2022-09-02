
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Stock_page", urlPatterns = {"/Stock_page"})
public class Stock_page extends HttpServlet {

   /*In this method we get the search result string from the servlet and using that string 
    we call the API in JS and display the following information in html*/
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        String res = request.getParameter("stocks");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>\n" +
                        "<html>\n" +
                        "  <head>\n" +
                        "    <meta charset=\"utf-8\">\n" +
                        "    <meta name=\"viewport\" content=\"width=device-width\">\n" +
                        "    <title id=\"title\">Stock page</title>\n" +
                        "    <link href=\"CSS/stockPage.css\" rel=\"stylesheet\" type=\"text/css\" />\n" +
                        "    <script src=\"https://cdn.jsdelivr.net/npm/chart.js@3.5.1/dist/chart.min.js\"></script>\n" +
                      
                        "      <script src=\"https://canvasjs.com/assets/script/canvasjs.min.js\"></script>\n" +
                        "\n" +
                        "      <script type=\"text/javascript\" src=\"https://canvasjs.com/assets/script/jquery-1.11.1.min.js\"></script>\n" +
                        "      <script type=\"text/javascript\" src=\"https://canvasjs.com/assets/script/canvasjs.stock.min.js\"></script>\n" +
                        "      \n" +
                        "  <body>\n" +
                        "    <div class=\"header\">\n" +
                        "       <h1><img src=\"icons/stockmarket.png\" alt=\"\" height=50 width=50 class=\"icon\"></img> Stock Market</h1>\n" +
                       
                        "    </div>\n" +
                        "<input type=\"hidden\" value=\""+res+"\" class=\"searchContent\" id=\"searchContent\" name=\"searchContent\"/>" +
                        "\n" +
                        "\n" +
                        "<div class=\"row\">\n" +
                        "  <div class=\"col-1 menu\">\n" +
                        "    <ul>\n" +
                        "      <li><form method=\"get\" action=\"Search\">\n"+
//                                + "<img src=\"icons/search.png\" alt=\"\" height=10 width=10></img>" +                                    
//                        "            <input type=\"submit\" value=\"Search\" class=\"start\" ></input>\n"
                                 "<button type=\"submit\" value=\"Search\" class=\"start\" ><img src=\"icons/search.png\" alt=\"\" height=20 width=20 class=\"icon\"></img> Search</button>\n" +
                        "          </form></li>\n" +
                                
                        "      <li><form method=\"get\" action=\"FinancialData\">\n" +         
                        "            <input type=\"hidden\" value=\""+res+"\" class=\"start\" name=\"symbol\"/>\n" +        
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
                        "  </div>\n" +
                        "\n" +
                        "  <div class=\"col-9\">\n" +
                        "    <h1 id=\"compName\">Company</h1>\n" +
                        "    <label id=\"symbol\" style=\"padding-left:20px\">symbol</label>\n" +
                        "\n" +
                        "    <div class=\"col-12\">\n" +
                        "      <h2 id=\"price\">price</h2>   \n" +
                        "      <h3 id=\"pchange\">pchange</h3>   \n" +
                        "    </div>\n" +
                        "\n" +
                        "    \n" +
                        "    \n" +
                        "    <div class=\"col-13\">\n" +
                        "      <div id=\"chartContainer\" style=\"height: 500px; width: 100%;\"></div>\n" +
                        "      <table id=\"buttons\" class=\"buttons\">\n" +
                        "      <tr>\n" +
                        "        <button id=\"day\" class=\"chart_buttons\">Days</button>\n" +
                        "        <button id=\"month\" class=\"chart_buttons\">Months</button>\n" +
                        "        <button id=\"year\" class=\"chart_buttons\">Years</button>\n" +
                        "      </tr>\n" +
                        "    </table>\n" +
                        "    </div>\n" +
                        "    \n" +
                        "   \n" +
                        "  \n" +
                        "\n" +
                        "  <div class=\"col-12\">\n" +
                        "    <div class=\"tab\">\n" +
                        "        <button class=\"tablinks\" onclick=\"openCity(event, 'Summary')\">Summary</button>\n" +
                        "        <button class=\"tablinks\" onclick=\"openCity(event, 'Company_Overview')\">Company Overview</button>\n" +
                        "        <button class=\"tablinks\" onclick=\"openCity(event, 'Financial_Analysis')\">Financial Analysis</button>\n" +
                        "        \n" +
                        "    </div>\n" +
                        "\n" +
                        "    <div id=\"Summary\" class=\"tabcontent\">\n" +
                        "          <h3>Summary</h3>\n" +
                        "          <table id=\"Summary_table\">\n" +
                        "            <tr>\n" +
                        "              <td>Previous Close</td>\n" +
                        "              <td id=\"regularMarketPreviousClose\">0.00</td>\n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "              <td>Open</td>\n" +
                        "              <td id=\"regularMarketOpen\">0.00</td>\n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "              <td>Day Range</td>\n" +
                        "              <td id=\"regularMarketDayRange\">0.00</td>\n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "              <td>Market Change</td>\n" +
                        "              <td id=\"regularMarketChange\">0.00</td>\n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "              <td>Ask</td>\n" +
                        "              <td id=\"ask\">0.00</td>\n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "              <td>Bid</td>\n" +
                        "              <td id=\"bid\">0.00</td>\n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "              <td>52 week range</td>\n" +
                        "              <td id=\"fiftyTwoWeekRange\">0.00</td>\n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "              <td>52 week average change</td>\n" +
                        "              <td id=\"fiftyDayAverageChange\">0.00</td>\n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "              <td>200 average</td>\n" +
                        "              <td id=\"twoHundredDayAverage\">0.00</td>\n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "              <td>200 average change</td>\n" +
                        "              <td id=\"twoHundredDayAverageChange\">0.00</td>\n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "              <td>EPS current year</td>\n" +
                        "              <td id=\"epsCurrentYear\">0.00</td>\n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "              <td>EPS trailing twelve months</td>\n" +
                        "              <td id=\"epsTrailingTwelveMonths\">0.00</td>\n" +
                        "            </tr>\n" +
                        "          </table>\n" +
                        "          \n" +
                        "    </div>\n" +
                        "    \n" +
                        "    <div id=\"Company_Overview\" class=\"tabcontent\">\n" +
                        "          <h3>Company Overview</h3>\n" +
                        "          <p id=\"comp_overview\">00</p>\n" +
                        "          \n" +
                        "    </div>\n" +
                        "    <div id=\"Financial_Analysis\" class=\"tabcontent\">\n" +
                        "          <h3>Financial Analysis</h3>\n" +
                        "          <table id=\"fin_table\">\n" +
                        "            <tr>\n" +
                        "              <td>Recommendation</td>\n" +
                        "              <td id=\"recommendationKey\"></td>\n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "              <td>Total Cash</td>\n" +
                        "              <td id=\"totalCash\"></td>\n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "              <td>Total Cash Per Share</td>\n" +
                        "              <td id=\"totalCashPerShare\"></td>\n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "              <td>Ebitda</td>\n" +
                        "              <td id=\"ebitda\"></td>\n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "              <td>Total Debt</td>\n" +
                        "              <td id=\"totalDebt\"></td>\n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "              <td>Quick Ratio</td>\n" +
                        "              <td id=\"quickRatio\"></td>\n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "              <td>Current Ratio</td>\n" +
                        "              <td id=\"currentRatio\"></td>\n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "              <td>Total Revenue</td>\n" +
                        "              <td id=\"totalRevenue\"></td>\n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "              <td>Debt To Equity</td>\n" +
                        "              <td id=\"debtToEquity\"></td>\n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "              <td>Revenue Per Share</td>\n" +
                        "              <td id=\"revenuePerShare\"></td>\n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "              <td>Return On Assets</td>\n" +
                        "              <td id=\"returnOnAssets\"></td>\n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "              <td>Return On Equity</td>\n" +
                        "              <td id=\"returnOnEquity\"></td>\n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "              <td>Gross Profits</td>\n" +
                        "              <td id=\"grossProfits\"></td>\n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "              <td>Free Cash flow</td>\n" +
                        "              <td id=\"freeCashflow\"></td>\n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "              <td>Operating Cash flow</td>\n" +
                        "              <td id=\"operatingCashflow\"></td>\n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "              <td>Earnings Growth</td>\n" +
                        "              <td id=\"earningsGrowth\"></td>\n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "              <td>Revenue Growth</td>\n" +
                        "              <td id=\"revenueGrowth\"></td>\n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "              <td>Gross Margins</td>\n" +
                        "              <td id=\"grossMargins\"></td>\n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "              <td>Ebitda Margins</td>\n" +
                        "              <td id=\"ebitdaMargins\"></td>\n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "              <td>Operating Margins</td>\n" +
                        "              <td id=\"operatingMargins\"></td>\n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "              <td>Profit Margins</td>\n" +
                        "              <td id=\"profitMargins\"></td>\n" +
                        "            </tr>\n" +
                        "            \n" +
                        "          </table>\n" +
                        "          \n" +
                        "    </div>\n" +
                        "\n" +
                        "    \n" +
                        "\n" +
                        "    \n" +
                        "  </div>\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "    \n" +
                        "    \n" +
                        "\n" +
                        "   \n" +
                        "</div>\n" +
                        "  </div>\n" +
                                
                                
                        "<div class=\"footer\">\n" +
                        "      <p></p>\n" +
                        "      <h1 style=\"color: #1D2E3E\">Footer</h1>\n" +
                        "    </div>" +
                                
                                
                        "\n" +
                        "\n" +
                        "\n" +
                        "  <script src=\"JS/stockPage.js\"></script>\n" +
                        "  </head>\n" +
                        "  </body>\n" +
                        "</html>");
            
        }
        
    }

  
}
