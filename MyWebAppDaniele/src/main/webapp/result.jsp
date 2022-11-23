<%@page import="it.its.mywebapp.database.Database"%>
<%@page import="java.util.ArrayList"%>
<%@page import="it.its.mywebapp.model.Person"%>
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
<h2>La registrazione è andata a buon fine !</h2>
<label>Nome: <%= request.getParameter("name") %></label>
<br>
<label>Cognome: <%= request.getParameter("surname") %></label>
<br>
<label>Eta: <%= request.getParameter("age") %></label>
<br>
<label>Sesso: <%= request.getParameter("sex") %></label>
<br>
<label>Provincia: <%= request.getParameter("province") %></label>
<br>
<label>Email: <%= request.getParameter("email") %></label>
</fieldset>
<br>
<%} %>
<h2>Lista delle registrazioni effettuate</h2>
<% ArrayList<Person> personList = (ArrayList<Person>) request.getAttribute("personList"); %>
<% if (personList.size()>0) {%>
<table>
<tr>
	<th>Id</th><th>Nome</th><th>Cognome</th><th>Eta</th><th>Sesso</th><th>Provincia</th><th>Email</th><th>Delete</th>
</tr>
<% for ( Person person : personList) {%>
<tr>
<td><%=person.getId() %></td>
<td><%=person.getName() %></td>
<td><%=person.getSurname() %></td>
<td><%=person.getAge() %></td>
<td><%=person.getSex() %></td>
<td><%=person.getProvince() %></td>
<td><%=person.getEmail() %></td>
<td><form method ="get" action ="DeletePersonServlet">
<input type ="hidden" name ="id" value ="<%= person.getId() %>"/>
<input type ="submit" value="Cancella"/>
</form></td>
</tr>
<%} %>

</table>
<%} %>

</body>
</html>