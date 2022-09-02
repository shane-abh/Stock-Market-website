package FinancialData;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/BalanceSheet"})
public class BalanceSheet extends HttpServlet {

    /*In this method, the search string is recieved from the financialdata servlet 
    and we use javascript ajax to call the API and the balance sheet data is diplayed in a table in HTML*/   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String s = request.getParameter("search");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>\n" +
                        "<html>\n" + 
                        "  <head>\n" +
                        "    <meta charset=\"utf-8\">\n" +
                        "    <meta name=\"viewport\" content=\"width=device-width\">\n" +
                        "    <title>Balance Sheet</title>\n" +
                        "    <link href=\"CSS/stockPage.css\" rel=\"stylesheet\" type=\"text/css\" />\n" +
                        "    <link href=\"CSS/FinancialData.css\" rel=\"stylesheet\" type=\"text/css\" />" +
                        "  </head>\n" +
                        "  <body>\n" +
                        "  <input id=\"searchContent\" type=\"hidden\" value=\""+s+"\"></input>\n" +
                                
                        "    <div class=\"header\">\n" +
                        "       <h1><img src=\"icons/balancesheet.png\" alt=\"\" height=30 width=30 class=\"icon\"></img> Balance Sheet</h1>\n" +
                        "    </div>\n" +
                        
                        "      <form method=\"get\" action=\"FinancialData\">\n" +         
                        "            <input type=\"hidden\" value=\""+s+"\" class=\"start\" name=\"symbol\"/>\n" +        
                        "            <input type=\"image\" src=\"icons/back.png\" width=30 height=30 class=\"backicon\"/>" +
                        "      </form>\n" +          
                                
     
                        "    <div id=\"chartContainer\" style=\"height: 370px; width: 95%; \" class=\"chart\"></div>\n" +
                        "    <script src=\"https://canvasjs.com/assets/script/canvasjs.min.js\"></script>\n" +
                       
                                
                                
                        "\n" +
                        "    <div class=\"balanceSheet\">\n" +
                        "      <center>\n" +
                        "        <table id=\"FinData\">\n" +
                        "          <tr>\n" +
                        "            <th>Breakdown</th>\n" +
                        "            <th id=\"fiscalDateEnding0\">Date1</th>\n" +
                        "            <th id=\"fiscalDateEnding1\">Date2</th>\n" +
                        "            <th id=\"fiscalDateEnding2\">Date3</th>\n" +
                        "            <th id=\"fiscalDateEnding3\">Date4</th>\n" +
                        "            <th id=\"fiscalDateEnding4\">Date5</th>\n" +
                        "          </tr>\n" +
                        "\n" +
                        "\n" +
                        "          <tr>\n" +
                        "            <td>Total Assets</td>\n" +
                        "            <td id=\"totalAssets0\">Tot_rev1</td>\n" +
                        "            <td id=\"totalAssets1\">Tot_rev2</td>\n" +
                        "            <td id=\"totalAssets2\">Tot_rev3</td>\n" +
                        "            <td id=\"totalAssets3\">Tot_rev4</td>\n" +
                        "            <td id=\"totalAssets4\">Tot_rev5</td>\n" +
                        "          </tr>\n" +
                        "\n" +
                        "\n" +
                        "          <tr>\n" +
                        "            <td>Total Current Assets</td>\n" +
                        "            <td id=\"totalCurrentAssets0\">Tot_rev1</td>\n" +
                        "            <td id=\"totalCurrentAssets1\">Tot_rev2</td>\n" +
                        "            <td id=\"totalCurrentAssets2\">Tot_rev3</td>\n" +
                        "            <td id=\"totalCurrentAssets3\">Tot_rev4</td>\n" +
                        "            <td id=\"totalCurrentAssets4\">Tot_rev5</td>\n" +
                        "          </tr>\n" +
                        "\n" +
                        "          <tr>\n" +
                        "            <td>Cash and Cash Equivalents at carrying value</td>\n" +
                        "            <td id=\"cashAndCashEquivalentsAtCarryingValue0\">00</td>\n" +
                        "            <td id=\"cashAndCashEquivalentsAtCarryingValue1\">00</td>\n" +
                        "            <td id=\"cashAndCashEquivalentsAtCarryingValue2\">00</td>\n" +
                        "            <td id=\"cashAndCashEquivalentsAtCarryingValue3\">00</td>\n" +
                        "            <td id=\"cashAndCashEquivalentsAtCarryingValue4\">00</td>\n" +
                        "          </tr>\n" +
                        "\n" +
                        "          <tr>\n" +
                        "            <td>Cash and short tem investment</td>\n" +
                        "            <td id=\"cashAndShortTermInvestments0\">00</td>\n" +
                        "            <td id=\"cashAndShortTermInvestments1\">00</td>\n" +
                        "            <td id=\"cashAndShortTermInvestments2\">00</td>\n" +
                        "            <td id=\"cashAndShortTermInvestments3\">00</td>\n" +
                        "            <td id=\"cashAndShortTermInvestments4\">00</td>\n" +
                        "          </tr>\n" +
                        "\n" +
                        "          <tr>\n" +
                        "            <td>Inventory</td>\n" +
                        "            <td id=\"inventory0\">00</td>\n" +
                        "            <td id=\"inventory1\">00</td>\n" +
                        "            <td id=\"inventory2\">00</td>\n" +
                        "            <td id=\"inventory3\">00</td>\n" +
                        "            <td id=\"inventory4\">00</td>\n" +
                        "          </tr>\n" +
                        "\n" +
                        "          <tr>\n" +
                        "            <td>Current net recievables</td>\n" +
                        "            <td id=\"currentNetReceivables0\">00</td>\n" +
                        "            <td id=\"currentNetReceivables1\">00</td>\n" +
                        "            <td id=\"currentNetReceivables2\">00</td>\n" +
                        "            <td id=\"currentNetReceivables3\">00</td>\n" +
                        "            <td id=\"currentNetReceivables4\">00</td>\n" +
                        "          </tr>\n" +
                        "\n" +
                        "          <tr>\n" +
                        "            <td>Total Non Current Assets </td>\n" +
                        "            <td id=\"totalNonCurrentAssets0\">00</td>\n" +
                        "            <td id=\"totalNonCurrentAssets1\">00</td>\n" +
                        "            <td id=\"totalNonCurrentAssets2\">00</td>\n" +
                        "            <td id=\"totalNonCurrentAssets3\">00</td>\n" +
                        "            <td id=\"totalNonCurrentAssets4\">00</td>\n" +
                        "          </tr>\n" +
                        "\n" +
                        "          <tr>\n" +
                        "            <td>Property Plant Equipment0</td>\n" +
                        "            <td id=\"propertyPlantEquipment0\">00</td>\n" +
                        "            <td id=\"propertyPlantEquipment1\">00</td>\n" +
                        "            <td id=\"propertyPlantEquipment2\">00</td>\n" +
                        "            <td id=\"propertyPlantEquipment3\">00</td>\n" +
                        "            <td id=\"propertyPlantEquipment4\">00</td>\n" +
                        "          </tr>\n" +
                        "\n" +
                        "          <tr>\n" +
                        "            <td>Accumulated total Liabilities AmortizationPPE</td>\n" +
                        "            <td id=\"accumulatedDepreciationAmortizationPPE0\">00</td>\n" +
                        "            <td id=\"accumulatedDepreciationAmortizationPPE1\">00</td>\n" +
                        "            <td id=\"accumulatedDepreciationAmortizationPPE2\">00</td>\n" +
                        "            <td id=\"accumulatedDepreciationAmortizationPPE3\">00</td>\n" +
                        "            <td id=\"accumulatedDepreciationAmortizationPPE4\">00</td>\n" +
                        "          </tr>\n" +
                        "\n" +
                        "          <tr>\n" +
                        "            <td>Intangible Assets</td>\n" +
                        "            <td id=\"intangibleAssets0\">00</td>\n" +
                        "            <td id=\"intangibleAssets1\">00</td>\n" +
                        "            <td id=\"intangibleAssets2\">00</td>\n" +
                        "            <td id=\"intangibleAssets3\">00</td>\n" +
                        "            <td id=\"intangibleAssets4\">00</td>\n" +
                        "          </tr>\n" +
                        "\n" +
                        "          <tr>\n" +
                        "            <td>Intangible Assets Excluding Goodwill</td>\n" +
                        "            <td id=\"intangibleAssetsExcludingGoodwill0\">00</td>\n" +
                        "            <td id=\"intangibleAssetsExcludingGoodwill1\">00</td>\n" +
                        "            <td id=\"intangibleAssetsExcludingGoodwill2\">00</td>\n" +
                        "            <td id=\"intangibleAssetsExcludingGoodwill3\">00</td>\n" +
                        "            <td id=\"intangibleAssetsExcludingGoodwill4\">00</td>\n" +
                        "          </tr>\n" +
                        "\n" +
                        "          \n" +
                        "\n" +
                        "          <tr>\n" +
                        "            <td>Goodwill</td>\n" +
                        "            <td id=\"goodwill0\">00</td>\n" +
                        "            <td id=\"goodwill1\">00</td>\n" +
                        "            <td id=\"goodwill2\">00</td>\n" +
                        "            <td id=\"goodwill3\">00</td>\n" +
                        "            <td id=\"goodwill4\">00</td>\n" +
                        "          </tr>\n" +
                        "\n" +
                        "          <tr>\n" +
                        "            <td>Investments</td>\n" +
                        "            <td id=\"investments0\">00</td>\n" +
                        "            <td id=\"investments1\">00</td>\n" +
                        "            <td id=\"investments2\">00</td>\n" +
                        "            <td id=\"investments3\">00</td>\n" +
                        "            <td id=\"investments4\">00</td>\n" +
                        "          </tr>\n" +
                        "\n" +
                        "          <tr>\n" +
                        "            <td>Long Term Investments</td>\n" +
                        "            <td id=\"longTermInvestments0\">00</td>\n" +
                        "            <td id=\"longTermInvestments1\">00</td>\n" +
                        "            <td id=\"longTermInvestments2\">00</td>\n" +
                        "            <td id=\"longTermInvestments3\">00</td>\n" +
                        "            <td id=\"longTermInvestments4\">00</td>\n" +
                        "          </tr>\n" +
                        "\n" +
                        "          <tr>\n" +
                        "            <td>Short Term Investments</td>\n" +
                        "            <td id=\"shortTermInvestments0\">00</td>\n" +
                        "            <td id=\"shortTermInvestments1\">00</td>\n" +
                        "            <td id=\"shortTermInvestments2\">00</td>\n" +
                        "            <td id=\"shortTermInvestments3\">00</td>\n" +
                        "            <td id=\"shortTermInvestments4\">00</td>\n" +
                        "          </tr>\n" +
                        "\n" +
                        "          <tr>\n" +
                        "            <td>Other Current Assets</td>\n" +
                        "            <td id=\"otherCurrentAssets0\">00</td>\n" +
                        "            <td id=\"otherCurrentAssets1\">00</td>\n" +
                        "            <td id=\"otherCurrentAssets2\">00</td>\n" +
                        "            <td id=\"otherCurrentAssets3\">00</td>\n" +
                        "            <td id=\"otherCurrentAssets4\">00</td>\n" +
                        "          </tr>\n" +
                        "\n" +
                        "          <tr>\n" +
                        "            <td>Other Non-Currrent Assets</td>\n" +
                        "            <td id=\"otherNonCurrrentAssets0\">00</td>\n" +
                        "            <td id=\"otherNonCurrrentAssets1\">00</td>\n" +
                        "            <td id=\"otherNonCurrrentAssets2\">00</td>\n" +
                        "            <td id=\"otherNonCurrrentAssets3\">00</td>\n" +
                        "            <td id=\"otherNonCurrrentAssets4\">00</td>\n" +
                        "          </tr>\n" +
                        "\n" +
                        "          <tr>\n" +
                        "            <td>Total Liabilities</td>\n" +
                        "            <td id=\"totalLiabilities0\">00</td>\n" +
                        "            <td id=\"totalLiabilities1\">00</td>\n" +
                        "            <td id=\"totalLiabilities2\">00</td>\n" +
                        "            <td id=\"totalLiabilities3\">00</td>\n" +
                        "            <td id=\"totalLiabilities4\">00</td>\n" +
                        "          </tr>\n" +
                        "\n" +
                        "          <tr>\n" +
                        "            <td>Total Current Liabilities</td>\n" +
                        "            <td id=\"totalCurrentLiabilities0\">00</td>\n" +
                        "            <td id=\"totalCurrentLiabilities1\">00</td>\n" +
                        "            <td id=\"totalCurrentLiabilities2\">00</td>\n" +
                        "            <td id=\"totalCurrentLiabilities3\">00</td>\n" +
                        "            <td id=\"totalCurrentLiabilities4\">00</td>\n" +
                        "          </tr>\n" +
                        "\n" +
                        "          <tr>\n" +
                        "            <td>Current Accounts Payable</td>\n" +
                        "            <td id=\"currentAccountsPayable0\">00</td>\n" +
                        "            <td id=\"currentAccountsPayable1\">00</td>\n" +
                        "            <td id=\"currentAccountsPayable2\">00</td>\n" +
                        "            <td id=\"currentAccountsPayable3\">00</td>\n" +
                        "            <td id=\"currentAccountsPayable4\">00</td>\n" +
                        "          </tr>\n" +
                        "\n" +
                        "          <tr>\n" +
                        "            <td>Deferred Revenue</td>\n" +
                        "            <td id=\"deferredRevenue0\">00</td>\n" +
                        "            <td id=\"deferredRevenue1\">00</td>\n" +
                        "            <td id=\"deferredRevenue2\">00</td>\n" +
                        "            <td id=\"deferredRevenue3\">00</td>\n" +
                        "            <td id=\"deferredRevenue4\">00</td>\n" +
                        "          </tr>\n" +
                        "\n" +
                        "          <tr>\n" +
                        "            <td>Current Debt</td>\n" +
                        "            <td id=\"currentDebt0\">00</td>\n" +
                        "            <td id=\"currentDebt1\">00</td>\n" +
                        "            <td id=\"currentDebt2\">00</td>\n" +
                        "            <td id=\"currentDebt3\">00</td>\n" +
                        "            <td id=\"currentDebt4\">00</td>\n" +
                        "          </tr>\n" +
                        "\n" +
                        "          <tr>\n" +
                        "            <td>Short Term Debt</td>\n" +
                        "            <td id=\"shortTermDebt0\">00</td>\n" +
                        "            <td id=\"shortTermDebt1\">00</td>\n" +
                        "            <td id=\"shortTermDebt2\">00</td>\n" +
                        "            <td id=\"shortTermDebt3\">00</td>\n" +
                        "            <td id=\"shortTermDebt4\">00</td>\n" +
                        "          </tr>\n" +
                        "\n" +
                        "          <tr>\n" +
                        "            <td>Total Non Current Liabilities</td>\n" +
                        "            <td id=\"totalNonCurrentLiabilities0\">00</td>\n" +
                        "            <td id=\"totalNonCurrentLiabilities1\">00</td>\n" +
                        "            <td id=\"totalNonCurrentLiabilities2\">00</td>\n" +
                        "            <td id=\"totalNonCurrentLiabilities3\">00</td>\n" +
                        "            <td id=\"totalNonCurrentLiabilities4\">00</td>\n" +
                        "          </tr>\n" +
                        "\n" +
                        "          <tr>\n" +
                        "            <td>Capital Lease Obligations</td>\n" +
                        "            <td id=\"capitalLeaseObligations0\">00</td>\n" +
                        "            <td id=\"capitalLeaseObligations1\">00</td>\n" +
                        "            <td id=\"capitalLeaseObligations2\">00</td>\n" +
                        "            <td id=\"capitalLeaseObligations3\">00</td>\n" +
                        "            <td id=\"capitalLeaseObligations4\">00</td>\n" +
                        "          </tr>\n" +
                        "\n" +
                        "          <tr>\n" +
                        "            <td>Long Term Debt</td>\n" +
                        "            <td id=\"longTermDebt0\">00</td>\n" +
                        "            <td id=\"longTermDebt1\">00</td>\n" +
                        "            <td id=\"longTermDebt2\">00</td>\n" +
                        "            <td id=\"longTermDebt3\">00</td>\n" +
                        "            <td id=\"longTermDebt4\">00</td>\n" +
                        "          </tr>\n" +
                        "\n" +
                        "          \n" +
                        "          <tr>\n" +
                        "            <td>Current Long Term Debt</td>\n" +
                        "            <td id=\"currentLongTermDebt0\">00</td>\n" +
                        "            <td id=\"currentLongTermDebt1\">00</td>\n" +
                        "            <td id=\"currentLongTermDebt2\">00</td>\n" +
                        "            <td id=\"currentLongTermDebt3\">00</td>\n" +
                        "            <td id=\"currentLongTermDebt4\">00</td>\n" +
                        "          </tr>\n" +
                        "\n" +
                        "          <tr>\n" +
                        "            <td>Long Term Debt Non current</td>\n" +
                        "            <td id=\"longTermDebtNoncurrent0\">00</td>\n" +
                        "            <td id=\"longTermDebtNoncurrent1\">00</td>\n" +
                        "            <td id=\"longTermDebtNoncurrent2\">00</td>\n" +
                        "            <td id=\"longTermDebtNoncurrent3\">00</td>\n" +
                        "            <td id=\"longTermDebtNoncurrent4\">00</td>\n" +
                        "          </tr>\n" +
                        "\n" +
                        "          <tr>\n" +
                        "            <td>Short Long Term Debt Total</td>\n" +
                        "            <td id=\"shortLongTermDebtTotal0\">00</td>\n" +
                        "            <td id=\"shortLongTermDebtTotal1\">00</td>\n" +
                        "            <td id=\"shortLongTermDebtTotal2\">00</td>\n" +
                        "            <td id=\"shortLongTermDebtTotal3\">00</td>\n" +
                        "            <td id=\"shortLongTermDebtTotal4\">00</td>\n" +
                        "          </tr>\n" +
                        "          <tr>\n" +
                        "            <td>Other Current Liabilities</td>\n" +
                        "            <td id=\"otherCurrentLiabilities0\">00</td>\n" +
                        "            <td id=\"otherCurrentLiabilities1\">00</td>\n" +
                        "            <td id=\"otherCurrentLiabilities2\">00</td>\n" +
                        "            <td id=\"otherCurrentLiabilities3\">00</td>\n" +
                        "            <td id=\"otherCurrentLiabilities4\">00</td>\n" +
                        "          </tr>\n" +
                        "          <tr>\n" +
                        "            <td>Other Non Current Liabilities</td>\n" +
                        "            <td id=\"otherNonCurrentLiabilities0\">00</td>\n" +
                        "            <td id=\"otherNonCurrentLiabilities1\">00</td>\n" +
                        "            <td id=\"otherNonCurrentLiabilities2\">00</td>\n" +
                        "            <td id=\"otherNonCurrentLiabilities3\">00</td>\n" +
                        "            <td id=\"otherNonCurrentLiabilities4\">00</td>\n" +
                        "          </tr>\n" +
                        "          <tr>\n" +
                        "            <td>Total Shareholder Equity</td>\n" +
                        "            <td id=\"totalShareholderEquity0\">00</td>\n" +
                        "            <td id=\"totalShareholderEquity1\">00</td>\n" +
                        "            <td id=\"totalShareholderEquity2\">00</td>\n" +
                        "            <td id=\"totalShareholderEquity3\">00</td>\n" +
                        "            <td id=\"totalShareholderEquity4\">00</td>\n" +
                        "          </tr>\n" +
                        "          <tr>\n" +
                        "            <td>Treasury Stock</td>\n" +
                        "            <td id=\"treasuryStock0\">00</td>\n" +
                        "            <td id=\"treasuryStock1\">00</td>\n" +
                        "            <td id=\"treasuryStock2\">00</td>\n" +
                        "            <td id=\"treasuryStock3\">00</td>\n" +
                        "            <td id=\"treasuryStock4\">00</td>\n" +
                        "          </tr>\n" +
                        "\n" +
                        "          <tr>\n" +
                        "            <td>Retained Earnings</td>\n" +
                        "            <td id=\"retainedEarnings0\">00</td>\n" +
                        "            <td id=\"retainedEarnings1\">00</td>\n" +
                        "            <td id=\"retainedEarnings2\">00</td>\n" +
                        "            <td id=\"retainedEarnings3\">00</td>\n" +
                        "            <td id=\"retainedEarnings4\">00</td>\n" +
                        "          </tr>\n" +
                        "\n" +
                        "          <tr>\n" +
                        "            <td>Common Stock</td>\n" +
                        "            <td id=\"commonStock0\">00</td>\n" +
                        "            <td id=\"commonStock1\">00</td>\n" +
                        "            <td id=\"commonStock2\">00</td>\n" +
                        "            <td id=\"commonStock3\">00</td>\n" +
                        "            <td id=\"commonStock4\">00</td>\n" +
                        "          </tr>\n" +
                        "\n" +
                        "          <tr>\n" +
                        "            <td>Common Stock Shares Outstanding</td>\n" +
                        "            <td id=\"commonStockSharesOutstanding0\">00</td>\n" +
                        "            <td id=\"commonStockSharesOutstanding1\">00</td>\n" +
                        "            <td id=\"commonStockSharesOutstanding2\">00</td>\n" +
                        "            <td id=\"commonStockSharesOutstanding3\">00</td>\n" +
                        "            <td id=\"commonStockSharesOutstanding4\">00</td>\n" +
                        "          </tr>\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "        \n" +
                        "        </table>\n" +
                        "      </center>\n" +
                        "    </div>\n" +
                                
                                
                        "<div class=\"footer\">\n" +
                        "      <p></p>\n" +
                        "      <h1 style=\"color: #1D2E3E\">Footer</h1>\n" +
                        "    </div>" +
                                
                                
                        "    <script src=\"JS/balanceSheet.js\"></script>\n" +
                        "  </body>\n" +
                        "</html>");
            
        }
        
    }

   
}
