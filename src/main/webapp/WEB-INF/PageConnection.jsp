<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Page de Connection</title>
</head>
<body>
<c:if test="${!empty erreur}">
	<span class="error"> ${erreur}</span>
</c:if>

<form action="./connection" method="POST">

<label for="nom">Votre Identifiant</label>
<input type="text" name="identifiant" placeholder="votre pseudo ou adresse mail ?" size="30" maxlength="50"><br>


<label for="mot de passe">Votre Mot De Passe</label>
<input type="password" name="motdepasse"  size="30" maxlength="50">



<button type="submit">Valider</button>

</form>

</body>
</html>