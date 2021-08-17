<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Page de Connection</title>
</head>
<body>

<form action="./connection" method="POST">

<label for="nom">Votre Identifiant</label>
<input type="text" name="identifiant" placeholder="votre identifiant?" size="30" maxlength="10"><br>


<label for="mot de passe">Votre Mot De Passe</label>
<input type="password" name="motdepasse"  size="30" maxlength="10">



<button type="submit">Valider</button>

</form>

</body>
</html>