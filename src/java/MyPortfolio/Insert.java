
package MyPortfolio;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Insert", urlPatterns = {"/Insert"})
public class Insert extends HttpServlet {

    /*This servlet is used to process the information from recieved from insert_html servlet and if the data is inserted 
    into the table then the user would be able to see the updated table*/
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String stockName = request.getParameter("stName");
        String qty = request.getParameter("qty");
        String price = request.getParameter("price");
        String date = request.getParameter("dt");
        String user = request.getParameter("user");
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet dd</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet dd at " + request.getContextPath() + "</h1>");
            
            out.println(stockName);
            out.println(user);
            try{
                Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Test","root","root");
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT Name from stock_table where Symbol LIKE '"+stockName+"'"); //"SELECT Symbol,Name from stock_table where Name LIKE"+search
                List<String> list=new ArrayList<>(); 
                while (rs.next()) 
                {  
                 String n = rs.getString("Name");  
                 list.add(n);
                }
                out.println(list.get(0));
                stmt.executeUpdate("INSERT INTO stock (USERNAME,STOCKNAME,longstockname,QTY,PRICEBOUGHTAT,DATEBOUGHTAT) VALUES ('"+user+"','"+stockName+"', '"+list.get(0)+"' ,"+Integer.parseInt(qty)+","+Double.parseDouble(price)+",'"+date+"')"); 
                out.println("Successfully entered");
                
                RequestDispatcher rd=request.getRequestDispatcher("insert_html");
                rd.forward(request, response);

                out.println("      <form method=\"get\" action=\"insert_html\">\n"+
                    "<input type=\"hidden\" value=\""+user+"\" class=\"button\" name=\"user\">"+
                    "<input type=\"submit\" value=\"Back\">\n" +
                    "</form>");
            } catch (SQLException e) 
            {  
             out.println("error " + e);  
            }
            out.println("</body>");
            out.println("</html>");
        }
        
    }
    

}
