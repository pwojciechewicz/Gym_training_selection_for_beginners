<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>

<body>

<h4>Lista Treningów</h4>
<div class="col noPadding d-flex justify-content-start mb-2"><a href="/workouts/create" class="btn btn-success rounded-0 pt-0 pb-0 pr-4 pl-4">Dodaj
    trening</a></div>
<table class="table table-striped">
    <thead>
    <th scope="col">Id</th>
    <th scope="col">Nazwa treningu</th>
    <th scope="col">Plan</th>
    <th scope="col">Cel Treningowy</th>
    <th scope="col">Liczba treningów w tygodniu</th>
    <th scope="col">Akcje</th>

    </thead>
    <tbody>
    <c:forEach items="${workouts}" var="workout">
        <tr>
            <td>${workout.id}</td>
            <td>${workout.name}</td>
            <td>${workout.plan.name}</td>
            <td>${workout.goal.name}</td>
            <td>${workout.unit.unitsPerWeek}</td>

            <td>
                <a href="/workouts_exercises/workouts/${workout.id}" class="btn btn-info rounded-0 text-light m-1">Szczegóły</a>
                <a href="<c:url value="/workouts/update/${workout.id}"/>"class="btn btn-info rounded-0 text-light m-">Aktualizuj</a>
                <a href="<c:url value="/workouts/remove/${workout.id}"/>"class="btn btn-info rounded-0 text-light m-1">Usuń</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<jsp:include page="footer.jsp"/>