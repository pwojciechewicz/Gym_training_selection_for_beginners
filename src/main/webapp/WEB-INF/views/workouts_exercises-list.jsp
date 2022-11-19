<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<body>

<h4>Lista ćwiczeń</h4>
<div><a href="/workouts_exercises/create" class="btn btn-success rounded-0 pt-0 pb-0 pr-4 pl-4">Dodaj
    ćwiczenie</a></div>
<table class="table table-striped">
    <thead>
    <th scope="col">Nazwa ćwiczenia</th>
    <th scope="col">Partia mięśniowa</th>
    <th scope="col">Trening</th>
    <th scope="col">Liczba serii</th>
    <th scope="col">Liczba powtórzeń</th>
    <th scope="col">przerwy[min]</th>
    <th scope="col">Akcje</th>

    </thead>
    <tbody>
    <c:forEach items="${workouts_exercises}" var="workout_exercise">
        <tr>
            <td>${workout_exercise.exercise.name}</td>
            <td>${workout_exercise.exercise.bodyPart}</td>
            <td>${workout_exercise.workout.name}</td>
            <td>${workout_exercise.workout.unit.setRange}</td>
            <td>${workout_exercise.workout.goal.repRange}</td>
            <td>${workout_exercise.workout.goal.breakRange}</td>

            <td>
                <a href="${workout_exercise.exercise.link}#${workout_exercise.exercise.position}" name="${workout_exercise.exercise.position}"class="btn btn-info rounded-0 text-light m-1">Szczegóły</a>
                <a href="<c:url value="/workouts_exercises/update/${workout_exercise.id}"/>"class="btn btn-info rounded-0 text-light m-1">Zmień</a>
                <a href="<c:url value="/workouts_exercises/remove/${workout_exercise.id}"/>"class="btn btn-info rounded-0 text-light m-1">Usuń</a>
        </tr>
    </c:forEach>
    </tbody>
</table>
<jsp:include page="footer.jsp"/>