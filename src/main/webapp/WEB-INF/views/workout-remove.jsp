<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>

<body>

<h5>Usuń trening</h5>
<form:form method="post"  modelAttribute="workout">

  <form:hidden path="id"/>
  <div>
    <span style="color: red">Czy na pewno chcesz usunąć ten trening?</span>
    <h5>${workout.name}</h5>
  </div>
  <input type="submit"  name="remove" value="Potwierdź">

</form:form>
<jsp:include page="footer.jsp"/>