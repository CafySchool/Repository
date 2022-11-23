<%@page import="it.its.mywebapp.database.Database"%>
<%@page import="java.util.ArrayList"%>
<%@page import="it.its.mywebapp.model.Event"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
h2{
	border: 10px;
    font-size: 30px;
    color: #990099;
    text-align: center;
}
label {
	color: #780078;
	font-size: 30px;
}

fieldset {
 	border: 2px solid #780078;
	width:33%;
	background-color: #FFCCFF;
	font-size: 30px;
	border-radius: 10px;
	margin: auto;
	padding:20px;
}
th {
	color: #780078;
	font-size: 30px;
	padding: 15px;
}

table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
  border: 2px solid #780078;
	width:33%;
	background-color: #FFCCFF;
	font-size: 30px;
	border-radius: 10px;
	margin: auto;
	padding:20px;
}
button {
background-color: #660066;
	color: #FFCCFF;
	width: 100px;
	height:40px;
	border-radius: 4px;
	text-align: center;
	font-size: 20px;
	text-align: center;
}
form, input{
background-color: #660066;
	color: #FFCCFF;
	width: 100px;
	height:40px;
	border-radius: 4px;
	text-align: center;
	font-size: 20px;
	text-align: center;
}

</style>
</head>
<body>
<fieldset>
<% if (!(boolean)request.getAttribute("onlyTable")) { %>
<h2>L'evento è stato creato !</h2>
<label>Nome Evento: <%= request.getParameter("eventName") %></label>
<br>
<label>Descrizione: <%= request.getParameter("description") %></label>
<br>
<label>Data Evento: <%= request.getParameter("startDate") %></label>
</fieldset>
<%} %>
<h2>Lista delle registrazioni effettuate</h2>
<% ArrayList<Event> eventList = (ArrayList<Event>) request.getAttribute("eventList"); %>
<% if (eventList.size()>0) {%>
<table>
<tr>
	<th>Id</th><th>Nome Evento</th><th>Descrizione</th><th>Data Evento</th>
</tr>
<% for ( Event event : eventList) {%>
<tr>
<td><%=event.getId() %></td>
<td><%=event.getEventName() %></td>
<td><%=event.getDescription() %></td>
<td><%=event.getStartDate() %></td>
<td><form method ="get" action ="DeleteEventServlet">
<input type ="hidden" name ="id" value ="<%= event.getId() %>"/>
<input type ="submit" value="Cancella"/>
</form></td>
</tr>
<%} %>

</table>
<%} %>
</body>
</html>