
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Flights</title>
</head>
<body>
<form action="FindFlight" method="get">
Enter the Date of Travel: <input type="text" name="d">
<br/><br/>
Enter the Place of Boarding: <input type="text" name="Onboard">
<br/><br/>
Enter the Destination: <input type="text" name="destination">
<br/><br/>
Enter the No of Persons: <input type="text" name="nop">
<br/><br/>
<input type="submit" value="Search">
</form>
</body>
</html>
