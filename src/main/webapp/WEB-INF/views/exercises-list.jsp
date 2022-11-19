<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<body>

<h5>Lista ćwiczeń</h5>
<table class="table table-striped">
    <thead>

    <th scope="col">Id</th>
    <th scope="col">Nazwa ćwiczenia</th>
    <th scope="col">Partia mięśniowa</th>
    <th scope="col">Link</th>

    </thead>
    <tbody>
    <c:forEach items="${exercises}" var="exercise">
        <tr>

            <td>${exercise.id}</td>
            <td>${exercise.name}</td>
            <td>${exercise.bodyPart}</td>
            <td> <a href="${exercise.link}#${exercise.position}" name="${exercise.position}" class="btn btn-info rounded-0 text-light m-1">Szczegóły</a></td>

        </tr>
    </c:forEach>
    </tbody>
</table>
<jsp:include page="footer.jsp"/>