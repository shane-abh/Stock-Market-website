
package FinancialData;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "IncomeStatement", urlPatterns = {"/IncomeStatement"})
public class IncomeStatement extends HttpServlet {

   /*In this method, the search string is recieved from the financialdata servlet 
    and we use javascript ajax to call the API and the Income statement data is diplayed in a table in HTML*/   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
                String s = request.getParameter("search");
                try (PrintWriter out = response.getWriter()) {
                    
                    out.println("<!DOCTYPE html>\n" +
                                "<html>\n" +
                                "  <head>\n" +
                                "    <meta charset=\"utf-8\">\n" +
                                "    <meta name=\"viewport\" content=\"width=device-width\">\n" +
                                "    <title>Income Statement</title>\n" +
                                "    <link href=\"CSS/stockPage.css\" rel=\"stylesheet\" type=\"text/css\" />\n" +
                                "    <link href=\"CSS/FinancialData.css\" rel=\"stylesheet\" type=\"text/css\" />" +
                                "  </head>\n" +
                                "  <body>\n" +
                                "    \n" +
                            
                                "    <div class=\"header\">\n" +
                                "       <h1><img src=\"icons/incomeStatement.png\" alt=\"\" height=30 width=30 class=\"icon\"></img> Income Statement</h1>\n" +
                                "    </div>\n" +
                            
                                "      <form method=\"get\" action=\"FinancialData\">\n" +         
                                "            <input type=\"hidden\" value=\""+s+"\" class=\"start\" name=\"symbol\"/>\n" +        
                                "            <input type=\"image\" src=\"icons/back.png\" width=30 height=30 class=\"backicon\"/>" +
                                "      </form>\n" + 
                            
                                "\n" +
                                "<div id=\"chartContainer\" style=\"height: 370px; width: 95%; \" class=\"chart\"></div>\n" +
                                "  <script src=\"https://canvasjs.com/assets/script/canvasjs.min.js\"></script>\n" +
                                "\n" +

                                "  <input id=\"searchContent\" type=\"hidden\" value=\""+s+"\"></input>\n" +
                                "<div class=\"incomeStatement\">\n" +
                                "  <center>\n" +
                                "    <table id=\"FinData\">\n" +
                                "      <tr>\n" +
                                "        <th>Breakdown</th>\n" +
                                "        <th id=\"fiscalDateEnding0\">Date1</th>\n" +
                                "        <th id=\"fiscalDateEnding1\">Date2</th>\n" +
                                "        <th id=\"fiscalDateEnding2\">Date3</th>\n" +
                                "        <th id=\"fiscalDateEnding3\">Date4</th>\n" +
                                "        <th id=\"fiscalDateEnding4\">Date5</th>\n" +
                                "      </tr>\n" +
                                "\n" +
                                "\n" +
                                "      <tr>\n" +
                                "        <td>Gross Profit</td>\n" +
                                "        <td id=\"grossProfit0\">Tot_rev1</td>\n" +
                                "        <td id=\"grossProfit1\">Tot_rev2</td>\n" +
                                "        <td id=\"grossProfit2\">Tot_rev3</td>\n" +
                                "        <td id=\"grossProfit3\">Tot_rev4</td>\n" +
                                "        <td id=\"grossProfit4\">Tot_rev5</td>\n" +
                                "      </tr>\n" +
                                "\n" +
                                "\n" +
                                "      <tr>\n" +
                                "        <td>Total Revenue</td>\n" +
                                "        <td id=\"totalRevenue0\">Tot_rev1</td>\n" +
                                "        <td id=\"totalRevenue1\">Tot_rev2</td>\n" +
                                "        <td id=\"totalRevenue2\">Tot_rev3</td>\n" +
                                "        <td id=\"totalRevenue3\">Tot_rev4</td>\n" +
                                "        <td id=\"totalRevenue4\">Tot_rev5</td>\n" +
                                "      </tr>\n" +
                                "\n" +
                                "      <tr>\n" +
                                "        <td>Cost Of Revenue</td>\n" +
                                "        <td id=\"costOfRevenue0\">00</td>\n" +
                                "        <td id=\"costOfRevenue1\">00</td>\n" +
                                "        <td id=\"costOfRevenue2\">00</td>\n" +
                                "        <td id=\"costOfRevenue3\">00</td>\n" +
                                "        <td id=\"costOfRevenue4\">00</td>\n" +
                                "      </tr>\n" +
                                "\n" +
                                "      <tr>\n" +
                                "        <td>Cost of Goods And Services Sold</td>\n" +
                                "        <td id=\"costofGoodsAndServicesSold0\">00</td>\n" +
                                "        <td id=\"costofGoodsAndServicesSold1\">00</td>\n" +
                                "        <td id=\"costofGoodsAndServicesSold2\">00</td>\n" +
                                "        <td id=\"costofGoodsAndServicesSold3\">00</td>\n" +
                                "        <td id=\"costofGoodsAndServicesSold4\">00</td>\n" +
                                "      </tr>\n" +
                                "\n" +
                                "      <tr>\n" +
                                "        <td>Operating Income</td>\n" +
                                "        <td id=\"operatingIncome0\">00</td>\n" +
                                "        <td id=\"operatingIncome1\">00</td>\n" +
                                "        <td id=\"operatingIncome2\">00</td>\n" +
                                "        <td id=\"operatingIncome3\">00</td>\n" +
                                "        <td id=\"operatingIncome4\">00</td>\n" +
                                "      </tr>\n" +
                                "\n" +
                                "      <tr>\n" +
                                "        <td>Selling General And Administrative</td>\n" +
                                "        <td id=\"sellingGeneralAndAdministrative0\">00</td>\n" +
                                "        <td id=\"sellingGeneralAndAdministrative1\">00</td>\n" +
                                "        <td id=\"sellingGeneralAndAdministrative2\">00</td>\n" +
                                "        <td id=\"sellingGeneralAndAdministrative3\">00</td>\n" +
                                "        <td id=\"sellingGeneralAndAdministrative4\">00</td>\n" +
                                "      </tr>\n" +
                                "\n" +
                                "      <tr>\n" +
                                "        <td>Research And Development</td>\n" +
                                "        <td id=\"researchAndDevelopment0\">00</td>\n" +
                                "        <td id=\"researchAndDevelopment1\">00</td>\n" +
                                "        <td id=\"researchAndDevelopment2\">00</td>\n" +
                                "        <td id=\"researchAndDevelopment3\">00</td>\n" +
                                "        <td id=\"researchAndDevelopment4\">00</td>\n" +
                                "      </tr>\n" +
                                "\n" +
                                "      <tr>\n" +
                                "        <td>Operating Expenses</td>\n" +
                                "        <td id=\"operatingExpenses0\">00</td>\n" +
                                "        <td id=\"operatingExpenses1\">00</td>\n" +
                                "        <td id=\"operatingExpenses2\">00</td>\n" +
                                "        <td id=\"operatingExpenses3\">00</td>\n" +
                                "        <td id=\"operatingExpenses4\">00</td>\n" +
                                "      </tr>\n" +
                                "\n" +
                                "      <tr>\n" +
                                "        <td>Interest Expense</td>\n" +
                                "        <td id=\"interestExpense0\">00</td>\n" +
                                "        <td id=\"interestExpense1\">00</td>\n" +
                                "        <td id=\"interestExpense2\">00</td>\n" +
                                "        <td id=\"interestExpense3\">00</td>\n" +
                                "        <td id=\"interestExpense4\">00</td>\n" +
                                "      </tr>\n" +
                                "\n" +
                                "      <tr>\n" +
                                "        <td>Income Before Tax</td>\n" +
                                "        <td id=\"incomeBeforeTax0\">00</td>\n" +
                                "        <td id=\"incomeBeforeTax1\">00</td>\n" +
                                "        <td id=\"incomeBeforeTax2\">00</td>\n" +
                                "        <td id=\"incomeBeforeTax3\">00</td>\n" +
                                "        <td id=\"incomeBeforeTax4\">00</td>\n" +
                                "      </tr>\n" +
                                "\n" +
                                "      <tr>\n" +
                                "        <td>Interest And Debt Expense</td>\n" +
                                "        <td id=\"interestAndDebtExpense0\">00</td>\n" +
                                "        <td id=\"interestAndDebtExpense1\">00</td>\n" +
                                "        <td id=\"interestAndDebtExpense2\">00</td>\n" +
                                "        <td id=\"interestAndDebtExpense3\">00</td>\n" +
                                "        <td id=\"interestAndDebtExpense4\">00</td>\n" +
                                "      </tr>\n" +
                                "\n" +
                                "      \n" +
                                "\n" +
                                "      <tr>\n" +
                                "        <td>Investment Income Net</td>\n" +
                                "        <td id=\"investmentIncomeNet0\">00</td>\n" +
                                "        <td id=\"investmentIncomeNet1\">00</td>\n" +
                                "        <td id=\"investmentIncomeNet2\">00</td>\n" +
                                "        <td id=\"investmentIncomeNet3\">00</td>\n" +
                                "        <td id=\"investmentIncomeNet4\">00</td>\n" +
                                "      </tr>\n" +
                                "\n" +
                                "      <tr>\n" +
                                "        <td>Interest Income</td>\n" +
                                "        <td id=\"interestIncome0\">00</td>\n" +
                                "        <td id=\"interestIncome1\">00</td>\n" +
                                "        <td id=\"interestIncome2\">00</td>\n" +
                                "        <td id=\"interestIncome3\">00</td>\n" +
                                "        <td id=\"interestIncome4\">00</td>\n" +
                                "      </tr>\n" +
                                "\n" +
                                "      <tr>\n" +
                                "        <td>Net Interest Income</td>\n" +
                                "        <td id=\"netInterestIncome0\">00</td>\n" +
                                "        <td id=\"netInterestIncome1\">00</td>\n" +
                                "        <td id=\"netInterestIncome2\">00</td>\n" +
                                "        <td id=\"netInterestIncome3\">00</td>\n" +
                                "        <td id=\"netInterestIncome4\">00</td>\n" +
                                "      </tr>\n" +
                                "\n" +
                                "      <tr>\n" +
                                "        <td>Other Non-Operating Income</td>\n" +
                                "        <td id=\"otherNonOperatingIncome0\">00</td>\n" +
                                "        <td id=\"otherNonOperatingIncome1\">00</td>\n" +
                                "        <td id=\"otherNonOperatingIncome2\">00</td>\n" +
                                "        <td id=\"otherNonOperatingIncome3\">00</td>\n" +
                                "        <td id=\"otherNonOperatingIncome4\">00</td>\n" +
                                "      </tr>\n" +
                                "\n" +
                                "      <tr>\n" +
                                "        <td>Net Income From Continuing Operations</td>\n" +
                                "        <td id=\"netIncomeFromContinuingOperations0\">00</td>\n" +
                                "        <td id=\"netIncomeFromContinuingOperations1\">00</td>\n" +
                                "        <td id=\"netIncomeFromContinuingOperations2\">00</td>\n" +
                                "        <td id=\"netIncomeFromContinuingOperations3\">00</td>\n" +
                                "        <td id=\"netIncomeFromContinuingOperations4\">00</td>\n" +
                                "      </tr>\n" +
                                "\n" +
                                "      <tr>\n" +
                                "        <td>Comprehensive Income Net Of Tax</td>\n" +
                                "        <td id=\"comprehensiveIncomeNetOfTax0\">00</td>\n" +
                                "        <td id=\"comprehensiveIncomeNetOfTax1\">00</td>\n" +
                                "        <td id=\"comprehensiveIncomeNetOfTax2\">00</td>\n" +
                                "        <td id=\"comprehensiveIncomeNetOfTax3\">00</td>\n" +
                                "        <td id=\"comprehensiveIncomeNetOfTax4\">00</td>\n" +
                                "      </tr>\n" +
                                "\n" +
                                "      <tr>\n" +
                                "        <td>Depreciation</td>\n" +
                                "        <td id=\"depreciation0\">00</td>\n" +
                                "        <td id=\"depreciation1\">00</td>\n" +
                                "        <td id=\"depreciation2\">00</td>\n" +
                                "        <td id=\"depreciation3\">00</td>\n" +
                                "        <td id=\"depreciation4\">00</td>\n" +
                                "      </tr>\n" +
                                "\n" +
                                "      <tr>\n" +
                                "        <td>Depreciation And Amortization</td>\n" +
                                "        <td id=\"depreciationAndAmortization0\">00</td>\n" +
                                "        <td id=\"depreciationAndAmortization1\">00</td>\n" +
                                "        <td id=\"depreciationAndAmortization2\">00</td>\n" +
                                "        <td id=\"depreciationAndAmortization3\">00</td>\n" +
                                "        <td id=\"depreciationAndAmortization4\">00</td>\n" +
                                "      </tr>\n" +
                                "\n" +
                                "      <tr>\n" +
                                "        <td>ebit</td>\n" +
                                "        <td id=\"ebit0\">00</td>\n" +
                                "        <td id=\"ebit1\">00</td>\n" +
                                "        <td id=\"ebit2\">00</td>\n" +
                                "        <td id=\"ebit3\">00</td>\n" +
                                "        <td id=\"ebit4\">00</td>\n" +
                                "      </tr>\n" +
                                "\n" +
                                "      <tr>\n" +
                                "        <td>ebitda</td>\n" +
                                "        <td id=\"ebitda0\">00</td>\n" +
                                "        <td id=\"ebitda1\">00</td>\n" +
                                "        <td id=\"ebitda2\">00</td>\n" +
                                "        <td id=\"ebitda3\">00</td>\n" +
                                "        <td id=\"ebitda4\">00</td>\n" +
                                "      </tr>\n" +
                                "\n" +
                                "      <tr>\n" +
                                "        <td>Net Income</td>\n" +
                                "        <td id=\"netIncome0\">00</td>\n" +
                                "        <td id=\"netIncome1\">00</td>\n" +
                                "        <td id=\"netIncome2\">00</td>\n" +
                                "        <td id=\"netIncome3\">00</td>\n" +
                                "        <td id=\"netIncome4\">00</td>\n" +
                                "      </tr>\n" +
                                "\n" +
                                "\n" +
                                "\n" +
                                "    \n" +
                                "    </table>\n" +
                                "  </center>\n" +
                                "</div>\n" +
                                "  \n" +
                                "<script src=\"incomeStatement.js\"></script>\n" +
                                "\n" +
                                        
                                "<div class=\"footer\">\n" +
                                "      <p></p>\n" +
                                "      <h1 style=\"color: #1D2E3E\">Footer</h1>\n" +
                                "</div>" +       
                                        
                                "  </body>\n" +
                                "</html>");


                }
    }

   

}
