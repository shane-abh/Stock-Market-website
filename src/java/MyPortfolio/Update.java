
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


@WebServlet(name = "Update", urlPatterns = {"/Update"})
public class Update extends HttpServlet {

    
    /*This servlet is used to process the information from recieved from update_html servlet and if the data is updated 
    in the table then the user would be able to see the updated table*/
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("id");
        String stockName = request.getParameter("stName");
        String qty = request.getParameter("qty");
        String price = request.getParameter("price");
        String date = request.getParameter("dt");
        String user = request.getParameter("user");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Update</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Update at " + request.getContextPath() + "</h1>");
            out.println(id+" "+stockName + qty);
            
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
                stmt.executeUpdate("UPDATE stock SET STOCKNAME= '"+stockName+"',longstockname= '"+list.get(0)+"',QTY = "+Integer.parseInt(qty)+",PRICEBOUGHTAT= "+Double.parseDouble(price)+",DATEBOUGHTAT= '"+date+"' WHERE id="+Integer.parseInt(id)); 
                out.println("Successfully Updated");
                out.println(user);
                RequestDispatcher rd=request.getRequestDispatcher("update_html");
                rd.forward(request, response);
            } catch (SQLException e) 
            {  
             out.println("error updation " + e);  
            }
            out.println("</body>");
            out.println("</html>");
        }
        
    }

    

}
