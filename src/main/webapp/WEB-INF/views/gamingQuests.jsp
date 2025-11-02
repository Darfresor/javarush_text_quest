<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link href="<c:url value='/static/main.css'/>" rel="stylesheet">
    <script src="<c:url value="/static/jquery-3.6.0.min.js"/>"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/main.css">
    <title>Квест в процессе прохождения: </title>
</head>
<body>
<jsp:include page="/WEB-INF/fragments/header.jsp"/>

<div class="content">
    Текущая сцена:
    <p> ${question.description} </p>
    <p> ${question.question} </p>
    <p>
        <c:forEach var="answer" items="${question.answers}" varStatus="status">
            <button onclick="nextQuestion(${answer.id})" id="button_answer_${answer.id}"> ${answer.description}</button>
        </c:forEach>
    </p>
    <c:if test = "${question.defeatFlag || question.winFlag}">
        <button onclick="restartQuest(${sessionScope.questId})" id="button_restart_${sessionScope.questId}"> Начать квеста с начала</button>
    </c:if>
</div>

<jsp:include page="/WEB-INF/fragments/footer.jsp"/>
</body>
<script>
function nextQuestion(answerId) {
    let url = "/quests/gaming?answer=";
    url = url.concat(answerId)
    window.location.href = url;
}
function restartQuest(questId) {
    let url = "/quests/start?id=";
    url = url.concat(questId)
    window.location.href = url;
}
</script>
</html>
