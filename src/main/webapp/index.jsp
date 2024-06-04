<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Prologue</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  </head>
  <body class="container-fluid p-5 bg-primary text-white text-center">
  <div >
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
      <button type="button" id="startButton" class="btn btn-success">Начать</button>
    </form>
  </div>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script type="text/javascript", src="my.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
  </body>
</html>