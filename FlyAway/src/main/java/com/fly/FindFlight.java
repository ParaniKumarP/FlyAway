package com.fly;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

public class FindFlight extends HttpServlet {
private static final long serialVersionUID = 1L;

    public FindFlight() {
        super();
      
    }

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out = response.getWriter();
	Connection con = DatabaseConnection.getMyConnection();
	try
{

String d = request.getParameter("d");
String Onboard = request.getParameter("Onboard");
String destination = request.getParameter("destination");
int noperson = Integer.parseInt(request.getParameter("nop"));

String str = "select * from flightdetails";
Statement ps = con.createStatement();
ResultSet ans = ps.executeQuery(str);
out.println("<html><body>");
out.println("<table border=2>");
out.println("<tr><th>Airlines Name</th><th>Flight Name</th><th>Price</th></tr>");
int a=0;
while(ans.next()) {
if(ans.getDate(1).toString().equals(d)&& ans.getString(2).equalsIgnoreCase(Onboard)&&ans.getString(3).equalsIgnoreCase(destination)&&ans.getInt(4)>noperson)
{
out.print("<tr>");
out.print("<td>"+ans.getString(5)+"</td>");
out.print("<td>"+ans.getString(6)+"</td>");
out.print("<td>"+ans.getInt(7)+"</td>");
out.print("</tr>");
a=1;
}
}
if(a==0)
out.println("No Flights Available");
out.println("</table>");
out.println("</html></body>");
if(a==1)
{
RequestDispatcher rd = request.getRequestDispatcher("chooseflight.jsp");
rd.include(request, response);
}
}
catch(Exception e)
{
System.out.println(e);
}
}

}