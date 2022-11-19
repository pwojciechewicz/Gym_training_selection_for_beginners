<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<body>

<h5>Usuń ćwiczenie</h5>
<form:form method="post" modelAttribute="workout_exercise">
    <form:hidden path="id"/>

<div class="form-group">
    <span style="color: red">Czy na pewno chcesz usunąć to ćwiczenie z treningu?</span>
    <h5 name="workout">${workout_exercise.exercise.name} ${workout.id}</h5>
</div>
<input type="submit" name="remove" value="Tak">
<input type="submit" name="remove" value="Nie">
</form:form>
<jsp:include page="footer.jsp"/>