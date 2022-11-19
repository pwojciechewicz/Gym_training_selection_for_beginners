<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<jsp:include page="header.jsp"/>


           <h4> Lista Planów Treningowych</h4>

        <table class="table table-striped">
            <thead>
            <tr class="d-flex text-color-darker">
                <th scope="col" class="col">Id</th>
                <th scope="col" class="col">Nazwa planu</th>
                <th scope="col" class="col">Opis</th>
                <th scope="col" class="col">Akcje</th>
            </tr>
            </thead>
            <tbody class="text-color-lighter">


            <c:forEach var="plan" items="${plans}">
            <tr class="d-flex">
                <th scope="row" class="col">${plan.id}</th>
                <td class="col">${plan.name}</td>
                <td class="col">${plan.description}</td>


                <td class="col">
                    <a href="workouts/plans/${plan.id}" class="btn btn-info rounded-0 text-light m-1">Szczegóły</a>

                </td>
                </c:forEach>

            </tbody>
        </table>
    </div>
</div>
</div>
</section>

<jsp:include page="footer.jsp"/>
