package com.fly;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class DetailsOfUser extends HttpServlet {
private static final long serialVersionUID = 1L;
       
   
    public DetailsOfUser() {
        super();
    
    }


protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
PrintWriter out = response.getWriter();
out.println("<html><body>");
out.println("<form action='ShowDetails' method='get'>");
out.println("Enter UserName: <input type='text' name='cname'>");
out.println("<br/><br/>");
out.println("Enter Password: <input type='text' name='cpassword'>");
out.println("<br/><br/>");
out.println("Enter Confirm Password: <input type='text' name='ccpassword'>");
out.println("<br/><br/>");

out.println("<input type='submit' value='Submit'");
out.println("</html></body>");
}

}