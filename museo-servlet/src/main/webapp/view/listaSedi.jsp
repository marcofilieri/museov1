<%@include file="../utils/utils.jsp" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Museo v1 - Ricerca Sede</title>
    <script src="https://kit.fontawesome.com/a076d05399.js"></script>
    <!-- Bootstrap CSS -->
    <%--    <link rel="stylesheet"--%>
    <%--          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"--%>
    <%--          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"--%>
    <%--          crossorigin="anonymous">--%>


</head>
<body>
<div class="container">
    <div class="row mt-2">
        <div class="col-12">

            <h1>Elenco Sedi</h1>

            <c:if test="${not empty errorMessage }">
                <div class="error">
                        ${errorMessage}
                </div>
            </c:if>

            <table class="table table-striped" id="tabellaSedi">
                <tr>
                    <th>Nome</th>
                    <th>Ora apertura</th>
                    <th>Ora chiusura</th>
                    <th>Longitudine</th>
                    <th>Latitudine</th>
                    <th>Azioni</th>
                </tr>
                <c:forEach items="${listaSedi}" var="sede">
                    <tr>
                        <td>${sede.nome}</td>
                        <td>${sede.orarioApertura}</td>
                        <td>${sede.orarioChiusura}</td>
                        <td>${sede.longitudine}</td>
                        <td>${sede.latitudine}</td>
                        <td>
                            <a class="button" href="${pageContext.request.contextPath}/modifica-sede?idSede=${sede.id}"><i
                                    class="far fa-edit"></i></a>
                            <a class="button" href="" onclick="$('#deleteForm').submit(); return false;"><i
                                    class="fas fa-trash"></i></a>
                        </td>
                        <form id="deleteForm" action="${pageContext.request.contextPath}/elimina-sede" method="post"
                              style="display: none">
                            <input type="hidden" name="idSede" value="${sede.id}">
                        </form>
                    </tr>
                </c:forEach>
            </table>

        </div>
    </div>


</div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<%--<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"--%>
<%--        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"--%>
<%--        crossorigin="anonymous"></script>--%>
<%--<script--%>
<%--        src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"--%>
<%--        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"--%>
<%--        crossorigin="anonymous"></script>--%>
<%--<script--%>
<%--        src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"--%>
<%--        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"--%>
<%--        crossorigin="anonymous"></script>--%>

</body>
</html>