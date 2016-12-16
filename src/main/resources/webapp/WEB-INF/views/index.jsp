<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
    <title>Todo lists</title>
</head>
<body>

<h3>TODO lists</h3>

<table>
    <c:forEach var="list" items="${lists}">
    <tr>
        <td>#${list.getId()}</td>
        <td>${list.getName()}</td>
        <td><a href="/todos-${list.getId()}">View list<a/></td>
        <td>
            <form:form method="POST" action="/lists/${list.getId()}/delete">
                <input type="submit" value="delete">
            </form:form>
        </td>
    </tr>
    </c:forEach>
</table>

<h3>Add new TODO list</h3>
<form:form modelAttribute="todoList" method="POST" action="/lists/add">
    <p>
        <form:label path="name">Name:</form:label>
        <form:input path="name"/></td>
    </p>
    <input type="submit" value="add">
</form:form>
</body>
</html>
