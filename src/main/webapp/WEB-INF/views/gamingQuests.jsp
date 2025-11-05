<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link href="<c:url value='/static/main.css'/>" rel="stylesheet">
    <script src="<c:url value="/static/jquery-3.6.0.min.js"/>"></script>
    <link href="<c:url value='/static/gaming.css'/>" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/main.css">
    <title>Квест в процессе прохождения: </title>
</head>
<body>
<jsp:include page="/WEB-INF/fragments/header.jsp"/>

<div class="content" id="gameContent">
    <p style="display: none;"><img src="${pageContext.request.contextPath}/${question.imgUrl}"
                                   id="backgroundImage"></p>
    <div class="content-text">
        Текущая сцена:
        <p> ${question.description} </p>
        <p class="question-text"> ${question.question} </p>
        <p class="answers-container">
            <c:forEach var="answer" items="${question.answers}" varStatus="status">
                <button onclick="nextQuestion(${answer.id})"
                        id="button_answer_${answer.id}"> ${answer.description}</button>
            </c:forEach>
        <c:if test="${question.defeatFlag || question.winFlag}">
            <button onclick="restartQuest(${sessionScope.questId})" id="button_restart_${sessionScope.questId}"> Начать
                квест с начала
            </button>
        </c:if>
        </p>
    </div>
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
