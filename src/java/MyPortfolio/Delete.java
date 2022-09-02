
package MyPortfolio;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Delete", urlPatterns = {"/Delete"})
public class Delete extends HttpServlet {
    
    /*This servlet is used to process the information from recieved from delete_html servlet and if the data is deleted 
    from the table then the user would be able to see the updated table*/
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("id");
        
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Update</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Delete at " + request.getContextPath() + "</h1>");
            
            
            try{
                Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Test","root","root");
                Statement stmt = conn.createStatement();
                
                stmt.executeUpdate("DELETE from stock WHERE id="+id); 
                out.println("Successfully Deleted");
                RequestDispatcher rd=request.getRequestDispatcher("delete_html");
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
