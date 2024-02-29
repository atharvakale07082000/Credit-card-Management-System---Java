<%-- 
    Document   : accountDetails
    Created on : Jan 9, 2020, 2:09:16 PM
    Author     : student
--%>

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String cardNo = request.getParameter("cardNo");
            try{
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Welcome");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CreditCardSystem","root","root");
                System.out.println("Connection Created");
                Statement st = con.createStatement();  
                ResultSet rs = st.executeQuery("select * from userDetails where card_no = "+cardNo);
                out.println("<center><h1>Account Details</h1></center>");
                out.println("<center><h3>Account Number : "+cardNo+"</h3></center>");
                out.println("<center><table border=1 cellpadding=10>");
                out.println("<tr>");
                out.println("<tr><th>F_Name</th><th>L_Name</th><th>Address</th><th>City</th><th>State</th><th>Pin Code</th><th>Mobile No.</th><th>Email</th><th>Employment</th><th>Gender</th><th>Age</th><th>Card Number</th></tr>");
                
                while(rs.next())
                {
                    out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getInt(6)+"</td><td>"+rs.getInt(7)+"</td><td>"+rs.getString(8)+"</td><td>"+rs.getString(9)+"</td><td>"+rs.getString(10)+"</td><td>"+rs.getInt(11)+"</td><td>"+rs.getString(12)+"</td></tr>");

                }
                out.println("</table></center>");
                con.close();  
            }
            catch(Exception e){
            System.out.println("Exception :"+e);
            }
            
        
        %>
    </body>
</html>
