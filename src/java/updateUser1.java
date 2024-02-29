/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
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
 * @author student
 */
@WebServlet(urlPatterns = {"/updateUser1"})
public class updateUser1 extends HttpServlet {

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
        String id = request.getParameter("userId");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet updateUser1</title>");            
            out.println("</head>");
            out.println("<body>");
            String fname = request.getParameter("fName");
            String lname = request.getParameter("lName");
            String address = request.getParameter("address");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            String gender = request.getParameter("gender");
            int age = Integer.parseInt(request.getParameter("age"));
            int pin = Integer.parseInt(request.getParameter("pincode"));
            int mob = Integer.parseInt(request.getParameter("mobNo"));
            String email = request.getParameter("eId");
            String emp = request.getParameter("employment");
            
            out.println(fname);
            out.println(lname);
            out.println(address);
            out.println(city);
            out.println(state);
            out.println(pin);
            out.println(mob);
            out.println(email);
            out.println(emp);
            out.println(gender);
            out.println(age);
            
            out.println("<table border=1 width=50% height=50%>");
            out.println("<tr><th>F_Name</th><th>L_Name</th><th>Address</th><th>City</th><th>State</th><th>Pin Code</th><th>Gender</th><th>Mobile NO</th><th>Email</th><th>Employment</th><th>Age</th></tr>");
            out.println("<tr><td>"+fname+"</td><td>"+lname+"</td><td>"+address+"</td><td>"+city+"</td><td>"+state+"</td><td>"+pin+"</td><td>"+mob+"</td><td>"+email+"</td><td>"+emp+"</td><td>"+gender+"</td><td>"+age+"</td></tr>");
            try{
                
            
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Welcome");
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CreditCardSystem","root","root");
            System.out.println("Connection Created");
            
            String s = "update  userDetails set fName=?,lName=?,address=?,city=?,state=?,pin=?,mob=?,emailId=?,employment=?,gender=?,age=? where id=emailId";
            
            PreparedStatement ps = con.prepareStatement(s);
            ps.setString(1,fname);
            ps.setString(2,lname);
            ps.setString(3,address);
            ps.setString(4,city);
            ps.setString(5,state);
            ps.setInt(6,pin);
            ps.setInt(7,mob);
            ps.setString(8,email);
            ps.setString(9,emp);
            ps.setString(10, gender);
            ps.setInt(11, age);
            out.println("<h1>Servlet updateUser1 at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            }
            catch(Exception e){
            out.println(e);}
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
