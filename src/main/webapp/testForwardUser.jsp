<%@ page import="org.example.firsteeproject.testClasses.User" %><%--
  Created by IntelliJ IDEA.
  User: User1
  Date: 23.12.2024
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h1>Ты прибыл из сервлета ServletSessionWithParameters</h1>
<% User user = (User) session.getAttribute("user"); %>
<%="Твое имя: " + user.getName()%>
<%="Твой возраст: " + user.getAge()%>
</body>
</html>
