/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 *
 * @author ABC
 */
@WebServlet(urlPatterns = {"/getCreditCard"})
public class getCreditCard extends HttpServlet {

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
            out.println("<title>User details</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet userDetails at " + request.getContextPath() + "</h1>");
            String cardType="";
            String id =request.getParameter("id");
            int salary =Integer.parseInt(request.getParameter("salary"));
            if(salary<20000 && salary>10000)
            {
            cardType="Normal";
            }
            else if(salary<30000)
            {
            cardType="Silver";
            }
            else if(salary<40000)
            {
            cardType="Gold";
            }
            else if(salary<50000)
            {
            cardType="Diamond";
            }
           
            try{  
            String CardNo="";
           int card=0;
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/CreditCardSystem","root","root");  
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("select * from userDetails");  
            while(rs.next())
            {
            
            CardNo=rs.getString(12);

            }
           
            card=Integer.parseInt(CardNo);
            card=card+1;
            String c = String.valueOf(card);
            out.println(c);
            PreparedStatement ps=con.prepareStatement("update userDetails set card_no=?,cardtype=? where emailId=?");
            ps.setString(1,c);
            ps.setString(2,cardType);
            ps.setString(3,id);
            
            ps.executeUpdate();
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
