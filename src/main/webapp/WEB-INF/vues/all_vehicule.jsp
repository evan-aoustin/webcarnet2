<%-- 
    Document   : all_vehicule
    Created on : 12 déc. 2025, 13:22:54
    Author     : Aoustin
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../includes/head.jsp" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste vehciules</title>
    </head>
    <body>
        <jsp:include page="../includes/header.jsp" />    
        
        <h2>Liste des vehicules</h2>
        
        <table class="table table-striped">
            <thead>
              <tr>
                <th scope="col">Numéro d'immatriculation</th>
                <th scope="col">Nb de km actuel</th>
                <th></th>
              </tr>
            </thead>
            <tbody>
                <c:forEach var="v" items="${allVehicules}">
                    <tr>
                        <td>${v.getNumImma()}</td>
                        <td>${v.getNbKmActuel()}</td>
                        <td class="btns">
                            <a href="${pageContext.request.contextPath}/srv_vehicule?immat=${v.getNumImma()}" class="btn btn-outline-secondary">Voir</a>
                            <a href="${pageContext.request.contextPath}/srv_form_vehicule?action=update&immat=${v.getNumImma()}&km=${v.getNbKmActuel()}" class="btn btn-outline-primary">Modifier</a>
                            <form method="post" action="srv_all_vehicule">
                                <input id="numImma" name="numImma" type="hidden" value="${v.getNumImma()}" />
                                <button class="btn btn-outline-danger" type="submit" name="delete" value="true">Supprimer</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>  
        
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/srv_form_vehicule">Ajouter un vehicule</a>
        <a href="${pageContext.request.contextPath}/srv_index" class="btn btn-outline-primary">Retour</a>
        
    <jsp:include page="../includes/scripts.jsp" />
    </body>
</html>