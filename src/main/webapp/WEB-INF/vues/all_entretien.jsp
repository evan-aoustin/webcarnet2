<%-- 
    Document   : all_entretien
    Created on : 12 déc. 2025, 13:23:05
    Author     : Aoustin
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../includes/head.jsp" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste entretien</title>
    </head>
    <body>
        <jsp:include page="../includes/header.jsp" />    
        
        <h2>Liste des entretiens</h2>
        <table class="table table-striped">
            <thead>
              <tr>
                <th scope="col">ID</th>
                <th scope="col">Date</th>
                <th scope="col">Nb Km Compteur</th>
                <th scope="col">Commentaire</th>
                <th scope="col">Numéro d'immatriculation</th>
                <th scope="col">Type d'entretien</th>
                <th></th>
              </tr>
            </thead>
            <tbody>
                <c:forEach var="e" items="${allEntretiens}">
                    <tr>
                      <td>${e.getIdEntretien()}</td>
                      <td>${e.getDate().toString()}</td>
                      <td>${e.getNbKmCompteur()}</td>
                      <td>${e.getCommentaire()}</td>
                      <td>${e.getVehicule().getNumImma()}</td>
                      <td>${e.getType().getCode()}</td>
                      <td class="btns">
                        <a href="${pageContext.request.contextPath}/srv_form_entretien?action=update&idEntretien=${e.getIdEntretien()}&date=${e.getDate().toString()}&nbKmCompteur=${e.getNbKmCompteur()}&commentaire=${e.getCommentaire()}&vehiImmat=${e.getVehicule().getNumImma()}&entretientypeCode=${e.getType().getCode()}" class="btn btn-outline-primary">Modifier</a>
                        <form method="post" action="srv_all_entretien">
                            <input id="id" name="id" type="hidden" value="${e.getIdEntretien()}" />
                            <button class="btn btn-outline-danger" type="submit" name="delete" value="true">Supprimer</button>
                        </form>
                      </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>  

        <a class="btn btn-primary" href="${pageContext.request.contextPath}/srv_form_entretien">Ajouter un entretien</a>
        <a href="${pageContext.request.contextPath}/srv_index" class="btn btn-outline-primary">Retour</a>
        
    <jsp:include page="../includes/scripts.jsp" />
    </body>
</html>
