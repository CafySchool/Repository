<%@page import="it.its.mywebapp.model.*"%>
<%@page import="java.util.ArrayList"%>
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
<h2>Inserisci i tuoi dati</h2>
<fieldset>
<form action="MyServlet" method="post">
<label>Inserisci il tuo Nome: </label><input type="text" name="name" id="input" value="<% if (request.getAttribute("person") != null && ((Person)request.getAttribute("person")).getName()!= null) { 	
	Person person= (Person)request.getAttribute("person");
	out.write(person.getName());
	}
	%>"/><br>
<% if (request.getAttribute("name")!= null && (boolean)request.getAttribute("check") == false) {%>
	<p style ='color:red'> Nome errato </p>
<%}%>
<label>Inserisci il tuo Cognome: </label><input type="text" name="surname" id="input" value="<% if (request.getAttribute("person") != null && ((Person)request.getAttribute("person")).getSurname()!= null) { 	
	Person person= (Person)request.getAttribute("person");
	out.write(person.getSurname());
	}
	%>"/><br>
<% if (request.getAttribute("surname")!= null && (boolean)request.getAttribute("check") == false) {%>
	<p style ='color:red'> Cognome errato </p>
<%}%>
<label>Inserisci la tua Eta: </label><input type="number" name="age" id="input" value="<% if (request.getAttribute("person") != null) { 	
	Person person= (Person)request.getAttribute("person");
	out.write(Integer.toString(person.getAge()));
	}
	%>"><br>
<% if (request.getAttribute("age")!= null && (boolean)request.getAttribute("check") == false) {%>
	<p style ='color:red'> Inserire Eta </p>
<%}%>
<label>Inserisci il tuo Sesso: <br><input type="radio" name="sex" value="m" id="radio"/>m<input type="radio" name="sex" value="f" id="radio"/>f</label><br>
<% if (request.getAttribute("sex")!= null && (boolean)request.getAttribute("check") == false) {%>
	<p style ='color:red'> Inserire sesso </p>
<%}%>
<label>Inserisci la tua Provincia: </label><br><select name="province" >
<option value="BA" >Bari</option>
<option value="FO" >Foggia</option>
<option value="LE" >Lecce</option>
</select><br>
<label>Inserisci la tua Email: </label> <input type="email" name="email" id="input" value="<% if (request.getAttribute("person") != null && ((Person)request.getAttribute("person")).getEmail() != null) { 
		
	Person person= (Person)request.getAttribute("person");
	out.write(person.getEmail());
	}
	%>"><br>
<% if (request.getAttribute("email")!= null && (boolean)request.getAttribute("check") == false) {%>
	<p style ='color:red'> Email errata </p>
<%}%>
<input type="submit" value="submit" name="submit" id="bottone"/>
</form>
</fieldset>
</div>
</body>
</html>