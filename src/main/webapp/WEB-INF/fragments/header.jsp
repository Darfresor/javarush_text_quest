<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
    <h1>Добро пожаловать в мастерскую квестов</h1>
    <nav>
        <div class="nav-left">
            <a href="/about">О нас</a> |
            <a href="/quests">Квесты</a> |
            <a href="#">Форум</a> |
            <a href="#">Мастерская квестов</a>
        </div>
        <div class="nav-right">
            <c:if test="${empty sessionScope.userName}">
                <a href="#">Вход</a>
            </c:if>
            <c:if test="${not empty sessionScope.userName}">
                <a href="#">Личный кабинет</a>
            </c:if>
        </div>
    </nav>
</header>
<script>


</script>
