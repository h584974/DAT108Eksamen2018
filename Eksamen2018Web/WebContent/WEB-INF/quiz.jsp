<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
      table,
      th,
      td {
        padding: 10px;
        border: 1px solid black;
        border-collapse: collapse;
      }
    </style>
<meta charset="UTF-8">
<title>Quiz</title>
</head>
<body>
	<h1>${tittel == null ? "Det er ingen aktiv quiz" : tittel}</h1>
	<c:if test="${tittel != null}">
		<table>
			<tr>
				<th>Alternativer</th>
				<th>Antall svar</th>
			</tr>
			<c:forEach items="${alternativer}" var="a">
			<tr>
				<td>${a}</td>
				<td>0</td>
			</tr>
			</c:forEach>
		</table>
		<br>
	</c:if>
	<form action="quiz" method="post">
		<input type="submit" value="Start ny quiz med titelen">
		<label></label>
		<input type="text" name="tittel" pattern=".{3,80}" required>
		<font>${tittel == null ? "" : "NB! Nullstiller alle svar."}</font>
	</form>
</body>
</html>