
package servlets;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Register", urlPatterns = {"/Register"})
public class Register extends HttpServlet {
    
    
    /*This funtion is used to add a user into the users table in MySQL database*/
    public static boolean CreateUser(String username,String email,String password) 
    {   
        
        boolean st =false;
        try{
                Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Test","root","root");
                Statement stmt = conn.createStatement();
                PreparedStatement ps = conn.prepareStatement("INSERT into users (username,email,password)"+ "VALUES (?,?,?)");
                ps.setString(1, username);
                ps.setString(2, email);
                ps.setString(3, password);

                int status = ps.executeUpdate();
                if(status > 0) {
                   System.out.println("Record is inserted successfully !!!");
                   st = true;
                   
                }
            }catch(SQLException e){
                System.out.println("Error "+e);
            }
        return st;  
    }
    
    
    
    
    /*This method processes the information from the register html and adds the user to the table*/
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Register</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Register at " + request.getContextPath() + "</h1>");
            if(CreateUser(username,email, password)){
                out.println("Registration Succesfull");
                RequestDispatcher rd=request.getRequestDispatcher("login.html");
                rd.forward(request, response);
            }else{
                out.println("Registration Failed");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    

}
