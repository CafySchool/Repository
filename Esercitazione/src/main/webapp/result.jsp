<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<fieldset>
<h2>La registrazione è andata a buon fine !</h2>
<label>Nome: <%= request.getParameter("name") %></label>
<br>
<label>Cognome: <%= request.getParameter("surname") %></label>
<br>
</fieldset>
</body>
</html>