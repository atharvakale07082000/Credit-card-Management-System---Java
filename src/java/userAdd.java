/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ABC
 */
@WebServlet(urlPatterns = {"/userAdd"})
public class userAdd extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet userAdd</title>");            
            out.println("</head>");
            out.println("<body>");
            
            String id =request.getParameter("userId");
            String firstname =request.getParameter("firstName");
            String lastname=request.getParameter("lastName");
            String address =request.getParameter("address");
            String telephone =request.getParameter("telephone");
            String mobile =request.getParameter("mobile");
            String occupation =request.getParameter("occupation");
            String monthlyIncome =request.getParameter("monthlyIncome");
            String city =request.getParameter("city");
            String state=request.getParameter("state");
            
            try{      
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/CreditCardSystem","root","root"); 
            
            PreparedStatement ps = con.prepareStatement("insert into creditcardsystem values(?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1,id);
            ps.setString(2,firstname);
            ps.setString(3,lastname);
            ps.setString(4,address);
            ps.setString(5,telephone);
            ps.setString(6,mobile);
            ps.setString(7,occupation);
            ps.setString(8,monthlyIncome);
            ps.setString(9,city);
            ps.setString(10,state);
            ps.executeQuery();
            out.println("<h1>Servlet userAdd at " + request.getContextPath() + "</h1>");
            ps.close();
            con.close();  
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
