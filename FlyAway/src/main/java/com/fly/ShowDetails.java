package com.fly;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ShowDetails extends HttpServlet {
private static final long serialVersionUID = 1L;
       
   
    public ShowDetails() {
        super();
  
    }


protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out = response.getWriter();
	String cname = request.getParameter("cname");
String cpwd = request.getParameter("cpassword");
String conpwd = request.getParameter("ccpassword");


out.println("<html><body>");
out.println("<br/><br/>");
if(cpwd.equals(conpwd))
{
out.println("Username: "+cname);
out.println("<br/><br/>");
out.println("<a href='cash.jsp'>Proceed To Pay</a>");
out.println("</html></body>");
}
else
{
out.println("Invalid Username or Password");
}
}

}