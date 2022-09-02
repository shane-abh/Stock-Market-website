
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    /*This method is used to check if the information entered by the user is valid or not*/
    public static boolean checkUser(String username,String password) 
    {   
        
        boolean st =false;
        try{
                Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Test","root","root");
                Statement stmt = conn.createStatement();
                PreparedStatement ps = conn.prepareStatement("select * from users where username=? and password=?");
                ps.setString(1, username);
                ps.setString(2, password);
                ResultSet rs =ps.executeQuery();
                st = rs.next();
            }catch(SQLException e){
                System.out.println("Error "+e);
            }
        return st;  
    }
    
    
    /*This method gets the information from the login.html and uses the above function for validation*/
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Login</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Login at " + request.getContextPath() + "</h1>");
            out.println(username);
            out.println(password);
            
            if(checkUser(username, password)){
                out.println("Login Succesfull");
                RequestDispatcher rd=request.getRequestDispatcher("MyPortfolio");
                rd.forward(request, response);
            }else{
                out.println("Login Failed");
            }
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
