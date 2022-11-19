<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<body>

<h5>Dodaj ćwiczenie do treningu</h5>
<form:form method="post" modelAttribute="workout_exercise">
    <form:hidden path="id"/>
    <div class="form-group">
        <form:label for="exampleFormControlInput1" path="exercise">${workout_exercise.exercise.name}</form:label>
        <form:select class="form-control" id="exampleFormControlSelect1" path="exercise" items="${exercises}" itemLabel="name" itemValue="id"/>
        <form:errors path="exercise" cssStyle="color: red"/>
    </div>
    <div class="form-group">
        <form:label for="exampleFormControlInput1" path="workout"> ${workout_exercise.workout.name}</form:label>
        <form:select class="form-control" id="exampleFormControlSelect1" path="workout" items="${workouts}" itemLabel="name" itemValue="id"/>
        <form:errors path="workout" cssStyle="color: red"/>
    </div>

    <form:button>Zapisz</form:button>
</form:form>
</body>
</html>