<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link href="<c:url value='/static/main.css'/>" rel="stylesheet">
    <link href="<c:url value='/static/register.css'/>" rel="stylesheet">
    <script src="<c:url value="/static/jquery-3.6.0.min.js"/>"></script>
    <title>Ошибка регистрации</title>
</head>
<body class="register-page">
<jsp:include page="/WEB-INF/fragments/header.jsp"/>

<div class="content register-content">
    <h1>Ошибка при регистрации! Такой пользователь уже есть. Попробуйте еще раз.</h1>
    <form class="register-form" action="/register" method="post" autocomplete="off">
        <div class="form-group">
            <label for="username">Логин:</label>
            <input type="text" id="username" name="username" required class="form-input">
        </div>

        <div class="form-group">
            <label for="password">Пароль:</label>
            <input type="password" id="password" name="password" required class="form-input">
        </div>

        <div class="form-group">
            <label for="email">email:</label>
            <input type="text" id="email" name="email" required class="form-input">
        </div>

        <div class="form-group">
            <button type="submit" class="submit-btn">Регистрация</button>
        </div>
    </form>
</div>

<jsp:include page="/WEB-INF/fragments/footer.jsp"/>
</body>
<script>
</script>
</html>