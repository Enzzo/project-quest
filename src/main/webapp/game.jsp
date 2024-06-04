<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Quest</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script type="text/javascript", src="my.js"></script>
  <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="container-fluid p-5 bg-primary text-white text-center">
  <h1><%= "Quest Project" %></h1>
  <section id="gameSection">
    <h2>${title}</h2>
    <p>${text}</p>
    <c:forEach var="ans" items="${answers}" varStatus="loop">
      <p class="answers" onclick="select(${loop.index})">${ans.getAnswer()}</p>
    </c:forEach>
  </section>
  <br/>

  <c:if test="${state=='game over'}">
    <input id="restartButton" type="button" value="Начать новую игру" onclick="startNewGame()"/>
    <%-- <input id="createButton" type="button" value="Создать свою игру" onclick=window.location="quest?game=create" /> --%>
  </c:if>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>