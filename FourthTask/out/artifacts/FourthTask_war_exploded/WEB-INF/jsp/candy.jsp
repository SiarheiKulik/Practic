<%--
  Created by IntelliJ IDEA.
  User: sergey
  Date: 03.12.2018
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>List of candies</title>
</head>
<body bgcolor="#e6e6e6">
<h1>Candies</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Type</th>
        <th>Energy</th>
        <th>Water</th>
        <th>Sugar</th>
        <th>Fructose</th>
        <th>Chocolatetype</th>
        <th>Vanilla</th>
        <th>Proteins</th>
        <th>Fats</th>
        <th>Carbohydrates</th>
        <th>Production</th>
        <th>Topping</th>
    </tr>
    <c:forEach items="${candiesList}" var="candy" begin="${begin}" end="${end}">
        <tr>
            <td>${candy.id}</td>
            <td>${candy.type}</td>
            <td>${candy.energy}</td>
            <td>${candy.water}</td>
            <td>${candy.sugar}</td>
            <td>${candy.fructose}</td>
            <td>${candy.chocolatetype}</td>
            <td>${candy.vanilla}</td>
            <td>${candy.proteins}</td>
            <td>${candy.fats}</td>
            <td>${candy.carbohydrates}</td>
            <td>${candy.production}</td>
            <td>${candy.topping}</td>
        </tr>
    </c:forEach>
</table>
<a href="controller.do?direction=back">Previous</a>
<a href="controller.do?direction=next">&nbsp&nbsp&nbsp Next</a>
</body>
</html>
