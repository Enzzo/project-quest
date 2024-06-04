<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Quest</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="style.css">
</head>

<body>
<div class="container-fluid p-5 bg-primary text-white text-center">
  <section id="gameSection">
    <h2>${title}</h2>
    <p>${text}</p>
    <c:forEach var="ans" items="${answers}" varStatus="loop">
<%--      <p class="answers" onclick="select(${loop.index})">${ans.getAnswer()}</p>--%>
      <button type="button" class="btn btn-dark" onclick="select(${loop.index})">${ans.getAnswer()}</button>
    </c:forEach>
  </section>

  <br>
  <c:if test="${state=='game over'}">
    <button id="restartButton" type="button" class="btn btn-warning" onclick="restart()">Начать новую игру</button>
    <%-- <input id="createButton" type="button" value="Создать свою игру" onclick=window.location="quest?game=create" /> --%>
  </c:if>
  <button id="exittButton" type="button" class="btn btn-danger" onclick="closeGame()">Выйти из игры</button>
</div>

<footer>
  <b>User:</b> ${session.userName}<br>
  <b>IP:</b> ${session.IP}<br>
  <b>Wins:</b> ${session.wins} | <b>Loses:</b> ${session.loses}
</footer>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript", src="my.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>