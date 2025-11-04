<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link href="<c:url value='/static/main.css'/>" rel="stylesheet">
    <script src="<c:url value="/static/jquery-3.6.0.min.js"/>"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/main.css">
    <title>Ошибка регистрации: </title>
</head>
<body>
<jsp:include page="/WEB-INF/fragments/header.jsp"/>

<div class="content">

    <h1>Ошибка при регистрации! Такой пользователь уже есть. Попробуйте еще раз.</h1>
    <form action="/register" method="post" autocomplete="off">
        <div>
            <label for="username">Логин:</label>
            <input type="text" id="username" name="username" required>
        </div>

        <div>
            <label for="password">Пароль:</label>
            <input type="password" id="password" name="password" required>
        </div>

        <div>
            <label for="email">email:</label>
            <input type="text" id="email" name="email" required>
        </div>

        <div>
            <button type="submit">Регистрация</button>
        </div>
    </form>

</div>

<jsp:include page="/WEB-INF/fragments/footer.jsp"/>
</body>
<script>
</script>
</html>
