<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link href="<c:url value='/static/main.css'/>" rel="stylesheet">
    <script src="<c:url value="/static/jquery-3.6.0.min.js"/>"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/main.css">
    <title>Проблема прав</title>
</head>
<body>
<jsp:include page="/WEB-INF/fragments/header.jsp"/>

<div class="content">
    <p>Данная страница доступна пользователям с определенными ролями.</p>
</div>

<jsp:include page="/WEB-INF/fragments/footer.jsp"/>
</body>
</html>
