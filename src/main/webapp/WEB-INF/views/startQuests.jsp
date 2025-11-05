<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link href="<c:url value='/static/main.css'/>" rel="stylesheet">
    <link href="<c:url value='/static/gaming.css'/>" rel="stylesheet">
    <script src="<c:url value="/static/jquery-3.6.0.min.js"/>"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/main.css">
    <title>Начало квеста: </title>
</head>
<body>
<jsp:include page="/WEB-INF/fragments/header.jsp"/>

<div class="content" id="gameContent">
    <p style="display: none;"><img src="${pageContext.request.contextPath}/${startQuestion.imgUrl}"
                                   id="backgroundImage"></p>
    <div class="content-text">
        Начало квеста:

        <p> ${startQuestion.description} </p>
        <p class="question-text"> ${startQuestion.question} </p>
        <p class="answers-container">
            <c:forEach var="answer" items="${startQuestion.answers}" varStatus="status">
                <button onclick="nextQuestion(${answer.id})"
                        id="button_answer_${answer.id}"> ${answer.description}</button>
            </c:forEach>
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

    // Устанавливаем фоновое изображение для content блока
    document.addEventListener('DOMContentLoaded', function () {
        const backgroundImage = document.getElementById('backgroundImage');
        if (backgroundImage) {
            const gameContent = document.getElementById('gameContent');
            const imageUrl = backgroundImage.src;
            gameContent.style.backgroundImage = 'url(' + imageUrl + ')';
        }
    });
</script>
</html>
