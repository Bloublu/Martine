<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<h1>ACCUEILLLLLL</h1>
<h2>Bienvenue ${User.nom} ${User.prenom}, il vous reste ${User.credit} de crédit.</h2> 
	
<a href = "./private/NouvelleVente">Nouvelle vente</a><br><br>

<a href = "./connection">Connexion</a><br><br>




<c:if test="${User }">
	<a href = "./AccueilServlet">Deconnexion</a>
</c:if>




</body>
</html>