<%-- 
    Document   : form_vehicule
    Created on : 10 déc. 2025, 14:34:20
    Author     : Aoustin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../includes/head.jsp" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ajouter un vehicule</title>
    </head>
    <body>
        <jsp:include page="../includes/header.jsp" />    
        
        <h1>Ajouter un vehicule</h2>

        <form method="post" action="srv_form_vehicule">
            <div class="form-group">
                <label>Num d'immatriculation</label>
                <input class="form-control" type="text" id="immat" name="immat" placeholder="AA-123-BB" value="${immat}" <c:if test="${action == 'update'}"> readonly </c:if> />

                <br>

                <label>Nb Km Actuel</label>
                <input class="form-control" type="number" id="km" name="km" value="${km}"/>

                <br>

                <button class="btn btn-primary" type="submit">Ajouter</button>
                <a href="${pageContext.request.contextPath}/admin/srv_all_vehicule" class="btn btn-outline-primary">Retour</a>
            </div>
        </form>
        
    <jsp:include page="../includes/scripts.jsp" />
    </body>
</html>
