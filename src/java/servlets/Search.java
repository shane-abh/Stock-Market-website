
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


@WebServlet(name = "Search", urlPatterns = {"/Search"})
public class Search extends HttpServlet {


    /*This  method loads data from the stock_table into the datalist and an input box in given so that the user can search */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Search</title>"); 
            out.println("<link href=\"CSS/search.css\" rel=\"stylesheet\" type=\"text/css\" />");
            out.println("<link href=\"CSS/stockPage.css\" rel=\"stylesheet\" type=\"text/css\" />"); 
            out.println("</head>");
            out.println("<body>");

            try{
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Test","root","root");
            Statement stmt = conn.createStatement();
             
            
            ResultSet rs = stmt.executeQuery("SELECT Symbol,Name from stock_table"); 
            
            
            out.println("    <div class=\"header\">\n" +
                        "       <h1><img src=\"icons/search.png\" alt=\"\" height=30 width=30 class=\"icon\"></img> Search</h1>\n" +
                        "    </div>\n" );
            
            out.println("<form method=\"get\" action=\"Stock_page\" class=\"search_sto\">");
             
             List<String> list=new ArrayList<>(); 
             List<String> list2=new ArrayList<>();
             while (rs.next()) 
             {  
                 String n = rs.getString("Symbol");  
                 String nm = rs.getString("Name");  
                 
                 list.add(nm);
                 list2.add(n);                 
             }  

            out.println("<center>");
            out.println("<label class=\"label\">Enter name of the stock</label>");
            out.println("<br>");
            out.println("<br>");
            out.println("<input list=\"stocks\" name=\"stocks\" id=\"st\" class=\"stocks\" placeholder=\" Search\" pattern=\"^[a-zA-Z]+$\" required>");
            out.println("<datalist name=\"stocks\" id=\"stocks\">\n");
                           
            //adds the list into the datalist
            for(int i =0;i<list.size();i++){

                out.println("<option label =\""+list.get(i)+"\" id=\"li\" value=\""+list2.get(i)+"\"></option>\n");
            }
            out.println("</datalist>");
         
            out.println("<input type=\"submit\" value=\"Go\" class=\"search\" />");
            out.println("</center>");
            
            out.println("</form>");
            

           } catch (SQLException e) 
            {  
             out.println("error");  
            }
            
            out.println("<div class=\"footer\">\n" +
                        "      <p></p>\n" +
                        "      <h1 style=\"color: #1D2E3E\">Footer</h1>\n" +
                        "    </div>");
            
            out.println("<script src=\"search.js\"></script>");
            out.println("</body>");
            out.println("</html>");
        }
        
    }


}
