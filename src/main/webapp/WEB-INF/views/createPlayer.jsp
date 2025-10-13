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
<h1>Пролог</h1>
<p>${startPageData['annotation']}</p>
<h1>Знакомство с экипажем</h1>
<p>${startPageData['meeting_player_info']}</p>
<p>
    <input type="text" id="input_name" required size="12" maxlength="12"></input>
    <button onclick="createName()" id="button_create_name">Представиться</button>
</p>
</body>
<script>
    function createName() {
        let url = '/start?playerName=';
        let playerName = $("#input_name").val();
        url = url.concat(encodeURIComponent(playerName));
        $.ajax({
            url: url,
            type: 'POST',
            contentType: 'application/x-www-form-urlencoded; charset=UTF-8;',
            success: function(){
                window.location.href = '/quest';
            }
        });


    }
</script>
</html>
