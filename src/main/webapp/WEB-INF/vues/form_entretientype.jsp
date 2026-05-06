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
        <title>Ajouter un type d'entretien</title>
    </head>
    <body>
        <jsp:include page="../includes/header.jsp" />    
        
        <h1>Ajouter un type d'entretien</h2>
        
        <form method="post" action="srv_form_entretientype">
            <div class="form-group">
               
                <label>Nb Km</label>
                <input class="form-control" type="number" id="km" name="km" value="${nbKm}" />

                <br>
                
                <label>Nb Km Tolere</label>
                <input class="form-control" type="number" id="kmTolere" name="kmTolere" value="${nbKmTolere}" />
                
                <br>
                <input type="hidden" name="code" id="code" value="${code}"/>
                
                <button class="btn btn-primary" type="submit">Ajouter</button>
                <a href="${pageContext.request.contextPath}/srv_all_entretientype" class="btn btn-outline-primary">Retour</a>
            </div>
        </form>
        
    <jsp:include page="../includes/scripts.jsp" />
    </body>
</html>
