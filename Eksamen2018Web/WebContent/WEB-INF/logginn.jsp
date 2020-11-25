<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logg inn</title>
</head>
<body>
	<p style="color: red">${feilmelding == null ? "Du er ikke innlogget" : feilmelding}</p>
	<form action="logginn" method="post">
		<p>Pinkode:&ensp;&ensp;<input type="text" name="pinkode" pattern="[0-9]{4}" required></p>
		<p><input type="submit" value="Logg inn"></p>
	</form>
</body>
</html>