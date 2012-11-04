<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Green Bean Lager</title>
</head>
<body>
<h1>
	Välkommen till Green Bean Lager  
</h1>

Lagerstatus just nu är:
<table>
	<tr><td>ProduktId</td><td>Lagersaldo</td></tr>
	<c:forEach items="${stock}" var="entry">
		<tr><td>${entry.key}</td><td>${entry.value}</td></tr>
	</c:forEach>  
</table>

</body>
</html>
