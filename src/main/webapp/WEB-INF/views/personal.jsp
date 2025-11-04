<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link href="<c:url value='/static/main.css'/>" rel="stylesheet">
    <script src="<c:url value="/static/jquery-3.6.0.min.js"/>"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/main.css">
    <title>Квесты</title>
</head>
<body>
<jsp:include page="/WEB-INF/fragments/header.jsp"/>

<div class="content">
    <p>Личный кабинет</p>
    <p><b>Пользователь:</b> ${sessionScope.userInfo.name}
    <p>
    <p><b>Роли пользователя:</b>
        <c:forEach var="role" items="${sessionScope.userInfo.userRoles}" varStatus="status">
        ${role};
        </c:forEach>
    <p>
    <p><b>Количество сыгранных игр:</b> ${sessionScope.userInfo.numberOfGamesPlayed}</p>
</div>

<jsp:include page="/WEB-INF/fragments/footer.jsp"/>
</body>
</html>
