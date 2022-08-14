package com.fly;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Display extends HttpServlet {
private static final long serialVersionUID = 1L;
       
   
    public Display() {
        super();
      
    }


protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
HttpSession s = request.getSession();
PrintWriter out = response.getWriter();
out.println("<html><body>");
out.println("<br/><br/>");
out.println("<h1>User Details</h1>");
out.println("<br/><br/>");
out.println("Date Of Travel: "+s.getAttribute("date"));
out.println("<br/><br/>");
out.println("Flight Name: "+s.getAttribute("flight name"));
out.println("<br/><br/>");
out.println("Airlines: "+s.getAttribute("Airlines"));
out.println("<br/><br/>");
out.println("Boarding Point: "+s.getAttribute("Boarding Point"));
out.println("<br/><br/>");
out.println("Destination: "+s.getAttribute("Destination"));
out.println("<br/><br/>");
out.println("Number Of Passengers: "+s.getAttribute("Nop"));
out.println("<br/><br/>");
out.println("Price: "+s.getAttribute("Price"));
out.println("<br/><br/>");
out.println("Total Price: "+s.getAttribute("TotalPrice"));
out.println("<br/><br/>");
out.println("</html></body>");
RequestDispatcher rd = request.getRequestDispatcher("DetailsOfUser");
rd.include(request, response);
}

}





