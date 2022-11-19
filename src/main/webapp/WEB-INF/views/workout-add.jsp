<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<body>

<h5>Dodaj plan treningowy</h5>
<form:form method="post" modelAttribute="workout">

    <form:hidden path="id"/>
<div class="form-group">
        <form:label for="exampleFormControlInput1" path="name">Nazwa treningu</form:label>
        <form:input class="form-control" id="exampleFormControlInput1" placeholder="Tutaj wpisz nazwę" path="name"/>
        <form:errors path="name" cssStyle="color: red"/>
    </div>
<div class="form-group">
        <form:label for="exampleFormControlSelect1" path="goal">Cel</form:label>
        <form:select class="form-control" id="exampleFormControlSelect1" path="goal" items="${goals}" itemLabel="name" itemValue="id"/>
        <form:errors path="goal" cssStyle="color: red"/>
    </div>
<div class="form-group">
        <form:label for="exampleFormControlSelect1" path="plan">Rodzaj planu</form:label>
        <form:select class="form-control" id="exampleFormControlSelect1" path="plan" items="${plans}" itemLabel="name" itemValue="id"/>
        <form:errors path="plan" cssStyle="color: red"/>
    </div>
<div class="form-group">
        <form:label for="exampleFormControlSelect1" path="unit">Liczba jednostek w tygodniu</form:label>
        <form:select class="form-control" id="exampleFormControlSelect1" path="unit" items="${units}" itemLabel="unitsPerWeek" itemValue="id"/>
        <form:errors path="unit" cssStyle="color: red"/>
    </div>
    <form:button >Zapisz</form:button>
</form:form>

<jsp:include page="footer.jsp"/>