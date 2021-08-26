<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    <%@page import="fr.eni.martine.bo.User" %>
	<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profil</title>
</head>
<body>

<h1>Profil de : ${user.prenom} </h1>

<p> ${user.pseudo}</p> 
<p> ${user.nom}</p> 
<p> ${user.prenom}</p> 
<p> ${user.email}</p> 
<p> ${user.telephone}</p> 
<p> ${user.rue}</p>
<p> ${user.codepostal}</p>
<p> ${user.ville}</p> 

</body>
</html>