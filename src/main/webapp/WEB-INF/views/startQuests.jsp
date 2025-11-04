<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link href="<c:url value='/static/main.css'/>" rel="stylesheet">
    <script src="<c:url value="/static/jquery-3.6.0.min.js"/>"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/main.css">
    <title>Начало квеста: </title>
</head>
<body>
<jsp:include page="/WEB-INF/fragments/header.jsp"/>

<div class="content">
    Начало квеста:

    <p> <img src="${pageContext.request.contextPath}/${startQuestion.imgUrl}"> </p>
    <p> ${startQuestion.description} </p>
    <p> ${startQuestion.question} </p>
    <p>
        <c:forEach var="answer" items="${startQuestion.answers}" varStatus="status">
            <button onclick="nextQuestion(${answer.id})" id="button_answer_${answer.id}"> ${answer.description}</button>
        </c:forEach>
    </p>
</div>

<jsp:include page="/WEB-INF/fragments/footer.jsp"/>
</body>
<script>
function nextQuestion(answerId) {
    let url = "/quests/gaming?answer=";
    url = url.concat(answerId)
    window.location.href = url;
}
</script>
</html>
