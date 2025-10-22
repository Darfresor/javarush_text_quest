<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html>
<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link href="<c:url value='/static/main.css'/>" rel="stylesheet">
    <script src="<c:url value="/static/jquery-3.6.0.min.js"/>"></script>
    <title>JavaRush Text Quest</title>
</head>
<body>
<c:if test="${not empty currentStep}">
    <h1>${currentStep.description}</h1>
    <p>${currentStep.question}</p>
    <div class="choice-group">
        <div class="choice-item">
            <input  type="radio"  id="choice1" name="choice" value="yes">
            <label for="choice1" onclick ="clickFirst()">${currentStep.choices['yes']}</label>
        </div>
        <div class="choice-item">
            <input type="radio" id="choice2" name="choice" value="no">
            <label for="choice2" onclick ="clickSecond()">${currentStep.choices['no']}</label>
        </div>
    </div>

    <button onclick="answer()" id="button_answer">Ответить</button>
</c:if>
<div>-----------------------------------------------------------------------------</div>
<div>
    <p>Статистика:</p>
    <p>Имя в игре: ${sessionScope.gameSession.playerName}</p>
    <p>Количество игр: ${sessionScope.gameSession.gamesPlayed}</p>
    <p>Ид текущего шага квеста: ${sessionScope.gameSession.currentStep}</p>
</div>
</body>
<script>
    let userChoice = "";

    function clickFirst(){
        let userChoices = $("#choice1").val();
        userChoice = userChoices;

    };
    function clickSecond(){
        let userChoices = $("#choice2").val();
        userChoice = userChoices;
    };

    function answer() {
        console.log(userChoice);
        let playerChoice = {
            answer: userChoice
        }
        let url = "/quest";
        let jsonString = JSON.stringify(playerChoice);
        $.ajax({
            type: 'POST',
            url: url,
            contentType: 'application/json;',
            data: jsonString
        });

    }
</script>
</html>
