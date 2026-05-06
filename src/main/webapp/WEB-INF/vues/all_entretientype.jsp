<%-- 
    Document   : all_entretientype
    Created on : 12 déc. 2025, 13:23:16
    Author     : Aoustin
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../includes/head.jsp" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste entretien type</title>
    </head>
    <body>
        <jsp:include page="../includes/header.jsp" />    
        
         <h2>Liste des type d'entretiens</h2>
        
        <table class="table table-striped">
            <thead>
              <tr>
                <th scope="col">Code</th>
                <th scope="col">Nb de km</th>
                <th scope="col">Nb de km tolérer</th>
                <th></th>
              </tr>
            </thead>
            <tbody>
                <c:forEach var="et" items="${allEntretienTypes}">
                    <tr>
                      <th>${et.getCode()}</th>
                      <td>${et.getNbKm()}</td>
                      <td>${et.getNbKmTolere()}</td>
                      <td class="btns">
                        <a href="${pageContext.request.contextPath}/srv_form_entretientype?action=update&code=${et.getCode()}&nbKm=${et.getNbKm()}&nbKmTolere=${et.getNbKmTolere()}" class="btn btn-outline-primary">Modifier</a>
                        <form method="post" action="srv_all_entretientype">
                            <input id="code" name="code" type="hidden" value="${et.getCode()}" />
                            <button class="btn btn-outline-danger" type="submit" name="delete" value="true">Supprimer</button>
                        </form>
                      </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/srv_form_entretientype">Ajouter un type d'entretien</a>
        <a href="${pageContext.request.contextPath}/srv_index" class="btn btn-outline-primary">Retour</a>
        
    <jsp:include page="../includes/scripts.jsp" />
    </body>
</html>