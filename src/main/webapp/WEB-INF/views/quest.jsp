<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html>
<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link href="<c:url value='/static/main.css'/>" rel="stylesheet">
    <script src="<c:url value="/static/jquery-3.6.0.min.js"/>"></script>
    <title>JavaRush Text Quest</title>
</head>
<body>
<h1>Твой путь начинается здесь, дорогой ${sessionScope.gameSession.playerName}</h1>
</body>
<script>
</script>
</html>
