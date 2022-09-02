
package FinancialData;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "CashFlow", urlPatterns = {"/CashFlow"})
public class CashFlow extends HttpServlet {

   /*In this method, the search string is recieved from the financialdata servlet 
    and we use javascript ajax to call the API and the Cash Flow data is diplayed in a table in HTML*/   
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
                        "    <title>Cash Flow</title>\n" +
                        "    <link href=\"CSS/stockPage.css\" rel=\"stylesheet\" type=\"text/css\" />\n" +
                        "    <link href=\"CSS/FinancialData.css\" rel=\"stylesheet\" type=\"text/css\" />" +
                        "  </head>\n" +
                        "  <body>\n" +
                    
                    
                        "    <div class=\"header\">\n" +
                        "       <h1><img src=\"icons/money-flow.png\" alt=\"\" height=30 width=30 class=\"icon\"></img> Cash Flow Statement</h1>\n" +
                        "    </div>\n" +
                    
                    
                        "      <form method=\"get\" action=\"FinancialData\">\n" +         
                        "            <input type=\"hidden\" value=\""+s+"\" class=\"start\" name=\"symbol\"/>\n" +        
                        "            <input type=\"image\" src=\"icons/back.png\" width=30 height=30 class=\"backicon\"/>" +
                        "      </form>\n" +  
                          
                    
                        "    <div id=\"chartContainer3\" style=\"height: 370px; width: 95%;\" class=\"chart\"></div>\n" +
                        "<script src=\"https://canvasjs.com/assets/script/canvasjs.min.js\"></script>\n" +
                        "\n" +
                        "<br>\n" +
                        "    <br>\n" +
                        "    <br>\n" +
                        "    <br>\n" +
                        "    <br>\n" +
                        "    <br>\n" +
                        "  <input id=\"searchContent\" type=\"hidden\" value=\""+s+"\"></input>\n" +
                        "\n" +
                        "<div class=\"CashFlow\">\n" +
                        "  <center>\n" +
                        "    <table id=\"FinData\">\n" +
                        "      <tr>\n" +
                        "        <th>Breakdown</th>\n" +
                        "        <th id=\"fiscalDateEnding_cash0\">Date1</th>\n" +
                        "        <th id=\"fiscalDateEnding_cash1\">Date2</th>\n" +
                        "        <th id=\"fiscalDateEnding_cash2\">Date3</th>\n" +
                        "        <th id=\"fiscalDateEnding_cash3\">Date4</th>\n" +
                        "        <th id=\"fiscalDateEnding_cash4\">Date5</th>\n" +
                        "      </tr>\n" +
                        "\n" +
                        "      <tr>\n" +
                        "        <td>Operating Cashflow</td>\n" +
                        "        <td id=\"operatingCashflow0\">Tot_rev1</td>\n" +
                        "        <td id=\"operatingCashflow1\">Tot_rev2</td>\n" +
                        "        <td id=\"operatingCashflow2\">Tot_rev3</td>\n" +
                        "        <td id=\"operatingCashflow3\">Tot_rev4</td>\n" +
                        "        <td id=\"operatingCashflow4\">Tot_rev5</td>\n" +
                        "      </tr>\n" +
                        "\n" +
                        "      <tr>\n" +
                        "        <td>Payments For Operating Activities</td>\n" +
                        "        <td id=\"paymentsForOperatingActivities0\">Tot_rev1</td>\n" +
                        "        <td id=\"paymentsForOperatingActivities1\">Tot_rev2</td>\n" +
                        "        <td id=\"paymentsForOperatingActivities2\">Tot_rev3</td>\n" +
                        "        <td id=\"paymentsForOperatingActivities3\">Tot_rev4</td>\n" +
                        "        <td id=\"paymentsForOperatingActivities4\">Tot_rev5</td>\n" +
                        "      </tr>\n" +
                        "\n" +
                        "      <tr>\n" +
                        "        <td>Proceeds From Operating Activities</td>\n" +
                        "        <td id=\"proceedsFromOperatingActivities0\">00</td>\n" +
                        "        <td id=\"proceedsFromOperatingActivities1\">00</td>\n" +
                        "        <td id=\"proceedsFromOperatingActivities2\">00</td>\n" +
                        "        <td id=\"proceedsFromOperatingActivities3\">00</td>\n" +
                        "        <td id=\"proceedsFromOperatingActivities4\">00</td>\n" +
                        "      </tr>\n" +
                        "\n" +
                        "      <tr>\n" +
                        "        <td>Change In Operating Liabilities</td>\n" +
                        "        <td id=\"changeInOperatingLiabilities0\">00</td>\n" +
                        "        <td id=\"changeInOperatingLiabilities1\">00</td>\n" +
                        "        <td id=\"changeInOperatingLiabilities2\">00</td>\n" +
                        "        <td id=\"changeInOperatingLiabilities3\">00</td>\n" +
                        "        <td id=\"changeInOperatingLiabilities4\">00</td>\n" +
                        "      </tr>\n" +
                        "\n" +
                        "     <tr>\n" +
                        "        <td>Change In Operating Assets</td>\n" +
                        "        <td id=\"changeInOperatingAssets0\">00</td>\n" +
                        "        <td id=\"changeInOperatingAssets1\">00</td>\n" +
                        "        <td id=\"changeInOperatingAssets2\">00</td>\n" +
                        "        <td id=\"changeInOperatingAssets3\">00</td>\n" +
                        "        <td id=\"changeInOperatingAssets4\">00</td>\n" +
                        "      </tr>\n" +
                        "\n" +
                        "      <tr>\n" +
                        "        <td>Depreciation Depletion And Amortization</td>\n" +
                        "        <td id=\"depreciationDepletionAndAmortization0\">00</td>\n" +
                        "        <td id=\"depreciationDepletionAndAmortization1\">00</td>\n" +
                        "        <td id=\"depreciationDepletionAndAmortization2\">00</td>\n" +
                        "        <td id=\"depreciationDepletionAndAmortization3\">00</td>\n" +
                        "        <td id=\"depreciationDepletionAndAmortization4\">00</td>\n" +
                        "      </tr>\n" +
                        "\n" +
                        "      <tr>\n" +
                        "        <td>Capital Expenditures</td>\n" +
                        "        <td id=\"capitalExpenditures0\">00</td>\n" +
                        "        <td id=\"capitalExpenditures1\">00</td>\n" +
                        "        <td id=\"capitalExpenditures2\">00</td>\n" +
                        "        <td id=\"capitalExpenditures3\">00</td>\n" +
                        "        <td id=\"capitalExpenditures4\">00</td>\n" +
                        "      </tr>\n" +
                        "\n" +
                        "      <tr>\n" +
                        "        <td>Change In Receivables</td>\n" +
                        "        <td id=\"changeInReceivables0\">00</td>\n" +
                        "        <td id=\"changeInReceivables1\">00</td>\n" +
                        "        <td id=\"changeInReceivables2\">00</td>\n" +
                        "        <td id=\"changeInReceivables3\">00</td>\n" +
                        "        <td id=\"changeInReceivables4\">00</td>\n" +
                        "      </tr>\n" +
                        "\n" +
                        "      <tr>\n" +
                        "        <td>Change In Inventory</td>\n" +
                        "        <td id=\"changeInInventory0\">00</td>\n" +
                        "        <td id=\"changeInInventory1\">00</td>\n" +
                        "        <td id=\"changeInInventory2\">00</td>\n" +
                        "        <td id=\"changeInInventory3\">00</td>\n" +
                        "        <td id=\"changeInInventory4\">00</td>\n" +
                        "      </tr>\n" +
                        "\n" +
                        "      <tr>\n" +
                        "        <td>Profit Loss</td>\n" +
                        "        <td id=\"profitLoss0\">00</td>\n" +
                        "        <td id=\"profitLoss1\">00</td>\n" +
                        "        <td id=\"profitLoss2\">00</td>\n" +
                        "        <td id=\"profitLoss3\">00</td>\n" +
                        "        <td id=\"profitLoss4\">00</td>\n" +
                        "      </tr>\n" +
                        "      \n" +
                        "      <tr>\n" +
                        "        <td>Cashflow From Investment</td>\n" +
                        "        <td id=\"cashflowFromInvestment0\">00</td>\n" +
                        "        <td id=\"cashflowFromInvestment1\">00</td>\n" +
                        "        <td id=\"cashflowFromInvestment2\">00</td>\n" +
                        "        <td id=\"cashflowFromInvestment3\">00</td>\n" +
                        "        <td id=\"cashflowFromInvestment4\">00</td>\n" +
                        "      </tr>\n" +
                        "\n" +
                        "      \n" +
                        "\n" +
                        "      <tr>\n" +
                        "        <td>Cashflow From Financing</td>\n" +
                        "        <td id=\"cashflowFromFinancing0\">00</td>\n" +
                        "        <td id=\"cashflowFromFinancing1\">00</td>\n" +
                        "        <td id=\"cashflowFromFinancing2\">00</td>\n" +
                        "        <td id=\"cashflowFromFinancing3\">00</td>\n" +
                        "        <td id=\"cashflowFromFinancing4\">00</td>\n" +
                        "      </tr>\n" +
                        "\n" +
                        "      <tr>\n" +
                        "        <td>Proceeds From Repayments Of ShortTerm Debt</td>\n" +
                        "        <td id=\"proceedsFromRepaymentsOfShortTermDebt0\">00</td>\n" +
                        "        <td id=\"proceedsFromRepaymentsOfShortTermDebt1\">00</td>\n" +
                        "        <td id=\"proceedsFromRepaymentsOfShortTermDebt2\">00</td>\n" +
                        "        <td id=\"proceedsFromRepaymentsOfShortTermDebt3\">00</td>\n" +
                        "        <td id=\"proceedsFromRepaymentsOfShortTermDebt4\">00</td>\n" +
                        "      </tr>\n" +
                        "\n" +
                        "      <tr>\n" +
                        "        <td>Payments For Repurchase Of Common Stock</td>\n" +
                        "        <td id=\"paymentsForRepurchaseOfCommonStock0\">00</td>\n" +
                        "        <td id=\"paymentsForRepurchaseOfCommonStock1\">00</td>\n" +
                        "        <td id=\"paymentsForRepurchaseOfCommonStock2\">00</td>\n" +
                        "        <td id=\"paymentsForRepurchaseOfCommonStock3\">00</td>\n" +
                        "        <td id=\"paymentsForRepurchaseOfCommonStock4\">00</td>\n" +
                        "      </tr>\n" +
                        "\n" +
                        "      <tr>\n" +
                        "        <td>Payments For Repurchase Of Equity</td>\n" +
                        "        <td id=\"paymentsForRepurchaseOfEquity0\">00</td>\n" +
                        "        <td id=\"paymentsForRepurchaseOfEquity1\">00</td>\n" +
                        "        <td id=\"paymentsForRepurchaseOfEquity2\">00</td>\n" +
                        "        <td id=\"paymentsForRepurchaseOfEquity3\">00</td>\n" +
                        "        <td id=\"paymentsForRepurchaseOfEquity4\">00</td>\n" +
                        "      </tr>\n" +
                        "\n" +
                        "      <tr>\n" +
                        "        <td>Payments For Repurchase Of Preferred Stock</td>\n" +
                        "        <td id=\"paymentsForRepurchaseOfPreferredStock0\">00</td>\n" +
                        "        <td id=\"paymentsForRepurchaseOfPreferredStock1\">00</td>\n" +
                        "        <td id=\"paymentsForRepurchaseOfPreferredStock2\">00</td>\n" +
                        "        <td id=\"paymentsForRepurchaseOfPreferredStock3\">00</td>\n" +
                        "        <td id=\"paymentsForRepurchaseOfPreferredStock4\">00</td>\n" +
                        "      </tr>\n" +
                        "\n" +
                        "      <tr>\n" +
                        "        <td>Dividend Payout</td>\n" +
                        "        <td id=\"dividendPayout0\">00</td>\n" +
                        "        <td id=\"dividendPayout1\">00</td>\n" +
                        "        <td id=\"dividendPayout2\">00</td>\n" +
                        "        <td id=\"dividendPayout3\">00</td>\n" +
                        "        <td id=\"dividendPayout4\">00</td>\n" +
                        "      </tr>\n" +
                        "\n" +
                        "      <tr>\n" +
                        "        <td>Dividend Payout Common Stock</td>\n" +
                        "        <td id=\"dividendPayoutCommonStock0\">00</td>\n" +
                        "        <td id=\"dividendPayoutCommonStock1\">00</td>\n" +
                        "        <td id=\"dividendPayoutCommonStock2\">00</td>\n" +
                        "        <td id=\"dividendPayoutCommonStock3\">00</td>\n" +
                        "        <td id=\"dividendPayoutCommonStock4\">00</td>\n" +
                        "      </tr>\n" +
                        "\n" +
                        "      <tr>\n" +
                        "        <td>Dividend Payout Preferred Stock</td>\n" +
                        "        <td id=\"dividendPayoutPreferredStock0\">00</td>\n" +
                        "        <td id=\"dividendPayoutPreferredStock1\">00</td>\n" +
                        "        <td id=\"dividendPayoutPreferredStock2\">00</td>\n" +
                        "        <td id=\"dividendPayoutPreferredStock3\">00</td>\n" +
                        "        <td id=\"dividendPayoutPreferredStock4\">00</td>\n" +
                        "      </tr>\n" +
                        "\n" +
                        "      <tr>\n" +
                        "        <td>Proceeds From Issuance Of Common Stock</td>\n" +
                        "        <td id=\"proceedsFromIssuanceOfCommonStock0\">00</td>\n" +
                        "        <td id=\"proceedsFromIssuanceOfCommonStock1\">00</td>\n" +
                        "        <td id=\"proceedsFromIssuanceOfCommonStock2\">00</td>\n" +
                        "        <td id=\"proceedsFromIssuanceOfCommonStock3\">00</td>\n" +
                        "        <td id=\"proceedsFromIssuanceOfCommonStock4\">00</td>\n" +
                        "      </tr>\n" +
                        "\n" +
                        "      <tr>\n" +
                        "        <td>Proceeds From Issuance Of Long Term Debt And Capital Securities Net</td>\n" +
                        "        <td id=\"proceedsFromIssuanceOfLongTermDebtAndCapitalSecuritiesNet0\">00</td>\n" +
                        "        <td id=\"proceedsFromIssuanceOfLongTermDebtAndCapitalSecuritiesNet1\">00</td>\n" +
                        "        <td id=\"proceedsFromIssuanceOfLongTermDebtAndCapitalSecuritiesNet2\">00</td>\n" +
                        "        <td id=\"proceedsFromIssuanceOfLongTermDebtAndCapitalSecuritiesNet3\">00</td>\n" +
                        "        <td id=\"proceedsFromIssuanceOfLongTermDebtAndCapitalSecuritiesNet4\">00</td>\n" +
                        "      </tr>\n" +
                        "\n" +
                        "      <tr>\n" +
                        "        <td>Proceeds From Issuance Of Preferred Stock</td>\n" +
                        "        <td id=\"proceedsFromIssuanceOfPreferredStock0\">00</td>\n" +
                        "        <td id=\"proceedsFromIssuanceOfPreferredStock1\">00</td>\n" +
                        "        <td id=\"proceedsFromIssuanceOfPreferredStock2\">00</td>\n" +
                        "        <td id=\"proceedsFromIssuanceOfPreferredStock3\">00</td>\n" +
                        "        <td id=\"proceedsFromIssuanceOfPreferredStock4\">00</td>\n" +
                        "      </tr>\n" +
                        "\n" +
                        "      <tr>\n" +
                        "        <td>Proceeds From Repurchase Of Equity</td>\n" +
                        "        <td id=\"proceedsFromRepurchaseOfEquity0\">00</td>\n" +
                        "        <td id=\"proceedsFromRepurchaseOfEquity1\">00</td>\n" +
                        "        <td id=\"proceedsFromRepurchaseOfEquity2\">00</td>\n" +
                        "        <td id=\"proceedsFromRepurchaseOfEquity3\">00</td>\n" +
                        "        <td id=\"proceedsFromRepurchaseOfEquity4\">00</td>\n" +
                        "      </tr>\n" +
                        "\n" +
                        "      <tr>\n" +
                        "        <td>Proceeds From Sale Of Treasury Stock</td>\n" +
                        "        <td id=\"proceedsFromSaleOfTreasuryStock0\">00</td>\n" +
                        "        <td id=\"proceedsFromSaleOfTreasuryStock1\">00</td>\n" +
                        "        <td id=\"proceedsFromSaleOfTreasuryStock2\">00</td>\n" +
                        "        <td id=\"proceedsFromSaleOfTreasuryStock3\">00</td>\n" +
                        "        <td id=\"proceedsFromSaleOfTreasuryStock4\">00</td>\n" +
                        "      </tr>\n" +
                        "\n" +
                        "      <tr>\n" +
                        "        <td>Change In Cash And Cash Equivalents</td>\n" +
                        "        <td id=\"changeInCashAndCashEquivalents0\">00</td>\n" +
                        "        <td id=\"changeInCashAndCashEquivalents1\">00</td>\n" +
                        "        <td id=\"changeInCashAndCashEquivalents2\">00</td>\n" +
                        "        <td id=\"changeInCashAndCashEquivalents3\">00</td>\n" +
                        "        <td id=\"changeInCashAndCashEquivalents4\">00</td>\n" +
                        "      </tr>\n" +
                        "\n" +
                        "      <tr>\n" +
                        "        <td>Change In Exchange Rate</td>\n" +
                        "        <td id=\"changeInExchangeRate0\">00</td>\n" +
                        "        <td id=\"changeInExchangeRate1\">00</td>\n" +
                        "        <td id=\"changeInExchangeRate2\">00</td>\n" +
                        "        <td id=\"changeInExchangeRate3\">00</td>\n" +
                        "        <td id=\"changeInExchangeRate4\">00</td>\n" +
                        "      </tr>\n" +
                        "\n" +
                        "      \n" +
                        "      \n" +
                        "\n" +
                        "    <tr>\n" +
                        "        <td>Net Income</td>\n" +
                        "        <td id=\"netIncome_cash0\">00</td>\n" +
                        "        <td id=\"netIncome_cash1\">00</td>\n" +
                        "        <td id=\"netIncome_cash2\">00</td>\n" +
                        "        <td id=\"netIncome_cash3\">00</td>\n" +
                        "        <td id=\"netIncome_cash4\">00</td>\n" +
                        "      </tr>\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "    \n" +
                        "    </table>\n" +
                        "  </center>\n" +
                        "</div>\n" +
                                
                        "<div class=\"footer\">\n" +
                        "      <p></p>\n" +
                        "      <h1 style=\"color: #1D2E3E\">Footer</h1>\n" +
                        "    </div>"     +
                                
                                
                        "    <script src=\"cashFlow.js\"></script>\n" +

                        "  </body>\n" +
                        "</html>");

        }
    }

   

}
