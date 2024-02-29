
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
@WebServlet(urlPatterns = {"/loginForm"})
public class loginForm extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet loginForm</title>");            
            out.println("</head>");
            out.println("<body>");
            
            String username =request.getParameter("username");
            String password =request.getParameter("password");
            out.println(username);
            out.println(password);
            String user = "";
            String pass = "";

       try  
        {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Welcome");
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CreditCardSystem","root","root");
            System.out.println("Connection Created");
            Statement stmt = con.createStatement();
            PreparedStatement ps=con.prepareStatement("select * from login where id=?");
            ps.setString(1,username);
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){
            user = rs.getString(1);
            pass = rs.getString(2);
            if (user.equals("admin")){
                break;
            }
            }
            rs.close();
            con.close();
            out.println(user);
            out.println(pass);
        if(username.equals("admin") && password.equals(pass)){
            out.println("Username : "+user);    
            response.sendRedirect("admin.html");
        }
        if(username.equals(user) && password.equals(pass)){
            response.sendRedirect("navigationPage.html");
        }
        else{
            out.println("Login Unseccessful!");
            response.sendRedirect("index.html");
        }
        }
        catch(Exception e)
            {
                System.out.println(e);
            }
           
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
