
package FinancialData;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "FinancialData", urlPatterns = {"/FinancialData"})
public class FinancialData extends HttpServlet {

   
    /*In this method the search string is passed from the stock page and the user would be able 
    to choose which financial statement they would want of the particular company*/
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String sym= request.getParameter("symbol");
        
        if(sym == null){
            RequestDispatcher rd=request.getRequestDispatcher("Search");
            rd.forward(request, response);
        }
        
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FinancialData</title>");    
            out.println("<link href=\"CSS/FinancialData.css\" rel=\"stylesheet\" type=\"text/css\" />");
            out.println("</head>");
            out.println("<body>");
            out.println("    <div class=\"header\">\n" +
                        "       <h1><img src=\"icons/Finance.png\" alt=\"\" height=30 width=30 class=\"icon\"></img> Financial Data</h1>\n" +
                        "    </div>\n" );
            
            out.println("<link href=\"CSS/stockPage.css\" rel=\"stylesheet\" type=\"text/css\" />"); 
            
            
            out.println("<div class=\"row\">\n");
            
            out.println("  <div class=\"col-1 menu\">\n" +
                        "    <ul>\n" +
                        "      <li><form method=\"get\" action=\"Search\">\n"+

                                 "<button type=\"submit\" value=\"Search\" class=\"start\" ><img src=\"icons/search.png\" alt=\"\" height=20 width=20 class=\"icon\"></img> Search</button>\n" +
                        "          </form></li>\n" +
                                
                                                
                        "      <li><form method=\"get\" action=\"LivePriceMonitor\">\n" +         
                        "            <button type=\"submit\" value=\"Live Price Monitor\" class=\"start\" ><img src=\"icons/price_monitor.png\" alt=\"\" height=20 width=20 class=\"icon\"></img> Live Price Monitor</button>\n" +
                        "          </form></li>\n" + 
                                
                        
                        "      <li><form method=\"post\" action=\"MyPortfolio\">\n"
                                + "" +         
                        "            <button type=\"submit\" value=\"My Portfolio\" class=\"start\" ><img src=\"icons/Portfolio.png\" alt=\"\" height=20 width=20 class=\"icon\"></img> My Portfolio</button>\n" +
                        "          </form></li>\n" +
                        "    </ul>\n" +
                        "  </div>\n" );
            
            
            
            out.println("  <div class=\"col-9\">\n");
            out.println("<h1>Financial Statements of "+sym+"</h1>");
            
            
            out.println("<p class=\"info\">Financial statements are written documents that describe a company's operations and financial performance. "
                    + "Government authorities, accountants, corporations, and others frequently audit financial accounts to verify accuracy "
                    + "and for tax, financing, and investment purposes.</p>");
            
            out.println("<h2>Balance Sheet</h2>");
            out.println("<p class=\"info\">A balance sheet is a financial statement that shows the assets, liabilities, and shareholder equity of a corporation at a"
                    + " certain point in time. Balance sheets serve as the foundation for calculating investor returns and assessing a company's financial structure."
                    + " In a nutshell, a balance sheet is a financial statement that shows what a firm owns and owes, as well as how much money shareholders have invested."
                    + " To conduct basic analysis or calculate financial ratios, balance sheets can be combined with other essential financial accounts.</p>");
            
            out.println("<h2>Income Statement</h2>");
            out.println("<p class=\"info\">An income statement is a financial statement that details the income and expenses of a firm. It also displays if a firm is profitable"
                    + " or losing money over a certain time period. The income statement, together with the balance sheet and cash flow statement, aids in the understanding of your company's "
                    + "financial health. A profit and loss statement, a statement of operation, a statement of financial result or income, "
                    + "or an earnings statement are all terms for the same thing.</p>");
            
            out.println("<h2>Cash Flow Statement</h2>");
            out.println("<p class=\"info\">The cash flow statement (CFS), sometimes known as the statement of cash flows, is a financial statement that outlines the amount of cash"
                    + " and cash equivalents entering and leaving a business. It, too, measures a company's success over time, much like the income statement. It varies, though, since "
                    + "the timing of non-cash transactions is less easily influenced.</p>");
            
            out.println("<center>");
            
            out.println("<div class=\"form-group\">");
            out.println("<form method=\"get\" action=\"BalanceSheet\">\n" +
                        
                        "            <input type=\"hidden\" value=\""+sym+"\" name=\"search\" /><br/>\n" +
                        "            <input type=\"submit\" value=\"BalanceSheet\" class=\"button\" >\n" +
                        
                        "</form>");
            out.println("</div>");
            
            
            out.println("<div class=\"form-group\">");
            out.println("<form method=\"get\" action=\"IncomeStatement\">\n" +
                        "            <input type=\"hidden\" value=\""+sym+"\" name=\"search\" /><br/>\n" +

                        "            <input type=\"submit\" value=\"Income Statement\" class=\"button\" >\n" +

                        "        </form>");
            out.println("</div>");
            
            
            out.println("<div class=\"form-group\">");
            out.println("<form method=\"get\" action=\"CashFlow\">\n" +
                        "            <input type=\"hidden\" value=\""+sym+"\" name=\"search\" /><br/>\n" +

                        "            <input type=\"submit\" value=\"Cash Flow\" class=\"button\" >\n" +

                        "        </form>");
            out.println("</div>");
            
            out.println("</center>");
            out.println("</div>");
            
            out.println("</div>");
            out.println("<div class=\"footer\">\n" +
                        "      <p></p>\n" +
                        "      <h1 style=\"color: #1D2E3E\">Footer</h1>\n" +
                        "    </div>");
            out.println("</div>");
            
        
            out.println("</body>");
            out.println("</html>");
        }
    }

   

}
