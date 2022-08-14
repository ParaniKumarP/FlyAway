package com.fly;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class DetailsOfFlight extends HttpServlet {
private static final long serialVersionUID = 1L;
       
   
    public DetailsOfFlight() {
        super();
    
    }


protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out = response.getWriter();
	try
{

Connection con = DatabaseConnection.getMyConnection();
String d = request.getParameter("d");
String flight_name = request.getParameter("fname");
int noperson = Integer.parseInt(request.getParameter("nop"));

HttpSession s = request.getSession();
String str = "select * from flightdetails";
Statement ps = con.createStatement();
ResultSet ans = ps.executeQuery(str);
int c=0;
while(ans.next()) {
if(ans.getDate(1).toString().equals(d)&& ans.getString(6).equals(flight_name)&&ans.getInt(4)>noperson)
{
s.setAttribute("date", d);
s.setAttribute("Airlines", ans.getString(5));
s.setAttribute("flight name", ans.getString(6));
s.setAttribute("Boarding Point", ans.getString(2));
s.setAttribute("Destination", ans.getString(3));
s.setAttribute("Nop", noperson);
s.setAttribute("Price", ans.getInt(7));
s.setAttribute("TotalPrice", noperson*ans.getInt(7));
c=1;
}
}
if(c==0)
out.println("Invalid Entry");
if(c==1)
{
RequestDispatcher rd = request.getRequestDispatcher("Display");
rd.forward(request, response);
}
}
catch(Exception e)
{
System.out.println(e);
}
}
}
