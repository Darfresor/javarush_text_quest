<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link href="<c:url value='/static/main.css'/>" rel="stylesheet">
    <script src="<c:url value="/static/jquery-3.6.0.min.js"/>"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/main.css">
    <title>Вход в личный кабинет: </title>
</head>
<body>
<jsp:include page="/WEB-INF/fragments/header.jsp"/>

<div class="content">
    <h1>Ошибка при авторизации! Неправильный логин или пароль. Попробуйте еще раз.</h1>
    <form action="/login" method="post" autocomplete="off">
        <div>
            <label for="username">Логин:</label>
            <input type="text" id="username" name="username" required>
        </div>

        <div>
            <label for="password">Пароль:</label>
            <input type="password" id="password" name="password" required>
        </div>

        <div>
            <button type="submit">Вход</button>
            <button type="button" onclick="location.href='/register'">Регистрация</button>
        </div>
    </form>

</div>

<jsp:include page="/WEB-INF/fragments/footer.jsp"/>
</body>
<script>
</script>
</html>
