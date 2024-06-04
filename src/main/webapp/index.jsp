<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <title>Prologue</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script type="text/javascript", src="my.js"></script>
  </head>
  <body>
  <div>
    <h1><%= "Quest Project" %></h1>
    <p>
      <h2>Пролог</h2>Ты стоишь в космическом порту и готов подняться на бортсвоего корабля. Разве ты не об этом мечтал? Стать капитаномгалактического судна с экипажем, который будет совершатьподвиги под твоим командованием. Так что вперёд!
    </p>
    <p>
      <h2>Знакомство с экипажем</h2>Когда ты поднялся на борт корабля, тепя поприветствовала девушка с чёрной папкой в руках:<br>- Здравствууйте, командир! я Зинаида - ваша помощница. Видите? Там в углу пьёт кофенаш штурман - сержант Перегарный Шлейф, под штурвалом спит наш бортмеханик - Чёрный Богдан, А как обращаться к вам?
    </p>
    <form id="sendName">
      <label for="nameField">Введите имя:</label><br>
      <input type="text" id="nameField" name="nameField" placeholder="Имя"><br>
      <input type="button" id="startButton" value="Продолжить">
    </form>
  </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
  </body>
</html>