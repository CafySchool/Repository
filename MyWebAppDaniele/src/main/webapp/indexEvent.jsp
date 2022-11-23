<%@page import="it.its.mywebapp.model.*"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
h2{
	border: 10px;
    font-size: 50px;
    color: #990099;
    text-align: center;
}

fieldset {
 	border: 2px solid #780078;
	width:20%;
	background-color: #FFCCFF;
	font-size: 30px;
	border-radius: 10px;
	margin: auto;
	padding:20px;

}
#bottone {
	background-color: #660066;
	color: #FFCCFF;
	width: 100px;
	height:40px;
	border-radius: 4px;
	font-size: 20px;
	text-align: center;
	margin-top:20px;
	margin-left: 225px;
}
#input {
  	border: 2px solid #780078;
 	border-radius: 4px;
  	text-align: center; 
  	padding: 10px 80px 10px 80px;
  	font-size: 30px;
}
select {
	color: #780078;
	font-size: 30px;
	width:120px;
	height:40px;
	border-radius:4px;
	border: 2px solid #780078;
}

label {
	color: #780078;
	font-size: 30px;
}
#radio {
	height: 20px;
 	width: 20px;
 	margin-left: 50px;
}

</style>
</head>
<body>
<% if (request.getAttribute("check")!= null && (boolean)request.getAttribute("check") == false) {%>
	<p style ='color:red'> ATTENZIONE ERRORI </p>
<%}%>
<div>
<h2>Crea il tuo evento</h2>
<fieldset>
<form action="EventServlet" method="post">
<label>Inserisci il nome dell'evento: </label><input type="text" name="eventName" id="input" value="<% if (request.getAttribute("event") != null && ((Event)request.getAttribute("event")).getEventName()!= null) { 	
	Event event = (Event)request.getAttribute("event");
	out.write(event.getEventName());
	}
	%>"/><br>
	<% if (request.getAttribute("eventName")!= null && (boolean)request.getAttribute("check") == false) {%>
	<p style ='color:red'> Nome Evento Errato </p>
<%}%>
<label>Inserisci la descrizione dell'evento: </label><input type="text" name="description" id="input" value="<% if (request.getAttribute("event") != null && ((Event)request.getAttribute("event")).getDescription()!= null) { 	
	Event event = (Event)request.getAttribute("event");
	out.write(event.getDescription());
	}
	%>"/><br>
	<% if (request.getAttribute("description")!= null && (boolean)request.getAttribute("check") == false) {%>
	<p style ='color:red'> Descrizione Evento errata </p>
<%}%>
<label>Inserisci la data di inizio evento: </label><input type="date" name="startDate" id="input" value="<% if (request.getAttribute("event") != null) { 	
	}
	%>"><br>
<% if (request.getAttribute("startDate")!= null && (boolean)request.getAttribute("check") == false) {%>
	<p style ='color:red'> Data Inizio Evento Errata </p>
<%}%>
<input type="submit" value="submit" name="submit" id="bottone"/>
</form>
</fieldset>
</div>
</body>
</html>