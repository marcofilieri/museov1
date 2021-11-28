<%@include file="../utils/utils.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Museo v1 - Modifica Sede</title>
</head>
<body>
<div class="container">
    <div class="row mt-2">
        <form method="post" action="${pageContext.servletContext.contextPath}/modifica-sede">
            <input type="hidden" value="${sede.id}" name="idSede"/>
            <div class="mb-3">
                <label for="inputNome" class="form-label">Nome</label>
                <input type="text" class="form-control" id="inputNome" value="${sede.nome}" name="inputNome"/>
            </div>
            <div class="mb-3">
                <label for="inputDescrizione" class="form-label">Descrizione</label>
                <input type="text" class="form-control" id="inputDescrizione" value="${sede.descrizione}"
                       name="inputDescrizione"/>
            </div>
            <div class="mb-3">
                <label for="inputOrarioApertura" class="form-label">Orario apertura</label>
                <input type="time" class="form-control" id="inputOrarioApertura" value="${sede.orarioApertura}"
                       name="inputOrarioApertura"/>
            </div>
            <div class="mb-3">
                <label for="inputOrarioChiusura" class="form-label">Orario chiusura</label>
                <input type="time" class="form-control" id="inputOrarioChiusura" value="${sede.orarioChiusura}"
                       name="inputOrarioChiusura"/>
            </div>
            <div class="mb-3">
                <label for="inputLatitudine" class="form-label">Latitudine</label>
                <input type="text" class="form-control" id="inputLatitudine" value="${sede.latitudine}"
                       name="inputLatitudine"/>
            </div>
            <div class="mb-3">
                <label for="inputLongitudine" class="form-label">Longitudine</label>
                <input type="text" class="form-control" id="inputLongitudine" value="${sede.longitudine}"
                       name="inputLongitudine"/>
            </div>
            <div class="mb-3">
                <label for="inputResponsabile" class="form-label">Responsabile</label>
                <select class="form-select" name="inputResponsabile" id="inputResponsabile">
                    <c:forEach items="${listaResponsabili}" var="museo">
                        <option value="${museo.id}"
                                <c:if test="${museo.id == sede.utente.id}">selected</c:if>>${museo.ruolo.denominazione}
                            ::> ${museo.cognome} ${museo.nome}</option>
                    </c:forEach>
                </select>
            </div>


            <div class="mb-3">
                <label for="inputMuseo" class="form-label">Responsabile</label>
                <select class="form-select" name="inputMuseo" id="inputMuseo">
                    <c:forEach items="${listaMusei}" var="museo">
                        <option value="${museo.id}"
                                <c:if test="${museo.id == sede.museo.id}">selected</c:if>>${museo.nome}</option>
                    </c:forEach>
                </select>
            </div>


            <%--                    <div class="mb-3 form-check">--%>
            <%--                        <input type="checkbox" class="form-check-input" id="exampleCheck1">--%>
            <%--                        <label class="form-check-label" for="exampleCheck1">Check me out</label>--%>
            <%--                    </div>--%>

            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
</div>
</body>
</html>