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
<jsp:include page="/WEB-INF/fragments/header.jsp"/>


<div class="content">
    <h2>Возрождение текстовых игр</h2>
    <p>Наша команда намерена вдохнуть новую жизнь в текстовые игры.</p>
    <p>В активной разработке находится мастерская квестов, которая позволит всем желающим стать автором своей истории.</p>
    <p>Не забывайте оставлять свои пожелания и критику в книге отзывов, это позволяет проекту расти!</p>
</div>

<jsp:include page="/WEB-INF/fragments/footer.jsp"/>
</body>
</html>
