<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="fr.eni.martine.bo.User" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="./CSS/header.css" rel="stylesheet">
<title>MonProfil</title>
</head>
<body>
<h1>MON PROFIL</h1>

								<!-- Afficher son profil -->
								
        <form action="./MonProfil" method="post">
        
        
        
<div class="header">
<a href="./Accueil"><img src="<c:url value="/images/Martine.jpg"/>"/></a>
</div><br><br>

            <label>Pseudo :</label>
            <input type="text" value="${user.pseudo}" name="pseudo"/>
            <br/>
            <label>Nom :</label>
            <input type="text" value="${user.nom}" name="nom" />
            <br/>
            <label>Prénom :</label>
            <input type="text"  value="${user.prenom}" name="prenom" />
            <br/>
            <label>Email :</label>
            <input type="text" value="${user.email}" name="email"/>
            <br/>
            <label>Téléphone :</label>
            <input type="text" value="${user.telephone}" name="tel"/>
            <br/>
            <label>Rue :</label>
            <input type="text" value="${user.rue}" name="rue"/>
            <br/>
            <label>Code postal :</label>
            <input type="text" value="${user.codepostal}" name="codepostal"/>
            <br/>
            <label>Ville :</label>
            <input type="text" value="${user.ville}" name="ville"/>
            <br/>
 			<label for="mot de passe ">Mot De Passe : </label>
			<input type="text" value="${user.motDePasse}" name="motdepasse"/>
			<br>
			<label for="nouveau mot de passe">Nouveau Mot De Passe : </label>
			<input type="text" name="nouveaumotdepasse" placeholder="Votre Nouveau Mot De Passe" size="30" maxlength="50"><br>
			<br>
            <label for="motpasseconfirmation">Confirmation de Mot De Passe : </label>
			<input type="text" name="motpasseconfirmation" placeholder="Confirmation de Mot De Passe" size="30" maxlength="50"><br>
			
			<span class="messages"> ${messages}</span><br>
			
			<button class="creer" type="submit">Enregistrer</button><br>
		</form>
		
        <button type="submit" name="retour" onclick="document.location.href='${pageContext.request.contextPath}/ConfirmDelete'">supprimmer</button>
        
        
<p> ${user.credit}</p>

<button type="submit" name="retour" onclick="document.location.href='${pageContext.request.contextPath}/Accueil'">Retour</button>

</body>
</html>