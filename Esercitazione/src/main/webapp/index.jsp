<%-- <%@page import="it.its.esercitazione.domain.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
<h2>Registrazione Persona</h2>
<fieldset>
<form action="PersonServlet" method="post">
<label>Inserisci il tuo Nome: </label><input type="text" name="name" id="input" value="<% if (request.getAttribute("person") != null && ((Person)request.getAttribute("person")).getName()!= null) { 	
	Person person= (Person)request.getAttribute("person");
	out.write(person.getName());
	}
	%>"/><br>
<label>Inserisci il tuo Cognome: </label><input type="text" name="surname" id="input" value="<% if (request.getAttribute("person") != null && ((Person)request.getAttribute("person")).getSurname()!= null) { 	
	Person person= (Person)request.getAttribute("person");
	out.write(person.getSurname());
	}
	%>"/><br>
<input type="submit" value="submit" name="submit" id="bottone"/>
</form>
</fieldset>
</div>
</body>
</html> --%>