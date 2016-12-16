<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
    <title>${list.getName()} - Todos</title>
</head>
<body>

<h3>${list.getName()}</h3>
<p><a href="/lists">Back to lists</a></p>

<table>
    <c:forEach var="todo" items="${todos}">
    <tr>
        <td>#${todo.getId()}</td>
        <td>
        <c:choose>
            <c:when test="${todo.isDone()}">
                DONE
            </c:when>
            <c:otherwise>
                TODO
            </c:otherwise>
        </c:choose>
        </td>
        <td>${todo.getDescription()}</td>
        <td>
            <form:form method="POST" action="/todos-${list.getId()}/${todo.getId()}/update">
                <input type="submit" value="done">
            </form:form>
        </td>
    </tr>
    </c:forEach>
</table>

<h3>Add new TODO</h3>
<form:form modelAttribute="todo" method="POST" action="/todos-${list.getId()}/add">
    <p>
        <form:label path="description">Description:</form:label>
        <form:input path="description"/></td>
    </p>
    <input type="submit" value="add">
</form:form>

</body>
</html>