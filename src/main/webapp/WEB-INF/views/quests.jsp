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
    <p>Страница ${questListResponse.currentPage} из ${questListResponse.totalPages}</p>
    <div class="quests-list">
        <c:forEach var="quest" items="${questListResponse.quests}" varStatus="status">
            <div class="quest-item">
                <h3>#${status.index + 1}. Квест ID: ${quest.id}</h3>
                <p>${quest.description}</p>
                <div class="quest-meta">
                    <c:if test="${quest.isNew}">
                        <span class="badge new">NEW</span>
                    </c:if>
                    <c:if test="${not empty quest.imgUrl && quest.imgUrl != 'none'}">
                        <img src="${quest.imgUrl}" alt="Изображение квеста" width="100">
                    </c:if>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<jsp:include page="/WEB-INF/fragments/footer.jsp"/>
</body>
</html>
