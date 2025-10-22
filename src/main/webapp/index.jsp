<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html>
<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link href="<c:url value='/static/main.css'/>" rel="stylesheet">
    <script src="<c:url value="/static/jquery-3.6.0.min.js"/>"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/main.css">
    <title>Текстовый квест</title>
</head>
<body>
<header>
    <h1>Добро пожаловать в мастерскую квестов</h1>
    <nav>
        <div class="nav-left">
            <a href="#">О нас</a> |
            <a href="#">Квесты</a> |
            <a href="#">Форум</a> |
            <a href="#">Мастерская квестов</a>
        </div>
        <div class="nav-right">
            <a href="#">Личный кабинет</a>
        </div>
    </nav>
</header>


<div class="content">
    <h2>Основной контент страницы</h2>
    <p>Прокручивайте вниз - шапка останется на месте!</p>
    <p>Текст... текст... текст...</p>
    <p>Ещё больше текста...</p>
</div>
</body>
</html>
